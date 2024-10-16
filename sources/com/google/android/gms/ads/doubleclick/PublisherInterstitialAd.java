package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzabd;

/* loaded from: classes.dex */
public final class PublisherInterstitialAd {

    /* renamed from: a, reason: collision with root package name */
    private final zzabd f1135a;

    public PublisherInterstitialAd(Context context) {
        this.f1135a = new zzabd(context, this);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.f1135a.getAdListener();
    }

    public final String getAdUnitId() {
        return this.f1135a.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.f1135a.getAppEventListener();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f1135a.getOnCustomRenderedAdLoadedListener();
    }

    public final boolean isLoaded() {
        return this.f1135a.isLoaded();
    }

    public final boolean isLoading() {
        return this.f1135a.isLoading();
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.f1135a.zza(publisherAdRequest.zzde());
    }

    public final void setAdListener(AdListener adListener) {
        this.f1135a.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.f1135a.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.f1135a.setAppEventListener(appEventListener);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f1135a.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.f1135a.setCorrelator(correlator);
    }

    public final String getMediationAdapterClassName() {
        return this.f1135a.getMediationAdapterClassName();
    }

    public final void show() {
        this.f1135a.show();
    }

    public final void setImmersiveMode(boolean z) {
        this.f1135a.setImmersiveMode(z);
    }
}
