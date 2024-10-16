package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaem;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzyt;

/* loaded from: classes.dex */
public final class UnifiedNativeAdView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f1142a;
    private final zzaem b;

    public UnifiedNativeAdView(Context context) {
        super(context);
        this.f1142a = a(context);
        this.b = a();
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1142a = a(context);
        this.b = a();
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1142a = a(context);
        this.b = a();
    }

    @TargetApi(21)
    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1142a = a(context);
        this.b = a();
    }

    private final void a(String str, View view) {
        try {
            this.b.zzc(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call setAssetView on delegate", e);
        }
    }

    public final void setHeadlineView(View view) {
        a(UnifiedNativeAdAssetNames.ASSET_HEADLINE, view);
    }

    public final void setCallToActionView(View view) {
        a(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION, view);
    }

    public final void setIconView(View view) {
        a(UnifiedNativeAdAssetNames.ASSET_ICON, view);
    }

    public final void setBodyView(View view) {
        a(UnifiedNativeAdAssetNames.ASSET_BODY, view);
    }

    public final void setAdvertiserView(View view) {
        a(UnifiedNativeAdAssetNames.ASSET_ADVERTISER, view);
    }

    public final void setStoreView(View view) {
        a(UnifiedNativeAdAssetNames.ASSET_STORE, view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.b.zzi(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setPriceView(View view) {
        a(UnifiedNativeAdAssetNames.ASSET_PRICE, view);
    }

    public final void setImageView(View view) {
        a(UnifiedNativeAdAssetNames.ASSET_IMAGE, view);
    }

    public final void setStarRatingView(View view) {
        a(UnifiedNativeAdAssetNames.ASSET_STAR_RATING, view);
    }

    public final void setMediaView(MediaView mediaView) {
        a(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO, mediaView);
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        a(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        try {
            this.b.zze((IObjectWrapper) unifiedNativeAd.a());
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call setNativeAd on delegate", e);
        }
    }

    private final View a(String str) {
        try {
            IObjectWrapper zzcf = this.b.zzcf(str);
            if (zzcf != null) {
                return (View) ObjectWrapper.unwrap(zzcf);
            }
            return null;
        } catch (RemoteException e) {
            zzbad.zzc("Unable to call getAssetView on delegate", e);
            return null;
        }
    }

    public final View getHeadlineView() {
        return a(UnifiedNativeAdAssetNames.ASSET_HEADLINE);
    }

    public final View getCallToActionView() {
        return a(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION);
    }

    public final View getIconView() {
        return a(UnifiedNativeAdAssetNames.ASSET_ICON);
    }

    public final View getBodyView() {
        return a(UnifiedNativeAdAssetNames.ASSET_BODY);
    }

    public final View getStoreView() {
        return a(UnifiedNativeAdAssetNames.ASSET_STORE);
    }

    public final View getPriceView() {
        return a(UnifiedNativeAdAssetNames.ASSET_PRICE);
    }

    public final View getAdvertiserView() {
        return a(UnifiedNativeAdAssetNames.ASSET_ADVERTISER);
    }

    public final View getImageView() {
        return a(UnifiedNativeAdAssetNames.ASSET_IMAGE);
    }

    public final View getStarRatingView() {
        return a(UnifiedNativeAdAssetNames.ASSET_STAR_RATING);
    }

    public final MediaView getMediaView() {
        View a2 = a(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO);
        if (a2 instanceof MediaView) {
            return (MediaView) a2;
        }
        if (a2 == null) {
            return null;
        }
        zzbad.zzdp("View is not an instance of MediaView");
        return null;
    }

    public final AdChoicesView getAdChoicesView() {
        View a2 = a(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (a2 instanceof AdChoicesView) {
            return (AdChoicesView) a2;
        }
        return null;
    }

    public final void destroy() {
        try {
            this.b.destroy();
        } catch (RemoteException e) {
            zzbad.zzc("Unable to destroy native ad view", e);
        }
    }

    private final FrameLayout a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzaem a() {
        Preconditions.checkNotNull(this.f1142a, "createDelegate must be called after overlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzyt.zzpb().zza(this.f1142a.getContext(), this, this.f1142a);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f1142a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.f1142a == view) {
            return;
        }
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f1142a);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.f1142a;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzaem zzaemVar = this.b;
        if (zzaemVar != null) {
            try {
                zzaemVar.zzc(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }
}
