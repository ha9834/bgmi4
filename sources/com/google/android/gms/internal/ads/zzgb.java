package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;

/* loaded from: classes2.dex */
public final class zzgb {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f3639a;
    private int b;
    private int c;
    private final MediaCodec.CryptoInfo d;
    public byte[] iv;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;

    public zzgb() {
        this.d = zzkq.SDK_INT >= 16 ? new MediaCodec.CryptoInfo() : null;
    }

    public final void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.c = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.f3639a = bArr;
        this.iv = bArr2;
        this.b = 1;
        if (zzkq.SDK_INT >= 16) {
            this.d.set(this.c, this.numBytesOfClearData, this.numBytesOfEncryptedData, this.f3639a, this.iv, this.b);
        }
    }

    @TargetApi(16)
    public final void zza(MediaExtractor mediaExtractor) {
        mediaExtractor.getSampleCryptoInfo(this.d);
        this.c = this.d.numSubSamples;
        this.numBytesOfClearData = this.d.numBytesOfClearData;
        this.numBytesOfEncryptedData = this.d.numBytesOfEncryptedData;
        this.f3639a = this.d.key;
        this.iv = this.d.iv;
        this.b = this.d.mode;
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo zzdl() {
        return this.d;
    }
}
