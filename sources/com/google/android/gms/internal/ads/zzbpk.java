package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzbpk {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f2992a;
    private final ScheduledExecutorService b;
    private final zzbbh<zzbph> c;
    private volatile boolean d = true;

    public zzbpk(Executor executor, ScheduledExecutorService scheduledExecutorService, zzbbh<zzbph> zzbbhVar) {
        this.f2992a = executor;
        this.b = scheduledExecutorService;
        this.c = zzbbhVar;
    }

    public final void zza(zzban<zzbpc> zzbanVar) {
        zzbar.zza(this.c, new nt(this, zzbanVar), this.f2992a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<? extends zzbbh<? extends zzbpc>> list, final zzban<zzbpc> zzbanVar) {
        if (list == null || list.isEmpty()) {
            this.f2992a.execute(new Runnable(zzbanVar) { // from class: com.google.android.gms.internal.ads.nq

                /* renamed from: a, reason: collision with root package name */
                private final zzban f2376a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2376a = zzbanVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2376a.zzb(new zzcgm(3));
                }
            });
            return;
        }
        zzbbh zzm = zzbar.zzm(null);
        for (final zzbbh<? extends zzbpc> zzbbhVar : list) {
            zzm = zzbar.zza(zzbar.zza(zzm, Throwable.class, new zzbal(zzbanVar) { // from class: com.google.android.gms.internal.ads.nr

                /* renamed from: a, reason: collision with root package name */
                private final zzban f2377a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2377a = zzbanVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbal
                public final zzbbh zzf(Object obj) {
                    this.f2377a.zzb((Throwable) obj);
                    return zzbar.zzm(null);
                }
            }, this.f2992a), new zzbal(this, zzbanVar, zzbbhVar) { // from class: com.google.android.gms.internal.ads.ns

                /* renamed from: a, reason: collision with root package name */
                private final zzbpk f2378a;
                private final zzban b;
                private final zzbbh c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2378a = this;
                    this.b = zzbanVar;
                    this.c = zzbbhVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbal
                public final zzbbh zzf(Object obj) {
                    return this.f2378a.a(this.b, this.c, (zzbpc) obj);
                }
            }, this.f2992a);
        }
        zzbar.zza(zzm, new nu(this, zzbanVar), this.f2992a);
    }

    public final boolean isLoading() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(zzban zzbanVar, zzbbh zzbbhVar, zzbpc zzbpcVar) throws Exception {
        if (zzbpcVar != null) {
            zzbanVar.zzk(zzbpcVar);
        }
        return zzbar.zza(zzbbhVar, ((Long) zzyt.zzpe().zzd(zzacu.zzcqx)).longValue(), TimeUnit.MILLISECONDS, this.b);
    }
}
