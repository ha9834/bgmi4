package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzyd;
import com.google.android.gms.internal.ads.zzyt;
import com.tencent.smtt.sdk.TbsListener;
import com.twitter.sdk.android.core.internal.scribe.ScribeConfig;

@VisibleForTesting
/* loaded from: classes.dex */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;

    /* renamed from: a, reason: collision with root package name */
    private final int f1123a;
    private final int b;
    private final String c;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(TbsListener.ErrorCode.STARTDOWNLOAD_1, ScribeConfig.DEFAULT_SEND_INTERVAL_SECONDS, "160x600_as");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize zzaao = new AdSize(50, 50, "50x50_mb");
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AdSize(int r5, int r6) {
        /*
            r4 = this;
            r0 = -1
            if (r5 != r0) goto L6
            java.lang.String r0 = "FULL"
            goto La
        L6:
            java.lang.String r0 = java.lang.String.valueOf(r5)
        La:
            r1 = -2
            if (r6 != r1) goto L10
            java.lang.String r1 = "AUTO"
            goto L14
        L10:
            java.lang.String r1 = java.lang.String.valueOf(r6)
        L14:
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 4
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r0)
            java.lang.String r0 = "x"
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = "_as"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r4.<init>(r5, r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Invalid width for AdSize: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 < 0 && i2 != -2 && i2 != -4) {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("Invalid height for AdSize: ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        }
        this.f1123a = i;
        this.b = i2;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.f1123a == adSize.f1123a && this.b == adSize.b && this.c.equals(adSize.c);
    }

    public final int getHeight() {
        return this.b;
    }

    public final int getHeightInPixels(Context context) {
        switch (this.b) {
            case -4:
            case -3:
                return -1;
            case -2:
                return zzyd.zzc(context.getResources().getDisplayMetrics());
            default:
                zzyt.zzpa();
                return zzazt.zza(context, this.b);
        }
    }

    public final int getWidth() {
        return this.f1123a;
    }

    public final int getWidthInPixels(Context context) {
        int i = this.f1123a;
        if (i == -1) {
            return zzyd.zzb(context.getResources().getDisplayMetrics());
        }
        switch (i) {
            case -4:
            case -3:
                return -1;
            default:
                zzyt.zzpa();
                return zzazt.zza(context, this.f1123a);
        }
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final boolean isAutoHeight() {
        return this.b == -2;
    }

    public final boolean isFullWidth() {
        return this.f1123a == -1;
    }

    public final boolean isFluid() {
        return this.f1123a == -3 && this.b == -4;
    }

    public final String toString() {
        return this.c;
    }
}
