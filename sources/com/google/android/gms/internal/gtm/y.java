package com.google.android.gms.internal.gtm;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class y {
    private static volatile Handler b;

    /* renamed from: a, reason: collision with root package name */
    private final zzap f4378a;
    private final Runnable c;
    private volatile long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(zzap zzapVar) {
        Preconditions.checkNotNull(zzapVar);
        this.f4378a = zzapVar;
        this.c = new z(this);
    }

    public abstract void a();

    public final void a(long j) {
        d();
        if (j >= 0) {
            this.d = this.f4378a.zzcn().currentTimeMillis();
            if (e().postDelayed(this.c, j)) {
                return;
            }
            this.f4378a.zzco().zze("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public final void b(long j) {
        if (c()) {
            if (j < 0) {
                d();
                return;
            }
            long abs = j - Math.abs(this.f4378a.zzcn().currentTimeMillis() - this.d);
            if (abs < 0) {
                abs = 0;
            }
            e().removeCallbacks(this.c);
            if (e().postDelayed(this.c, abs)) {
                return;
            }
            this.f4378a.zzco().zze("Failed to adjust delayed post. time", Long.valueOf(abs));
        }
    }

    public final long b() {
        if (this.d == 0) {
            return 0L;
        }
        return Math.abs(this.f4378a.zzcn().currentTimeMillis() - this.d);
    }

    public final boolean c() {
        return this.d != 0;
    }

    public final void d() {
        this.d = 0L;
        e().removeCallbacks(this.c);
    }

    private final Handler e() {
        Handler handler;
        if (b != null) {
            return b;
        }
        synchronized (y.class) {
            if (b == null) {
                b = new zzdj(this.f4378a.getContext().getMainLooper());
            }
            handler = b;
        }
        return handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long a(y yVar, long j) {
        yVar.d = 0L;
        return 0L;
    }
}
