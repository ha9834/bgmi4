package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

@zzard
/* loaded from: classes2.dex */
public final class zzagm extends zzafj {

    /* renamed from: a, reason: collision with root package name */
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener f2722a;

    public zzagm(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.f2722a = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafi
    public final void zza(zzaew zzaewVar) {
        this.f2722a.onAppInstallAdLoaded(new zzaez(zzaewVar));
    }
}
