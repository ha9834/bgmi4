package com.google.zxing.a;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.c;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a implements c {
    @Override // com.google.zxing.c
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Charset charset;
        int i3;
        int i4;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        if (map != null) {
            if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                charset2 = Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString());
            }
            int parseInt = map.containsKey(EncodeHintType.ERROR_CORRECTION) ? Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString()) : 33;
            if (map.containsKey(EncodeHintType.AZTEC_LAYERS)) {
                charset = charset2;
                i3 = parseInt;
                i4 = Integer.parseInt(map.get(EncodeHintType.AZTEC_LAYERS).toString());
            } else {
                charset = charset2;
                i3 = parseInt;
                i4 = 0;
            }
        } else {
            charset = charset2;
            i3 = 33;
            i4 = 0;
        }
        return a(str, barcodeFormat, i, i2, charset, i3, i4);
    }

    private static BitMatrix a(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4) {
        if (barcodeFormat != BarcodeFormat.AZTEC) {
            throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(barcodeFormat)));
        }
        return a(com.google.zxing.a.a.c.a(str.getBytes(charset), i3, i4), i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static BitMatrix a(com.google.zxing.a.a.a aVar, int i, int i2) {
        BitMatrix a2 = aVar.a();
        if (a2 == null) {
            throw new IllegalStateException();
        }
        int width = a2.getWidth();
        int height = a2.getHeight();
        int max = Math.max(i, width);
        int max2 = Math.max(i2, height);
        int min = Math.min(max / width, max2 / height);
        int i3 = (max - (width * min)) / 2;
        int i4 = (max2 - (height * min)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        int i5 = 0;
        while (i5 < height) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < width) {
                if (a2.get(i7, i5)) {
                    bitMatrix.setRegion(i6, i4, min, min);
                }
                i7++;
                i6 += min;
            }
            i5++;
            i4 += min;
        }
        return bitMatrix;
    }
}
