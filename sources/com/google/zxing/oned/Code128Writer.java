package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Code128Writer extends m {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    @Override // com.google.zxing.oned.m, com.google.zxing.c
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat != BarcodeFormat.CODE_128) {
            throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(barcodeFormat)));
        }
        return super.encode(str, barcodeFormat, i, i2, map);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.zxing.oned.m
    public boolean[] a(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            switch (charAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (charAt > 127) {
                        throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                    }
                    break;
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (true) {
            int i7 = 103;
            if (i3 < length) {
                int a2 = a(str, i3, i5);
                if (a2 == i5) {
                    int i8 = 101;
                    switch (str.charAt(i3)) {
                        case 241:
                            i8 = 102;
                            break;
                        case 242:
                            i8 = 97;
                            break;
                        case 243:
                            i8 = 96;
                            break;
                        case 244:
                            if (i5 != 101) {
                                i8 = 100;
                                break;
                            }
                            break;
                        default:
                            switch (i5) {
                                case 100:
                                    i8 = str.charAt(i3) - ' ';
                                    break;
                                case 101:
                                    i8 = str.charAt(i3) - ' ';
                                    if (i8 < 0) {
                                        i8 += 96;
                                        break;
                                    }
                                    break;
                                default:
                                    i8 = Integer.parseInt(str.substring(i3, i3 + 2));
                                    i3++;
                                    break;
                            }
                    }
                    i3++;
                    i7 = i8;
                } else {
                    if (i5 == 0) {
                        switch (a2) {
                            case 100:
                                i7 = 104;
                                break;
                            case 101:
                                break;
                            default:
                                i7 = 105;
                                break;
                        }
                    } else {
                        i7 = a2;
                    }
                    i5 = a2;
                }
                arrayList.add(c.f5415a[i7]);
                i4 += i7 * i6;
                if (i3 != 0) {
                    i6++;
                }
            } else {
                arrayList.add(c.f5415a[i4 % 103]);
                arrayList.add(c.f5415a[106]);
                int i9 = 0;
                for (int[] iArr : arrayList) {
                    int i10 = i9;
                    for (int i11 : iArr) {
                        i10 += i11;
                    }
                    i9 = i10;
                }
                boolean[] zArr = new boolean[i9];
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    i += a(zArr, i, (int[]) it.next(), true);
                }
                return zArr;
            }
        }
    }

    private static CType a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i2);
        if (charAt2 < '0' || charAt2 > '9') {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }

    private static int a(CharSequence charSequence, int i, int i2) {
        CType a2;
        CType a3;
        char charAt;
        CType a4 = a(charSequence, i);
        if (a4 == CType.ONE_DIGIT) {
            return 100;
        }
        if (a4 == CType.UNCODABLE) {
            return (i >= charSequence.length() || ((charAt = charSequence.charAt(i)) >= ' ' && (i2 != 101 || charAt >= '`'))) ? 100 : 101;
        }
        if (i2 == 99) {
            return 99;
        }
        if (i2 == 100) {
            if (a4 == CType.FNC_1 || (a2 = a(charSequence, i + 2)) == CType.UNCODABLE || a2 == CType.ONE_DIGIT) {
                return 100;
            }
            if (a2 == CType.FNC_1) {
                return a(charSequence, i + 3) == CType.TWO_DIGITS ? 99 : 100;
            }
            int i3 = i + 4;
            while (true) {
                a3 = a(charSequence, i3);
                if (a3 != CType.TWO_DIGITS) {
                    break;
                }
                i3 += 2;
            }
            return a3 == CType.ONE_DIGIT ? 100 : 99;
        }
        if (a4 == CType.FNC_1) {
            a4 = a(charSequence, i + 1);
        }
        return a4 == CType.TWO_DIGITS ? 99 : 100;
    }
}
