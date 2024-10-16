package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
@zzard
/* loaded from: classes2.dex */
public final class hk<T> implements zzbbh<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f2217a;
    private final hl b = new hl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public hk(T t) {
        this.f2217a = t;
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
    public final T get() {
        return this.f2217a;
    }

    @Override // java.util.concurrent.Future
    public final T get(long j, TimeUnit timeUnit) {
        return this.f2217a;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void zza(Runnable runnable, Executor executor) {
        this.b.a(runnable, executor);
    }
}
