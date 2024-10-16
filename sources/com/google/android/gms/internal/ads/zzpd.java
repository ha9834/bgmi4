package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzpd {

    /* renamed from: a, reason: collision with root package name */
    private final String f3702a;
    private final MediaCodecInfo.CodecCapabilities b;
    public final String name;
    public final boolean zzabo;
    public final boolean zzaer;
    public final boolean zzawy;

    public static zzpd zzbc(String str) {
        return new zzpd(str, null, null, false, false);
    }

    public static zzpd zza(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new zzpd(str, str2, codecCapabilities, z, z2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        if ((com.google.android.gms.internal.ads.zzsy.SDK_INT >= 21 && r4.isFeatureSupported("secure-playback")) != false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private zzpd(java.lang.String r2, java.lang.String r3, android.media.MediaCodecInfo.CodecCapabilities r4, boolean r5, boolean r6) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzsk.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.name = r2
            r1.f3702a = r3
            r1.b = r4
            r2 = 1
            r3 = 0
            if (r5 != 0) goto L2a
            if (r4 == 0) goto L2a
            int r5 = com.google.android.gms.internal.ads.zzsy.SDK_INT
            r0 = 19
            if (r5 < r0) goto L25
            java.lang.String r5 = "adaptive-playback"
            boolean r5 = r4.isFeatureSupported(r5)
            if (r5 == 0) goto L25
            r5 = 1
            goto L26
        L25:
            r5 = 0
        L26:
            if (r5 == 0) goto L2a
            r5 = 1
            goto L2b
        L2a:
            r5 = 0
        L2b:
            r1.zzabo = r5
            r5 = 21
            if (r4 == 0) goto L44
            int r0 = com.google.android.gms.internal.ads.zzsy.SDK_INT
            if (r0 < r5) goto L3f
            java.lang.String r0 = "tunneled-playback"
            boolean r0 = r4.isFeatureSupported(r0)
            if (r0 == 0) goto L3f
            r0 = 1
            goto L40
        L3f:
            r0 = 0
        L40:
            if (r0 == 0) goto L44
            r0 = 1
            goto L45
        L44:
            r0 = 0
        L45:
            r1.zzawy = r0
            if (r6 != 0) goto L5e
            if (r4 == 0) goto L5d
            int r6 = com.google.android.gms.internal.ads.zzsy.SDK_INT
            if (r6 < r5) goto L59
            java.lang.String r5 = "secure-playback"
            boolean r4 = r4.isFeatureSupported(r5)
            if (r4 == 0) goto L59
            r4 = 1
            goto L5a
        L59:
            r4 = 0
        L5a:
            if (r4 == 0) goto L5d
            goto L5e
        L5d:
            r2 = 0
        L5e:
            r1.zzaer = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpd.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):void");
    }

    public final MediaCodecInfo.CodecProfileLevel[] zziq() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.b;
        if (codecCapabilities == null || codecCapabilities.profileLevels == null) {
            return new MediaCodecInfo.CodecProfileLevel[0];
        }
        return this.b.profileLevels;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzat(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpd.zzat(java.lang.String):boolean");
    }

    @TargetApi(21)
    public final boolean zza(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.b;
        if (codecCapabilities == null) {
            a("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            a("sizeAndRate.vCaps");
            return false;
        }
        if (a(videoCapabilities, i, i2, d)) {
            return true;
        }
        if (i >= i2 || !a(videoCapabilities, i2, i, d)) {
            StringBuilder sb = new StringBuilder(69);
            sb.append("sizeAndRate.support, ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            sb.append("x");
            sb.append(d);
            a(sb.toString());
            return false;
        }
        StringBuilder sb2 = new StringBuilder(69);
        sb2.append("sizeAndRate.rotated, ");
        sb2.append(i);
        sb2.append("x");
        sb2.append(i2);
        sb2.append("x");
        sb2.append(d);
        String sb3 = sb2.toString();
        String str = this.name;
        String str2 = this.f3702a;
        String str3 = zzsy.zzbnq;
        StringBuilder sb4 = new StringBuilder(String.valueOf(sb3).length() + 25 + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb4.append("AssumedSupport [");
        sb4.append(sb3);
        sb4.append("] [");
        sb4.append(str);
        sb4.append(", ");
        sb4.append(str2);
        sb4.append("] [");
        sb4.append(str3);
        sb4.append("]");
        Log.d("MediaCodecInfo", sb4.toString());
        return true;
    }

    @TargetApi(21)
    public final Point zze(int i, int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.b;
        if (codecCapabilities == null) {
            a("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            a("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(zzsy.zzb(i, widthAlignment) * widthAlignment, zzsy.zzb(i2, heightAlignment) * heightAlignment);
    }

    @TargetApi(21)
    public final boolean zzba(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.b;
        if (codecCapabilities == null) {
            a("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            a("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("sampleRate.support, ");
        sb.append(i);
        a(sb.toString());
        return false;
    }

    @TargetApi(21)
    public final boolean zzbb(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.b;
        if (codecCapabilities == null) {
            a("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            a("channelCount.aCaps");
            return false;
        }
        if (audioCapabilities.getMaxInputChannelCount() >= i) {
            return true;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("channelCount.support, ");
        sb.append(i);
        a(sb.toString());
        return false;
    }

    private final void a(String str) {
        String str2 = this.name;
        String str3 = this.f3702a;
        String str4 = zzsy.zzbnq;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        Log.d("MediaCodecInfo", sb.toString());
    }

    @TargetApi(21)
    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (d == -1.0d || d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }
}
