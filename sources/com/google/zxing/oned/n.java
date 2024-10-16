package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public final class n implements com.google.zxing.c {

    /* renamed from: a, reason: collision with root package name */
    private final i f5420a = new i();

    @Override // com.google.zxing.c
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat != BarcodeFormat.UPC_A) {
            throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(barcodeFormat)));
        }
        return this.f5420a.encode("0".concat(String.valueOf(str)), BarcodeFormat.EAN_13, i, i2, map);
    }
}
