package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.android.billingclient.api.ak;
import com.android.billingclient.api.b;
import com.android.billingclient.api.g;
import com.android.billingclient.api.h;
import com.android.billingclient.api.i;
import com.android.billingclient.api.l;
import com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

/* loaded from: classes2.dex */
public final class zza {
    public static final int zza = Runtime.getRuntime().availableProcessors();

    private static l a(String str, String str2) {
        if (str == null || str2 == null) {
            zzb(BillingHelper.TAG, "Received a bad purchase data.");
            return null;
        }
        try {
            return new l(str, str2);
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
            sb.append("Got JSONException while parsing purchase data: ");
            sb.append(valueOf);
            zzb(BillingHelper.TAG, sb.toString());
            return null;
        }
    }

    public static void zza(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            Log.v(str, str2);
        }
    }

    public static void zzb(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static h zzc(Intent intent, String str) {
        if (intent == null) {
            zzb(BillingHelper.TAG, "Got null intent!");
            h.a c = h.c();
            c.a(6);
            c.a("An internal error occurred.");
            return c.a();
        }
        h.a c2 = h.c();
        c2.a(zzd(intent.getExtras(), str));
        c2.a(zze(intent.getExtras(), str));
        return c2.a();
    }

    public static int zzd(Bundle bundle, String str) {
        if (bundle == null) {
            zzb(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            zza(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        String valueOf = String.valueOf(obj.getClass().getName());
        zzb(str, valueOf.length() != 0 ? "Unexpected type for bundle response code: ".concat(valueOf) : new String("Unexpected type for bundle response code: "));
        return 6;
    }

    public static String zze(Bundle bundle, String str) {
        if (bundle == null) {
            zzb(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            zza(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        String valueOf = String.valueOf(obj.getClass().getName());
        zzb(str, valueOf.length() != 0 ? "Unexpected type for debug message: ".concat(valueOf) : new String("Unexpected type for debug message: "));
        return "";
    }

    public static List<l> zzf(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList != null && stringArrayList2 != null) {
            for (int i = 0; i < stringArrayList.size() && i < stringArrayList2.size(); i++) {
                l a2 = a(stringArrayList.get(i), stringArrayList2.get(i));
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        } else {
            zzb(BillingHelper.TAG, "Couldn't find purchase lists, trying to find single data.");
            l a3 = a(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"));
            if (a3 == null) {
                zzb(BillingHelper.TAG, "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(a3);
        }
        return arrayList;
    }

    public static Bundle zzg(g gVar, boolean z, boolean z2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        if (gVar.d() != 0) {
            bundle.putInt("prorationMode", gVar.d());
        }
        if (!TextUtils.isEmpty(gVar.g())) {
            bundle.putString("accountId", gVar.g());
        }
        if (!TextUtils.isEmpty(gVar.i())) {
            bundle.putString("obfuscatedProfileId", gVar.i());
        }
        if (gVar.c()) {
            bundle.putBoolean("vr", true);
        }
        if (!TextUtils.isEmpty(gVar.a())) {
            bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(gVar.a())));
        }
        if (!TextUtils.isEmpty(gVar.b())) {
            bundle.putString("oldSkuPurchaseToken", gVar.b());
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("oldSkuPurchaseId", null);
        }
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("paymentsPurchaseParams", null);
        }
        if (z && z2) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        return bundle;
    }

    public static Bundle zzh(boolean z, boolean z2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        if (z && z2) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        return bundle;
    }

    public static Bundle zzi(int i, boolean z, String str, String str2, ArrayList<ak> arrayList) {
        Bundle bundle = new Bundle();
        if (i >= 9) {
            bundle.putString("playBillingLibraryVersion", str);
        }
        if (i >= 9 && z) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        if (i >= 14) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            int size = arrayList.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.get(i2);
                arrayList2.add(null);
                z2 |= !TextUtils.isEmpty(null);
            }
            if (z2) {
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2);
            }
        }
        return bundle;
    }

    public static Bundle zzj(i iVar, boolean z, String str) {
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putString("playBillingLibraryVersion", str);
        }
        return bundle;
    }

    public static Bundle zzk(b bVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        return bundle;
    }
}
