package com.tencent.midas.oversea.business.payhub.gwallet.New;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.android.billingclient.api.p;
import com.android.billingclient.api.q;
import com.android.vending.billing.util.IabHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.business.APBaseIntroInfo;
import com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper;
import com.tencent.midas.oversea.newapi.response.IAPMidasCallback;
import com.tencent.midas.oversea.newapi.response.InfoCallback;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APIntroInfo extends APBaseIntroInfo implements BillingHelper.OnIabSetupFinishedListener {
    public static final String TAG = "APIntroInfo_New";
    private BillingHelper billingHelper;
    private InfoCallback mCallback;
    private Context mContext;
    private boolean isSDKQueryFinished = false;
    private boolean isServerQueryFinished = false;
    private String intro_sdkJInfo = "";
    private String intro_serverJInfo = "";

    @Override // com.tencent.midas.oversea.business.APBaseIntroInfo
    public void getIntroInfo(Context context, String str, List<String> list, InfoCallback infoCallback) {
        this.mContext = context.getApplicationContext();
        this.channel = str;
        this.mCallback = infoCallback;
        this.productList = list;
        if (list == null || list.isEmpty()) {
            callbackSDK(-1, null);
        }
        init(this.mContext);
    }

    private void init(Context context) {
        this.billingHelper = new BillingHelper(context);
        this.billingHelper.startSetup(this);
        queryServerInfo(new IAPMidasCallback() { // from class: com.tencent.midas.oversea.business.payhub.gwallet.New.APIntroInfo.1
            @Override // com.tencent.midas.oversea.newapi.response.IAPMidasCallback
            public void callback(int i, String str) {
                APIntroInfo.this.callbackRspDiscountServer(i, str);
            }
        });
    }

    @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.OnIabSetupFinishedListener
    public void onIabSetupFinished(WrapperBillingResult wrapperBillingResult) {
        Log.d(TAG, "donIabSetupFinished: " + wrapperBillingResult);
        if (wrapperBillingResult.isSuccess()) {
            getPurchaseList();
        } else {
            callbackSDK(-1, null);
        }
    }

    private void getPurchaseList() {
        this.billingHelper.querySkuDetailsAsync(q.c().a(this.productList).a(IabHelper.ITEM_TYPE_SUBS).a(), new BillingHelper.OnIabQuerySkuDetailsListener() { // from class: com.tencent.midas.oversea.business.payhub.gwallet.New.APIntroInfo.2
            @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.OnIabQuerySkuDetailsListener
            public void onSkuDetailsResponse(WrapperBillingResult wrapperBillingResult, List<p> list) {
                int i;
                JSONArray jSONArray;
                Log.d(APIntroInfo.TAG, "querySkuDetailsAsync:" + wrapperBillingResult);
                if (wrapperBillingResult.isSuccess() && list != null && !list.isEmpty()) {
                    jSONArray = new JSONArray();
                    try {
                        for (p pVar : list) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("productId", pVar.b());
                            jSONObject.put(FirebaseAnalytics.Param.PRICE, pVar.d());
                            jSONObject.put("microprice", pVar.e());
                            jSONObject.put(FirebaseAnalytics.Param.CURRENCY, pVar.f());
                            jSONObject.put("introPrice", pVar.i());
                            jSONObject.put("introMicroPrice", pVar.j());
                            jSONObject.put("introPeriod", pVar.l());
                            jSONObject.put("introCycles", pVar.k());
                            jSONObject.put("originalPrice", pVar.g());
                            jSONObject.put("originalMicroprice", pVar.h());
                            jSONArray.put(jSONObject);
                        }
                        i = 0;
                    } catch (JSONException unused) {
                        APLog.e(APIntroInfo.TAG, "Query intro price exception.");
                    }
                    APIntroInfo.this.dispose();
                    APIntroInfo.this.callbackSDK(i, jSONArray);
                }
                i = -1;
                jSONArray = null;
                APIntroInfo.this.dispose();
                APIntroInfo.this.callbackSDK(i, jSONArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispose() {
        BillingHelper billingHelper = this.billingHelper;
        if (billingHelper != null) {
            billingHelper.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackSDK(int i, JSONArray jSONArray) {
        this.isSDKQueryFinished = true;
        if (jSONArray != null) {
            this.intro_sdkJInfo = jSONArray.toString();
        }
        if (this.isServerQueryFinished) {
            callbackIntro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackRspDiscountServer(int i, String str) {
        this.isServerQueryFinished = true;
        this.intro_serverJInfo = str;
        if (this.isSDKQueryFinished) {
            callbackIntro();
        }
    }

    private void callbackIntro() {
        String str = "";
        try {
            if (!TextUtils.isEmpty(this.intro_sdkJInfo)) {
                if (!TextUtils.isEmpty(this.intro_serverJInfo)) {
                    JSONObject jSONObject = new JSONObject(this.intro_serverJInfo);
                    jSONObject.put("ret", 0);
                    jSONObject.put("gwallet_productInfo", new JSONArray(this.intro_sdkJInfo));
                    str = jSONObject.toString();
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ret", 0);
                    jSONObject2.put("gwallet_productInfo", new JSONArray(this.intro_sdkJInfo));
                    str = jSONObject2.toString();
                }
            } else {
                JSONObject jSONObject3 = new JSONObject(this.intro_serverJInfo);
                if (!jSONObject3.has("ret") || jSONObject3.getInt("ret") != 0) {
                    jSONObject3.put("ret", -1);
                }
                str = jSONObject3.toString();
            }
        } catch (JSONException e) {
            APLog.e(TAG, "CallbackErr: " + e.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            str = "{\"ret\":-1}";
        }
        APLog.d(TAG, "Callback Response: " + str);
        InfoCallback infoCallback = this.mCallback;
        if (infoCallback != null) {
            infoCallback.callback(str);
        }
    }
}
