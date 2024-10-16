package com.google.android.gms.ads.formats;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.internal.ads.zzbad;

@Deprecated
/* loaded from: classes.dex */
public final class NativeContentAdView extends NativeAdView {
    public NativeContentAdView(Context context) {
        super(context);
    }

    public NativeContentAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NativeContentAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NativeContentAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public final void setHeadlineView(View view) {
        super.a("1001", view);
    }

    public final void setBodyView(View view) {
        super.a("1002", view);
    }

    public final void setCallToActionView(View view) {
        super.a(NativeContentAd.ASSET_CALL_TO_ACTION, view);
    }

    public final void setAdvertiserView(View view) {
        super.a(NativeContentAd.ASSET_ADVERTISER, view);
    }

    public final void setImageView(View view) {
        super.a(NativeContentAd.ASSET_IMAGE, view);
    }

    public final void setLogoView(View view) {
        super.a(NativeContentAd.ASSET_LOGO, view);
    }

    public final void setMediaView(MediaView mediaView) {
        super.a(NativeContentAd.ASSET_MEDIA_VIDEO, mediaView);
    }

    public final View getHeadlineView() {
        return super.a("1001");
    }

    public final View getBodyView() {
        return super.a("1002");
    }

    public final View getCallToActionView() {
        return super.a(NativeContentAd.ASSET_CALL_TO_ACTION);
    }

    public final View getAdvertiserView() {
        return super.a(NativeContentAd.ASSET_ADVERTISER);
    }

    public final View getImageView() {
        return super.a(NativeContentAd.ASSET_IMAGE);
    }

    public final View getLogoView() {
        return super.a(NativeContentAd.ASSET_LOGO);
    }

    public final MediaView getMediaView() {
        View a2 = super.a(NativeContentAd.ASSET_MEDIA_VIDEO);
        if (a2 instanceof MediaView) {
            return (MediaView) a2;
        }
        if (a2 == null) {
            return null;
        }
        zzbad.zzdp("View is not an instance of MediaView");
        return null;
    }
}
