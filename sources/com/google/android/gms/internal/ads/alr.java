package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

@TargetApi(24)
/* loaded from: classes2.dex */
final class alr {

    /* renamed from: a, reason: collision with root package name */
    private final MediaCodec.CryptoInfo f1959a;
    private final MediaCodec.CryptoInfo.Pattern b;

    private alr(MediaCodec.CryptoInfo cryptoInfo) {
        this.f1959a = cryptoInfo;
        this.b = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, int i2) {
        this.b.set(i, i2);
        this.f1959a.setPattern(this.b);
    }
}
