package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class aef extends ady {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aef(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.ady
    public final int a() {
        return 24;
    }

    @Override // com.google.android.gms.internal.ads.ady
    final int[] a(int[] iArr, int i) {
        if (iArr.length != 6) {
            throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
        }
        int[] iArr2 = new int[16];
        ady.a(r0, this.f1823a);
        int[] iArr3 = {0, 0, 0, 0, iArr3[12], iArr3[13], iArr3[14], iArr3[15], 0, 0, 0, 0, iArr[0], iArr[1], iArr[2], iArr[3]};
        ady.a(iArr3);
        ady.a(iArr2, Arrays.copyOf(iArr3, 8));
        iArr2[12] = i;
        iArr2[13] = 0;
        iArr2[14] = iArr[4];
        iArr2[15] = iArr[5];
        return iArr2;
    }
}
