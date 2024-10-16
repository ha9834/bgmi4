package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbmf implements zzdti<zzbme> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcxu> f2931a;
    private final zzdtu<zzcxm> b;
    private final zzdtu<zzdae> c;

    private zzbmf(zzdtu<zzcxu> zzdtuVar, zzdtu<zzcxm> zzdtuVar2, zzdtu<zzdae> zzdtuVar3) {
        this.f2931a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    public static zzbmf zza(zzdtu<zzcxu> zzdtuVar, zzdtu<zzcxm> zzdtuVar2, zzdtu<zzdae> zzdtuVar3) {
        return new zzbmf(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbme(this.f2931a.get(), this.b.get(), this.c.get());
    }
}
