package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzzk;

/* loaded from: classes.dex */
public final class PublisherAdView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private final zzabb f1134a;

    public PublisherAdView(Context context) {
        super(context);
        this.f1134a = new zzabb(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1134a = new zzabb(this, attributeSet, true);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1134a = new zzabb(this, attributeSet, true);
    }

    public final VideoController getVideoController() {
        return this.f1134a.getVideoController();
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.f1134a.setVideoOptions(videoOptions);
    }

    public final VideoOptions getVideoOptions() {
        return this.f1134a.getVideoOptions();
    }

    public final void destroy() {
        this.f1134a.destroy();
    }

    public final AdListener getAdListener() {
        return this.f1134a.getAdListener();
    }

    public final AdSize getAdSize() {
        return this.f1134a.getAdSize();
    }

    public final AdSize[] getAdSizes() {
        return this.f1134a.getAdSizes();
    }

    public final String getAdUnitId() {
        return this.f1134a.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.f1134a.getAppEventListener();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f1134a.getOnCustomRenderedAdLoadedListener();
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.f1134a.zza(publisherAdRequest.zzde());
    }

    public final void pause() {
        this.f1134a.pause();
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.f1134a.setManualImpressionsEnabled(z);
    }

    public final void recordManualImpression() {
        this.f1134a.recordManualImpression();
    }

    public final void resume() {
        this.f1134a.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.f1134a.setAdListener(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.f1134a.zza(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        this.f1134a.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.f1134a.setAppEventListener(appEventListener);
    }

    public final void setCorrelator(Correlator correlator) {
        this.f1134a.setCorrelator(correlator);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f1134a.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final String getMediationAdapterClassName() {
        return this.f1134a.getMediationAdapterClassName();
    }

    public final boolean isLoading() {
        return this.f1134a.isLoading();
    }

    public final boolean zza(zzzk zzzkVar) {
        return this.f1134a.zza(zzzkVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        } else {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzbad.zzc("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }
}
