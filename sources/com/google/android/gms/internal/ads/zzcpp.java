package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbqy;
import com.google.android.gms.internal.ads.zzbtv;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcpp extends zzzd {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3366a;
    private final zzbjm b;
    private final zzcxx c;
    private final zzbzc d;
    private final zzcpw e = new zzcpw();
    private final zzbro f;

    @GuardedBy("this")
    private zzbpk g;

    @GuardedBy("this")
    private String h;

    @GuardedBy("this")
    private String i;

    public zzcpp(Context context, zzbjm zzbjmVar, zzcxx zzcxxVar, zzbzc zzbzcVar, zzyz zzyzVar) {
        this.f3366a = context;
        this.b = zzbjmVar;
        this.c = zzcxxVar;
        this.d = zzbzcVar;
        this.e.zzc(zzyzVar);
        final zzcpw zzcpwVar = this.e;
        final zzaje zzaim = zzbzcVar.zzaim();
        this.f = new zzbro(zzcpwVar, zzaim) { // from class: com.google.android.gms.internal.ads.xh

            /* renamed from: a, reason: collision with root package name */
            private final zzcpw f2609a;
            private final zzaje b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2609a = zzcpwVar;
                this.b = zzaim;
            }

            @Override // com.google.android.gms.internal.ads.zzbro
            public final void onAdFailedToLoad(int i) {
                zzcpw zzcpwVar2 = this.f2609a;
                zzaje zzajeVar = this.b;
                zzcpwVar2.onAdFailedToLoad(i);
                if (zzajeVar != null) {
                    try {
                        zzajeVar.zzcr(i);
                    } catch (RemoteException e) {
                        zzbad.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzzc
    public final synchronized boolean isLoading() throws RemoteException {
        boolean z;
        if (this.g != null) {
            z = this.g.isLoading();
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zza(zzxz zzxzVar) {
        zza(zzxzVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final synchronized void zza(zzxz zzxzVar, int i) {
        if (this.c.zzamp() == null) {
            zzawz.zzen("Ad unit ID should not be null for AdLoader.");
            this.b.zzace().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.xg

                /* renamed from: a, reason: collision with root package name */
                private final zzcpp f2608a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2608a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2608a.a();
                }
            });
            return;
        }
        zzcya.zze(this.f3366a, zzxzVar.zzcgq);
        this.h = null;
        this.i = null;
        zzcxv zzamq = this.c.zzg(zzxzVar).zzdp(i).zzamq();
        zzbxo zzacy = this.b.zzacl().zza(new zzbqy.zza().zzbt(this.f3366a).zza(zzamq).zzagh()).zza(new zzbtv.zza().zza((zzbsr) this.e, this.b.zzace()).zza(this.f, this.b.zzace()).zza((zzbrw) this.e, this.b.zzace()).zza((zzxr) this.e, this.b.zzace()).zza((zzbrl) this.e, this.b.zzace()).zza(zzamq.zzgli, this.b.zzace()).zzagt()).zza(new zzbxk(this.d, this.e.zzald())).zzacy();
        zzacy.zzadc().zzdq(1);
        this.g = zzacy.zzacz();
        this.g.zza(new xi(this, zzacy));
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final synchronized String getMediationAdapterClassName() {
        return this.h;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final synchronized String zzpj() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        this.f.onAdFailedToLoad(1);
    }
}
