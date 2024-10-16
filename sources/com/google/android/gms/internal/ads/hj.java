package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@zzard
/* loaded from: classes2.dex */
final class hj<T> implements zzbbh<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Throwable f2216a;
    private final hl b = new hl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public hj(Throwable th) {
        this.f2216a = th;
        this.b.a();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    @Override // java.util.concurrent.Future
    public final T get() throws ExecutionException {
        throw new ExecutionException(this.f2216a);
    }

    @Override // java.util.concurrent.Future
    public final T get(long j, TimeUnit timeUnit) throws ExecutionException {
        throw new ExecutionException(this.f2216a);
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void zza(Runnable runnable, Executor executor) {
        this.b.a(runnable, executor);
    }
}
