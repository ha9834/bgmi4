package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzh;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class a {
    private static volatile Handler b;

    /* renamed from: a, reason: collision with root package name */
    private final eg f4722a;
    private final Runnable c;
    private volatile long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(eg egVar) {
        Preconditions.checkNotNull(egVar);
        this.f4722a = egVar;
        this.c = new b(this, egVar);
    }

    public abstract void a();

    public final void a(long j) {
        c();
        if (j >= 0) {
            this.d = this.f4722a.zzx().currentTimeMillis();
            if (d().postDelayed(this.c, j)) {
                return;
            }
            this.f4722a.zzab().zzgk().zza("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public final boolean b() {
        return this.d != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        this.d = 0L;
        d().removeCallbacks(this.c);
    }

    private final Handler d() {
        Handler handler;
        if (b != null) {
            return b;
        }
        synchronized (a.class) {
            if (b == null) {
                b = new zzh(this.f4722a.getContext().getMainLooper());
            }
            handler = b;
        }
        return handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long a(a aVar, long j) {
        aVar.d = 0L;
        return 0L;
    }
}
