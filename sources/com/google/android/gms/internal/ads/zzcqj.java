package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqy;
import com.google.android.gms.internal.ads.zzbtv;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcqj extends zzasx {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private zzbbh<zzcdb> f3378a;

    @GuardedBy("this")
    private zzcdb b;
    private final zzbjm c;
    private final Context d;
    private zzbss h;
    private final zzcqc e = new zzcqc();
    private final zzcpx f = new zzcpx();
    private final zzcpy g = new zzcpy();
    private boolean i = false;

    @GuardedBy("this")
    private final zzcxx j = new zzcxx();

    @GuardedBy("this")
    private boolean k = false;

    public zzcqj(zzbjm zzbjmVar, Context context) {
        this.c = zzbjmVar;
        this.d = context;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setAppPackageName(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void zza(zzath zzathVar) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        this.i = false;
        if (zzathVar.zzchk == null) {
            zzawz.zzen("Ad unit ID should not be null for rewarded video ad.");
            this.c.zzace().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.xp

                /* renamed from: a, reason: collision with root package name */
                private final zzcqj f2617a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2617a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2617a.c();
                }
            });
            return;
        }
        if (zzacw.zzcg(zzathVar.zzchk)) {
            return;
        }
        if (this.f3378a != null) {
            return;
        }
        if (d()) {
            if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcvh)).booleanValue()) {
                return;
            }
        }
        zzcya.zze(this.d, zzathVar.zzdlk.zzcgq);
        this.b = null;
        zzcdf zzaeh = this.c.zzacm().zzd(new zzbqy.zza().zzbt(this.d).zza(this.j.zzft(zzathVar.zzchk).zzd(zzyd.zzou()).zzg(zzathVar.zzdlk).zzamq()).zzfg(null).zzagh()).zzd(new zzbtv.zza().zza((zzbrl) this.e, this.c.zzace()).zza(new xs(this, this.e), this.c.zzace()).zza((zzbro) this.e, this.c.zzace()).zza(this.f, this.c.zzace()).zza(this.g, this.c.zzace()).zzagt()).zzaeh();
        this.h = zzaeh.zzaei();
        this.f3378a = zzaeh.zzadu();
        zzbar.zza(this.f3378a, new xq(this, zzaeh), this.c.zzace());
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void destroy() throws RemoteException {
        zzn(null);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void zzn(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        Context context = null;
        this.f.zzb(null);
        this.i = false;
        if (this.b != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.b.zzadd().zzbr(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void pause() throws RemoteException {
        zzl(null);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void zzl(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.b != null) {
            this.b.zzadd().zzbp(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void resume() throws RemoteException {
        zzm(null);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void zzm(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.b != null) {
            this.b.zzadd().zzbq(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void show() throws RemoteException {
        zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Activity activity;
        Preconditions.checkMainThread("showAd must be called on the main UI thread.");
        if (this.b == null) {
            return;
        }
        if (iObjectWrapper != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof Activity) {
                activity = (Activity) unwrap;
                this.b.zzb(this.k, activity);
            }
        }
        activity = null;
        this.b.zzb(this.k, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.b == null) {
            return null;
        }
        return this.b.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final boolean isLoaded() throws RemoteException {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return d();
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zza(zzatb zzatbVar) throws RemoteException {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.e.zzb(zzatbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zza(zzasu zzasuVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.e.zzb(zzasuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zza(zzzp zzzpVar) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        this.f.zzb(new xr(this, zzzpVar));
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final Bundle getAdMetadata() {
        zzbss zzbssVar;
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        if (this.i && (zzbssVar = this.h) != null) {
            return zzbssVar.getAdMetadata();
        }
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.i = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.f.onAdMetadataChanged();
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void setUserId(String str) throws RemoteException {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.j.zzfu(str);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void setCustomData(String str) throws RemoteException {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcow)).booleanValue()) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
            this.j.zzfv(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.k = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized boolean d() {
        boolean z;
        if (this.b != null) {
            z = this.b.isClosed() ? false : true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        this.e.onAdFailedToLoad(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzbbh a(zzcqj zzcqjVar, zzbbh zzbbhVar) {
        zzcqjVar.f3378a = null;
        return null;
    }
}
