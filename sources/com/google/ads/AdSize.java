package com.google.ads;

import android.content.Context;
import com.tencent.smtt.sdk.TbsListener;
import com.twitter.sdk.android.core.internal.scribe.ScribeConfig;

@Deprecated
/* loaded from: classes.dex */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.ads.AdSize f1105a;
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
    public static final AdSize BANNER = new AdSize(320, 50, "mb");
    public static final AdSize IAB_MRECT = new AdSize(300, 250, "as");
    public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
    public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(TbsListener.ErrorCode.STARTDOWNLOAD_1, ScribeConfig.DEFAULT_SEND_INTERVAL_SECONDS, "as");

    public AdSize(com.google.android.gms.ads.AdSize adSize) {
        this.f1105a = adSize;
    }

    public final boolean isCustomAdSize() {
        return false;
    }

    public AdSize(int i, int i2) {
        this(new com.google.android.gms.ads.AdSize(i, i2));
    }

    private AdSize(int i, int i2, String str) {
        this(new com.google.android.gms.ads.AdSize(i, i2));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AdSize) {
            return this.f1105a.equals(((AdSize) obj).f1105a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1105a.hashCode();
    }

    public final int getWidth() {
        return this.f1105a.getWidth();
    }

    public final int getHeight() {
        return this.f1105a.getHeight();
    }

    public final boolean isFullWidth() {
        return this.f1105a.isFullWidth();
    }

    public final boolean isAutoHeight() {
        return this.f1105a.isAutoHeight();
    }

    public final String toString() {
        return this.f1105a.toString();
    }

    public final int getWidthInPixels(Context context) {
        return this.f1105a.getWidthInPixels(context);
    }

    public final int getHeightInPixels(Context context) {
        return this.f1105a.getHeightInPixels(context);
    }

    public final boolean isSizeAppropriate(int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        float f = i;
        float f2 = width;
        if (f > f2 * 1.25f || f < f2 * 0.8f) {
            return false;
        }
        float f3 = i2;
        float f4 = height;
        return f3 <= 1.25f * f4 && f3 >= f4 * 0.8f;
    }

    public final AdSize findBestSize(AdSize... adSizeArr) {
        AdSize adSize = null;
        if (adSizeArr == null) {
            return null;
        }
        float f = 0.0f;
        int width = getWidth();
        int height = getHeight();
        for (AdSize adSize2 : adSizeArr) {
            if (isSizeAppropriate(adSize2.getWidth(), adSize2.getHeight())) {
                float f2 = (r7 * r8) / (width * height);
                if (f2 > 1.0f) {
                    f2 = 1.0f / f2;
                }
                if (f2 > f) {
                    adSize = adSize2;
                    f = f2;
                }
            }
        }
        return adSize;
    }
}
