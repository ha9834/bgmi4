package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public final class zzd extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f3521a = zzag.DEBUG;
    private final BlockingQueue<zzr<?>> b;
    private final BlockingQueue<zzr<?>> c;
    private final zzb d;
    private final zzab e;
    private volatile boolean f = false;
    private final ajb g = new ajb(this);

    public zzd(BlockingQueue<zzr<?>> blockingQueue, BlockingQueue<zzr<?>> blockingQueue2, zzb zzbVar, zzab zzabVar) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.d = zzbVar;
        this.e = zzabVar;
    }

    public final void quit() {
        this.f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (f3521a) {
            zzag.v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.zza();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzag.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private final void a() throws InterruptedException {
        zzr<?> take = this.b.take();
        take.zzb("cache-queue-take");
        take.a(1);
        try {
            take.isCanceled();
            zzc zza = this.d.zza(take.zze());
            if (zza == null) {
                take.zzb("cache-miss");
                if (!ajb.a(this.g, take)) {
                    this.c.put(take);
                }
                return;
            }
            if (zza.isExpired()) {
                take.zzb("cache-hit-expired");
                take.zza(zza);
                if (!ajb.a(this.g, take)) {
                    this.c.put(take);
                }
                return;
            }
            take.zzb("cache-hit");
            zzy<?> a2 = take.a(new zzp(zza.data, zza.zzf));
            take.zzb("cache-hit-parsed");
            if (!(zza.zze < System.currentTimeMillis())) {
                this.e.zzb(take, a2);
            } else {
                take.zzb("cache-hit-refresh-needed");
                take.zza(zza);
                a2.zzbj = true;
                if (!ajb.a(this.g, take)) {
                    this.e.zza(take, a2, new ait(this, take));
                } else {
                    this.e.zzb(take, a2);
                }
            }
        } finally {
            take.a(2);
        }
    }
}
