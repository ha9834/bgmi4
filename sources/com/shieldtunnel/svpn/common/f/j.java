package com.shieldtunnel.svpn.common.f;

import android.util.Base64;
import java.io.IOException;

/* loaded from: classes2.dex */
public class j {
    private static byte[] a(byte[] bArr) {
        try {
            return Base64.decode(bArr, 0);
        } catch (RuntimeException unused) {
            throw new IOException();
        }
    }

    private static byte[] b(byte[] bArr) {
        byte[] a2 = a();
        int length = a2.length;
        int length2 = bArr.length;
        byte[] bArr2 = new byte[length2];
        for (int i = 0; i < length2; i++) {
            bArr2[i] = (byte) (a2[i % length] ^ bArr[i]);
        }
        return bArr2;
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return b(a(bArr));
        } catch (IOException unused) {
            return null;
        }
    }

    private static byte[] a() {
        return new byte[]{113, 73, 117, 100, 81, 65, 52, 54, 74, 87, 109, 82, 65, 66, 56, 103, 112, 51, 77, 78, 66, 86, 117, 71, 89, 57, 119, 101, 105, 67, 76, 69, 122, 53, 103, 50, 105, 97, 85, 70, 109, 69, 72, 55, 78, 84, 104, 79, 82, 73, 55, 121, 72, 83, 116, 77, 76, 117, 74, 55, 104, 49, 65, 81, 119, 108, 122, 83, 114, 85, 57, 65, 108, 122, 112, 115, 80, 109, 57, 80, 102, 76, 116, 118, 118, 112, 86, 100, 57, 53, 97, 115, 101, 55, 89, 110, 105, 71, 121, 70, 53, 121, 76, 97, 55, 106, 112, 113, 102, 104, 106, 112, 101, 78, 119, 70, 81, 121, 85, 112, 85, 88, 88, 115, 57, 85, 110, 76};
    }
}
