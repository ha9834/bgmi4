package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class zzbbc<V> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbr<Void> f2849a = new zzbbr<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbc(Iterable<? extends zzbbh<? extends V>> iterable) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzbbh<? extends V> zzbbhVar : iterable) {
            atomicInteger.incrementAndGet();
            zzbar.b(this.f2849a, zzbbhVar);
        }
        if (atomicInteger.get() == 0) {
            this.f2849a.set(null);
            return;
        }
        Iterator<? extends zzbbh<? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            it.next().zza(new Runnable(this, atomicInteger) { // from class: com.google.android.gms.internal.ads.hh

                /* renamed from: a, reason: collision with root package name */
                private final zzbbc f2214a;
                private final AtomicInteger b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2214a = this;
                    this.b = atomicInteger;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2214a.a(this.b);
                }
            }, zzbbm.zzeaf);
        }
    }

    public final <C> zzbbh<C> zza(final Callable<C> callable, Executor executor) {
        return zzbar.zza(this.f2849a, new zzbal(callable) { // from class: com.google.android.gms.internal.ads.hi

            /* renamed from: a, reason: collision with root package name */
            private final Callable f2215a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2215a = callable;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return zzbar.zzm(this.f2215a.call());
            }
        }, executor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(AtomicInteger atomicInteger) {
        if (atomicInteger.decrementAndGet() == 0) {
            this.f2849a.set(null);
        }
    }
}
