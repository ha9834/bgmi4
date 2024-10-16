package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcor<AdT> implements zzcjv<AdT> {

    /* renamed from: a, reason: collision with root package name */
    private final zzado f3351a;
    private final zzbbl b;
    private final zzczt c;
    private final zzcou<AdT> d;

    public zzcor(zzczt zzcztVar, zzbbl zzbblVar, zzado zzadoVar, zzcou<AdT> zzcouVar) {
        this.c = zzcztVar;
        this.b = zzbblVar;
        this.f3351a = zzadoVar;
        this.d = zzcouVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean zza(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return (this.f3351a == null || zzcxmVar.zzgke == null || zzcxmVar.zzgke.zzdkp == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<AdT> zzb(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        zzbbr zzbbrVar = new zzbbr();
        zzcoz zzcozVar = new zzcoz();
        zzcozVar.zza(new wy(this, zzbbrVar, zzcxuVar, zzcxmVar, zzcozVar));
        final zzadj zzadjVar = new zzadj(zzcozVar, zzcxmVar.zzgke.zzdkn, zzcxmVar.zzgke.zzdkp);
        return this.c.zzv(zzczs.CUSTOM_RENDER_SYN).zza(new zzczd(this, zzadjVar) { // from class: com.google.android.gms.internal.ads.wx

            /* renamed from: a, reason: collision with root package name */
            private final zzcor f2599a;
            private final zzadj b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2599a = this;
                this.b = zzadjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzczd
            public final void run() {
                this.f2599a.a(this.b);
            }
        }, this.b).zzx(zzczs.CUSTOM_RENDER_ACK).zzb(zzbbrVar).zzane();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzadj zzadjVar) throws Exception {
        this.f3351a.zza(zzadjVar);
    }
}
