package com.tencent.mtt.des;

import java.lang.reflect.Array;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class DesUtils {
    public static final int FLAG_DECRYPT = 0;
    public static final int FLAG_ENCRYPT = 1;
    private static final int[] IP = {58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7};
    private static final int[] IP_1 = {40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25};
    private static final int[] PC_1 = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};
    private static final int[] PC_2 = {14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32};
    private static final int[] E = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
    private static final int[] P = {16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25};
    private static final int[][][] S_Box = {new int[][]{new int[]{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7}, new int[]{0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8}, new int[]{4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5}, new int[]{15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}}, new int[][]{new int[]{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10}, new int[]{3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5}, new int[]{0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15}, new int[]{13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}}, new int[][]{new int[]{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8}, new int[]{13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1}, new int[]{13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7}, new int[]{1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}}, new int[][]{new int[]{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15}, new int[]{13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9}, new int[]{10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4}, new int[]{3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}}, new int[][]{new int[]{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9}, new int[]{14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6}, new int[]{4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14}, new int[]{11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}}, new int[][]{new int[]{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11}, new int[]{10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8}, new int[]{9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6}, new int[]{4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}}, new int[][]{new int[]{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1}, new int[]{13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6}, new int[]{1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2}, new int[]{6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}}, new int[][]{new int[]{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7}, new int[]{1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2}, new int[]{7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8}, new int[]{2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}}};
    private static final int[] LeftMove = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};
    public static final byte[] REPORT_KEY_TEA = {98, -24, 57, -84, -115, 117, 55, 121};
    public static final byte[] KEY = {-25, -101, -115, 1, 47, 7, -27, -59, 18, Byte.MIN_VALUE, 123, 79, -44, 37, 46, 115};
    public static final byte[] MAC_KEY = {37, -110, 60, Byte.MAX_VALUE, 42, -27, -17, -110};
    public static final byte[] MTT_KEY = {-122, -8, -23, -84, -125, 113, 84, 99};
    public static final byte[] QQMARKET_KEY = "AL!#$AC9Ahg@KLJ1".getBytes();

    private static byte[] UnitDes(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length != 8 || bArr2.length != 8 || (i != 1 && i != 0)) {
            throw new RuntimeException("Data Format Error !");
        }
        int[] iArr = new int[64];
        int[] iArr2 = new int[64];
        byte[] bArr3 = new byte[8];
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) int.class, 16, 48);
        int[] ReadDataToBirnaryIntArray = ReadDataToBirnaryIntArray(bArr);
        int[] ReadDataToBirnaryIntArray2 = ReadDataToBirnaryIntArray(bArr2);
        KeyInitialize(ReadDataToBirnaryIntArray, iArr3);
        return Encrypt(ReadDataToBirnaryIntArray2, i, iArr3);
    }

    private static void KeyInitialize(int[] iArr, int[][] iArr2) {
        int[] iArr3 = new int[56];
        for (int i = 0; i < 56; i++) {
            iArr3[i] = iArr[PC_1[i] - 1];
        }
        for (int i2 = 0; i2 < 16; i2++) {
            LeftBitMove(iArr3, LeftMove[i2]);
            for (int i3 = 0; i3 < 48; i3++) {
                iArr2[i2][i3] = iArr3[PC_2[i3] - 1];
            }
        }
    }

    private static byte[] Encrypt(int[] iArr, int i, int[][] iArr2) {
        byte[] bArr = new byte[8];
        int[] iArr3 = new int[64];
        int[] iArr4 = new int[64];
        for (int i2 = 0; i2 < 64; i2++) {
            iArr3[i2] = iArr[IP[i2] - 1];
        }
        if (i == 1) {
            for (int i3 = 0; i3 < 16; i3++) {
                LoopF(iArr3, i3, i, iArr2);
            }
        } else if (i == 0) {
            for (int i4 = 15; i4 > -1; i4--) {
                LoopF(iArr3, i4, i, iArr2);
            }
        }
        for (int i5 = 0; i5 < 64; i5++) {
            iArr4[i5] = iArr3[IP_1[i5] - 1];
        }
        GetEncryptResultOfByteArray(iArr4, bArr);
        return bArr;
    }

    private static int[] ReadDataToBirnaryIntArray(byte[] bArr) {
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = bArr[i];
            if (iArr[i] < 0) {
                iArr[i] = iArr[i] + 256;
                iArr[i] = iArr[i] % 256;
            }
        }
        int[] iArr2 = new int[64];
        for (int i2 = 0; i2 < 8; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                iArr2[((i2 * 8) + 7) - i3] = iArr[i2] % 2;
                iArr[i2] = iArr[i2] / 2;
            }
        }
        return iArr2;
    }

    private static void LeftBitMove(int[] iArr, int i) {
        int[] iArr2 = new int[28];
        int[] iArr3 = new int[28];
        int[] iArr4 = new int[28];
        int[] iArr5 = new int[28];
        for (int i2 = 0; i2 < 28; i2++) {
            iArr2[i2] = iArr[i2];
            iArr3[i2] = iArr[i2 + 28];
        }
        if (i == 1) {
            int i3 = 0;
            while (i3 < 27) {
                int i4 = i3 + 1;
                iArr4[i3] = iArr2[i4];
                iArr5[i3] = iArr3[i4];
                i3 = i4;
            }
            iArr4[27] = iArr2[0];
            iArr5[27] = iArr3[0];
        } else if (i == 2) {
            for (int i5 = 0; i5 < 26; i5++) {
                int i6 = i5 + 2;
                iArr4[i5] = iArr2[i6];
                iArr5[i5] = iArr3[i6];
            }
            iArr4[26] = iArr2[0];
            iArr5[26] = iArr3[0];
            iArr4[27] = iArr2[1];
            iArr5[27] = iArr3[1];
        }
        for (int i7 = 0; i7 < 28; i7++) {
            iArr[i7] = iArr4[i7];
            iArr[i7 + 28] = iArr5[i7];
        }
    }

    private static void LoopF(int[] iArr, int i, int i2, int[][] iArr2) {
        int i3 = 32;
        int[] iArr3 = new int[32];
        int[] iArr4 = new int[32];
        int[] iArr5 = new int[32];
        int[] iArr6 = new int[32];
        int[] iArr7 = new int[48];
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) int.class, 8, 6);
        int[] iArr9 = new int[8];
        int[] iArr10 = new int[32];
        int[] iArr11 = new int[32];
        int i4 = 0;
        while (i4 < i3) {
            iArr3[i4] = iArr[i4];
            iArr4[i4] = iArr[i4 + 32];
            i4++;
            i3 = 32;
        }
        int i5 = 0;
        while (i5 < 48) {
            iArr7[i5] = iArr4[E[i5] - 1];
            iArr7[i5] = iArr7[i5] + iArr2[i][i5];
            if (iArr7[i5] == 2) {
                iArr7[i5] = 0;
            }
            i5++;
            i3 = 32;
        }
        int i6 = 0;
        while (i6 < 8) {
            int i7 = 0;
            for (int i8 = 6; i7 < i8; i8 = 6) {
                iArr8[i6][i7] = iArr7[(i6 * 6) + i7];
                i7++;
            }
            iArr9[i6] = S_Box[i6][(iArr8[i6][0] << 1) + iArr8[i6][5]][(iArr8[i6][1] << 3) + (iArr8[i6][2] << 2) + (iArr8[i6][3] << 1) + iArr8[i6][4]];
            for (int i9 = 0; i9 < 4; i9++) {
                iArr10[((i6 * 4) + 3) - i9] = iArr9[i6] % 2;
                iArr9[i6] = iArr9[i6] / 2;
            }
            i6++;
            i3 = 32;
        }
        for (int i10 = 0; i10 < i3; i10++) {
            iArr11[i10] = iArr10[P[i10] - 1];
            iArr5[i10] = iArr4[i10];
            iArr6[i10] = iArr3[i10] + iArr11[i10];
            if (iArr6[i10] == 2) {
                iArr6[i10] = 0;
            }
            if ((i2 == 0 && i == 0) || (i2 == 1 && i == 15)) {
                iArr[i10] = iArr6[i10];
                iArr[i10 + 32] = iArr5[i10];
            } else {
                iArr[i10] = iArr5[i10];
                iArr[i10 + 32] = iArr6[i10];
            }
        }
    }

    private static void GetEncryptResultOfByteArray(int[] iArr, byte[] bArr) {
        for (int i = 0; i < 8; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                bArr[i] = (byte) (bArr[i] + (iArr[(i << 3) + i2] << (7 - i2)));
            }
        }
    }

    private static byte[] ByteDataFormat(byte[] bArr) {
        int length = bArr.length;
        int i = 8 - (length % 8);
        int i2 = length + i;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        while (length < i2) {
            bArr2[length] = (byte) i;
            length++;
        }
        return bArr2;
    }

    private static byte[] KeyDataFormat(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        for (int i = 0; i < bArr2.length; i++) {
            bArr2[i] = 0;
        }
        if (bArr.length > 8) {
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        return bArr2;
    }

    public static byte[] DesEncrypt(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2 == null || bArr == null) {
            return bArr2;
        }
        try {
            byte[] KeyDataFormat = KeyDataFormat(bArr);
            byte[] ByteDataFormat = ByteDataFormat(bArr2);
            int length = ByteDataFormat.length;
            int i2 = length / 8;
            byte[] bArr3 = new byte[length];
            for (int i3 = 0; i3 < i2; i3++) {
                byte[] bArr4 = new byte[8];
                byte[] bArr5 = new byte[8];
                System.arraycopy(KeyDataFormat, 0, bArr4, 0, 8);
                int i4 = i3 * 8;
                System.arraycopy(ByteDataFormat, i4, bArr5, 0, 8);
                System.arraycopy(UnitDes(bArr4, bArr5, i), 0, bArr3, i4, 8);
            }
            if (i != 0) {
                return bArr3;
            }
            byte[] bArr6 = new byte[bArr2.length];
            System.arraycopy(bArr3, 0, bArr6, 0, bArr6.length);
            boolean z = true;
            int i5 = bArr6[bArr6.length - 1];
            if (i5 <= 0 || i5 > 8) {
                return bArr3;
            }
            int i6 = 0;
            while (true) {
                if (i6 >= i5) {
                    break;
                }
                if (i5 != bArr6[(bArr6.length - 1) - i6]) {
                    z = false;
                    break;
                }
                i6++;
            }
            if (!z) {
                return bArr3;
            }
            byte[] bArr7 = new byte[bArr6.length - i5];
            System.arraycopy(bArr6, 0, bArr7, 0, bArr7.length);
            return bArr7;
        } catch (Exception unused) {
            return bArr2;
        }
    }

    public static byte[] Des3Encrypt(byte[] bArr, byte[] bArr2, int i) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "DESede");
        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(i, secretKeySpec);
        return cipher.doFinal(bArr2);
    }
}
