package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzckb implements zzcjv<zzbnf> {

    /* renamed from: a, reason: collision with root package name */
    private final zzboc f3292a;
    private final Context b;
    private final zzcdn c;
    private final zzcxv d;
    private final Executor e;
    private final zzbam<zzcxm, zzayb> f;

    public zzckb(zzboc zzbocVar, Context context, Executor executor, zzcdn zzcdnVar, zzcxv zzcxvVar, zzbam<zzcxm, zzayb> zzbamVar) {
        this.b = context;
        this.f3292a = zzbocVar;
        this.e = executor;
        this.c = zzcdnVar;
        this.d = zzcxvVar;
        this.f = zzbamVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean zza(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return (zzcxmVar.zzgke == null || zzcxmVar.zzgke.zzdkp == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<zzbnf> zzb(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        return zzbar.zza(zzbar.zzm(null), new zzbal(this, zzcxuVar, zzcxmVar) { // from class: com.google.android.gms.internal.ads.uo

            /* renamed from: a, reason: collision with root package name */
            private final zzckb f2545a;
            private final zzcxu b;
            private final zzcxm c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2545a = this;
                this.b = zzcxuVar;
                this.c = zzcxmVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2545a.a(this.b, this.c, obj);
            }
        }, this.e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzbgz zzbgzVar) {
        zzbgzVar.zzaac();
        zzbhq zzyb = zzbgzVar.zzyb();
        if (this.d.zzgla == null || zzyb == null) {
            return;
        }
        zzyb.zzb(this.d.zzgla);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(zzcxu zzcxuVar, zzcxm zzcxmVar, Object obj) throws Exception {
        zzcxn zzcxnVar;
        zzyd zza = zzcxy.zza(this.b, zzcxmVar.zzgkg);
        final zzbgz zzc = this.c.zzc(zza);
        zzc.zzat(zzcxmVar.zzdok);
        zzboc zzbocVar = this.f3292a;
        zzbpr zzbprVar = new zzbpr(zzcxuVar, zzcxmVar, null);
        zzcec zzcecVar = new zzcec(this.b, zzc.getView(), this.f.apply(zzcxmVar));
        zzc.getClass();
        zzbpb a2 = up.a(zzc);
        if (zza.zzchh) {
            zzcxnVar = new zzcxn(-3, 0, true);
        } else {
            zzcxnVar = new zzcxn(zza.width, zza.height, false);
        }
        final zzbng zza2 = zzbocVar.zza(zzbprVar, new zzbnk(zzcecVar, zzc, a2, zzcxnVar));
        zza2.zzady().zzb(zzc, false);
        zza2.zzadg().zza(new zzbrw(zzc) { // from class: com.google.android.gms.internal.ads.uq

            /* renamed from: a, reason: collision with root package name */
            private final zzbgz f2547a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2547a = zzc;
            }

            @Override // com.google.android.gms.internal.ads.zzbrw
            public final void onAdImpression() {
                zzbgz zzbgzVar = this.f2547a;
                if (zzbgzVar.zzaai() != null) {
                    zzbgzVar.zzaai().zzabd();
                }
            }
        }, zzbbm.zzeaf);
        zza2.zzady();
        zzbbh<?> zza3 = zzcdp.zza(zzc, zzcxmVar.zzgke.zzdkn, zzcxmVar.zzgke.zzdkp);
        if (zzcxmVar.zzdpc) {
            zzc.getClass();
            zza3.zza(ur.a(zzc), this.e);
        }
        zza3.zza(new Runnable(this, zzc) { // from class: com.google.android.gms.internal.ads.us

            /* renamed from: a, reason: collision with root package name */
            private final zzckb f2549a;
            private final zzbgz b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2549a = this;
                this.b = zzc;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2549a.a(this.b);
            }
        }, this.e);
        return zzbar.zza(zza3, new zzbam(zza2) { // from class: com.google.android.gms.internal.ads.ut

            /* renamed from: a, reason: collision with root package name */
            private final zzbng f2550a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2550a = zza2;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object apply(Object obj2) {
                return this.f2550a.zzadx();
            }
        }, zzbbm.zzeaf);
    }
}
