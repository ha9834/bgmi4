package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.c;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.d;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a implements c {
    @Override // com.google.zxing.c
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        int i3;
        int i4;
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(barcodeFormat)));
        }
        d dVar = new d();
        if (map != null) {
            if (map.containsKey(EncodeHintType.PDF417_COMPACT)) {
                dVar.a(Boolean.valueOf(map.get(EncodeHintType.PDF417_COMPACT).toString()).booleanValue());
            }
            if (map.containsKey(EncodeHintType.PDF417_COMPACTION)) {
                dVar.a(Compaction.valueOf(map.get(EncodeHintType.PDF417_COMPACTION).toString()));
            }
            if (map.containsKey(EncodeHintType.PDF417_DIMENSIONS)) {
                com.google.zxing.pdf417.encoder.c cVar = (com.google.zxing.pdf417.encoder.c) map.get(EncodeHintType.PDF417_DIMENSIONS);
                dVar.a(cVar.b(), cVar.a(), cVar.d(), cVar.c());
            }
            int parseInt = map.containsKey(EncodeHintType.MARGIN) ? Integer.parseInt(map.get(EncodeHintType.MARGIN).toString()) : 30;
            int parseInt2 = map.containsKey(EncodeHintType.ERROR_CORRECTION) ? Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString()) : 2;
            if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                dVar.a(Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString()));
            }
            i4 = parseInt;
            i3 = parseInt2;
        } else {
            i3 = 2;
            i4 = 30;
        }
        return a(dVar, str, i3, i, i2, i4);
    }

    private static BitMatrix a(d dVar, String str, int i, int i2, int i3, int i4) throws WriterException {
        boolean z;
        dVar.a(str, i);
        byte[][] a2 = dVar.a().a(1, 4);
        if ((i3 > i2) != (a2[0].length < a2.length)) {
            a2 = a(a2);
            z = true;
        } else {
            z = false;
        }
        int length = i2 / a2[0].length;
        int length2 = i3 / a2.length;
        if (length >= length2) {
            length = length2;
        }
        if (length > 1) {
            byte[][] a3 = dVar.a().a(length, length << 2);
            if (z) {
                a3 = a(a3);
            }
            return a(a3, i4);
        }
        return a(a2, i4);
    }

    private static BitMatrix a(byte[][] bArr, int i) {
        int i2 = i * 2;
        BitMatrix bitMatrix = new BitMatrix(bArr[0].length + i2, bArr.length + i2);
        bitMatrix.clear();
        int height = (bitMatrix.getHeight() - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            byte[] bArr2 = bArr[i3];
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr2[i4] == 1) {
                    bitMatrix.set(i4 + i, height);
                }
            }
            i3++;
            height--;
        }
        return bitMatrix;
    }

    private static byte[][] a(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) byte.class, bArr[0].length, bArr.length);
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }
}
