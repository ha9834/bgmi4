package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.c;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.a.b;
import com.google.zxing.qrcode.a.f;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;

/* loaded from: classes2.dex */
public final class QRCodeWriter implements c {
    private static final int QUIET_ZONE_SIZE = 4;

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.google.zxing.c
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(barcodeFormat)));
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        }
        ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
        int i3 = 4;
        if (map != null) {
            if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(EncodeHintType.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(EncodeHintType.MARGIN)) {
                i3 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
            }
        }
        return renderResult(com.google.zxing.qrcode.a.c.a(str, errorCorrectionLevel, map), i, i2, i3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static BitMatrix renderResult(f fVar, int i, int i2, int i3) {
        b a2 = fVar.a();
        if (a2 == null) {
            throw new IllegalStateException();
        }
        int b = a2.b();
        int a3 = a2.a();
        int i4 = i3 << 1;
        int i5 = b + i4;
        int i6 = i4 + a3;
        int max = Math.max(i, i5);
        int max2 = Math.max(i2, i6);
        int min = Math.min(max / i5, max2 / i6);
        int i7 = (max - (b * min)) / 2;
        int i8 = (max2 - (a3 * min)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        int i9 = 0;
        while (i9 < a3) {
            int i10 = i7;
            int i11 = 0;
            while (i11 < b) {
                if (a2.a(i11, i9) == 1) {
                    bitMatrix.setRegion(i10, i8, min, min);
                }
                i11++;
                i10 += min;
            }
            i9++;
            i8 += min;
        }
        return bitMatrix;
    }
}
