package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzbbr<T> implements zzbbh<T> {

    @GuardedBy("lock")
    private T b;

    @GuardedBy("lock")
    private Throwable c;

    @GuardedBy("lock")
    private boolean d;

    @GuardedBy("lock")
    private boolean e;

    /* renamed from: a, reason: collision with root package name */
    private final Object f2852a = new Object();
    private final hl f = new hl();

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void zza(Runnable runnable, Executor executor) {
        this.f.a(runnable, executor);
    }

    public final void set(T t) {
        synchronized (this.f2852a) {
            if (this.e) {
                return;
            }
            if (a()) {
                zzk.zzlk().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
                return;
            }
            this.d = true;
            this.b = t;
            this.f2852a.notifyAll();
            this.f.a();
        }
    }

    public final void setException(Throwable th) {
        synchronized (this.f2852a) {
            if (this.e) {
                return;
            }
            if (a()) {
                zzk.zzlk().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
                return;
            }
            this.c = th;
            this.f2852a.notifyAll();
            this.f.a();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Future
    public T get() throws CancellationException, ExecutionException, InterruptedException {
        T t;
        synchronized (this.f2852a) {
            while (!a()) {
                this.f2852a.wait();
            }
            if (this.c != null) {
                throw new ExecutionException(this.c);
            }
            if (this.e) {
                throw new CancellationException("SettableFuture was cancelled.");
            }
            t = this.b;
        }
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        T t;
        synchronized (this.f2852a) {
            long millis = timeUnit.toMillis(j);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = millis + currentTimeMillis;
            while (!a() && currentTimeMillis < j2) {
                this.f2852a.wait(j2 - currentTimeMillis);
                currentTimeMillis = System.currentTimeMillis();
            }
            if (this.e) {
                throw new CancellationException("SettableFuture was cancelled.");
            }
            if (this.c != null) {
                throw new ExecutionException(this.c);
            }
            if (!this.d) {
                throw new TimeoutException("SettableFuture timed out.");
            }
            t = this.b;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.f2852a) {
            if (a()) {
                return false;
            }
            this.e = true;
            this.d = true;
            this.f2852a.notifyAll();
            this.f.a();
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        synchronized (this.f2852a) {
            z = this.e;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean a2;
        synchronized (this.f2852a) {
            a2 = a();
        }
        return a2;
    }

    @GuardedBy("lock")
    private final boolean a() {
        return this.c != null || this.d;
    }
}
