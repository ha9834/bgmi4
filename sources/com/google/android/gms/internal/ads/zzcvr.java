package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class zzcvr implements zzdti<zzcvo> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzawi> f3463a;
    private final zzdtu<Context> b;
    private final zzdtu<ScheduledExecutorService> c;
    private final zzdtu<Executor> d;

    public zzcvr(zzdtu<zzawi> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<ScheduledExecutorService> zzdtuVar3, zzdtu<Executor> zzdtuVar4) {
        this.f3463a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcvo(this.f3463a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
