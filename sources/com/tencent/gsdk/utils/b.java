package com.tencent.gsdk.utils;

import com.qq.taf.jce.JceStruct;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f6241a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 63, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, 0, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(((bArr.length - 1) / 3) << 6);
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i2 % 3;
            int i4 = 16 - (i3 * 8);
            i |= (bArr[i2] << i4) & (255 << i4);
            if (i3 == 2 || i2 == bArr.length - 1) {
                stringBuffer.append(f6241a[(16515072 & i) >>> 18]);
                stringBuffer.append(f6241a[(258048 & i) >>> 12]);
                stringBuffer.append(f6241a[(i & 4032) >>> 6]);
                stringBuffer.append(f6241a[i & 63]);
                i = 0;
            }
        }
        if (bArr.length % 3 > 0) {
            stringBuffer.setCharAt(stringBuffer.length() - 1, '=');
        }
        if (bArr.length % 3 == 1) {
            stringBuffer.setCharAt(stringBuffer.length() - 2, '=');
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 4 != 0) {
            throw new IllegalArgumentException("Base64 string length must be 4*n");
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        int i = str.charAt(length + (-1)) == '=' ? 1 : 0;
        if (str.charAt(length - 2) == '=') {
            i++;
        }
        int i2 = ((length / 4) * 3) - i;
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < length; i3 += 4) {
            int i4 = (i3 / 4) * 3;
            char charAt = str.charAt(i3);
            char charAt2 = str.charAt(i3 + 1);
            char charAt3 = str.charAt(i3 + 2);
            char charAt4 = str.charAt(i3 + 3);
            byte[] bArr2 = b;
            int i5 = (bArr2[charAt] << 18) | (bArr2[charAt2] << JceStruct.ZERO_TAG) | (bArr2[charAt3] << 6) | bArr2[charAt4];
            bArr[i4] = (byte) ((16711680 & i5) >> 16);
            if (i3 < length - 4) {
                bArr[i4 + 1] = (byte) ((65280 & i5) >> 8);
                bArr[i4 + 2] = (byte) (i5 & 255);
            } else {
                int i6 = i4 + 1;
                if (i6 < i2) {
                    bArr[i6] = (byte) ((65280 & i5) >> 8);
                }
                int i7 = i4 + 2;
                if (i7 < i2) {
                    bArr[i7] = (byte) (i5 & 255);
                }
            }
        }
        return bArr;
    }
}
