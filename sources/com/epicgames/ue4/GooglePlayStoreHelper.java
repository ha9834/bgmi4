package com.epicgames.ue4;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.util.Base64;
import com.android.vending.billing.util.Purchase;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GooglePlayStoreHelper implements StoreHelper {
    public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
    public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
    public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
    public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
    public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;
    public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
    public static final int BILLING_RESPONSE_RESULT_OK = 0;
    public static final int BILLING_RESPONSE_RESULT_SERVICE_UNAVAILABLE = 2;
    public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
    public static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
    public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    public static final String ITEM_TYPE_INAPP = "inapp";
    public static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    public static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
    public static final String RESPONSE_INAPP_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
    public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    public static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
    public static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
    private Logger Log;
    private GameActivity gameActivity;
    private IInAppBillingService mService;
    private String productKey;
    private final int UndefinedFailureResponse = -1;
    final int purchaseIntentIdentifier = 1001;
    private ServiceConnection mServiceConn = new ServiceConnection() { // from class: com.epicgames.ue4.GooglePlayStoreHelper.3
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            GooglePlayStoreHelper.this.Log.debug("[GooglePlayStoreHelper] - ServiceConnection::onServiceDisconnected");
            GooglePlayStoreHelper.this.mService = null;
            GooglePlayStoreHelper.this.bIsIapSetup = false;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            GooglePlayStoreHelper.this.Log.debug("[GooglePlayStoreHelper] - ServiceConnection::onServiceConnected");
            GooglePlayStoreHelper.this.mService = IInAppBillingService.Stub.asInterface(iBinder);
            GooglePlayStoreHelper.this.bIsIapSetup = true;
            try {
                GooglePlayStoreHelper.this.Log.debug("Checking for in-app billing 3 support.");
                int isBillingSupported = GooglePlayStoreHelper.this.mService.isBillingSupported(3, GooglePlayStoreHelper.this.gameActivity.getPackageName(), "inapp");
                if (isBillingSupported != 0) {
                    GooglePlayStoreHelper.this.Log.debug("In-app billing version 3 NOT supported for " + GooglePlayStoreHelper.this.gameActivity.getPackageName() + " error " + isBillingSupported);
                    return;
                }
                GooglePlayStoreHelper.this.Log.debug("In-app billing version 3 supported for " + GooglePlayStoreHelper.this.gameActivity.getPackageName());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };
    private boolean bIsIapSetup = false;

    /* loaded from: classes.dex */
    public interface PurchaseLaunchCallback {
        void launchForResult(PendingIntent pendingIntent, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String TranslateServerResponseCode(int i) {
        switch (i) {
            case 0:
                return "Success";
            case 1:
                return "User pressed back or canceled a dialog";
            case 2:
                return "Network connection is down";
            case 3:
                return "Billing API version is not supported for the type requested";
            case 4:
                return "Requested product is not available for purchase";
            case 5:
                return "Invalid arguments provided to the API. This error can also indicate that the application was not correctly signed or properly set up for In-app Billing in Google Play, or does not have the necessary permissions in its manifest";
            case 6:
                return "Fatal error during the API action";
            case 7:
                return "Failure to purchase since item is already owned";
            case 8:
                return "Failure to consume since item is not owned";
            default:
                return "Unknown Server Response Code";
        }
    }

    public native void nativePurchaseComplete(int i, String str, String str2, String str3, String str4);

    public native void nativeQueryComplete(int i, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, float[] fArr, String[] strArr5);

    public native void nativeQueryExistingPurchasesComplete(int i, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4);

    public native void nativeRestorePurchasesComplete(int i, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4);

    public GooglePlayStoreHelper(String str, GameActivity gameActivity, Logger logger) {
        this.Log = logger;
        this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::GooglePlayStoreHelper");
        this.gameActivity = gameActivity;
        this.productKey = str;
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        this.gameActivity.bindService(intent, this.mServiceConn, 1);
    }

    @Override // com.epicgames.ue4.StoreHelper
    public boolean IsAllowedToMakePurchases() {
        this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::IsAllowedToMakePurchases");
        return this.bIsIapSetup;
    }

    @Override // com.epicgames.ue4.StoreHelper
    public boolean QueryInAppPurchases(String[] strArr) {
        this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::QueryInAppPurchases");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : strArr) {
            this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::QueryInAppPurchases - Querying " + str);
            arrayList.add(str);
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
        try {
            Bundle skuDetails = this.mService.getSkuDetails(3, this.gameActivity.getPackageName(), "inapp", bundle);
            int i = skuDetails.getInt("RESPONSE_CODE");
            this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::QueryInAppPurchases - Response " + i + " Bundle:" + skuDetails.toString());
            if (i == 0) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                ArrayList arrayList7 = new ArrayList();
                Iterator<String> it = skuDetails.getStringArrayList("DETAILS_LIST").iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject = new JSONObject(it.next());
                    String string = jSONObject.getString("productId");
                    arrayList2.add(string);
                    this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::QueryInAppPurchases - Parsing details for: " + string);
                    String string2 = jSONObject.getString("title");
                    arrayList3.add(string2);
                    this.Log.debug("[GooglePlayStoreHelper] - title: " + string2);
                    String string3 = jSONObject.getString("description");
                    arrayList4.add(string3);
                    this.Log.debug("[GooglePlayStoreHelper] - description: " + string3);
                    String string4 = jSONObject.getString(FirebaseAnalytics.Param.PRICE);
                    arrayList5.add(string4);
                    this.Log.debug("[GooglePlayStoreHelper] - price: " + string4);
                    double d = jSONObject.getDouble("price_amount_micros") / 1000000.0d;
                    arrayList6.add(Float.valueOf((float) d));
                    this.Log.debug("[GooglePlayStoreHelper] - price_amount_micros: " + d);
                    String string5 = jSONObject.getString("price_currency_code");
                    arrayList7.add(string5);
                    this.Log.debug("[GooglePlayStoreHelper] - price_currency_code: " + string5);
                }
                float[] fArr = new float[arrayList6.size()];
                for (int i2 = 0; i2 < arrayList6.size(); i2++) {
                    fArr[i2] = ((Float) arrayList6.get(i2)).floatValue();
                }
                this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::QueryInAppPurchases " + arrayList2.size() + " items - Success!");
                nativeQueryComplete(i, (String[]) arrayList2.toArray(new String[arrayList2.size()]), (String[]) arrayList3.toArray(new String[arrayList3.size()]), (String[]) arrayList4.toArray(new String[arrayList4.size()]), (String[]) arrayList5.toArray(new String[arrayList5.size()]), fArr, (String[]) arrayList7.toArray(new String[arrayList7.size()]));
                this.Log.debug("[GooglePlayStoreHelper] - nativeQueryComplete done!");
                return true;
            }
            this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::QueryInAppPurchases - Failed!");
            nativeQueryComplete(i, null, null, null, null, null, null);
            return true;
        } catch (Exception e) {
            this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::QueryInAppPurchases - Failed! " + e.getMessage());
            nativeQueryComplete(-1, null, null, null, null, null, null);
            return true;
        }
    }

    @Override // com.epicgames.ue4.StoreHelper
    public boolean BeginPurchase(String str) {
        Bundle buyIntent;
        try {
            String GenerateDevPayload = GenerateDevPayload(str);
            if (this.gameActivity.IsInVRMode()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("vr", true);
                if (this.mService.isBillingSupportedExtraParams(7, this.gameActivity.getPackageName(), "inapp", bundle) == 0) {
                    this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::BeginPurchase - v7 VR purchase" + str);
                    buyIntent = this.mService.getBuyIntentExtraParams(7, this.gameActivity.getPackageName(), str, "inapp", GenerateDevPayload, bundle);
                } else {
                    this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::BeginPurchase - v3 IAB purchase:" + str);
                    buyIntent = this.mService.getBuyIntent(3, this.gameActivity.getPackageName(), str, "inapp", GenerateDevPayload);
                }
            } else {
                this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::BeginPurchase - v3 IAB purchase:" + str);
                buyIntent = this.mService.getBuyIntent(3, this.gameActivity.getPackageName(), str, "inapp", GenerateDevPayload);
            }
            int i = buyIntent.getInt("RESPONSE_CODE");
            if (i == 0) {
                this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::BeginPurchase - Starting Intent to buy " + str);
                PendingIntent pendingIntent = (PendingIntent) buyIntent.getParcelable("BUY_INTENT");
                if (pendingIntent != null) {
                    PurchaseLaunchCallback purchaseLaunchCallback = this.gameActivity.getPurchaseLaunchCallback();
                    if (purchaseLaunchCallback != null) {
                        purchaseLaunchCallback.launchForResult(pendingIntent, 1001);
                    } else {
                        Integer num = 0;
                        Integer num2 = 0;
                        Integer num3 = 0;
                        this.gameActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), num.intValue(), num2.intValue(), num3.intValue());
                    }
                } else {
                    this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::BeginPurchase - pendingIntent was null, possible non consumed item");
                    nativePurchaseComplete(-1, str, "", "", "");
                }
            } else {
                this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::BeginPurchase - Failed with error: " + TranslateServerResponseCode(i));
                nativePurchaseComplete(i, str, "", "", "");
            }
        } catch (Exception e) {
            this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::BeginPurchase - Failed! " + e.getMessage());
            nativePurchaseComplete(-1, str, "", "", "");
        }
        return true;
    }

    @Override // com.epicgames.ue4.StoreHelper
    public boolean RestorePurchases(final String[] strArr, final boolean[] zArr) {
        this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::RestorePurchases");
        final ArrayList<String> arrayList = new ArrayList<>();
        final ArrayList<String> arrayList2 = new ArrayList<>();
        final ArrayList<String> arrayList3 = new ArrayList<>();
        int GatherOwnedPurchaseData = GatherOwnedPurchaseData(arrayList, arrayList2, arrayList3, null);
        if (GatherOwnedPurchaseData == 0) {
            this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::RestorePurchases - User has previously purchased " + arrayList.size() + " inapp products");
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.epicgames.ue4.GooglePlayStoreHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    int i;
                    try {
                        GooglePlayStoreHelper.this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::RestorePurchases - Now consuming any purchases that may have been missed.");
                        ArrayList arrayList4 = new ArrayList();
                        ArrayList arrayList5 = new ArrayList();
                        int i2 = 0;
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            try {
                                Purchase purchase = new Purchase("inapp", (String) arrayList2.get(i3), (String) arrayList3.get(i3));
                                arrayList4.add(purchase.getToken());
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= strArr.length) {
                                        break;
                                    }
                                    if (!purchase.getSku().equals(strArr[i4])) {
                                        i4++;
                                    } else if (i4 < zArr.length) {
                                        z = zArr[i4];
                                        GooglePlayStoreHelper.this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::RestorePurchases - Found Consumable Flag for Product " + purchase.getSku() + " bConsumable = " + z);
                                    }
                                }
                                z = false;
                                if (z) {
                                    GooglePlayStoreHelper.this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::RestorePurchases - Attempting to consume " + purchase.getSku());
                                    i = GooglePlayStoreHelper.this.mService.consumePurchase(3, GooglePlayStoreHelper.this.gameActivity.getPackageName(), purchase.getToken());
                                } else {
                                    i = 0;
                                }
                                if (i == 0) {
                                    GooglePlayStoreHelper.this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::RestorePurchases - Purchase restored for " + purchase.getSku());
                                    arrayList5.add(Base64.encode(purchase.getOriginalJson().getBytes()));
                                    i = i2;
                                } else {
                                    GooglePlayStoreHelper.this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::RestorePurchases - consumePurchase failed for " + purchase.getSku() + " with error " + i);
                                    arrayList5.add("");
                                }
                                i2 = i;
                            } catch (JSONException e) {
                                GooglePlayStoreHelper.this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::RestorePurchases - Failed to parse receipt! " + e.getMessage());
                                arrayList4.add("");
                                arrayList5.add("");
                            }
                        }
                        GooglePlayStoreHelper.this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::RestorePurchases - Success!");
                        GooglePlayStoreHelper.this.nativeRestorePurchasesComplete(i2, (String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList4.toArray(new String[arrayList4.size()]), (String[]) arrayList5.toArray(new String[arrayList5.size()]), (String[]) arrayList3.toArray(new String[arrayList3.size()]));
                    } catch (Exception e2) {
                        GooglePlayStoreHelper.this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::RestorePurchases - consumePurchase failed. " + e2.getMessage());
                        GooglePlayStoreHelper.this.nativeRestorePurchasesComplete(-1, null, null, null, null);
                    }
                }
            });
            return true;
        }
        nativeRestorePurchasesComplete(GatherOwnedPurchaseData, null, null, null, null);
        this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::RestorePurchases - Failed to collect existing purchases");
        return false;
    }

    @Override // com.epicgames.ue4.StoreHelper
    public boolean QueryExistingPurchases() {
        this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::QueryExistingPurchases");
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        int GatherOwnedPurchaseData = GatherOwnedPurchaseData(arrayList, arrayList2, arrayList3, null);
        if (GatherOwnedPurchaseData == 0) {
            this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::QueryExistingPurchases - User has previously purchased " + arrayList.size() + " inapp products");
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                try {
                    Purchase purchase = new Purchase("inapp", arrayList2.get(i), arrayList3.get(i));
                    arrayList4.add(purchase.getToken());
                    arrayList5.add(Base64.encode(purchase.getOriginalJson().getBytes()));
                } catch (JSONException e) {
                    this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::QueryExistingPurchases - Failed to parse receipt! " + e.getMessage());
                    arrayList4.add("");
                    arrayList5.add("");
                }
            }
            this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::QueryExistingPurchases - Success!");
            nativeQueryExistingPurchasesComplete(GatherOwnedPurchaseData, (String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList4.toArray(new String[arrayList4.size()]), (String[]) arrayList5.toArray(new String[arrayList5.size()]), (String[]) arrayList3.toArray(new String[arrayList3.size()]));
            return true;
        }
        this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::QueryExistingPurchases - Failed to collect existing purchases" + TranslateServerResponseCode(GatherOwnedPurchaseData));
        nativeQueryExistingPurchasesComplete(GatherOwnedPurchaseData, null, null, null, null);
        return false;
    }

    @Override // com.epicgames.ue4.StoreHelper
    public void ConsumePurchase(final String str) {
        this.Log.debug("[GooglePlayStoreHelper] - Beginning ConsumePurchase: " + str);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.epicgames.ue4.GooglePlayStoreHelper.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    GooglePlayStoreHelper.this.Log.debug("[GooglePlayStoreHelper] - Consuming token: " + str);
                    int consumePurchase = GooglePlayStoreHelper.this.mService.consumePurchase(3, GooglePlayStoreHelper.this.gameActivity.getPackageName(), str);
                    if (consumePurchase == 0) {
                        GooglePlayStoreHelper.this.Log.debug("[GooglePlayStoreHelper] - ConsumePurchase success");
                    } else {
                        GooglePlayStoreHelper.this.Log.debug("[GooglePlayStoreHelper] - ConsumePurchase failed with error " + GooglePlayStoreHelper.this.TranslateServerResponseCode(consumePurchase));
                    }
                } catch (Exception e) {
                    GooglePlayStoreHelper.this.Log.debug("[GooglePlayStoreHelper] - ConsumePurchase failed. " + e.getMessage());
                }
            }
        });
    }

    @Override // com.epicgames.ue4.StoreHelper
    public void onDestroy() {
        this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::onDestroy");
        if (this.mService != null) {
            this.gameActivity.unbindService(this.mServiceConn);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00ff -> B:19:0x01ac). Please report as a decompilation issue!!! */
    @Override // com.epicgames.ue4.StoreHelper
    public boolean onActivityResult(int i, int i2, Intent intent) {
        this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::onActivityResult");
        if (i != 1001) {
            return false;
        }
        if (intent == null) {
            this.Log.debug("Null data in purchase activity result.");
            nativePurchaseComplete(-1, "", "", "", "");
            return true;
        }
        int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
            String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
            this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::onActivityResult - Processing purchase result. Response Code: " + TranslateServerResponseCode(intExtra));
            if (intExtra == 0) {
                this.Log.debug("Purchase data: " + stringExtra);
                this.Log.debug("Data signature: " + stringExtra2);
                this.Log.debug("Extras: " + intent.getExtras());
                if (stringExtra == null || stringExtra2 == null) {
                    this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::onActivityResult - Either purchaseData or dataSignature is null");
                    nativePurchaseComplete(-1, "", "", "", "");
                }
                try {
                    final Purchase purchase = new Purchase("inapp", stringExtra, stringExtra2);
                    final String sku = purchase.getSku();
                    if (VerifyPayload(purchase.getDeveloperPayload(), sku)) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.epicgames.ue4.GooglePlayStoreHelper.4
                            @Override // java.lang.Runnable
                            public void run() {
                                GooglePlayStoreHelper.this.nativePurchaseComplete(0, sku, purchase.getToken(), Base64.encode(purchase.getOriginalJson().getBytes()), purchase.getSignature());
                            }
                        });
                    } else {
                        this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::onActivityResult - Failed for verify developer payload for " + sku);
                        nativePurchaseComplete(-1, sku, "", "", "");
                    }
                } catch (JSONException e) {
                    this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::onActivityResult - Failed for purchase request! " + e.getMessage());
                    nativePurchaseComplete(-1, "", "", "", "");
                }
            } else {
                this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::onActivityResult - Failed for purchase request!. " + TranslateServerResponseCode(intExtra));
                nativePurchaseComplete(intExtra, "", "", "", "");
            }
        } else if (i2 == 0) {
            this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::onActivityResult - Purchase canceled." + TranslateServerResponseCode(intExtra));
            nativePurchaseComplete(1, "", "", "", "");
        } else {
            this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::onActivityResult - Purchase failed. Result code: " + Integer.toString(i2) + ". Response: " + TranslateServerResponseCode(intExtra));
            nativePurchaseComplete(-1, "", "", "", "");
        }
        return true;
    }

    private String GenerateDevPayload(String str) {
        return "ue4." + str;
    }

    private boolean VerifyPayload(String str, String str2) {
        String GenerateDevPayload = GenerateDevPayload(str2);
        this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::VerifyPayload, ExistingPayload: " + str);
        this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::VerifyPayload, GeneratedPayload: " + GenerateDevPayload);
        return str.equals(GenerateDevPayload);
    }

    private int GatherOwnedPurchaseData(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str) {
        int i = -1;
        try {
            Bundle purchases = this.mService.getPurchases(3, this.gameActivity.getPackageName(), "inapp", str);
            i = purchases.getInt("RESPONSE_CODE");
            this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::GatherOwnedPurchaseData - getPurchases result. Response Code: " + TranslateServerResponseCode(i));
            if (i == 0) {
                ArrayList<String> stringArrayList = purchases.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = purchases.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = purchases.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String string = purchases.getString("INAPP_CONTINUATION_TOKEN");
                for (int i2 = 0; i2 < stringArrayList2.size(); i2++) {
                    arrayList.add(stringArrayList.get(i2));
                    arrayList2.add(stringArrayList2.get(i2));
                    arrayList3.add(stringArrayList3.get(i2));
                }
                if (string != null) {
                    return GatherOwnedPurchaseData(arrayList, arrayList2, arrayList3, str);
                }
            }
        } catch (Exception e) {
            this.Log.debug("[GooglePlayStoreHelper] - GooglePlayStoreHelper::GatherOwnedPurchaseData - Failed for purchase request!. " + e.getMessage());
        }
        return i;
    }
}
