package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbnj implements zzdti<nh> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f2950a;
    private final zzdtu<zzcxn> b;
    private final zzdtu<View> c;
    private final zzdtu<zzbgz> d;
    private final zzdtu<zzbpb> e;
    private final zzdtu<zzbzc> f;
    private final zzdtu<zzbvd> g;
    private final zzdtu<zzcpm> h;
    private final zzdtu<Executor> i;
    private final zzdtu<zzcxu> j;
    private final zzdtu<zzcxm> k;
    private final zzdtu<zzbry> l;
    private final zzdtu<zzbso> m;
    private final zzdtu<String> n;

    public zzbnj(zzdtu<Context> zzdtuVar, zzdtu<zzcxn> zzdtuVar2, zzdtu<View> zzdtuVar3, zzdtu<zzbgz> zzdtuVar4, zzdtu<zzbpb> zzdtuVar5, zzdtu<zzbzc> zzdtuVar6, zzdtu<zzbvd> zzdtuVar7, zzdtu<zzcpm> zzdtuVar8, zzdtu<Executor> zzdtuVar9, zzdtu<zzcxu> zzdtuVar10, zzdtu<zzcxm> zzdtuVar11, zzdtu<zzbry> zzdtuVar12, zzdtu<zzbso> zzdtuVar13, zzdtu<String> zzdtuVar14) {
        this.f2950a = zzdtuVar;
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
    }

    public static nh zza(Context context, zzcxn zzcxnVar, View view, zzbgz zzbgzVar, zzbpb zzbpbVar, zzbzc zzbzcVar, zzbvd zzbvdVar, zzdte<zzcpm> zzdteVar, Executor executor) {
        return new nh(context, zzcxnVar, view, zzbgzVar, zzbpbVar, zzbzcVar, zzbvdVar, zzdteVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        nh nhVar = new nh(this.f2950a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), zzdth.zzap(this.h), this.i.get());
        zzbql.zza(nhVar, this.j.get());
        zzbql.zza(nhVar, this.k.get());
        zzbql.zza(nhVar, this.l.get());
        zzbql.zza(nhVar, this.m.get());
        zzbql.zza(nhVar, this.n.get());
        return nhVar;
    }
}
