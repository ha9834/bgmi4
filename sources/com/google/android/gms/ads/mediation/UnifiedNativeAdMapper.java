package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.internal.ads.zzard;
import java.util.List;
import java.util.Map;

@zzard
/* loaded from: classes.dex */
public class UnifiedNativeAdMapper {

    /* renamed from: a, reason: collision with root package name */
    private String f1170a;
    private List<NativeAd.Image> b;
    private String c;
    private NativeAd.Image d;
    private String e;
    private String f;
    private Double g;
    private String h;
    private String i;
    private VideoController j;
    private boolean k;
    private View l;
    private View m;
    private Object n;
    private Bundle o = new Bundle();
    private boolean p;
    private boolean q;

    public void handleClick(View view) {
    }

    public void recordImpression() {
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }

    public final void setHeadline(String str) {
        this.f1170a = str;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.b = list;
    }

    public final void setBody(String str) {
        this.c = str;
    }

    public final void setIcon(NativeAd.Image image) {
        this.d = image;
    }

    public final void setCallToAction(String str) {
        this.e = str;
    }

    public final void setAdvertiser(String str) {
        this.f = str;
    }

    public final void setStarRating(Double d) {
        this.g = d;
    }

    public final void setStore(String str) {
        this.h = str;
    }

    public final void setPrice(String str) {
        this.i = str;
    }

    public final void zza(VideoController videoController) {
        this.j = videoController;
    }

    public void setHasVideoContent(boolean z) {
        this.k = z;
    }

    public void setAdChoicesContent(View view) {
        this.l = view;
    }

    public void setMediaView(View view) {
        this.m = view;
    }

    public final void zzp(Object obj) {
        this.n = obj;
    }

    public final void setExtras(Bundle bundle) {
        this.o = bundle;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.p = z;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.q = z;
    }

    public final String getHeadline() {
        return this.f1170a;
    }

    public final List<NativeAd.Image> getImages() {
        return this.b;
    }

    public final String getBody() {
        return this.c;
    }

    public final NativeAd.Image getIcon() {
        return this.d;
    }

    public final String getCallToAction() {
        return this.e;
    }

    public final String getAdvertiser() {
        return this.f;
    }

    public final Double getStarRating() {
        return this.g;
    }

    public final String getStore() {
        return this.h;
    }

    public final String getPrice() {
        return this.i;
    }

    public final VideoController getVideoController() {
        return this.j;
    }

    public boolean hasVideoContent() {
        return this.k;
    }

    public View getAdChoicesContent() {
        return this.l;
    }

    public final View zzacd() {
        return this.m;
    }

    public final Object zzkv() {
        return this.n;
    }

    public final Bundle getExtras() {
        return this.o;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.p;
    }

    public final boolean getOverrideClickHandling() {
        return this.q;
    }
}
