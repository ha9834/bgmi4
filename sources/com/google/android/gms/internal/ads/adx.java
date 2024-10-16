package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;

/* loaded from: classes2.dex */
final class adx extends ady {
    /* JADX INFO: Access modifiers changed from: package-private */
    public adx(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.ady
    public final int a() {
        return 12;
    }

    @Override // com.google.android.gms.internal.ads.ady
    final int[] a(int[] iArr, int i) {
        if (iArr.length != 3) {
            throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
        }
        int[] iArr2 = new int[16];
        ady.a(iArr2, this.f1823a);
        iArr2[12] = i;
        System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
        return iArr2;
    }
}
