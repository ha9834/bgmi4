package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class zzcgl implements zzdti<zzcgb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Executor> f3247a;
    private final zzdtu<Context> b;
    private final zzdtu<Executor> c;
    private final zzdtu<zzclc> d;
    private final zzdtu<ScheduledExecutorService> e;

    public zzcgl(zzdtu<Executor> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<Executor> zzdtuVar3, zzdtu<zzclc> zzdtuVar4, zzdtu<ScheduledExecutorService> zzdtuVar5) {
        this.f3247a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcgb(this.f3247a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
