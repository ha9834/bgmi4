package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzfc extends ee {
    private static final AtomicLong j = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: a, reason: collision with root package name */
    private dh f4940a;
    private dh b;
    private final PriorityBlockingQueue<di<?>> c;
    private final BlockingQueue<di<?>> d;
    private final Thread.UncaughtExceptionHandler e;
    private final Thread.UncaughtExceptionHandler f;
    private final Object g;
    private final Semaphore h;
    private volatile boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfc(zzfj zzfjVar) {
        super(zzfjVar);
        this.g = new Object();
        this.h = new Semaphore(2);
        this.c = new PriorityBlockingQueue<>();
        this.d = new LinkedBlockingQueue();
        this.e = new dg(this, "Thread death: Uncaught exception on worker thread");
        this.f = new dg(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // com.google.android.gms.measurement.internal.ee
    protected final boolean a() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final void zzo() {
        if (Thread.currentThread() != this.f4940a) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final void zzn() {
        if (Thread.currentThread() != this.b) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final boolean zzhp() {
        return Thread.currentThread() == this.f4940a;
    }

    public final <V> Future<V> zza(Callable<V> callable) throws IllegalStateException {
        l();
        Preconditions.checkNotNull(callable);
        di<?> diVar = new di<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f4940a) {
            if (!this.c.isEmpty()) {
                zzab().zzgn().zzao("Callable skipped the worker queue.");
            }
            diVar.run();
        } else {
            a(diVar);
        }
        return diVar;
    }

    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        l();
        Preconditions.checkNotNull(callable);
        di<?> diVar = new di<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f4940a) {
            diVar.run();
        } else {
            a(diVar);
        }
        return diVar;
    }

    public final void zza(Runnable runnable) throws IllegalStateException {
        l();
        Preconditions.checkNotNull(runnable);
        a(new di<>(this, runnable, false, "Task exception on worker thread"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> T a(AtomicReference<T> atomicReference, long j2, String str, Runnable runnable) {
        synchronized (atomicReference) {
            zzaa().zza(runnable);
            try {
                atomicReference.wait(15000L);
            } catch (InterruptedException unused) {
                zzeh zzgn = zzab().zzgn();
                String valueOf = String.valueOf(str);
                zzgn.zzao(valueOf.length() != 0 ? "Interrupted waiting for ".concat(valueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            zzeh zzgn2 = zzab().zzgn();
            String valueOf2 = String.valueOf(str);
            zzgn2.zzao(valueOf2.length() != 0 ? "Timed out waiting for ".concat(valueOf2) : new String("Timed out waiting for "));
        }
        return t;
    }

    private final void a(di<?> diVar) {
        synchronized (this.g) {
            this.c.add(diVar);
            if (this.f4940a == null) {
                this.f4940a = new dh(this, "Measurement Worker", this.c);
                this.f4940a.setUncaughtExceptionHandler(this.e);
                this.f4940a.start();
            } else {
                this.f4940a.a();
            }
        }
    }

    public final void zzb(Runnable runnable) throws IllegalStateException {
        l();
        Preconditions.checkNotNull(runnable);
        di<?> diVar = new di<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.g) {
            this.d.add(diVar);
            if (this.b == null) {
                this.b = new dh(this, "Measurement Network", this.d);
                this.b.setUncaughtExceptionHandler(this.f);
                this.b.start();
            } else {
                this.b.a();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ cz zzac() {
        return super.zzac();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ dh a(zzfc zzfcVar, dh dhVar) {
        zzfcVar.f4940a = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ dh b(zzfc zzfcVar, dh dhVar) {
        zzfcVar.b = null;
        return null;
    }
}
