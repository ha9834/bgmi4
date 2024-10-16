package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class zzcbc implements zzdti<zzcau> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3162a;
    private final zzdtu<zzcan> b;
    private final zzdtu<zzdh> c;
    private final zzdtu<zzbai> d;
    private final zzdtu<com.google.android.gms.ads.internal.zza> e;
    private final zzdtu<zzwj> f;
    private final zzdtu<Executor> g;
    private final zzdtu<zzcxv> h;
    private final zzdtu<zzcbi> i;
    private final zzdtu<ScheduledExecutorService> j;

    public zzcbc(zzdtu<Context> zzdtuVar, zzdtu<zzcan> zzdtuVar2, zzdtu<zzdh> zzdtuVar3, zzdtu<zzbai> zzdtuVar4, zzdtu<com.google.android.gms.ads.internal.zza> zzdtuVar5, zzdtu<zzwj> zzdtuVar6, zzdtu<Executor> zzdtuVar7, zzdtu<zzcxv> zzdtuVar8, zzdtu<zzcbi> zzdtuVar9, zzdtu<ScheduledExecutorService> zzdtuVar10) {
        this.f3162a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
        this.f = zzdtuVar6;
        this.g = zzdtuVar7;
        this.h = zzdtuVar8;
        this.i = zzdtuVar9;
        this.j = zzdtuVar10;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcau(this.f3162a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
