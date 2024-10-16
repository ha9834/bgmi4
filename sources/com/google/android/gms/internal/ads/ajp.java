package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

@TargetApi(21)
/* loaded from: classes2.dex */
final class ajp implements ajn {

    /* renamed from: a, reason: collision with root package name */
    private final int f1917a;
    private MediaCodecInfo[] b;

    public ajp(boolean z) {
        this.f1917a = z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.ajn
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.ajn
    public final int a() {
        c();
        return this.b.length;
    }

    @Override // com.google.android.gms.internal.ads.ajn
    public final MediaCodecInfo a(int i) {
        c();
        return this.b[i];
    }

    @Override // com.google.android.gms.internal.ads.ajn
    public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private final void c() {
        if (this.b == null) {
            this.b = new MediaCodecList(this.f1917a).getCodecInfos();
        }
    }
}
