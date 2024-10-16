package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcle implements zzcjv<zzbvx> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3308a;
    private final zzcdn b;
    private final zzbws c;
    private final zzcxv d;
    private final Executor e;
    private final zzbai f;

    public zzcle(Context context, zzbai zzbaiVar, zzcxv zzcxvVar, Executor executor, zzbws zzbwsVar, zzcdn zzcdnVar) {
        this.f3308a = context;
        this.d = zzcxvVar;
        this.c = zzbwsVar;
        this.e = executor;
        this.f = zzbaiVar;
        this.b = zzcdnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean zza(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return (zzcxmVar.zzgke == null || zzcxmVar.zzgke.zzdkp == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<zzbvx> zzb(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        final zzced zzcedVar = new zzced();
        zzbbh<zzbvx> zza = zzbar.zza(zzbar.zzm(null), new zzbal(this, zzcxmVar, zzcedVar, zzcxuVar) { // from class: com.google.android.gms.internal.ads.vd

            /* renamed from: a, reason: collision with root package name */
            private final zzcle f2559a;
            private final zzcxm b;
            private final zzced c;
            private final zzcxu d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2559a = this;
                this.b = zzcxmVar;
                this.c = zzcedVar;
                this.d = zzcxuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2559a.a(this.b, this.c, this.d, obj);
            }
        }, this.e);
        zzcedVar.getClass();
        zza.zza(ve.a(zzcedVar), this.e);
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(final zzcxm zzcxmVar, zzced zzcedVar, zzcxu zzcxuVar, Object obj) throws Exception {
        final zzbgz zzc = this.b.zzc(this.d.zzdll);
        zzc.zzat(zzcxmVar.zzdok);
        zzcedVar.zza(this.f3308a, zzc.getView());
        final zzbbr zzbbrVar = new zzbbr();
        final zzbvy zza = this.c.zza(new zzbpr(zzcxuVar, zzcxmVar, null), new zzbvz(new zzbwz(this, zzc, zzcxmVar, zzbbrVar) { // from class: com.google.android.gms.internal.ads.vf

            /* renamed from: a, reason: collision with root package name */
            private final zzcle f2561a;
            private final zzbgz b;
            private final zzcxm c;
            private final zzbbr d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2561a = this;
                this.b = zzc;
                this.c = zzcxmVar;
                this.d = zzbbrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void zza(boolean z, Context context) {
                this.f2561a.a(this.b, this.c, this.d, z, context);
            }
        }, zzc));
        zzbbrVar.set(zza);
        zza.zzadg().zza(new zzbrw(zzc) { // from class: com.google.android.gms.internal.ads.vg

            /* renamed from: a, reason: collision with root package name */
            private final zzbgz f2562a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2562a = zzc;
            }

            @Override // com.google.android.gms.internal.ads.zzbrw
            public final void onAdImpression() {
                zzbgz zzbgzVar = this.f2562a;
                if (zzbgzVar.zzaai() != null) {
                    zzbgzVar.zzaai().zzabd();
                }
            }
        }, zzbbm.zzeaf);
        zza.zzady().zzb(zzc, true);
        zza.zzady();
        zzbbh<?> zza2 = zzcdp.zza(zzc, zzcxmVar.zzgke.zzdkn, zzcxmVar.zzgke.zzdkp);
        if (zzcxmVar.zzdpc) {
            zza2.zza(new Runnable(zzc) { // from class: com.google.android.gms.internal.ads.vh

                /* renamed from: a, reason: collision with root package name */
                private final zzbgz f2563a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2563a = zzc;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2563a.zzaav();
                }
            }, this.e);
        }
        zza2.zza(new Runnable(zzc) { // from class: com.google.android.gms.internal.ads.vi

            /* renamed from: a, reason: collision with root package name */
            private final zzbgz f2564a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2564a = zzc;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2564a.zzaac();
            }
        }, this.e);
        return zzbar.zza(zza2, new zzbam(zza) { // from class: com.google.android.gms.internal.ads.vj

            /* renamed from: a, reason: collision with root package name */
            private final zzbvy f2565a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2565a = zza;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object apply(Object obj2) {
                return this.f2565a.zzaee();
            }
        }, zzbbm.zzeaf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzbgz zzbgzVar, zzcxm zzcxmVar, zzbbr zzbbrVar, boolean z, Context context) {
        try {
            zzbgzVar.zzaq(true);
            zzk.zzlg();
            com.google.android.gms.ads.internal.zzh zzhVar = new com.google.android.gms.ads.internal.zzh(false, zzaxi.zzax(this.f3308a), false, 0.0f, -1, z, zzcxmVar.zzgkl, false);
            zzk.zzlf();
            com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel(null, ((zzbvy) zzbbrVar.get()).zzaeg(), null, zzbgzVar, zzcxmVar.zzgkm, this.f, zzcxmVar.zzdno, zzhVar), true);
        } catch (Exception unused) {
        }
    }
}
