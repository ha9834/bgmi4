package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* renamed from: com.google.android.gms.internal.ads.do, reason: invalid class name */
/* loaded from: classes2.dex */
final class Cdo implements com.google.android.gms.ads.internal.overlay.zzo {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzapl f2127a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(zzapl zzaplVar) {
        this.f2127a = zzaplVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzsz() {
        MediationInterstitialListener mediationInterstitialListener;
        zzbad.zzdp("AdMobCustomTabsAdapter overlay is closed.");
        mediationInterstitialListener = this.f2127a.b;
        mediationInterstitialListener.onAdClosed(this.f2127a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
        zzbad.zzdp("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
        zzbad.zzdp("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzta() {
        MediationInterstitialListener mediationInterstitialListener;
        zzbad.zzdp("Opening AdMobCustomTabsAdapter overlay.");
        mediationInterstitialListener = this.f2127a.b;
        mediationInterstitialListener.onAdOpened(this.f2127a);
    }
}
