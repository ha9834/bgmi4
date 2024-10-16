package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbzp implements zzdti<zzbzl> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3141a;
    private final zzdtu<zzaxb> b;
    private final zzdtu<zzcxv> c;
    private final zzdtu<zzbyx> d;
    private final zzdtu<zzbyt> e;
    private final zzdtu<zzbzt> f;
    private final zzdtu<Executor> g;
    private final zzdtu<Executor> h;

    private zzbzp(zzdtu<Context> zzdtuVar, zzdtu<zzaxb> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<zzbyx> zzdtuVar4, zzdtu<zzbyt> zzdtuVar5, zzdtu<zzbzt> zzdtuVar6, zzdtu<Executor> zzdtuVar7, zzdtu<Executor> zzdtuVar8) {
        this.f3141a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
        this.f = zzdtuVar6;
        this.g = zzdtuVar7;
        this.h = zzdtuVar8;
    }

    public static zzbzp zza(zzdtu<Context> zzdtuVar, zzdtu<zzaxb> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<zzbyx> zzdtuVar4, zzdtu<zzbyt> zzdtuVar5, zzdtu<zzbzt> zzdtuVar6, zzdtu<Executor> zzdtuVar7, zzdtu<Executor> zzdtuVar8) {
        return new zzbzp(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6, zzdtuVar7, zzdtuVar8);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbzl(this.f3141a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
