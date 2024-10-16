package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzcmx<AdT> implements zzbal<zzcxu, AdT> {

    /* renamed from: a, reason: collision with root package name */
    private final zzczt f3330a;
    private final zzbrm b;
    private final zzdae c;
    private final Executor d;
    private final ScheduledExecutorService e;
    private final zzbpe<AdT> f;
    private final zzcmu g;

    public zzcmx(zzczt zzcztVar, zzcmu zzcmuVar, zzbrm zzbrmVar, zzdae zzdaeVar, zzbpe<AdT> zzbpeVar, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.f3330a = zzcztVar;
        this.g = zzcmuVar;
        this.b = zzbrmVar;
        this.c = zzdaeVar;
        this.f = zzbpeVar;
        this.d = executor;
        this.e = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final /* synthetic */ zzbbh zzf(zzcxu zzcxuVar) throws Exception {
        final zzcxu zzcxuVar2 = zzcxuVar;
        zzcze zzane = this.f3330a.zzv(zzczs.RENDER_CONFIG_INIT).zzb(zzbar.zzd(new zzcmw("No ad configs", 3))).zzane();
        this.b.zza(new zzbmd(zzcxuVar2, this.c), this.d);
        int i = 0;
        for (final zzcxm zzcxmVar : zzcxuVar2.zzgky.zzgkt) {
            Iterator<String> it = zzcxmVar.zzgjy.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                final zzcjv<AdT> zze = this.f.zze(zzcxmVar.zzflt, next);
                if (zze != null && zze.zza(zzcxuVar2, zzcxmVar)) {
                    zzczl<I> zza = this.f3330a.zza((zzczt) zzczs.RENDER_CONFIG_WATERFALL, (zzbbh) zzane);
                    StringBuilder sb = new StringBuilder(String.valueOf(next).length() + 26);
                    sb.append("render-config-");
                    sb.append(i);
                    sb.append("-");
                    sb.append(next);
                    zzane = zza.zzfy(sb.toString()).zza(Throwable.class, new zzbal(this, zzcxmVar, zze, zzcxuVar2) { // from class: com.google.android.gms.internal.ads.vx

                        /* renamed from: a, reason: collision with root package name */
                        private final zzcmx f2576a;
                        private final zzcxm b;
                        private final zzcjv c;
                        private final zzcxu d;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f2576a = this;
                            this.b = zzcxmVar;
                            this.c = zze;
                            this.d = zzcxuVar2;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbal
                        public final zzbbh zzf(Object obj) {
                            return this.f2576a.a(this.b, this.c, this.d, (Throwable) obj);
                        }
                    }).zzane();
                    break;
                }
            }
            i++;
        }
        return zzane;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(zzcxm zzcxmVar, zzcjv zzcjvVar, zzcxu zzcxuVar, Throwable th) throws Exception {
        return this.g.zza(zzcxmVar, zzbar.zza(zzcjvVar.zzb(zzcxuVar, zzcxmVar), zzcxmVar.zzgkn, TimeUnit.MILLISECONDS, this.e));
    }
}
