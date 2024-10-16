package com.google.android.gms.internal.ads;

@zzard
/* loaded from: classes2.dex */
public final class zzaly {

    /* renamed from: a, reason: collision with root package name */
    private zzakh f2754a;
    private zzbbr<zzalf> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaly(zzakh zzakhVar) {
        this.f2754a = zzakhVar;
    }

    private final void a() {
        if (this.b == null) {
            this.b = new zzbbr<>();
            final zzbbr<zzalf> zzbbrVar = this.b;
            this.f2754a.zzb(null).zza(new zzbbv(zzbbrVar) { // from class: com.google.android.gms.internal.ads.cj

                /* renamed from: a, reason: collision with root package name */
                private final zzbbr f2097a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2097a = zzbbrVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbbv
                public final void zzh(Object obj) {
                    this.f2097a.set((zzalf) obj);
                }
            }, new zzbbt(zzbbrVar) { // from class: com.google.android.gms.internal.ads.cl

                /* renamed from: a, reason: collision with root package name */
                private final zzbbr f2098a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2098a = zzbbrVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbbt
                public final void run() {
                    this.f2098a.setException(new zzali("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final zzamd zzb(String str, zzalm zzalmVar, zzall zzallVar) {
        a();
        return new zzamd(this.b, str, zzalmVar, zzallVar);
    }

    public final void zzc(final String str, final zzaho<? super zzalf> zzahoVar) {
        a();
        this.b = (zzbbr) zzbar.zza(this.b, new zzbal(str, zzahoVar) { // from class: com.google.android.gms.internal.ads.cm

            /* renamed from: a, reason: collision with root package name */
            private final String f2099a;
            private final zzaho b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2099a = str;
                this.b = zzahoVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                zzalf zzalfVar = (zzalf) obj;
                zzalfVar.zza(this.f2099a, this.b);
                return zzbar.zzm(zzalfVar);
            }
        }, zzbbm.zzeaf);
    }

    public final void zzd(final String str, final zzaho<? super zzalf> zzahoVar) {
        this.b = (zzbbr) zzbar.zza(this.b, new zzbam(str, zzahoVar) { // from class: com.google.android.gms.internal.ads.cn

            /* renamed from: a, reason: collision with root package name */
            private final String f2100a;
            private final zzaho b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2100a = str;
                this.b = zzahoVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object apply(Object obj) {
                zzalf zzalfVar = (zzalf) obj;
                zzalfVar.zzb(this.f2100a, this.b);
                return zzalfVar;
            }
        }, zzbbm.zzeaf);
    }
}
