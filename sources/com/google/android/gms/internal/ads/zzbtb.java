package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzbtb extends zzbts<zzbtf> {

    /* renamed from: a */
    private final ScheduledExecutorService f3039a;
    private final Clock b;

    @GuardedBy("this")
    private long c;

    @GuardedBy("this")
    private long d;

    @GuardedBy("this")
    private boolean e;

    @GuardedBy("this")
    private ScheduledFuture<?> f;

    public zzbtb(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.c = -1L;
        this.d = -1L;
        this.e = false;
        this.f3039a = scheduledExecutorService;
        this.b = clock;
    }

    public final synchronized void onPause() {
        if (!this.e) {
            if (this.f != null && !this.f.isCancelled()) {
                this.f.cancel(true);
                this.d = this.c - this.b.elapsedRealtime();
            } else {
                this.d = -1L;
            }
            this.e = true;
        }
    }

    public final synchronized void onResume() {
        if (this.e) {
            if (this.d > 0 && this.f.isCancelled()) {
                a(this.d);
            }
            this.e = false;
        }
    }

    public final synchronized void zzagi() {
        this.e = false;
        a(0L);
    }

    public final synchronized void zzdk(int i) {
        if (i <= 0) {
            return;
        }
        long millis = TimeUnit.SECONDS.toMillis(i);
        if (!this.e) {
            if (this.b.elapsedRealtime() > this.c || this.c - this.b.elapsedRealtime() > millis) {
                a(millis);
            }
        } else {
            if (this.d <= 0 || millis >= this.d) {
                millis = this.d;
            }
            this.d = millis;
        }
    }

    private final synchronized void a(long j) {
        if (this.f != null && !this.f.isDone()) {
            this.f.cancel(true);
        }
        this.c = this.b.elapsedRealtime() + j;
        this.f = this.f3039a.schedule(new ox(this), j, TimeUnit.MILLISECONDS);
    }

    public final void a() {
        a(ov.f2404a);
    }
}
