package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.internal.ads.zzard;

@zzard
/* loaded from: classes.dex */
public final class NativeExpressAdView extends a {
    public NativeExpressAdView(Context context) {
        super(context, 1);
    }

    public NativeExpressAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
    }

    public NativeExpressAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 1);
    }

    public final VideoController getVideoController() {
        return this.f1131a.getVideoController();
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.f1131a.setVideoOptions(videoOptions);
    }

    public final VideoOptions getVideoOptions() {
        return this.f1131a.getVideoOptions();
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ String getMediationAdapterClassName() {
        return super.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ void setAdUnitId(String str) {
        super.setAdUnitId(str);
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ void setAdSize(AdSize adSize) {
        super.setAdSize(adSize);
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ void setAdListener(AdListener adListener) {
        super.setAdListener(adListener);
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ boolean isLoading() {
        return super.isLoading();
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ void resume() {
        super.resume();
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ void pause() {
        super.pause();
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ void loadAd(AdRequest adRequest) {
        super.loadAd(adRequest);
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ String getAdUnitId() {
        return super.getAdUnitId();
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ AdSize getAdSize() {
        return super.getAdSize();
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ AdListener getAdListener() {
        return super.getAdListener();
    }

    @Override // com.google.android.gms.ads.a
    public final /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }
}
