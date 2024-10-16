package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzckv implements zzcjv<zzbnf> {

    /* renamed from: a, reason: collision with root package name */
    private final zzboc f3300a;
    private final zzckb b;
    private final zzbbl c;
    private final zzbrm d;
    private final ScheduledExecutorService e;

    public zzckv(zzboc zzbocVar, zzckb zzckbVar, zzbrm zzbrmVar, ScheduledExecutorService scheduledExecutorService, zzbbl zzbblVar) {
        this.f3300a = zzbocVar;
        this.b = zzckbVar;
        this.d = zzbrmVar;
        this.e = scheduledExecutorService;
        this.c = zzbblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean zza(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return zzcxuVar.zzgkx.zzfjp.zzamn() != null && this.b.zza(zzcxuVar, zzcxmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<zzbnf> zzb(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        return this.c.submit(new Callable(this, zzcxuVar, zzcxmVar) { // from class: com.google.android.gms.internal.ads.va

            /* renamed from: a, reason: collision with root package name */
            private final zzckv f2556a;
            private final zzcxu b;
            private final zzcxm c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2556a = this;
                this.b = zzcxuVar;
                this.c = zzcxmVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2556a.a(this.b, this.c);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbnf a(final zzcxu zzcxuVar, final zzcxm zzcxmVar) throws Exception {
        return this.f3300a.zza(new zzbpr(zzcxuVar, zzcxmVar, null), new zzbop(zzcxuVar.zzgkx.zzfjp.zzamn(), new Runnable(this, zzcxuVar, zzcxmVar) { // from class: com.google.android.gms.internal.ads.vb

            /* renamed from: a, reason: collision with root package name */
            private final zzckv f2557a;
            private final zzcxu b;
            private final zzcxm c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2557a = this;
                this.b = zzcxuVar;
                this.c = zzcxmVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2557a.b(this.b, this.c);
            }
        })).zzaeb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        zzbar.zza(zzbar.zza(this.b.zzb(zzcxuVar, zzcxmVar), zzcxmVar.zzgkn, TimeUnit.SECONDS, this.e), new vc(this), this.c);
    }
}
