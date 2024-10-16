package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

@zzard
/* loaded from: classes.dex */
final class hn<V> extends FutureTask<V> implements zzbbh<V> {

    /* renamed from: a, reason: collision with root package name */
    private final hl f2220a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hn(Callable<V> callable) {
        super(callable);
        this.f2220a = new hl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public hn(Runnable runnable, @Nullable V v) {
        super(runnable, v);
        this.f2220a = new hl();
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void zza(Runnable runnable, Executor executor) {
        this.f2220a.a(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    protected final void done() {
        this.f2220a.a();
    }
}
