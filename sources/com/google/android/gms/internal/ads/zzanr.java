package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzanr extends zzane {

    /* renamed from: a, reason: collision with root package name */
    private final NativeContentAdMapper f2767a;

    public zzanr(NativeContentAdMapper nativeContentAdMapper) {
        this.f2767a = nativeContentAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaea zzrj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper zzrk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String getHeadline() {
        return this.f2767a.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final List getImages() {
        List<NativeAd.Image> images = this.f2767a.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new zzadw(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String getBody() {
        return this.f2767a.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaei zzrl() {
        NativeAd.Image logo = this.f2767a.getLogo();
        if (logo != null) {
            return new zzadw(logo.getDrawable(), logo.getUri(), logo.getScale(), logo.getWidth(), logo.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String getCallToAction() {
        return this.f2767a.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String getAdvertiser() {
        return this.f2767a.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void recordImpression() {
        this.f2767a.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zzt(IObjectWrapper iObjectWrapper) {
        this.f2767a.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.f2767a.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.f2767a.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.f2767a.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final boolean getOverrideImpressionRecording() {
        return this.f2767a.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final boolean getOverrideClickHandling() {
        return this.f2767a.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final Bundle getExtras() {
        return this.f2767a.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper zzso() {
        View adChoicesContent = this.f2767a.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaar getVideoController() {
        if (this.f2767a.getVideoController() != null) {
            return this.f2767a.getVideoController().zzdh();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper zzsp() {
        View zzacd = this.f2767a.zzacd();
        if (zzacd == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzacd);
    }
}
