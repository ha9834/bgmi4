package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

@zzard
/* loaded from: classes2.dex */
public final class zzbar {
    public static <V> void zza(final zzbbh<V> zzbbhVar, final zzban<? super V> zzbanVar, Executor executor) {
        zzbbhVar.zza(new Runnable(zzbanVar, zzbbhVar) { // from class: com.google.android.gms.internal.ads.gx

            /* renamed from: a, reason: collision with root package name */
            private final zzban f2203a;
            private final zzbbh b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2203a = zzbanVar;
                this.b = zzbbhVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzban zzbanVar2 = this.f2203a;
                try {
                    zzbanVar2.zzk(this.b.get());
                } catch (InterruptedException e) {
                    e = e;
                    Thread.currentThread().interrupt();
                    zzbanVar2.zzb(e);
                } catch (ExecutionException e2) {
                    e = e2.getCause();
                    zzbanVar2.zzb(e);
                } catch (Exception e3) {
                    e = e3;
                    zzbanVar2.zzb(e);
                }
            }
        }, executor);
    }

    public static <A, B> zzbbh<B> zza(final zzbbh<A> zzbbhVar, final zzbam<A, B> zzbamVar, Executor executor) {
        final zzbbr zzbbrVar = new zzbbr();
        zzbbhVar.zza(new Runnable(zzbbrVar, zzbamVar, zzbbhVar) { // from class: com.google.android.gms.internal.ads.gy

            /* renamed from: a, reason: collision with root package name */
            private final zzbbr f2204a;
            private final zzbam b;
            private final zzbbh c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2204a = zzbbrVar;
                this.b = zzbamVar;
                this.c = zzbbhVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbbr zzbbrVar2 = this.f2204a;
                try {
                    zzbbrVar2.set(this.b.apply(this.c.get()));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    zzbbrVar2.setException(e);
                } catch (CancellationException unused) {
                    zzbbrVar2.cancel(true);
                } catch (ExecutionException e2) {
                    e = e2;
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        e = cause;
                    }
                    zzbbrVar2.setException(e);
                } catch (Exception e3) {
                    zzbbrVar2.setException(e3);
                }
            }
        }, executor);
        b(zzbbrVar, zzbbhVar);
        return zzbbrVar;
    }

    public static <A, B> zzbbh<B> zza(final zzbbh<A> zzbbhVar, final zzbal<? super A, ? extends B> zzbalVar, Executor executor) {
        final zzbbr zzbbrVar = new zzbbr();
        zzbbhVar.zza(new Runnable(zzbbrVar, zzbalVar, zzbbhVar) { // from class: com.google.android.gms.internal.ads.gz

            /* renamed from: a, reason: collision with root package name */
            private final zzbbr f2205a;
            private final zzbal b;
            private final zzbbh c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2205a = zzbbrVar;
                this.b = zzbalVar;
                this.c = zzbbhVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbar.a(this.f2205a, this.b, this.c);
            }
        }, executor);
        b(zzbbrVar, zzbbhVar);
        return zzbbrVar;
    }

    public static <V> zzbbh<List<V>> zze(final Iterable<? extends zzbbh<? extends V>> iterable) {
        final zzbbr zzbbrVar = new zzbbr();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzbbh<? extends V> zzbbhVar : iterable) {
            atomicInteger.incrementAndGet();
            b(zzbbrVar, zzbbhVar);
        }
        final Runnable runnable = new Runnable(iterable, zzbbrVar) { // from class: com.google.android.gms.internal.ads.ha

            /* renamed from: a, reason: collision with root package name */
            private final Iterable f2207a;
            private final zzbbr b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2207a = iterable;
                this.b = zzbbrVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterable iterable2 = this.f2207a;
                zzbbr zzbbrVar2 = this.b;
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable2.iterator();
                while (it.hasNext()) {
                    try {
                        arrayList.add(((zzbbh) it.next()).get());
                    } catch (InterruptedException e) {
                        e = e;
                        zzbbrVar2.setException(e);
                    } catch (ExecutionException e2) {
                        zzbbrVar2.setException(e2.getCause());
                    } catch (Exception e3) {
                        e = e3;
                        zzbbrVar2.setException(e);
                    }
                }
                zzbbrVar2.set(arrayList);
            }
        };
        for (final zzbbh<? extends V> zzbbhVar2 : iterable) {
            zzbbhVar2.zza(new Runnable(zzbbhVar2, atomicInteger, runnable, zzbbrVar) { // from class: com.google.android.gms.internal.ads.hb

                /* renamed from: a, reason: collision with root package name */
                private final zzbbh f2208a;
                private final AtomicInteger b;
                private final Runnable c;
                private final zzbbr d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2208a = zzbbhVar2;
                    this.b = atomicInteger;
                    this.c = runnable;
                    this.d = zzbbrVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbbh zzbbhVar3 = this.f2208a;
                    AtomicInteger atomicInteger2 = this.b;
                    Runnable runnable2 = this.c;
                    zzbbr zzbbrVar2 = this.d;
                    try {
                        zzbbhVar3.get();
                        if (atomicInteger2.decrementAndGet() == 0) {
                            runnable2.run();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        zzbbrVar2.setException(e);
                    } catch (ExecutionException e2) {
                        zzbbrVar2.setException(e2.getCause());
                    } catch (Exception e3) {
                        zzbbrVar2.setException(e3);
                    }
                }
            }, zzbbm.zzeaf);
        }
        return zzbbrVar;
    }

    public static <V> zzbbh<V> zza(zzbbh<V> zzbbhVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        final zzbbr zzbbrVar = new zzbbr();
        b(zzbbrVar, zzbbhVar);
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable(zzbbrVar) { // from class: com.google.android.gms.internal.ads.hc

            /* renamed from: a, reason: collision with root package name */
            private final zzbbr f2209a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2209a = zzbbrVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2209a.setException(new TimeoutException());
            }
        }, j, timeUnit);
        a((zzbbh) zzbbhVar, zzbbrVar);
        zzbbrVar.zza(new Runnable(schedule) { // from class: com.google.android.gms.internal.ads.hd

            /* renamed from: a, reason: collision with root package name */
            private final Future f2210a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2210a = schedule;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Future future = this.f2210a;
                if (future.isDone()) {
                    return;
                }
                future.cancel(true);
            }
        }, zzbbm.zzeaf);
        return zzbbrVar;
    }

    public static <V, X extends Throwable> zzbbh<V> zza(final zzbbh<? extends V> zzbbhVar, final Class<X> cls, final zzbal<? super X, ? extends V> zzbalVar, final Executor executor) {
        final zzbbr zzbbrVar = new zzbbr();
        b(zzbbrVar, zzbbhVar);
        zzbbhVar.zza(new Runnable(zzbbrVar, zzbbhVar, cls, zzbalVar, executor) { // from class: com.google.android.gms.internal.ads.he

            /* renamed from: a, reason: collision with root package name */
            private final zzbbr f2211a;
            private final zzbbh b;
            private final Class c;
            private final zzbal d;
            private final Executor e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2211a = zzbbrVar;
                this.b = zzbbhVar;
                this.c = cls;
                this.d = zzbalVar;
                this.e = executor;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbar.a(this.f2211a, this.b, this.c, this.d, this.e);
            }
        }, zzbbm.zzeaf);
        return zzbbrVar;
    }

    public static <V> zzbbc<V> zza(zzbbh<? extends V>... zzbbhVarArr) {
        return zzf(Arrays.asList(zzbbhVarArr));
    }

    public static <V> zzbbc<V> zzf(Iterable<? extends zzbbh<? extends V>> iterable) {
        return new zzbbc<>(iterable);
    }

    public static <T> hk<T> zzm(T t) {
        return new hk<>(t);
    }

    public static <T> hj<T> zzd(Throwable th) {
        return new hj<>(th);
    }

    private static <V> void a(final zzbbh<? extends V> zzbbhVar, final zzbbr<V> zzbbrVar) {
        b(zzbbrVar, zzbbhVar);
        zzbbhVar.zza(new Runnable(zzbbrVar, zzbbhVar) { // from class: com.google.android.gms.internal.ads.hf

            /* renamed from: a, reason: collision with root package name */
            private final zzbbr f2212a;
            private final zzbbh b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2212a = zzbbrVar;
                this.b = zzbbhVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbbr zzbbrVar2 = this.f2212a;
                try {
                    zzbbrVar2.set(this.b.get());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    zzbbrVar2.setException(e);
                } catch (ExecutionException e2) {
                    zzbbrVar2.setException(e2.getCause());
                } catch (Exception e3) {
                    zzbbrVar2.setException(e3);
                }
            }
        }, zzbbm.zzeaf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <A, B> void b(final zzbbh<A> zzbbhVar, final Future<B> future) {
        zzbbhVar.zza(new Runnable(zzbbhVar, future) { // from class: com.google.android.gms.internal.ads.hg

            /* renamed from: a, reason: collision with root package name */
            private final zzbbh f2213a;
            private final Future b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2213a = zzbbhVar;
                this.b = future;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbbh zzbbhVar2 = this.f2213a;
                Future future2 = this.b;
                if (zzbbhVar2.isCancelled()) {
                    future2.cancel(true);
                }
            }
        }, zzbbm.zzeaf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void a(com.google.android.gms.internal.ads.zzbbr r1, com.google.android.gms.internal.ads.zzbbh r2, java.lang.Class r3, com.google.android.gms.internal.ads.zzbal r4, java.util.concurrent.Executor r5) {
        /*
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Exception -> L8 java.lang.InterruptedException -> La java.util.concurrent.ExecutionException -> L13
            r1.set(r2)     // Catch: java.lang.Exception -> L8 java.lang.InterruptedException -> La java.util.concurrent.ExecutionException -> L13
            return
        L8:
            r2 = move-exception
            goto L18
        La:
            r2 = move-exception
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L18
        L13:
            r2 = move-exception
            java.lang.Throwable r2 = r2.getCause()
        L18:
            boolean r3 = r3.isInstance(r2)
            if (r3 == 0) goto L2a
            com.google.android.gms.internal.ads.hk r2 = zzm(r2)
            com.google.android.gms.internal.ads.zzbbh r2 = zza(r2, r4, r5)
            a(r2, r1)
            return
        L2a:
            r1.setException(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbar.a(com.google.android.gms.internal.ads.zzbbr, com.google.android.gms.internal.ads.zzbbh, java.lang.Class, com.google.android.gms.internal.ads.zzbal, java.util.concurrent.Executor):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(zzbbr zzbbrVar, zzbal zzbalVar, zzbbh zzbbhVar) {
        if (zzbbrVar.isCancelled()) {
            return;
        }
        try {
            a(zzbalVar.zzf(zzbbhVar.get()), zzbbrVar);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            zzbbrVar.setException(e);
        } catch (CancellationException unused) {
            zzbbrVar.cancel(true);
        } catch (ExecutionException e2) {
            zzbbrVar.setException(e2.getCause());
        } catch (Exception e3) {
            zzbbrVar.setException(e3);
        }
    }
}
