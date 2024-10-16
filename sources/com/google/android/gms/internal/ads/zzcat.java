package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcat implements zzdti<zzcaq> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3160a;
    private final zzdtu<zzcau> b;
    private final zzdtu<zzcbd> c;

    public zzcat(zzdtu<zzbbl> zzdtuVar, zzdtu<zzcau> zzdtuVar2, zzdtu<zzcbd> zzdtuVar3) {
        this.f3160a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcaq(this.f3160a.get(), this.b.get(), this.c.get());
    }
}
