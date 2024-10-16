package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.h;
import com.google.android.gms.internal.play_billing.zza;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class af {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a(Bundle bundle, String str, String str2) {
        h hVar = ad.l;
        if (bundle == null) {
            zza.zzb("BillingClient", String.format("%s got null owned items list", str2));
            return hVar;
        }
        int zzd = zza.zzd(bundle, "BillingClient");
        String zze = zza.zze(bundle, "BillingClient");
        h.a c = h.c();
        c.a(zzd);
        c.a(zze);
        h a2 = c.a();
        if (zzd != 0) {
            zza.zzb("BillingClient", String.format("%s failed. Response code: %s", str2, Integer.valueOf(zzd)));
            return a2;
        }
        if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            zza.zzb("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", str2));
            return hVar;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        if (stringArrayList == null) {
            zza.zzb("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", str2));
            return hVar;
        }
        if (stringArrayList2 == null) {
            zza.zzb("BillingClient", String.format("Bundle returned from %s contains null purchases list.", str2));
            return hVar;
        }
        if (stringArrayList3 != null) {
            return ad.p;
        }
        zza.zzb("BillingClient", String.format("Bundle returned from %s contains null signatures list.", str2));
        return hVar;
    }
}
