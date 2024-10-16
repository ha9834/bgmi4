package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcnl implements zzcjv<zzcdb> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3339a;
    private final zzcdn b;
    private final zzcdf c;
    private final zzcxv d;
    private final Executor e;
    private final zzbai f;

    public zzcnl(Context context, zzbai zzbaiVar, zzcxv zzcxvVar, Executor executor, zzcdf zzcdfVar, zzcdn zzcdnVar) {
        this.f3339a = context;
        this.d = zzcxvVar;
        this.c = zzcdfVar;
        this.e = executor;
        this.f = zzbaiVar;
        this.b = zzcdnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean zza(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return (zzcxmVar.zzgke == null || zzcxmVar.zzgke.zzdkp == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<zzcdb> zzb(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        final zzced zzcedVar = new zzced();
        zzbbh<zzcdb> zza = zzbar.zza(zzbar.zzm(null), new zzbal(this, zzcxmVar, zzcedVar, zzcxuVar) { // from class: com.google.android.gms.internal.ads.wd

            /* renamed from: a, reason: collision with root package name */
            private final zzcnl f2580a;
            private final zzcxm b;
            private final zzced c;
            private final zzcxu d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2580a = this;
                this.b = zzcxmVar;
                this.c = zzcedVar;
                this.d = zzcxuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2580a.a(this.b, this.c, this.d, obj);
            }
        }, this.e);
        zzcedVar.getClass();
        zza.zza(we.a(zzcedVar), this.e);
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(final zzcxm zzcxmVar, zzced zzcedVar, zzcxu zzcxuVar, Object obj) throws Exception {
        final zzbgz zzc = this.b.zzc(this.d.zzdll);
        zzc.zzat(zzcxmVar.zzdok);
        zzcedVar.zza(this.f3339a, zzc.getView());
        final zzbbr zzbbrVar = new zzbbr();
        final zzcdc zza = this.c.zza(new zzbpr(zzcxuVar, zzcxmVar, null), new zzcdd(new zzbwz(this, zzc, zzcxmVar, zzbbrVar) { // from class: com.google.android.gms.internal.ads.wh

            /* renamed from: a, reason: collision with root package name */
            private final zzcnl f2584a;
            private final zzbgz b;
            private final zzcxm c;
            private final zzbbr d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2584a = this;
                this.b = zzc;
                this.c = zzcxmVar;
                this.d = zzbbrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void zza(boolean z, Context context) {
                this.f2584a.a(this.b, this.c, this.d, z, context);
            }
        }, zzc));
        zzbbrVar.set(zza);
        zzahx.zza(zzc, zza.zzaek());
        zza.zzadg().zza(new zzbrw(zzc) { // from class: com.google.android.gms.internal.ads.wi

            /* renamed from: a, reason: collision with root package name */
            private final zzbgz f2585a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2585a = zzc;
            }

            @Override // com.google.android.gms.internal.ads.zzbrw
            public final void onAdImpression() {
                zzbgz zzbgzVar = this.f2585a;
                if (zzbgzVar.zzaai() != null) {
                    zzbgzVar.zzaai().zzabd();
                }
            }
        }, zzbbm.zzeaf);
        zza.zzady().zzb(zzc, true);
        zza.zzady();
        zzbbh<?> zza2 = zzcdp.zza(zzc, zzcxmVar.zzgke.zzdkn, zzcxmVar.zzgke.zzdkp);
        if (zzcxmVar.zzdpc) {
            zza2.zza(new Runnable(zzc) { // from class: com.google.android.gms.internal.ads.wj

                /* renamed from: a, reason: collision with root package name */
                private final zzbgz f2586a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2586a = zzc;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2586a.zzaav();
                }
            }, this.e);
        }
        zza2.zza(new Runnable(zzc) { // from class: com.google.android.gms.internal.ads.wk

            /* renamed from: a, reason: collision with root package name */
            private final zzbgz f2587a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2587a = zzc;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2587a.zzaac();
            }
        }, this.e);
        return zzbar.zza(zza2, new zzbam(zza) { // from class: com.google.android.gms.internal.ads.wl

            /* renamed from: a, reason: collision with root package name */
            private final zzcdc f2588a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2588a = zza;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object apply(Object obj2) {
                return this.f2588a.zzaej();
            }
        }, zzbbm.zzeaf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzbgz zzbgzVar, zzcxm zzcxmVar, zzbbr zzbbrVar, boolean z, Context context) {
        zzbgz zzbgzVar2;
        try {
            zzcdc zzcdcVar = (zzcdc) zzbbrVar.get();
            if (zzbgzVar.zzaaw()) {
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoq)).booleanValue()) {
                    final zzbgz zzc = this.b.zzc(this.d.zzdll);
                    zzahx.zza(zzc, zzcdcVar.zzaek());
                    final zzced zzcedVar = new zzced();
                    zzcedVar.zza(this.f3339a, zzc.getView());
                    zzcdcVar.zzady().zzb(zzc, true);
                    zzc.zzaai().zza(new zzbij(zzcedVar, zzc) { // from class: com.google.android.gms.internal.ads.wf

                        /* renamed from: a, reason: collision with root package name */
                        private final zzced f2582a;
                        private final zzbgz b;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f2582a = zzcedVar;
                            this.b = zzc;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbij
                        public final void zzae(boolean z2) {
                            zzced zzcedVar2 = this.f2582a;
                            zzbgz zzbgzVar3 = this.b;
                            zzcedVar2.zzajo();
                            zzbgzVar3.zzaac();
                            zzbgzVar3.zzaai().zzabd();
                        }
                    });
                    zzbii zzaai = zzc.zzaai();
                    zzc.getClass();
                    zzaai.zza(wg.a(zzc));
                    zzc.zzb(zzcxmVar.zzgke.zzdkn, zzcxmVar.zzgke.zzdkp, null);
                    zzbgzVar2 = zzc;
                    zzbgzVar2.zzaq(true);
                    zzk.zzlg();
                    com.google.android.gms.ads.internal.zzh zzhVar = new com.google.android.gms.ads.internal.zzh(false, zzaxi.zzax(this.f3339a), false, 0.0f, -1, z, zzcxmVar.zzgkl, zzcxmVar.zzbrm);
                    zzk.zzlf();
                    com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel(null, ((zzcdc) zzbbrVar.get()).zzaeg(), null, zzbgzVar2, zzcxmVar.zzgkm, this.f, zzcxmVar.zzdno, zzhVar), true);
                }
            }
            zzbgzVar2 = zzbgzVar;
            zzbgzVar2.zzaq(true);
            zzk.zzlg();
            com.google.android.gms.ads.internal.zzh zzhVar2 = new com.google.android.gms.ads.internal.zzh(false, zzaxi.zzax(this.f3339a), false, 0.0f, -1, z, zzcxmVar.zzgkl, zzcxmVar.zzbrm);
            zzk.zzlf();
            com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel(null, ((zzcdc) zzbbrVar.get()).zzaeg(), null, zzbgzVar2, zzcxmVar.zzgkm, this.f, zzcxmVar.zzdno, zzhVar2), true);
        } catch (Exception unused) {
        }
    }
}
