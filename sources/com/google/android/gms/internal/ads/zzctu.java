package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;

/* loaded from: classes2.dex */
public final class zzctu implements zzdti<zzctp> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbbl> f3433a;
    private final zzdtu<zzcxv> b;
    private final zzdtu<PackageInfo> c;
    private final zzdtu<zzaxb> d;

    public zzctu(zzdtu<zzbbl> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<PackageInfo> zzdtuVar3, zzdtu<zzaxb> zzdtuVar4) {
        this.f3433a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzctp(this.f3433a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
