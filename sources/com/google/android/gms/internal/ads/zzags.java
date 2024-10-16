package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

@zzard
/* loaded from: classes2.dex */
public final class zzags extends zzafy {

    /* renamed from: a, reason: collision with root package name */
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener f2727a;

    public zzags(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.f2727a = onUnifiedNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    public final void zza(zzagg zzaggVar) {
        this.f2727a.onUnifiedNativeAdLoaded(new zzagj(zzaggVar));
    }
}
