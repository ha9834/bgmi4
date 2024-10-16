package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class zzcpm extends zzzl {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3363a;
    private final zzyz b;
    private final zzcxv c;
    private final zzbnf d;
    private final ViewGroup e;

    public zzcpm(Context context, zzyz zzyzVar, zzcxv zzcxvVar, zzbnf zzbnfVar) {
        this.f3363a = context;
        this.b = zzyzVar;
        this.c = zzcxvVar;
        this.d = zzbnfVar;
        FrameLayout frameLayout = new FrameLayout(this.f3363a);
        frameLayout.removeAllViews();
        frameLayout.addView(this.d.zzafi(), zzk.zzli().zzwg());
        frameLayout.setMinimumHeight(zzpn().heightPixels);
        frameLayout.setMinimumWidth(zzpn().widthPixels);
        this.e = frameLayout;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setUserId(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void showInterstitial() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void stopLoading() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzaax zzaaxVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzaqn zzaqnVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzaqt zzaqtVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzatb zzatbVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzbt(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final IObjectWrapper zzpl() throws RemoteException {
        return ObjectWrapper.wrap(this.e);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.d.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean zzb(zzxz zzxzVar) throws RemoteException {
        zzawz.zzeo("loadAd is not supported for a Publisher AdView returned from AdLoader.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void pause() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.d.zzafy().zzbp(null);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void resume() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.d.zzafy().zzbq(null);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzpm() throws RemoteException {
        this.d.zzpm();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyd zzpn() {
        return zzcxy.zza(this.f3363a, Collections.singletonList(this.d.zzafj()));
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String getMediationAdapterClassName() throws RemoteException {
        return this.d.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzaar getVideoController() throws RemoteException {
        return this.d.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String getAdUnitId() throws RemoteException {
        return this.c.zzglb;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzzs zzpo() throws RemoteException {
        return this.c.zzgli;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyz zzpp() throws RemoteException {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String zzpj() throws RemoteException {
        return this.d.zzpj();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzacd zzacdVar) throws RemoteException {
        zzawz.zzeo("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzyd zzydVar) throws RemoteException {
        zzbnf zzbnfVar = this.d;
        if (zzbnfVar != null) {
            zzbnfVar.zza(this.e, zzydVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzado zzadoVar) throws RemoteException {
        zzawz.zzeo("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzyw zzywVar) throws RemoteException {
        zzawz.zzeo("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzb(zzzy zzzyVar) throws RemoteException {
        zzawz.zzeo("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        zzawz.zzeo("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzb(zzyz zzyzVar) throws RemoteException {
        zzawz.zzeo("setAdListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzzs zzzsVar) throws RemoteException {
        zzawz.zzeo("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzzp zzzpVar) throws RemoteException {
        zzawz.zzeo("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final Bundle getAdMetadata() throws RemoteException {
        zzawz.zzeo("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
        return new Bundle();
    }
}
