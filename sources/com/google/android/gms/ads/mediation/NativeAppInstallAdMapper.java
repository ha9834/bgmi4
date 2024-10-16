package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public class NativeAppInstallAdMapper extends NativeAdMapper {
    private String e;
    private List<NativeAd.Image> f;
    private String g;
    private NativeAd.Image h;
    private String i;
    private double j;
    private String k;
    private String l;

    public final void setHeadline(String str) {
        this.e = str;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.f = list;
    }

    public final void setBody(String str) {
        this.g = str;
    }

    public final void setIcon(NativeAd.Image image) {
        this.h = image;
    }

    public final void setCallToAction(String str) {
        this.i = str;
    }

    public final void setStarRating(double d) {
        this.j = d;
    }

    public final void setStore(String str) {
        this.k = str;
    }

    public final void setPrice(String str) {
        this.l = str;
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

    public final NativeAd.Image getIcon() {
        return this.h;
    }

    public final String getCallToAction() {
        return this.i;
    }

    public final double getStarRating() {
        return this.j;
    }

    public final String getStore() {
        return this.k;
    }

    public final String getPrice() {
        return this.l;
    }
}
