package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzcuz;

/* loaded from: classes2.dex */
final class yj<S extends zzcuz> {

    /* renamed from: a, reason: collision with root package name */
    public final zzbbh<S> f2637a;
    private final long b;
    private final Clock c;

    public yj(zzbbh<S> zzbbhVar, long j, Clock clock) {
        this.f2637a = zzbbhVar;
        this.c = clock;
        this.b = clock.elapsedRealtime() + j;
    }

    public final boolean a() {
        return this.b < this.c.elapsedRealtime();
    }
}
