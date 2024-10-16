package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class gn {

    /* renamed from: a, reason: collision with root package name */
    private final Clock f4888a;
    private long b;

    public gn(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.f4888a = clock;
    }

    public final void a() {
        this.b = this.f4888a.elapsedRealtime();
    }

    public final void b() {
        this.b = 0L;
    }

    public final boolean a(long j) {
        return this.b == 0 || this.f4888a.elapsedRealtime() - this.b >= 3600000;
    }
}
