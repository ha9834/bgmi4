package com.google.android.gms.internal.ads;

import com.tencent.imsdk.android.IR;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public final class zzcze<E, V> implements zzbbh<V> {

    /* renamed from: a, reason: collision with root package name */
    private final E f3515a;
    private final String b;
    private final zzbbh<V> c;

    public zzcze(E e, String str, zzbbh<V> zzbbhVar) {
        this.f3515a = e;
        this.b = str;
        this.c = zzbbhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void zza(Runnable runnable, Executor executor) {
        this.c.zza(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.c.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        return this.c.get();
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.c.get(j, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.c.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.c.isDone();
    }

    public final E zzanb() {
        return this.f3515a;
    }

    public final String zzanc() {
        return this.b;
    }

    public final String toString() {
        String str = this.b;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append(IR.account.EMAIL_TAG);
        sb.append(identityHashCode);
        return sb.toString();
    }
}
