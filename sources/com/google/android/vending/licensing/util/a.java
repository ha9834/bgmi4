package com.google.android.vending.licensing.util;

import com.qq.taf.jce.JceStruct;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f5391a = !a.class.desiredAssertionStatus();
    private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
    private static final byte[] e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};

    private a() {
    }

    private static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, byte[] bArr3) {
        int i4 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << 24) >>> 24 : 0);
        switch (i2) {
            case 1:
                bArr2[i3] = bArr3[i4 >>> 18];
                bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
                bArr2[i3 + 2] = 61;
                bArr2[i3 + 3] = 61;
                return bArr2;
            case 2:
                bArr2[i3] = bArr3[i4 >>> 18];
                bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
                bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
                bArr2[i3 + 3] = 61;
                return bArr2;
            case 3:
                bArr2[i3] = bArr3[i4 >>> 18];
                bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
                bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
                bArr2[i3 + 3] = bArr3[i4 & 63];
                return bArr2;
            default:
                return bArr2;
        }
    }

    public static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length, b, true);
    }

    public static String a(byte[] bArr, int i, int i2, byte[] bArr2, boolean z) {
        byte[] a2 = a(bArr, i, i2, bArr2, Integer.MAX_VALUE);
        int length = a2.length;
        while (!z && length > 0 && a2[length - 1] == 61) {
            length--;
        }
        return new String(a2, 0, length);
    }

    public static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = ((i2 + 2) / 3) * 4;
        byte[] bArr3 = new byte[i4 + (i4 / i3)];
        int i5 = i2 - 2;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < i5) {
            int i9 = ((bArr[i6 + i] << 24) >>> 8) | ((bArr[(i6 + 1) + i] << 24) >>> 16) | ((bArr[(i6 + 2) + i] << 24) >>> 24);
            bArr3[i7] = bArr2[i9 >>> 18];
            int i10 = i7 + 1;
            bArr3[i10] = bArr2[(i9 >>> 12) & 63];
            bArr3[i7 + 2] = bArr2[(i9 >>> 6) & 63];
            bArr3[i7 + 3] = bArr2[i9 & 63];
            i8 += 4;
            if (i8 == i3) {
                bArr3[i7 + 4] = 10;
                i8 = 0;
            } else {
                i10 = i7;
            }
            i6 += 3;
            i7 = i10 + 4;
        }
        if (i6 < i2) {
            a(bArr, i6 + i, i2 - i6, bArr3, i7, bArr2);
            if (i8 + 4 == i3) {
                bArr3[i7 + 4] = 10;
                i7++;
            }
            i7 += 4;
        }
        if (f5391a || i7 == bArr3.length) {
            return bArr3;
        }
        throw new AssertionError();
    }

    private static int a(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3) {
        int i3 = i + 2;
        if (bArr[i3] == 61) {
            bArr2[i2] = (byte) ((((bArr3[bArr[i + 1]] << 24) >>> 12) | ((bArr3[bArr[i]] << 24) >>> 6)) >>> 16);
            return 1;
        }
        int i4 = i + 3;
        if (bArr[i4] == 61) {
            int i5 = ((bArr3[bArr[i3]] << 24) >>> 18) | ((bArr3[bArr[i + 1]] << 24) >>> 12) | ((bArr3[bArr[i]] << 24) >>> 6);
            bArr2[i2] = (byte) (i5 >>> 16);
            bArr2[i2 + 1] = (byte) (i5 >>> 8);
            return 2;
        }
        int i6 = ((bArr3[bArr[i4]] << 24) >>> 24) | ((bArr3[bArr[i + 1]] << 24) >>> 12) | ((bArr3[bArr[i]] << 24) >>> 6) | ((bArr3[bArr[i3]] << 24) >>> 18);
        bArr2[i2] = (byte) (i6 >> 16);
        bArr2[i2 + 1] = (byte) (i6 >> 8);
        bArr2[i2 + 2] = (byte) i6;
        return 3;
    }

    public static byte[] a(String str) throws Base64DecoderException {
        byte[] bytes = str.getBytes();
        return a(bytes, 0, bytes.length);
    }

    public static byte[] a(byte[] bArr, int i, int i2) throws Base64DecoderException {
        return a(bArr, i, i2, d);
    }

    public static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2) throws Base64DecoderException {
        byte[] bArr3 = new byte[((i2 * 3) / 4) + 2];
        byte[] bArr4 = new byte[4];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            int i6 = i3 + i;
            byte b2 = (byte) (bArr[i6] & Byte.MAX_VALUE);
            byte b3 = bArr2[b2];
            if (b3 < -5) {
                throw new Base64DecoderException("Bad Base64 input character at " + i3 + ": " + ((int) bArr[i6]) + "(decimal)");
            }
            if (b3 >= -1) {
                if (b2 == 61) {
                    int i7 = i2 - i3;
                    byte b4 = (byte) (bArr[(i2 - 1) + i] & Byte.MAX_VALUE);
                    if (i4 == 0 || i4 == 1) {
                        throw new Base64DecoderException("invalid padding byte '=' at byte offset " + i3);
                    }
                    if ((i4 == 3 && i7 > 2) || (i4 == 4 && i7 > 1)) {
                        throw new Base64DecoderException("padding byte '=' falsely signals end of encoded value at offset " + i3);
                    }
                    if (b4 != 61 && b4 != 10) {
                        throw new Base64DecoderException("encoded value has invalid trailing byte");
                    }
                } else {
                    int i8 = i4 + 1;
                    bArr4[i4] = b2;
                    if (i8 == 4) {
                        i5 += a(bArr4, 0, bArr3, i5, bArr2);
                        i4 = 0;
                    } else {
                        i4 = i8;
                    }
                }
            }
            i3++;
        }
        if (i4 != 0) {
            if (i4 == 1) {
                throw new Base64DecoderException("single trailing character at offset " + (i2 - 1));
            }
            bArr4[i4] = 61;
            i5 += a(bArr4, 0, bArr3, i5, bArr2);
        }
        byte[] bArr5 = new byte[i5];
        System.arraycopy(bArr3, 0, bArr5, 0, i5);
        return bArr5;
    }
}
