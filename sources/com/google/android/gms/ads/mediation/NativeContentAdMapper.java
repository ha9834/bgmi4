package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public class NativeContentAdMapper extends NativeAdMapper {
    private String e;
    private List<NativeAd.Image> f;
    private String g;
    private NativeAd.Image h;
    private String i;
    private String j;

    public final void setHeadline(String str) {
        this.e = str;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.f = list;
    }

    public final void setBody(String str) {
        this.g = str;
    }

    public final void setLogo(NativeAd.Image image) {
        this.h = image;
    }

    public final void setCallToAction(String str) {
        this.i = str;
    }

    public final void setAdvertiser(String str) {
        this.j = str;
    }

    public final String getHeadline() {
        return this.e;
    }

    public final List<NativeAd.Image> getImages() {
        return this.f;
    }

    public final String getBody() {
        return this.g;
    }

    public final NativeAd.Image getLogo() {
        return this.h;
    }

    public final String getCallToAction() {
        return this.i;
    }

    public final String getAdvertiser() {
        return this.j;
    }
}
