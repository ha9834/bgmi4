package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class di<V> extends FutureTask<V> implements Comparable<di> {

    /* renamed from: a, reason: collision with root package name */
    final boolean f4806a;
    private final long b;
    private final String c;
    private final /* synthetic */ zzfc d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public di(zzfc zzfcVar, Callable<V> callable, boolean z, String str) {
        super(callable);
        AtomicLong atomicLong;
        this.d = zzfcVar;
        Preconditions.checkNotNull(str);
        atomicLong = zzfc.j;
        this.b = atomicLong.getAndIncrement();
        this.c = str;
        this.f4806a = z;
        if (this.b == Long.MAX_VALUE) {
            zzfcVar.zzab().zzgk().zzao("Tasks index overflow");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public di(zzfc zzfcVar, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        AtomicLong atomicLong;
        this.d = zzfcVar;
        Preconditions.checkNotNull(str);
        atomicLong = zzfc.j;
        this.b = atomicLong.getAndIncrement();
        this.c = str;
        this.f4806a = false;
        if (this.b == Long.MAX_VALUE) {
            zzfcVar.zzab().zzgk().zzao("Tasks index overflow");
        }
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        this.d.zzab().zzgk().zza(this.c, th);
        if (th instanceof zzff) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(di diVar) {
        di diVar2 = diVar;
        boolean z = this.f4806a;
        if (z != diVar2.f4806a) {
            return z ? -1 : 1;
        }
        long j = this.b;
        long j2 = diVar2.b;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.d.zzab().zzgl().zza("Two tasks share the same index. index", Long.valueOf(this.b));
        return 0;
    }
}
