package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcvn implements zzcuz<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3461a;
    private final AdvertisingIdClient.Info b;
    private final String c;

    public zzcvn(AdvertisingIdClient.Info info, Context context, String str) {
        this.f3461a = context;
        this.b = info;
        this.c = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(JSONObject jSONObject) {
        try {
            JSONObject zzb = zzazc.zzb(jSONObject, "pii");
            String str = null;
            boolean z = false;
            if (this.b != null) {
                str = this.b.getId();
                z = this.b.isLimitAdTrackingEnabled();
            }
            if (!TextUtils.isEmpty(str)) {
                zzb.put("rdid", str);
                zzb.put("is_lat", z);
                zzb.put("idtype", "adid");
            } else {
                zzb.put("pdid", this.c);
                zzb.put("pdidtype", "ssaid");
            }
        } catch (JSONException e) {
            zzawz.zza("Failed putting Ad ID.", e);
        }
    }
}
