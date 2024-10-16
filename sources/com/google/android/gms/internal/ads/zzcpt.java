package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqy;
import com.google.android.gms.internal.ads.zzbtv;
import java.util.Collections;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes2.dex */
public final class zzcpt extends zzzl implements zzbtf {

    /* renamed from: a, reason: collision with root package name */
    private final zzbjm f3367a;
    private final Context b;
    private final ViewGroup c;
    private final zzbtb g;

    @GuardedBy("this")
    private zzado i;

    @GuardedBy("this")
    private zzbnf j;

    @GuardedBy("this")
    private zzbbh<zzbnf> k;
    private final zzcpw d = new zzcpw();
    private final zzcpv e = new zzcpv();
    private final zzcpy f = new zzcpy();

    @GuardedBy("this")
    private final zzcxx h = new zzcxx();

    public zzcpt(zzbjm zzbjmVar, Context context, zzyd zzydVar, String str) {
        this.c = new FrameLayout(context);
        this.f3367a = zzbjmVar;
        this.b = context;
        this.h.zzd(zzydVar).zzft(str);
        this.g = zzbjmVar.zzacg();
        this.g.zza(this, this.f3367a.zzace());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void showInterstitial() {
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
    public final void zza(zzatb zzatbVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzbt(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final IObjectWrapper zzpl() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.c);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized boolean zzb(zzxz zzxzVar) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (this.k != null) {
            return false;
        }
        zzcya.zze(this.b, zzxzVar.zzcgq);
        zzboc a2 = a(this.h.zzg(zzxzVar).zzamq());
        this.k = a2.zzadu();
        zzbar.zza(this.k, new xj(this, a2), this.f3367a.zzace());
        return true;
    }

    private final synchronized zzboc a(zzcxv zzcxvVar) {
        return this.f3367a.zzacj().zzb(new zzbqy.zza().zzbt(this.b).zza(zzcxvVar).zzagh()).zzb(new zzbtv.zza().zza((zzxr) this.d, this.f3367a.zzace()).zza(this.e, this.f3367a.zzace()).zza((zzbrl) this.d, this.f3367a.zzace()).zza((zzbsr) this.d, this.f3367a.zzace()).zza((zzbro) this.d, this.f3367a.zzace()).zza(this.f, this.f3367a.zzace()).zzagt()).zza(new zzcow(this.i)).zzb(new zzbxk(zzbzc.zzfpd, null)).zza(new zzbox(this.g)).zza(new zzbnc(this.c)).zzads();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.j != null) {
            this.j.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.j != null) {
            this.j.zzafy().zzbp(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.j != null) {
            this.j.zzafy().zzbq(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzb(zzyz zzyzVar) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.d.zzc(zzyzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyz zzpp() {
        return this.d.zzald();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzzs zzzsVar) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.f.zzb(zzzsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzzs zzpo() {
        return this.f.zzale();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void zzpm() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        if (this.j != null) {
            this.j.zzpm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized zzyd zzpn() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.j != null) {
            return zzcxy.zza(this.b, Collections.singletonList(this.j.zzafj()));
        }
        return this.h.zzpn();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void zza(zzyd zzydVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.h.zzd(zzydVar);
        if (this.j != null) {
            this.j.zza(this.c, zzydVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized String getMediationAdapterClassName() {
        if (this.j == null) {
            return null;
        }
        return this.j.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized String zzpj() {
        if (this.j == null) {
            return null;
        }
        return this.j.zzpj();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void zzb(zzzy zzzyVar) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.h.zzd(zzzyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.h.zzbc(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized boolean isLoading() {
        boolean z;
        if (this.k != null) {
            z = this.k.isDone() ? false : true;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized zzaar getVideoController() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        if (this.j == null) {
            return null;
        }
        return this.j.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized String getAdUnitId() {
        return this.h.zzamp();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void zza(zzacd zzacdVar) {
        Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        this.h.zzc(zzacdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzyw zzywVar) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.e.zzb(zzywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void zza(zzado zzadoVar) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.i = zzadoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final synchronized void zzagk() {
        boolean zza;
        Object parent = this.c.getParent();
        if (parent instanceof View) {
            View view = (View) parent;
            zza = zzk.zzlg().zza(view, view.getContext());
        } else {
            zza = false;
        }
        if (zza) {
            zzb(this.h.zzamo());
        } else {
            this.g.zzdk(60);
        }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzbbh a(zzcpt zzcptVar, zzbbh zzbbhVar) {
        zzcptVar.k = null;
        return null;
    }
}
