package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

@zzard
/* loaded from: classes2.dex */
public final class zzxv extends zzza {

    /* renamed from: a, reason: collision with root package name */
    private final AdListener f3777a;

    public zzxv(AdListener adListener) {
        this.f3777a = adListener;
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdClosed() {
        this.f3777a.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdFailedToLoad(int i) {
        this.f3777a.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdLeftApplication() {
        this.f3777a.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdLoaded() {
        this.f3777a.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdOpened() {
        this.f3777a.onAdOpened();
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdClicked() {
        this.f3777a.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdImpression() {
        this.f3777a.onAdImpression();
    }

    public final AdListener getAdListener() {
        return this.f3777a;
    }
}
