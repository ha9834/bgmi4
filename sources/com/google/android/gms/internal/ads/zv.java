package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final class zv implements zzcva<zzcuz<JSONObject>> {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f2675a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zv(Context context) {
        this.f2675a = zzasj.zzu(context);
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcuz<JSONObject>> zzalm() {
        return zzbar.zzm(new zzcuz(this) { // from class: com.google.android.gms.internal.ads.zw

            /* renamed from: a, reason: collision with root package name */
            private final zv f2676a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2676a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcuz
            public final void zzt(Object obj) {
                this.f2676a.a((JSONObject) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.f2675a);
        } catch (JSONException unused) {
            zzawz.zzds("Failed putting version constants.");
        }
    }
}
