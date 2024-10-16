package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcea implements zzdti<zzcdp> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbri> f3198a;
    private final zzdtu<zzbse> b;
    private final zzdtu<zzbss> c;
    private final zzdtu<zzbsv> d;
    private final zzdtu<zzbtp> e;
    private final zzdtu<Executor> f;
    private final zzdtu<zzbva> g;
    private final zzdtu<zzbmn> h;
    private final zzdtu<com.google.android.gms.ads.internal.zzb> i;
    private final zzdtu<zzbry> j;
    private final zzdtu<zzavb> k;
    private final zzdtu<zzdh> l;
    private final zzdtu<zzbtl> m;

    private zzcea(zzdtu<zzbri> zzdtuVar, zzdtu<zzbse> zzdtuVar2, zzdtu<zzbss> zzdtuVar3, zzdtu<zzbsv> zzdtuVar4, zzdtu<zzbtp> zzdtuVar5, zzdtu<Executor> zzdtuVar6, zzdtu<zzbva> zzdtuVar7, zzdtu<zzbmn> zzdtuVar8, zzdtu<com.google.android.gms.ads.internal.zzb> zzdtuVar9, zzdtu<zzbry> zzdtuVar10, zzdtu<zzavb> zzdtuVar11, zzdtu<zzdh> zzdtuVar12, zzdtu<zzbtl> zzdtuVar13) {
        this.f3198a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
        this.f = zzdtuVar6;
        this.g = zzdtuVar7;
        this.h = zzdtuVar8;
        this.i = zzdtuVar9;
        this.j = zzdtuVar10;
        this.k = zzdtuVar11;
        this.l = zzdtuVar12;
        this.m = zzdtuVar13;
    }

    public static zzcea zza(zzdtu<zzbri> zzdtuVar, zzdtu<zzbse> zzdtuVar2, zzdtu<zzbss> zzdtuVar3, zzdtu<zzbsv> zzdtuVar4, zzdtu<zzbtp> zzdtuVar5, zzdtu<Executor> zzdtuVar6, zzdtu<zzbva> zzdtuVar7, zzdtu<zzbmn> zzdtuVar8, zzdtu<com.google.android.gms.ads.internal.zzb> zzdtuVar9, zzdtu<zzbry> zzdtuVar10, zzdtu<zzavb> zzdtuVar11, zzdtu<zzdh> zzdtuVar12, zzdtu<zzbtl> zzdtuVar13) {
        return new zzcea(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6, zzdtuVar7, zzdtuVar8, zzdtuVar9, zzdtuVar10, zzdtuVar11, zzdtuVar12, zzdtuVar13);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcdp(this.f3198a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get());
    }
}
