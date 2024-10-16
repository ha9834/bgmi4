package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class zzchp implements zzdti<zzchl> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbtg> f3263a;
    private final zzdtu<zzcxv> b;
    private final zzdtu<zzcgn> c;
    private final zzdtu<zzbbl> d;
    private final zzdtu<ScheduledExecutorService> e;
    private final zzdtu<zzcji> f;

    private zzchp(zzdtu<zzbtg> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<zzcgn> zzdtuVar3, zzdtu<zzbbl> zzdtuVar4, zzdtu<ScheduledExecutorService> zzdtuVar5, zzdtu<zzcji> zzdtuVar6) {
        this.f3263a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
        this.f = zzdtuVar6;
    }

    public static zzchp zza(zzdtu<zzbtg> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<zzcgn> zzdtuVar3, zzdtu<zzbbl> zzdtuVar4, zzdtu<ScheduledExecutorService> zzdtuVar5, zzdtu<zzcji> zzdtuVar6) {
        return new zzchp(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzchl(this.f3263a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
