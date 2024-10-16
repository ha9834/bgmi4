package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* loaded from: classes2.dex */
final class amy implements amx {
    private amy() {
    }

    @Override // com.google.android.gms.internal.ads.amx
    public final boolean b() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.amx
    public final int a() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.android.gms.internal.ads.amx
    public final MediaCodecInfo a(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // com.google.android.gms.internal.ads.amx
    public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }
}
