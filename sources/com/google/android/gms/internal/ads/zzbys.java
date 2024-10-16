package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbys implements zzdti<zzbyn> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Executor> f3127a;
    private final zzdtu<zzbyt> b;
    private final zzdtu<zzbzb> c;
    private final zzdtu<zzbzl> d;
    private final zzdtu<zzbyx> e;
    private final zzdtu<zzbzc> f;
    private final zzdtu<zzccb> g;
    private final zzdtu<zzcbz> h;
    private final zzdtu<zzccg> i;
    private final zzdtu<zzcbw> j;
    private final zzdtu<zzccd> k;
    private final zzdtu<zzavf> l;
    private final zzdtu<zzdh> m;
    private final zzdtu<zzbai> n;
    private final zzdtu<Context> o;
    private final zzdtu<zzcxu> p;
    private final zzdtu<zzcxm> q;
    private final zzdtu<zzbry> r;
    private final zzdtu<zzbso> s;
    private final zzdtu<String> t;

    private zzbys(zzdtu<Executor> zzdtuVar, zzdtu<zzbyt> zzdtuVar2, zzdtu<zzbzb> zzdtuVar3, zzdtu<zzbzl> zzdtuVar4, zzdtu<zzbyx> zzdtuVar5, zzdtu<zzbzc> zzdtuVar6, zzdtu<zzccb> zzdtuVar7, zzdtu<zzcbz> zzdtuVar8, zzdtu<zzccg> zzdtuVar9, zzdtu<zzcbw> zzdtuVar10, zzdtu<zzccd> zzdtuVar11, zzdtu<zzavf> zzdtuVar12, zzdtu<zzdh> zzdtuVar13, zzdtu<zzbai> zzdtuVar14, zzdtu<Context> zzdtuVar15, zzdtu<zzcxu> zzdtuVar16, zzdtu<zzcxm> zzdtuVar17, zzdtu<zzbry> zzdtuVar18, zzdtu<zzbso> zzdtuVar19, zzdtu<String> zzdtuVar20) {
        this.f3127a = zzdtuVar;
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
        this.n = zzdtuVar14;
        this.o = zzdtuVar15;
        this.p = zzdtuVar16;
        this.q = zzdtuVar17;
        this.r = zzdtuVar18;
        this.s = zzdtuVar19;
        this.t = zzdtuVar20;
    }

    public static zzbys zza(zzdtu<Executor> zzdtuVar, zzdtu<zzbyt> zzdtuVar2, zzdtu<zzbzb> zzdtuVar3, zzdtu<zzbzl> zzdtuVar4, zzdtu<zzbyx> zzdtuVar5, zzdtu<zzbzc> zzdtuVar6, zzdtu<zzccb> zzdtuVar7, zzdtu<zzcbz> zzdtuVar8, zzdtu<zzccg> zzdtuVar9, zzdtu<zzcbw> zzdtuVar10, zzdtu<zzccd> zzdtuVar11, zzdtu<zzavf> zzdtuVar12, zzdtu<zzdh> zzdtuVar13, zzdtu<zzbai> zzdtuVar14, zzdtu<Context> zzdtuVar15, zzdtu<zzcxu> zzdtuVar16, zzdtu<zzcxm> zzdtuVar17, zzdtu<zzbry> zzdtuVar18, zzdtu<zzbso> zzdtuVar19, zzdtu<String> zzdtuVar20) {
        return new zzbys(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6, zzdtuVar7, zzdtuVar8, zzdtuVar9, zzdtuVar10, zzdtuVar11, zzdtuVar12, zzdtuVar13, zzdtuVar14, zzdtuVar15, zzdtuVar16, zzdtuVar17, zzdtuVar18, zzdtuVar19, zzdtuVar20);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzbyn zzbynVar = new zzbyn(this.f3127a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), zzdth.zzap(this.g), zzdth.zzap(this.h), zzdth.zzap(this.i), zzdth.zzap(this.j), zzdth.zzap(this.k), this.l.get(), this.m.get(), this.n.get(), this.o.get());
        zzbql.zza(zzbynVar, this.p.get());
        zzbql.zza(zzbynVar, this.q.get());
        zzbql.zza(zzbynVar, this.r.get());
        zzbql.zza(zzbynVar, this.s.get());
        zzbql.zza(zzbynVar, this.t.get());
        return zzbynVar;
    }
}
