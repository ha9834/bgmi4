package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzczl<O> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzczf f3519a;
    private final E b;

    @Nullable
    private final String c;
    private final zzbbh<?> d;
    private final List<zzbbh<?>> e;
    private final zzbbh<O> f;

    private zzczl(zzczf zzczfVar, E e, String str, zzbbh<?> zzbbhVar, List<zzbbh<?>> list, zzbbh<O> zzbbhVar2) {
        this.f3519a = zzczfVar;
        this.b = e;
        this.c = str;
        this.d = zzbbhVar;
        this.e = list;
        this.f = zzbbhVar2;
    }

    public final zzczl<O> zzfy(String str) {
        return new zzczl<>(this.f3519a, this.b, str, this.d, this.e, this.f);
    }

    public final <O2> zzczl<O2> zzb(final zzczc<O, O2> zzczcVar) {
        return zza(new zzbal(zzczcVar) { // from class: com.google.android.gms.internal.ads.aap

            /* renamed from: a, reason: collision with root package name */
            private final zzczc f1764a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1764a = zzczcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return zzbar.zzm(this.f1764a.apply(obj));
            }
        });
    }

    public final <O2> zzczl<O2> zza(zzbal<O, O2> zzbalVar) {
        zzbbl zzbblVar;
        zzbblVar = this.f3519a.b;
        return a(zzbalVar, zzbblVar);
    }

    private final <O2> zzczl<O2> a(zzbal<O, O2> zzbalVar, Executor executor) {
        return new zzczl<>(this.f3519a, this.b, this.c, this.d, this.e, zzbar.zza(this.f, zzbalVar, executor));
    }

    public final <O2> zzczl<O2> zzb(final zzbbh<O2> zzbbhVar) {
        return a(new zzbal(zzbbhVar) { // from class: com.google.android.gms.internal.ads.aaq

            /* renamed from: a, reason: collision with root package name */
            private final zzbbh f1765a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1765a = zzbbhVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f1765a;
            }
        }, zzbbm.zzeaf);
    }

    public final <T extends Throwable> zzczl<O> zza(Class<T> cls, final zzczc<T, O> zzczcVar) {
        return zza(cls, new zzbal(zzczcVar) { // from class: com.google.android.gms.internal.ads.aar

            /* renamed from: a, reason: collision with root package name */
            private final zzczc f1766a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1766a = zzczcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return zzbar.zzm(this.f1766a.apply((Throwable) obj));
            }
        });
    }

    public final <T extends Throwable> zzczl<O> zza(Class<T> cls, zzbal<T, O> zzbalVar) {
        zzbbl zzbblVar;
        zzczf zzczfVar = this.f3519a;
        E e = this.b;
        String str = this.c;
        zzbbh<?> zzbbhVar = this.d;
        List<zzbbh<?>> list = this.e;
        zzbbh<O> zzbbhVar2 = this.f;
        zzbblVar = zzczfVar.b;
        return new zzczl<>(zzczfVar, e, str, zzbbhVar, list, zzbar.zza(zzbbhVar2, cls, zzbalVar, zzbblVar));
    }

    public final zzczl<O> zza(long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService;
        zzczf zzczfVar = this.f3519a;
        E e = this.b;
        String str = this.c;
        zzbbh<?> zzbbhVar = this.d;
        List<zzbbh<?>> list = this.e;
        zzbbh<O> zzbbhVar2 = this.f;
        scheduledExecutorService = zzczfVar.c;
        return new zzczl<>(zzczfVar, e, str, zzbbhVar, list, zzbar.zza(zzbbhVar2, j, timeUnit, scheduledExecutorService));
    }

    public final zzcze<E, O> zzane() {
        E e = this.b;
        String str = this.c;
        if (str == null) {
            str = this.f3519a.a((zzczf) e);
        }
        final zzcze<E, O> zzczeVar = new zzcze<>(e, str, this.f);
        this.f3519a.d.zza(zzczeVar);
        this.d.zza(new Runnable(this, zzczeVar) { // from class: com.google.android.gms.internal.ads.aas

            /* renamed from: a, reason: collision with root package name */
            private final zzczl f1767a;
            private final zzcze b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1767a = this;
                this.b = zzczeVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzczl zzczlVar = this.f1767a;
                zzczlVar.f3519a.d.zzb(this.b);
            }
        }, zzbbm.zzeaf);
        zzbar.zza(zzczeVar, new aat(this, zzczeVar), zzbbm.zzeaf);
        return zzczeVar;
    }

    public final zzczl<O> zzx(E e) {
        return this.f3519a.zza((zzczf) e, (zzbbh) zzane());
    }
}
