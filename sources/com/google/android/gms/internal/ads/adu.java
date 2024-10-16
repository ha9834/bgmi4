package com.google.android.gms.internal.ads;

import com.intlgame.core.INTLMethodID;

/* loaded from: classes2.dex */
final class adu {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] a(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("value must be a block.");
        }
        byte[] bArr2 = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr2[i] = (byte) ((bArr[i] << 1) & 254);
            if (i < 15) {
                bArr2[i] = (byte) (bArr2[i] | ((byte) ((bArr[i + 1] >> 7) & 1)));
            }
        }
        bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & INTLMethodID.INTL_METHOD_ID_AUTH_MODIFY_DATA_PROTECTION_ACCEPTANCE)) ^ bArr2[15]);
        return bArr2;
    }
}
