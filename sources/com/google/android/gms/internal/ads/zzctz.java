package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcuz;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzctz<S extends zzcuz> implements zzcva<S> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcva<S> f3437a;
    private final long b;
    private final ScheduledExecutorService c;

    public zzctz(zzcva<S> zzcvaVar, long j, ScheduledExecutorService scheduledExecutorService) {
        this.f3437a = zzcvaVar;
        this.b = j;
        this.c = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<S> zzalm() {
        zzbbh<S> zzalm = this.f3437a.zzalm();
        long j = this.b;
        if (j > 0) {
            zzalm = zzbar.zza(zzalm, j, TimeUnit.MILLISECONDS, this.c);
        }
        return zzbar.zza(zzalm, Throwable.class, yz.f2652a, zzbbm.zzeaf);
    }
}
