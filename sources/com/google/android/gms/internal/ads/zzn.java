package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public final class zzn extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final BlockingQueue<zzr<?>> f3689a;
    private final zzm b;
    private final zzb c;
    private final zzab d;
    private volatile boolean e = false;

    public zzn(BlockingQueue<zzr<?>> blockingQueue, zzm zzmVar, zzb zzbVar, zzab zzabVar) {
        this.f3689a = blockingQueue;
        this.b = zzmVar;
        this.c = zzbVar;
        this.d = zzabVar;
    }

    public final void quit() {
        this.e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzag.e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private final void a() throws InterruptedException {
        zzr<?> take = this.f3689a.take();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        take.a(3);
        try {
            take.zzb("network-queue-take");
            take.isCanceled();
            TrafficStats.setThreadStatsTag(take.zzd());
            zzp zzc = this.b.zzc(take);
            take.zzb("network-http-complete");
            if (zzc.zzac && take.zzl()) {
                take.b("not-modified");
                take.a();
                return;
            }
            zzy<?> a2 = take.a(zzc);
            take.zzb("network-parse-complete");
            if (take.zzh() && a2.zzbh != null) {
                this.c.zza(take.zze(), a2.zzbh);
                take.zzb("network-cache-written");
            }
            take.zzk();
            this.d.zzb(take, a2);
            take.a(a2);
        } catch (Exception e) {
            zzag.zza(e, "Unhandled exception %s", e.toString());
            zzaf zzafVar = new zzaf(e);
            zzafVar.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.d.zza(take, zzafVar);
            take.a();
        } catch (zzaf e2) {
            e2.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.d.zza(take, e2);
            take.a();
        } finally {
            take.a(4);
        }
    }
}
