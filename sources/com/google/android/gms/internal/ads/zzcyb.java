package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcyb<T> {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private final Deque<zzbbh<T>> f3496a = new LinkedBlockingDeque();
    private final Callable<T> b;
    private final zzbbl c;

    public zzcyb(Callable<T> callable, zzbbl zzbblVar) {
        this.b = callable;
        this.c = zzbblVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void zzdq(int i) {
        int size = i - this.f3496a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f3496a.add(this.c.zza(this.b));
        }
    }

    public final synchronized zzbbh<T> zzamr() {
        zzdq(1);
        return this.f3496a.poll();
    }

    public final synchronized void zza(zzbbh<T> zzbbhVar) {
        this.f3496a.addFirst(zzbbhVar);
    }
}
