package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class zzckz implements zzdti<zzckv> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzboc> f3301a;
    private final zzdtu<zzckb> b;
    private final zzdtu<zzbrm> c;
    private final zzdtu<ScheduledExecutorService> d;
    private final zzdtu<zzbbl> e;

    public zzckz(zzdtu<zzboc> zzdtuVar, zzdtu<zzckb> zzdtuVar2, zzdtu<zzbrm> zzdtuVar3, zzdtu<ScheduledExecutorService> zzdtuVar4, zzdtu<zzbbl> zzdtuVar5) {
        this.f3301a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzckv(this.f3301a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
