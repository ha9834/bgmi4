package com.google.zxing.qrcode.a;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.intlgame.core.INTLMethodID;
import com.tencent.smtt.sdk.TbsListener;

/* loaded from: classes2.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f5434a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, INTLMethodID.INTL_METHOD_ID_QUERY_ID_TOKEN, -1}, new int[]{6, 30, 56, 82, 108, INTLMethodID.INTL_METHOD_ID_AUTH_QUERY_DATA_PROTECTION_ACCEPTANCE, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, TbsListener.ErrorCode.NEEDDOWNLOAD_3, -1}, new int[]{6, 34, 62, 90, 118, TbsListener.ErrorCode.NEEDDOWNLOAD_7, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, INTLMethodID.INTL_METHOD_ID_AUTH_UNBIND, 158}, new int[]{6, 32, 58, 84, 110, 136, TbsListener.ErrorCode.STARTDOWNLOAD_3}, new int[]{6, 26, 54, 82, 110, 138, TbsListener.ErrorCode.STARTDOWNLOAD_7}, new int[]{6, 30, 58, 86, 114, TbsListener.ErrorCode.NEEDDOWNLOAD_3, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE}};
    private static final int[][] d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private static boolean b(int i) {
        return i == -1;
    }

    static void a(b bVar) {
        bVar.a((byte) -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.google.zxing.common.a aVar, ErrorCorrectionLevel errorCorrectionLevel, com.google.zxing.qrcode.decoder.a aVar2, int i, b bVar) throws WriterException {
        a(bVar);
        a(aVar2, bVar);
        a(errorCorrectionLevel, i, bVar);
        b(aVar2, bVar);
        a(aVar, i, bVar);
    }

    static void a(com.google.zxing.qrcode.decoder.a aVar, b bVar) throws WriterException {
        d(bVar);
        c(bVar);
        c(aVar, bVar);
        b(bVar);
    }

    static void a(ErrorCorrectionLevel errorCorrectionLevel, int i, b bVar) throws WriterException {
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        a(errorCorrectionLevel, i, aVar);
        for (int i2 = 0; i2 < aVar.a(); i2++) {
            boolean a2 = aVar.a((aVar.a() - 1) - i2);
            int[] iArr = d[i2];
            bVar.a(iArr[0], iArr[1], a2);
            if (i2 < 8) {
                bVar.a((bVar.b() - i2) - 1, 8, a2);
            } else {
                bVar.a(8, (bVar.a() - 7) + (i2 - 8), a2);
            }
        }
    }

    static void b(com.google.zxing.qrcode.decoder.a aVar, b bVar) throws WriterException {
        if (aVar.a() < 7) {
            return;
        }
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        a(aVar, aVar2);
        int i = 0;
        int i2 = 17;
        while (i < 6) {
            int i3 = i2;
            for (int i4 = 0; i4 < 3; i4++) {
                boolean a2 = aVar2.a(i3);
                i3--;
                bVar.a(i, (bVar.a() - 11) + i4, a2);
                bVar.a((bVar.a() - 11) + i4, i, a2);
            }
            i++;
            i2 = i3;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void a(com.google.zxing.common.a aVar, int i, b bVar) throws WriterException {
        boolean z;
        int b2 = bVar.b() - 1;
        int a2 = bVar.a() - 1;
        int i2 = 0;
        int i3 = -1;
        while (b2 > 0) {
            if (b2 == 6) {
                b2--;
            }
            while (a2 >= 0 && a2 < bVar.a()) {
                int i4 = i2;
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = b2 - i5;
                    if (b(bVar.a(i6, a2))) {
                        if (i4 < aVar.a()) {
                            z = aVar.a(i4);
                            i4++;
                        } else {
                            z = false;
                        }
                        if (i != -1 && d.a(i, i6, a2)) {
                            z = !z;
                        }
                        bVar.a(i6, a2, z);
                    }
                }
                a2 += i3;
                i2 = i4;
            }
            i3 = -i3;
            a2 += i3;
            b2 -= 2;
        }
        if (i2 == aVar.a()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i2 + '/' + aVar.a());
    }

    static int a(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int a(int i, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int a2 = a(i2);
        int i3 = i << (a2 - 1);
        while (a(i3) >= a2) {
            i3 ^= i2 << (a(i3) - a2);
        }
        return i3;
    }

    static void a(ErrorCorrectionLevel errorCorrectionLevel, int i, com.google.zxing.common.a aVar) throws WriterException {
        if (!f.b(i)) {
            throw new WriterException("Invalid mask pattern");
        }
        int a2 = (errorCorrectionLevel.a() << 3) | i;
        aVar.b(a2, 5);
        aVar.b(a(a2, 1335), 10);
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        aVar2.b(21522, 15);
        aVar.b(aVar2);
        if (aVar.a() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar.a());
    }

    static void a(com.google.zxing.qrcode.decoder.a aVar, com.google.zxing.common.a aVar2) throws WriterException {
        aVar2.b(aVar.a(), 6);
        aVar2.b(a(aVar.a(), 7973), 12);
        if (aVar2.a() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar2.a());
    }

    private static void b(b bVar) {
        int i = 8;
        while (i < bVar.b() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (b(bVar.a(i, 6))) {
                bVar.a(i, 6, i3);
            }
            if (b(bVar.a(6, i))) {
                bVar.a(6, i, i3);
            }
            i = i2;
        }
    }

    private static void c(b bVar) throws WriterException {
        if (bVar.a(8, bVar.a() - 8) == 0) {
            throw new WriterException();
        }
        bVar.a(8, bVar.a() - 8, 1);
    }

    private static void a(int i, int i2, b bVar) throws WriterException {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            if (!b(bVar.a(i4, i2))) {
                throw new WriterException();
            }
            bVar.a(i4, i2, 0);
        }
    }

    private static void b(int i, int i2, b bVar) throws WriterException {
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = i2 + i3;
            if (!b(bVar.a(i, i4))) {
                throw new WriterException();
            }
            bVar.a(i, i4, 0);
        }
    }

    private static void c(int i, int i2, b bVar) {
        for (int i3 = 0; i3 < 5; i3++) {
            int[] iArr = b[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                bVar.a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    private static void d(int i, int i2, b bVar) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = f5434a[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                bVar.a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    private static void d(b bVar) throws WriterException {
        int length = f5434a[0].length;
        d(0, 0, bVar);
        d(bVar.b() - length, 0, bVar);
        d(0, bVar.b() - length, bVar);
        a(0, 7, bVar);
        a(bVar.b() - 8, 7, bVar);
        a(0, bVar.b() - 8, bVar);
        b(7, 0, bVar);
        b((bVar.a() - 7) - 1, 0, bVar);
        b(7, bVar.a() - 7, bVar);
    }

    private static void c(com.google.zxing.qrcode.decoder.a aVar, b bVar) {
        if (aVar.a() < 2) {
            return;
        }
        int[] iArr = c[aVar.a() - 1];
        for (int i : iArr) {
            if (i >= 0) {
                for (int i2 : iArr) {
                    if (i2 >= 0 && b(bVar.a(i2, i))) {
                        c(i2 - 2, i - 2, bVar);
                    }
                }
            }
        }
    }
}
