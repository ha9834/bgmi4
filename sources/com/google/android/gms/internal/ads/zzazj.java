package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes2.dex */
public final class zzazj {

    /* renamed from: a, reason: collision with root package name */
    private long f2839a;

    @GuardedBy("lock")
    private long b = Long.MIN_VALUE;
    private final Object c = new Object();

    public zzazj(long j) {
        this.f2839a = j;
    }

    public final boolean tryAcquire() {
        synchronized (this.c) {
            long elapsedRealtime = zzk.zzln().elapsedRealtime();
            if (this.b + this.f2839a > elapsedRealtime) {
                return false;
            }
            this.b = elapsedRealtime;
            return true;
        }
    }

    public final void zzfe(long j) {
        synchronized (this.c) {
            this.f2839a = j;
        }
    }
}
