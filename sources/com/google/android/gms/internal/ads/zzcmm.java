package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqy;

/* loaded from: classes2.dex */
public final class zzcmm implements zzdti<zzcml> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbjm> f3322a;
    private final zzdtu<zzbxk> b;
    private final zzdtu<zzbqy.zza> c;
    private final zzdtu<zzbtv> d;

    public zzcmm(zzdtu<zzbjm> zzdtuVar, zzdtu<zzbxk> zzdtuVar2, zzdtu<zzbqy.zza> zzdtuVar3, zzdtu<zzbtv> zzdtuVar4) {
        this.f3322a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcml(this.f3322a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
