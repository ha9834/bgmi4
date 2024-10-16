package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcmd implements zzdti<zzclx> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbxo> f3316a;
    private final zzdtu<zzbbl> b;
    private final zzdtu<zzcaq> c;

    public zzcmd(zzdtu<zzbxo> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<zzcaq> zzdtuVar3) {
        this.f3316a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzclx(this.f3316a.get(), this.b.get(), this.c.get());
    }
}
