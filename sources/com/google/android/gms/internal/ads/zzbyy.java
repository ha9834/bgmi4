package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbyy extends zzbyx {
    private final JSONObject b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    public zzbyy(zzcxm zzcxmVar, JSONObject jSONObject) {
        super(zzcxmVar);
        this.b = zzazc.zza(jSONObject, "tracking_urls_and_actions", "active_view");
        this.c = zzazc.zza(false, jSONObject, "allow_pub_owned_ad_view");
        this.d = zzazc.zza(false, jSONObject, "attribution", "allow_pub_rendering");
        this.e = zzazc.zza(false, jSONObject, "enable_omid");
    }

    @Override // com.google.android.gms.internal.ads.zzbyx
    public final JSONObject zzaie() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.f3129a.zzdnr);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbyx
    public final boolean zzaif() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzbyx
    public final boolean zzaih() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzbyx
    public final boolean zzaig() {
        return this.d;
    }
}
