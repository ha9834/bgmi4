package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcov<AdT> implements zzdti<zzcor<AdT>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzczt> f3352a;
    private final zzdtu<zzbbl> b;
    private final zzdtu<zzado> c;
    private final zzdtu<zzcou<AdT>> d;

    public zzcov(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<zzado> zzdtuVar3, zzdtu<zzcou<AdT>> zzdtuVar4) {
        this.f3352a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcor(this.f3352a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
