package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ai {

    /* renamed from: a, reason: collision with root package name */
    private final Clock f4298a;
    private long b;

    public ai(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.f4298a = clock;
    }

    public ai(Clock clock, long j) {
        Preconditions.checkNotNull(clock);
        this.f4298a = clock;
        this.b = j;
    }

    public final void a() {
        this.b = this.f4298a.elapsedRealtime();
    }

    public final void b() {
        this.b = 0L;
    }

    public final boolean a(long j) {
        return this.b == 0 || this.f4298a.elapsedRealtime() - this.b > j;
    }
}
