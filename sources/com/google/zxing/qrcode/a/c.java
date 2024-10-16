package com.google.zxing.qrcode.a;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.a;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f5432a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    private static int a(b bVar) {
        return d.a(bVar) + d.b(bVar) + d.c(bVar) + d.d(bVar);
    }

    public static f a(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        com.google.zxing.qrcode.decoder.a a2;
        CharacterSetECI a3;
        boolean z = map != null && map.containsKey(EncodeHintType.CHARACTER_SET);
        String obj = z ? map.get(EncodeHintType.CHARACTER_SET).toString() : "ISO-8859-1";
        Mode a4 = a(str, obj);
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        if (a4 == Mode.BYTE && z && (a3 = CharacterSetECI.a(obj)) != null) {
            a(a3, aVar);
        }
        if ((map != null && map.containsKey(EncodeHintType.GS1_FORMAT)) && Boolean.valueOf(map.get(EncodeHintType.GS1_FORMAT).toString()).booleanValue()) {
            a(Mode.FNC1_FIRST_POSITION, aVar);
        }
        a(a4, aVar);
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        a(str, a4, aVar2, obj);
        if (map != null && map.containsKey(EncodeHintType.QR_VERSION)) {
            a2 = com.google.zxing.qrcode.decoder.a.a(Integer.parseInt(map.get(EncodeHintType.QR_VERSION).toString()));
            if (!a(a(a4, aVar, aVar2, a2), a2, errorCorrectionLevel)) {
                throw new WriterException("Data too big for requested version");
            }
        } else {
            a2 = a(errorCorrectionLevel, a4, aVar, aVar2);
        }
        com.google.zxing.common.a aVar3 = new com.google.zxing.common.a();
        aVar3.a(aVar);
        a(a4 == Mode.BYTE ? aVar2.b() : str.length(), a2, a4, aVar3);
        aVar3.a(aVar2);
        a.b a5 = a2.a(errorCorrectionLevel);
        int b = a2.b() - a5.c();
        a(b, aVar3);
        com.google.zxing.common.a a6 = a(aVar3, a2.b(), b, a5.b());
        f fVar = new f();
        fVar.a(errorCorrectionLevel);
        fVar.a(a4);
        fVar.a(a2);
        int c = a2.c();
        b bVar = new b(c, c);
        int a7 = a(a6, errorCorrectionLevel, a2, bVar);
        fVar.a(a7);
        e.a(a6, errorCorrectionLevel, a2, a7, bVar);
        fVar.a(bVar);
        return fVar;
    }

    private static com.google.zxing.qrcode.decoder.a a(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, com.google.zxing.common.a aVar, com.google.zxing.common.a aVar2) throws WriterException {
        return a(a(mode, aVar, aVar2, a(a(mode, aVar, aVar2, com.google.zxing.qrcode.decoder.a.a(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    private static int a(Mode mode, com.google.zxing.common.a aVar, com.google.zxing.common.a aVar2, com.google.zxing.qrcode.decoder.a aVar3) {
        return aVar.a() + mode.a(aVar3) + aVar2.a();
    }

    static int a(int i) {
        int[] iArr = f5432a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    private static Mode a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && a(str)) {
            return Mode.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else {
                if (a(charAt) == -1) {
                    return Mode.BYTE;
                }
                z = true;
            }
        }
        if (z) {
            return Mode.ALPHANUMERIC;
        }
        if (z2) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    private static boolean a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int a(com.google.zxing.common.a aVar, ErrorCorrectionLevel errorCorrectionLevel, com.google.zxing.qrcode.decoder.a aVar2, b bVar) throws WriterException {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            e.a(aVar, errorCorrectionLevel, aVar2, i3, bVar);
            int a2 = a(bVar);
            if (a2 < i) {
                i2 = i3;
                i = a2;
            }
        }
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static com.google.zxing.qrcode.decoder.a a(int i, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            com.google.zxing.qrcode.decoder.a a2 = com.google.zxing.qrcode.decoder.a.a(i2);
            if (a(i, a2, errorCorrectionLevel)) {
                return a2;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean a(int i, com.google.zxing.qrcode.decoder.a aVar, ErrorCorrectionLevel errorCorrectionLevel) {
        return aVar.b() - aVar.a(errorCorrectionLevel).c() >= (i + 7) / 8;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void a(int i, com.google.zxing.common.a aVar) throws WriterException {
        int i2 = i << 3;
        if (aVar.a() > i2) {
            throw new WriterException("data bits cannot fit in the QR Code" + aVar.a() + " > " + i2);
        }
        for (int i3 = 0; i3 < 4 && aVar.a() < i2; i3++) {
            aVar.a(false);
        }
        int a2 = aVar.a() & 7;
        if (a2 > 0) {
            while (a2 < 8) {
                aVar.a(false);
                a2++;
            }
        }
        int b = i - aVar.b();
        for (int i4 = 0; i4 < b; i4++) {
            aVar.b((i4 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.a() != i2) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    static void a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 >= i3) {
            throw new WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
        } else {
            iArr[0] = i10;
            iArr2[0] = i12;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static com.google.zxing.common.a a(com.google.zxing.common.a aVar, int i, int i2, int i3) throws WriterException {
        if (aVar.b() != i2) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            a(i, i2, i3, i7, iArr, iArr2);
            int i8 = iArr[0];
            byte[] bArr = new byte[i8];
            aVar.a(i4 << 3, bArr, 0, i8);
            byte[] a2 = a(bArr, iArr2[0]);
            arrayList.add(new a(bArr, a2));
            i5 = Math.max(i5, i8);
            i6 = Math.max(i6, a2.length);
            i4 += iArr[0];
        }
        if (i2 != i4) {
            throw new WriterException("Data bytes does not match offset");
        }
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        for (int i9 = 0; i9 < i5; i9++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] a3 = ((a) it.next()).a();
                if (i9 < a3.length) {
                    aVar2.b(a3[i9], 8);
                }
            }
        }
        for (int i10 = 0; i10 < i6; i10++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] b = ((a) it2.next()).b();
                if (i10 < b.length) {
                    aVar2.b(b[i10], 8);
                }
            }
        }
        if (i == aVar2.b()) {
            return aVar2;
        }
        throw new WriterException("Interleaving error: " + i + " and " + aVar2.b() + " differ.");
    }

    static byte[] a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
        }
        new com.google.zxing.common.a.c(com.google.zxing.common.a.a.e).a(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static void a(Mode mode, com.google.zxing.common.a aVar) {
        aVar.b(mode.a(), 4);
    }

    static void a(int i, com.google.zxing.qrcode.decoder.a aVar, Mode mode, com.google.zxing.common.a aVar2) throws WriterException {
        int a2 = mode.a(aVar);
        int i2 = 1 << a2;
        if (i >= i2) {
            throw new WriterException(i + " is bigger than " + (i2 - 1));
        }
        aVar2.b(i, a2);
    }

    static void a(String str, Mode mode, com.google.zxing.common.a aVar, String str2) throws WriterException {
        switch (mode) {
            case NUMERIC:
                a((CharSequence) str, aVar);
                return;
            case ALPHANUMERIC:
                b(str, aVar);
                return;
            case BYTE:
                a(str, aVar, str2);
                return;
            case KANJI:
                a(str, aVar);
                return;
            default:
                throw new WriterException("Invalid mode: ".concat(String.valueOf(mode)));
        }
    }

    static void a(CharSequence charSequence, com.google.zxing.common.a aVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                aVar.b((charAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    aVar.b((charAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    aVar.b(charAt, 4);
                }
            }
        }
    }

    static void b(CharSequence charSequence, com.google.zxing.common.a aVar) throws WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a2 = a(charSequence.charAt(i));
            if (a2 == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int a3 = a(charSequence.charAt(i2));
                if (a3 == -1) {
                    throw new WriterException();
                }
                aVar.b((a2 * 45) + a3, 11);
                i += 2;
            } else {
                aVar.b(a2, 6);
                i = i2;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void a(String str, com.google.zxing.common.a aVar, String str2) throws WriterException {
        try {
            for (byte b : str.getBytes(str2)) {
                aVar.b(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void a(String str, com.google.zxing.common.a aVar) throws WriterException {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i = 0; i < length; i += 2) {
                int i2 = ((bytes[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (bytes[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
                int i3 = (i2 < 33088 || i2 > 40956) ? (i2 < 57408 || i2 > 60351) ? -1 : i2 - 49472 : i2 - 33088;
                if (i3 == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                aVar.b(((i3 >> 8) * 192) + (i3 & 255), 13);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    private static void a(CharacterSetECI characterSetECI, com.google.zxing.common.a aVar) {
        aVar.b(Mode.ECI.a(), 4);
        aVar.b(characterSetECI.a(), 8);
    }
}
