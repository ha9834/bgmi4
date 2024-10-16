package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* loaded from: classes2.dex */
final class ajo implements ajn {
    private ajo() {
    }

    @Override // com.google.android.gms.internal.ads.ajn
    public final boolean b() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.ajn
    public final int a() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.android.gms.internal.ads.ajn
    public final MediaCodecInfo a(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // com.google.android.gms.internal.ads.ajn
    public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }
}
