package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

/* loaded from: classes2.dex */
public final class zzmz {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f3688a;
    private int b;
    private int c;
    private int d;
    private int e;
    private final MediaCodec.CryptoInfo f;
    private final alr g;
    public byte[] iv;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;

    public zzmz() {
        this.f = zzsy.SDK_INT >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.g = zzsy.SDK_INT >= 24 ? new alr(this.f) : null;
    }

    public final void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.c = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.f3688a = bArr;
        this.iv = bArr2;
        this.b = i2;
        this.d = 0;
        this.e = 0;
        if (zzsy.SDK_INT >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.f;
            cryptoInfo.numSubSamples = this.c;
            cryptoInfo.numBytesOfClearData = this.numBytesOfClearData;
            cryptoInfo.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
            cryptoInfo.key = this.f3688a;
            cryptoInfo.iv = this.iv;
            cryptoInfo.mode = this.b;
            if (zzsy.SDK_INT >= 24) {
                this.g.a(0, 0);
            }
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo zzdl() {
        return this.f;
    }
}
