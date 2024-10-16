package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzanq extends zzanb {

    /* renamed from: a, reason: collision with root package name */
    private final NativeAppInstallAdMapper f2766a;

    public zzanq(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.f2766a = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzaea zzrj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper zzrk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String getHeadline() {
        return this.f2766a.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final List getImages() {
        List<NativeAd.Image> images = this.f2766a.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new zzadw(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String getBody() {
        return this.f2766a.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzaei zzri() {
        NativeAd.Image icon = this.f2766a.getIcon();
        if (icon != null) {
            return new zzadw(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String getCallToAction() {
        return this.f2766a.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final double getStarRating() {
        return this.f2766a.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String getStore() {
        return this.f2766a.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String getPrice() {
        return this.f2766a.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void recordImpression() {
        this.f2766a.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzt(IObjectWrapper iObjectWrapper) {
        this.f2766a.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.f2766a.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.f2766a.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.f2766a.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final boolean getOverrideImpressionRecording() {
        return this.f2766a.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final boolean getOverrideClickHandling() {
        return this.f2766a.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final Bundle getExtras() {
        return this.f2766a.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzaar getVideoController() {
        if (this.f2766a.getVideoController() != null) {
            return this.f2766a.getVideoController().zzdh();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper zzso() {
        View adChoicesContent = this.f2766a.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper zzsp() {
        View zzacd = this.f2766a.zzacd();
        if (zzacd == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzacd);
    }
}
