package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public final class j extends p {
    @Override // com.google.zxing.oned.m, com.google.zxing.c
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat != BarcodeFormat.EAN_8) {
            throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(barcodeFormat)));
        }
        return super.encode(str, barcodeFormat, i, i2, map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.zxing.oned.m
    public boolean[] a(String str) {
        int length = str.length();
        switch (length) {
            case 7:
                try {
                    str = str + o.b(str);
                    break;
                } catch (FormatException e) {
                    throw new IllegalArgumentException(e);
                }
            case 8:
                try {
                    if (!o.a(str)) {
                        throw new IllegalArgumentException("Contents do not pass checksum");
                    }
                    break;
                } catch (FormatException unused) {
                    throw new IllegalArgumentException("Illegal contents");
                }
            default:
                throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
        }
        boolean[] zArr = new boolean[67];
        int a2 = a(zArr, 0, o.b, true) + 0;
        for (int i = 0; i <= 3; i++) {
            a2 += a(zArr, a2, o.e[Character.digit(str.charAt(i), 10)], false);
        }
        int a3 = a2 + a(zArr, a2, o.c, false);
        for (int i2 = 4; i2 <= 7; i2++) {
            a3 += a(zArr, a3, o.e[Character.digit(str.charAt(i2), 10)], true);
        }
        a(zArr, a3, o.b, true);
        return zArr;
    }
}
