package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zza {
    private static Object l = new Object();
    private static zza m;

    /* renamed from: a, reason: collision with root package name */
    private volatile long f5159a;
    private volatile long b;
    private volatile boolean c;
    private volatile AdvertisingIdClient.Info d;
    private volatile long e;
    private volatile long f;
    private final Context g;
    private final Clock h;
    private final Thread i;
    private final Object j;
    private zzd k;

    public static zza zzf(Context context) {
        if (m == null) {
            synchronized (l) {
                if (m == null) {
                    zza zzaVar = new zza(context);
                    m = zzaVar;
                    zzaVar.i.start();
                }
            }
        }
        return m;
    }

    private zza(Context context) {
        this(context, null, DefaultClock.getInstance());
    }

    @VisibleForTesting
    private zza(Context context, zzd zzdVar, Clock clock) {
        this.f5159a = 900000L;
        this.b = 30000L;
        this.c = false;
        this.j = new Object();
        this.k = new x(this);
        this.h = clock;
        if (context != null) {
            this.g = context.getApplicationContext();
        } else {
            this.g = context;
        }
        this.e = this.h.currentTimeMillis();
        this.i = new Thread(new ap(this));
    }

    public final String zzgq() {
        if (this.d == null) {
            a();
        } else {
            b();
        }
        c();
        if (this.d == null) {
            return null;
        }
        return this.d.getId();
    }

    public final boolean isLimitAdTrackingEnabled() {
        if (this.d == null) {
            a();
        } else {
            b();
        }
        c();
        return this.d == null || this.d.isLimitAdTrackingEnabled();
    }

    private final void a() {
        synchronized (this) {
            try {
                if (!this.c) {
                    b();
                    wait(500L);
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    private final void b() {
        if (this.h.currentTimeMillis() - this.e > this.b) {
            synchronized (this.j) {
                this.j.notify();
            }
            this.e = this.h.currentTimeMillis();
        }
    }

    private final void c() {
        if (this.h.currentTimeMillis() - this.f > 3600000) {
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        Process.setThreadPriority(10);
        while (!this.c) {
            AdvertisingIdClient.Info zzgv = this.k.zzgv();
            if (zzgv != null) {
                this.d = zzgv;
                this.f = this.h.currentTimeMillis();
                zzdi.zzaw("Obtained fresh AdvertisingId info from GmsCore.");
            }
            synchronized (this) {
                notifyAll();
            }
            try {
                synchronized (this.j) {
                    this.j.wait(this.f5159a);
                }
            } catch (InterruptedException unused) {
                zzdi.zzaw("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    @VisibleForTesting
    public final void close() {
        this.c = true;
        this.i.interrupt();
    }
}
