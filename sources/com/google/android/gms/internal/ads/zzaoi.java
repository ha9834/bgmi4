package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzaoi extends zzanh {

    /* renamed from: a, reason: collision with root package name */
    private final UnifiedNativeAdMapper f2771a;

    public zzaoi(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.f2771a = unifiedNativeAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzaea zzrj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final float zzsq() {
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String getHeadline() {
        return this.f2771a.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final List getImages() {
        List<NativeAd.Image> images = this.f2771a.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image image : images) {
                arrayList.add(new zzadw(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String getBody() {
        return this.f2771a.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzaei zzri() {
        NativeAd.Image icon = this.f2771a.getIcon();
        if (icon != null) {
            return new zzadw(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String getCallToAction() {
        return this.f2771a.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String getAdvertiser() {
        return this.f2771a.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final double getStarRating() {
        if (this.f2771a.getStarRating() != null) {
            return this.f2771a.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String getStore() {
        return this.f2771a.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String getPrice() {
        return this.f2771a.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzaar getVideoController() {
        if (this.f2771a.getVideoController() != null) {
            return this.f2771a.getVideoController().zzdh();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final IObjectWrapper zzso() {
        View adChoicesContent = this.f2771a.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final IObjectWrapper zzsp() {
        View zzacd = this.f2771a.zzacd();
        if (zzacd == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzacd);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final IObjectWrapper zzrk() {
        Object zzkv = this.f2771a.zzkv();
        if (zzkv == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzkv);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final Bundle getExtras() {
        return this.f2771a.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final boolean getOverrideImpressionRecording() {
        return this.f2771a.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final boolean getOverrideClickHandling() {
        return this.f2771a.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void recordImpression() {
        this.f2771a.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzt(IObjectWrapper iObjectWrapper) {
        this.f2771a.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.f2771a.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.f2771a.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
