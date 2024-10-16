package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzclv implements zzcjz<zzams, zzcla> {

    /* renamed from: a, reason: collision with root package name */
    private final zzclc f3314a;

    public zzclv(zzclc zzclcVar) {
        this.f3314a = zzclcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjz
    public final zzcjy<zzams, zzcla> zzd(String str, JSONObject jSONObject) throws Throwable {
        zzams zze = this.f3314a.zze(str, jSONObject);
        if (zze == null) {
            return null;
        }
        return new zzcjy<>(zze, new zzcla(), str);
    }
}
