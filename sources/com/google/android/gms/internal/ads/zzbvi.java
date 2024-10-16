package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbvi implements zzdti<zzbvh> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcxm> f3071a;
    private final zzdtu<zzdae> b;

    private zzbvi(zzdtu<zzcxm> zzdtuVar, zzdtu<zzdae> zzdtuVar2) {
        this.f3071a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzbvi zzh(zzdtu<zzcxm> zzdtuVar, zzdtu<zzdae> zzdtuVar2) {
        return new zzbvi(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbvh(this.f3071a.get(), this.b.get());
    }
}
