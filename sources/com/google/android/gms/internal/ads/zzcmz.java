package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class zzcmz<AdT> implements zzdti<zzcmx<AdT>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzczt> f3331a;
    private final zzdtu<zzcmu> b;
    private final zzdtu<zzbrm> c;
    private final zzdtu<zzdae> d;
    private final zzdtu<zzbpe<AdT>> e;
    private final zzdtu<Executor> f;
    private final zzdtu<ScheduledExecutorService> g;

    private zzcmz(zzdtu<zzczt> zzdtuVar, zzdtu<zzcmu> zzdtuVar2, zzdtu<zzbrm> zzdtuVar3, zzdtu<zzdae> zzdtuVar4, zzdtu<zzbpe<AdT>> zzdtuVar5, zzdtu<Executor> zzdtuVar6, zzdtu<ScheduledExecutorService> zzdtuVar7) {
        this.f3331a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
        this.f = zzdtuVar6;
        this.g = zzdtuVar7;
    }

    public static <AdT> zzcmz<AdT> zza(zzdtu<zzczt> zzdtuVar, zzdtu<zzcmu> zzdtuVar2, zzdtu<zzbrm> zzdtuVar3, zzdtu<zzdae> zzdtuVar4, zzdtu<zzbpe<AdT>> zzdtuVar5, zzdtu<Executor> zzdtuVar6, zzdtu<ScheduledExecutorService> zzdtuVar7) {
        return new zzcmz<>(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6, zzdtuVar7);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcmx(this.f3331a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
