package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class zzbpq implements zzdti<zzbpk> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Executor> f2993a;
    private final zzdtu<ScheduledExecutorService> b;
    private final zzdtu<zzbbh<zzbph>> c;

    public zzbpq(zzdtu<Executor> zzdtuVar, zzdtu<ScheduledExecutorService> zzdtuVar2, zzdtu<zzbbh<zzbph>> zzdtuVar3) {
        this.f2993a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbpk(this.f2993a.get(), this.b.get(), this.c.get());
    }
}
