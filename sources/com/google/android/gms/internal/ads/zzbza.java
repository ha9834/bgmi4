package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbza implements zzdti<zzbyy> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcxm> f3132a;
    private final zzdtu<JSONObject> b;

    public zzbza(zzdtu<zzcxm> zzdtuVar, zzdtu<JSONObject> zzdtuVar2) {
        this.f3132a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbyy(this.f3132a.get(), this.b.get());
    }
}
