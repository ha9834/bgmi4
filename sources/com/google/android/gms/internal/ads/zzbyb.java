package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbyb implements zzdti<zzbxx> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3115a;
    private final zzdtu<zzbzc> b;
    private final zzdtu<JSONObject> c;
    private final zzdtu<zzccj> d;
    private final zzdtu<zzbyt> e;
    private final zzdtu<zzdh> f;
    private final zzdtu<zzbrt> g;
    private final zzdtu<zzbri> h;
    private final zzdtu<zzcxm> i;
    private final zzdtu<zzbai> j;
    private final zzdtu<zzcxv> k;
    private final zzdtu<zzbmn> l;
    private final zzdtu<zzbzq> m;
    private final zzdtu<Clock> n;
    private final zzdtu<zzbva> o;
    private final zzdtu<zzdae> p;

    public zzbyb(zzdtu<Context> zzdtuVar, zzdtu<zzbzc> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3, zzdtu<zzccj> zzdtuVar4, zzdtu<zzbyt> zzdtuVar5, zzdtu<zzdh> zzdtuVar6, zzdtu<zzbrt> zzdtuVar7, zzdtu<zzbri> zzdtuVar8, zzdtu<zzcxm> zzdtuVar9, zzdtu<zzbai> zzdtuVar10, zzdtu<zzcxv> zzdtuVar11, zzdtu<zzbmn> zzdtuVar12, zzdtu<zzbzq> zzdtuVar13, zzdtu<Clock> zzdtuVar14, zzdtu<zzbva> zzdtuVar15, zzdtu<zzdae> zzdtuVar16) {
        this.f3115a = zzdtuVar;
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
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbxx(this.f3115a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get());
    }
}
