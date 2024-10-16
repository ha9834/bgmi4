package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public class g extends m {
    @Override // com.google.zxing.oned.m, com.google.zxing.c
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat != BarcodeFormat.CODE_93) {
            throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(barcodeFormat)));
        }
        return super.encode(str, barcodeFormat, i, i2, map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.zxing.oned.m
    public boolean[] a(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        int[] iArr = new int[9];
        int length2 = ((str.length() + 2 + 2) * 9) + 1;
        a(f.f5417a[47], iArr);
        boolean[] zArr = new boolean[length2];
        int a2 = a(zArr, 0, iArr);
        for (int i = 0; i < length; i++) {
            a(f.f5417a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i))], iArr);
            a2 += a(zArr, a2, iArr);
        }
        int a3 = a(str, 20);
        a(f.f5417a[a3], iArr);
        int a4 = a2 + a(zArr, a2, iArr);
        a(f.f5417a[a(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(a3), 15)], iArr);
        int a5 = a4 + a(zArr, a4, iArr);
        a(f.f5417a[47], iArr);
        zArr[a5 + a(zArr, a5, iArr)] = true;
        return zArr;
    }

    private static void a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    private static int a(boolean[] zArr, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = i;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i2 + 1;
            zArr[i2] = iArr[i3] != 0;
            i3++;
            i2 = i4;
        }
        return 9;
    }

    private static int a(String str, int i) {
        int i2 = 0;
        int i3 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i3;
            i3++;
            if (i3 > i) {
                i3 = 1;
            }
        }
        return i2 % 47;
    }
}
