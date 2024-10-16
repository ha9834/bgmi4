package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbqy;
import com.google.android.gms.internal.ads.zzbtv;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcqd extends zzzl {

    /* renamed from: a, reason: collision with root package name */
    private final zzbjm f3376a;
    private final Context b;
    private final Executor c;

    @GuardedBy("this")
    private zzado h;

    @GuardedBy("this")
    private zzbvx i;

    @GuardedBy("this")
    private zzbbh<zzbvx> j;
    private final zzcpw d = new zzcpw();
    private final zzcpy e = new zzcpy();
    private final zzcqc f = new zzcqc();

    @GuardedBy("this")
    private final zzcxx g = new zzcxx();

    @GuardedBy("this")
    private boolean k = false;

    public zzcqd(zzbjm zzbjmVar, Context context, zzyd zzydVar, String str) {
        this.f3376a = zzbjmVar;
        this.g.zzd(zzydVar).zzft(str);
        this.c = zzbjmVar.zzace();
        this.b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzaar getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzaax zzaaxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzaqn zzaqnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzaqt zzaqtVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzyd zzydVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzyw zzywVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzbt(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final IObjectWrapper zzpl() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzpm() {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyd zzpn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized boolean zzb(zzxz zzxzVar) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (this.j == null && !a()) {
            zzcya.zze(this.b, zzxzVar.zzcgq);
            this.i = null;
            zzcxv zzamq = this.g.zzg(zzxzVar).zzamq();
            zzbtv.zza zzaVar = new zzbtv.zza();
            if (this.f != null) {
                zzaVar.zza((zzbrl) this.f, this.f3376a.zzace()).zza((zzbsr) this.f, this.f3376a.zzace()).zza((zzbro) this.f, this.f3376a.zzace());
            }
            zzbws zzaed = this.f3376a.zzack().zzc(new zzbqy.zza().zzbt(this.b).zza(zzamq).zzagh()).zzc(zzaVar.zza((zzbrl) this.d, this.f3376a.zzace()).zza((zzbsr) this.d, this.f3376a.zzace()).zza((zzbro) this.d, this.f3376a.zzace()).zza((zzxr) this.d, this.f3376a.zzace()).zza(this.e, this.f3376a.zzace()).zzagt()).zzb(new zzcow(this.h)).zzaed();
            this.j = zzaed.zzadu();
            zzbar.zza(this.j, new xl(this, zzaed), this.c);
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.i != null) {
            this.i.zzadd().zzbr(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.i != null) {
            this.i.zzadd().zzbp(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.i != null) {
            this.i.zzadd().zzbq(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzb(zzyz zzyzVar) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.d.zzc(zzyzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzzs zzzsVar) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.e.zzb(zzzsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void showInterstitial() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        if (this.i == null) {
            return;
        }
        if (this.i.zzagz()) {
            this.i.show(this.k);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized String getMediationAdapterClassName() {
        if (this.i == null) {
            return null;
        }
        return this.i.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized String zzpj() {
        if (this.i == null) {
            return null;
        }
        return this.i.zzpj();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void zzb(zzzy zzzyVar) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.g.zzd(zzzyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.g.zzbc(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized boolean isLoading() {
        boolean z;
        if (this.j != null) {
            z = this.j.isDone() ? false : true;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized boolean isReady() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return a();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized String getAdUnitId() {
        return this.g.zzamp();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzzs zzpo() {
        return this.e.zzale();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyz zzpp() {
        return this.d.zzald();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.k = z;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void zza(zzacd zzacdVar) {
        this.g.zzc(zzacdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void zza(zzado zzadoVar) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.h = zzadoVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized boolean a() {
        boolean z;
        if (this.i != null) {
            z = this.i.isClosed() ? false : true;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzzp zzzpVar) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzatb zzatbVar) {
        this.f.zzb(zzatbVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzbbh a(zzcqd zzcqdVar, zzbbh zzbbhVar) {
        zzcqdVar.j = null;
        return null;
    }
}
