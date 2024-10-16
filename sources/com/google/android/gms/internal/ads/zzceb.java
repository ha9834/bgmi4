package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzceb implements zzdti<zzcdn> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbhf> f3199a;
    private final zzdtu<Context> b;
    private final zzdtu<zzcxv> c;
    private final zzdtu<zzdh> d;
    private final zzdtu<zzbai> e;
    private final zzdtu<com.google.android.gms.ads.internal.zza> f;
    private final zzdtu<zzwj> g;
    private final zzdtu<zzbtb> h;

    private zzceb(zzdtu<zzbhf> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<zzdh> zzdtuVar4, zzdtu<zzbai> zzdtuVar5, zzdtu<com.google.android.gms.ads.internal.zza> zzdtuVar6, zzdtu<zzwj> zzdtuVar7, zzdtu<zzbtb> zzdtuVar8) {
        this.f3199a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
        this.f = zzdtuVar6;
        this.g = zzdtuVar7;
        this.h = zzdtuVar8;
    }

    public static zzceb zzb(zzdtu<zzbhf> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<zzdh> zzdtuVar4, zzdtu<zzbai> zzdtuVar5, zzdtu<com.google.android.gms.ads.internal.zza> zzdtuVar6, zzdtu<zzwj> zzdtuVar7, zzdtu<zzbtb> zzdtuVar8) {
        return new zzceb(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6, zzdtuVar7, zzdtuVar8);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcdn(this.f3199a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
