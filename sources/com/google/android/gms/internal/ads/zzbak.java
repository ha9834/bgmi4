package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

@zzard
/* loaded from: classes.dex */
public abstract class zzbak extends AbstractExecutorService implements zzbbl {
    @Override // java.util.concurrent.AbstractExecutorService
    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new hn(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new hn(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzbbh<?> submit(Runnable runnable) throws RejectedExecutionException {
        return (zzbbh) super.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final <T> zzbbh<T> submit(Callable<T> callable) throws RejectedExecutionException {
        return (zzbbh) super.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* synthetic */ Future submit(Runnable runnable, @Nullable Object obj) {
        return (zzbbh) super.submit(runnable, obj);
    }
}
