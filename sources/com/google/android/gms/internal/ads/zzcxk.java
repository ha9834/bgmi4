package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcxk {

    /* renamed from: a, reason: collision with root package name */
    private final Clock f3493a;
    private final Object b = new Object();

    @GuardedBy("lock")
    private volatile int c = aaf.f1757a;
    private volatile long d = 0;

    public zzcxk(Clock clock) {
        this.f3493a = clock;
    }

    private final void a(int i, int i2) {
        a();
        long currentTimeMillis = this.f3493a.currentTimeMillis();
        synchronized (this.b) {
            if (this.c != i) {
                return;
            }
            this.c = i2;
            if (this.c == aaf.c) {
                this.d = currentTimeMillis;
            }
        }
    }

    private final void a() {
        long currentTimeMillis = this.f3493a.currentTimeMillis();
        synchronized (this.b) {
            if (this.c == aaf.c) {
                if (this.d + ((Long) zzyt.zzpe().zzd(zzacu.zzcwe)).longValue() <= currentTimeMillis) {
                    this.c = aaf.f1757a;
                }
            }
        }
    }

    public final void zzbb(boolean z) {
        if (z) {
            a(aaf.f1757a, aaf.b);
        } else {
            a(aaf.b, aaf.f1757a);
        }
    }

    public final boolean zzaml() {
        boolean z;
        synchronized (this.b) {
            a();
            z = this.c == aaf.b;
        }
        return z;
    }

    public final boolean zzamm() {
        boolean z;
        synchronized (this.b) {
            a();
            z = this.c == aaf.c;
        }
        return z;
    }

    public final void zzuy() {
        a(aaf.b, aaf.c);
    }
}
