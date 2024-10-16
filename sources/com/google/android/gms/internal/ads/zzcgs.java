package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcgs implements zzdti<zzcgn> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3249a;
    private final zzdtu<zzbbl> b;
    private final zzdtu<zzchv> c;
    private final zzdtu<zzcig> d;

    private zzcgs(zzdtu<zzbbl> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<zzchv> zzdtuVar3, zzdtu<zzcig> zzdtuVar4) {
        this.f3249a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    public static zzcgs zzc(zzdtu<zzbbl> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<zzchv> zzdtuVar3, zzdtu<zzcig> zzdtuVar4) {
        return new zzcgs(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcgn(this.f3249a.get(), this.b.get(), this.c.get(), zzdth.zzap(this.d));
    }
}
