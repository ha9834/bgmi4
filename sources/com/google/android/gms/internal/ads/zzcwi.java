package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcwi implements zzcuz<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private String f3473a;
    private String b;

    public zzcwi(String str, String str2) {
        this.f3473a = str;
        this.b = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(JSONObject jSONObject) {
        try {
            JSONObject zzb = zzazc.zzb(jSONObject, "pii");
            zzb.put("doritos", this.f3473a);
            zzb.put("doritos_v2", this.b);
        } catch (JSONException unused) {
            zzawz.zzds("Failed putting doritos string.");
        }
    }
}
