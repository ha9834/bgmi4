package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.ads.zzard;

@zzard
/* loaded from: classes.dex */
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int ORIENTATION_ANY = 0;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1136a;
    private final int b;
    private final int c;
    private final boolean d;
    private final int e;
    private final VideoOptions f;
    private final boolean g;

    /* loaded from: classes.dex */
    public @interface AdChoicesPlacement {
    }

    private NativeAdOptions(Builder builder) {
        this.f1136a = builder.f1137a;
        this.b = builder.b;
        this.c = 0;
        this.d = builder.d;
        this.e = builder.f;
        this.f = builder.e;
        this.g = builder.g;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private VideoOptions e;

        /* renamed from: a, reason: collision with root package name */
        private boolean f1137a = false;
        private int b = -1;
        private int c = 0;
        private boolean d = false;
        private int f = 1;
        private boolean g = false;

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.f1137a = z;
            return this;
        }

        public final Builder setImageOrientation(int i) {
            this.b = i;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.d = z;
            return this;
        }

        public final Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.f = i;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.e = videoOptions;
            return this;
        }

        public final Builder setRequestCustomMuteThisAd(boolean z) {
            this.g = z;
            return this;
        }

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.f1136a;
    }

    public final int getImageOrientation() {
        return this.b;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.d;
    }

    public final int getAdChoicesPlacement() {
        return this.e;
    }

    public final VideoOptions getVideoOptions() {
        return this.f;
    }

    public final boolean zzkr() {
        return this.g;
    }
}
