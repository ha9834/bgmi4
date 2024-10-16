package com.google.zxing.a.a;

import com.google.zxing.common.BitMatrix;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f5396a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static a a(byte[] bArr, int i, int i2) {
        int i3;
        com.google.zxing.common.a a2;
        com.google.zxing.common.a aVar;
        boolean z;
        int i4;
        int i5;
        int i6;
        com.google.zxing.common.a a3 = new d(bArr).a();
        int a4 = ((a3.a() * i) / 100) + 11;
        int a5 = a3.a() + a4;
        int i7 = 0;
        int i8 = 1;
        if (i2 != 0) {
            z = i2 < 0;
            i4 = Math.abs(i2);
            if (i4 > (z ? 4 : 32)) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
            }
            i5 = a(i4, z);
            i3 = f5396a[i4];
            int i9 = i5 - (i5 % i3);
            aVar = a(a3, i3);
            if (aVar.a() + a4 > i9) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            if (z && aVar.a() > (i3 << 6)) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
        } else {
            com.google.zxing.common.a aVar2 = null;
            int i10 = 0;
            int i11 = 0;
            while (i10 <= 32) {
                boolean z2 = i10 <= 3;
                int i12 = z2 ? i10 + 1 : i10;
                int a6 = a(i12, z2);
                if (a5 <= a6) {
                    if (aVar2 == null || i11 != f5396a[i12]) {
                        i3 = f5396a[i12];
                        a2 = a(a3, i3);
                    } else {
                        int i13 = i11;
                        a2 = aVar2;
                        i3 = i13;
                    }
                    int i14 = a6 - (a6 % i3);
                    if ((!z2 || a2.a() <= (i3 << 6)) && a2.a() + a4 <= i14) {
                        aVar = a2;
                        z = z2;
                        i4 = i12;
                        i5 = a6;
                    } else {
                        com.google.zxing.common.a aVar3 = a2;
                        i11 = i3;
                        aVar2 = aVar3;
                    }
                }
                i10++;
                i7 = 0;
                i8 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        com.google.zxing.common.a a7 = a(aVar, i5, i3);
        int a8 = aVar.a() / i3;
        com.google.zxing.common.a a9 = a(z, i4, a8);
        int i15 = (z ? 11 : 14) + (i4 << 2);
        int[] iArr = new int[i15];
        int i16 = 2;
        if (z) {
            for (int i17 = 0; i17 < iArr.length; i17++) {
                iArr[i17] = i17;
            }
            i6 = i15;
        } else {
            int i18 = i15 / 2;
            i6 = i15 + 1 + (((i18 - 1) / 15) * 2);
            int i19 = i6 / 2;
            for (int i20 = 0; i20 < i18; i20++) {
                iArr[(i18 - i20) - i8] = (i19 - r14) - 1;
                iArr[i18 + i20] = (i20 / 15) + i20 + i19 + i8;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i6);
        int i21 = 0;
        int i22 = 0;
        while (i21 < i4) {
            int i23 = ((i4 - i21) << i16) + (z ? 9 : 12);
            int i24 = 0;
            while (i24 < i23) {
                int i25 = i24 << 1;
                while (i7 < i16) {
                    if (a7.a(i22 + i25 + i7)) {
                        int i26 = i21 << 1;
                        bitMatrix.set(iArr[i26 + i7], iArr[i26 + i24]);
                    }
                    if (a7.a((i23 << 1) + i22 + i25 + i7)) {
                        int i27 = i21 << 1;
                        bitMatrix.set(iArr[i27 + i24], iArr[((i15 - 1) - i27) - i7]);
                    }
                    if (a7.a((i23 << 2) + i22 + i25 + i7)) {
                        int i28 = (i15 - 1) - (i21 << 1);
                        bitMatrix.set(iArr[i28 - i7], iArr[i28 - i24]);
                    }
                    if (a7.a((i23 * 6) + i22 + i25 + i7)) {
                        int i29 = i21 << 1;
                        bitMatrix.set(iArr[((i15 - 1) - i29) - i24], iArr[i29 + i7]);
                    }
                    i7++;
                    i16 = 2;
                }
                i24++;
                i7 = 0;
                i16 = 2;
            }
            i22 += i23 << 3;
            i21++;
            i7 = 0;
            i16 = 2;
        }
        a(bitMatrix, z, i6, a9);
        if (z) {
            a(bitMatrix, i6 / 2, 5);
        } else {
            int i30 = i6 / 2;
            a(bitMatrix, i30, 7);
            int i31 = 0;
            int i32 = 0;
            while (i31 < (i15 / 2) - 1) {
                for (int i33 = i30 & 1; i33 < i6; i33 += 2) {
                    int i34 = i30 - i32;
                    bitMatrix.set(i34, i33);
                    int i35 = i30 + i32;
                    bitMatrix.set(i35, i33);
                    bitMatrix.set(i33, i34);
                    bitMatrix.set(i33, i35);
                }
                i31 += 15;
                i32 += 16;
            }
        }
        a aVar4 = new a();
        aVar4.a(z);
        aVar4.a(i6);
        aVar4.b(i4);
        aVar4.c(a8);
        aVar4.a(bitMatrix);
        return aVar4;
    }

    private static void a(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 <= i6) {
                    bitMatrix.set(i5, i4);
                    bitMatrix.set(i5, i6);
                    bitMatrix.set(i4, i5);
                    bitMatrix.set(i6, i5);
                    i5++;
                }
            }
        }
        int i7 = i - i2;
        bitMatrix.set(i7, i7);
        int i8 = i7 + 1;
        bitMatrix.set(i8, i7);
        bitMatrix.set(i7, i8);
        int i9 = i + i2;
        bitMatrix.set(i9, i7);
        bitMatrix.set(i9, i8);
        bitMatrix.set(i9, i9 - 1);
    }

    static com.google.zxing.common.a a(boolean z, int i, int i2) {
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        if (z) {
            aVar.b(i - 1, 2);
            aVar.b(i2 - 1, 6);
            return a(aVar, 28, 4);
        }
        aVar.b(i - 1, 5);
        aVar.b(i2 - 1, 11);
        return a(aVar, 40, 4);
    }

    private static void a(BitMatrix bitMatrix, boolean z, int i, com.google.zxing.common.a aVar) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (aVar.a(i3)) {
                    bitMatrix.set(i4, i2 - 5);
                }
                if (aVar.a(i3 + 7)) {
                    bitMatrix.set(i2 + 5, i4);
                }
                if (aVar.a(20 - i3)) {
                    bitMatrix.set(i4, i2 + 5);
                }
                if (aVar.a(27 - i3)) {
                    bitMatrix.set(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (aVar.a(i3)) {
                bitMatrix.set(i5, i2 - 7);
            }
            if (aVar.a(i3 + 10)) {
                bitMatrix.set(i2 + 7, i5);
            }
            if (aVar.a(29 - i3)) {
                bitMatrix.set(i5, i2 + 7);
            }
            if (aVar.a(39 - i3)) {
                bitMatrix.set(i2 - 7, i5);
            }
            i3++;
        }
    }

    private static com.google.zxing.common.a a(com.google.zxing.common.a aVar, int i, int i2) {
        int a2 = aVar.a() / i2;
        com.google.zxing.common.a.c cVar = new com.google.zxing.common.a.c(a(i2));
        int i3 = i / i2;
        int[] b = b(aVar, i2, i3);
        cVar.a(b, i3 - a2);
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        aVar2.b(0, i % i2);
        for (int i4 : b) {
            aVar2.b(i4, i2);
        }
        return aVar2;
    }

    private static int[] b(com.google.zxing.common.a aVar, int i, int i2) {
        int[] iArr = new int[i2];
        int a2 = aVar.a() / i;
        for (int i3 = 0; i3 < a2; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= aVar.a((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static com.google.zxing.common.a.a a(int i) {
        if (i == 4) {
            return com.google.zxing.common.a.a.d;
        }
        if (i == 6) {
            return com.google.zxing.common.a.a.c;
        }
        if (i == 8) {
            return com.google.zxing.common.a.a.g;
        }
        if (i == 10) {
            return com.google.zxing.common.a.a.b;
        }
        if (i == 12) {
            return com.google.zxing.common.a.a.f5404a;
        }
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i)));
    }

    static com.google.zxing.common.a a(com.google.zxing.common.a aVar, int i) {
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        int a2 = aVar.a();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < a2) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= a2 || aVar.a(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                aVar2.b(i7, i);
                i3--;
            } else if (i7 == 0) {
                aVar2.b(i4 | 1, i);
                i3--;
            } else {
                aVar2.b(i4, i);
            }
            i3 += i;
        }
        return aVar2;
    }
}
