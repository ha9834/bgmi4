package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

@TargetApi(21)
/* loaded from: classes2.dex */
final class amz implements amx {

    /* renamed from: a, reason: collision with root package name */
    private final int f1978a;
    private MediaCodecInfo[] b;

    public amz(boolean z) {
        this.f1978a = z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.amx
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.amx
    public final int a() {
        c();
        return this.b.length;
    }

    @Override // com.google.android.gms.internal.ads.amx
    public final MediaCodecInfo a(int i) {
        c();
        return this.b[i];
    }

    @Override // com.google.android.gms.internal.ads.amx
    public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private final void c() {
        if (this.b == null) {
            this.b = new MediaCodecList(this.f1978a).getCodecInfos();
        }
    }
}
