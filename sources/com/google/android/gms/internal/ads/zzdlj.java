package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzdlj {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f3576a;

    public static zzdlj zzv(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new zzdlj(bArr, 0, bArr.length);
    }

    public final byte[] getBytes() {
        byte[] bArr = this.f3576a;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private zzdlj(byte[] bArr, int i, int i2) {
        this.f3576a = new byte[i2];
        System.arraycopy(bArr, 0, this.f3576a, 0, i2);
    }
}
