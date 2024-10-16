package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.e;
import com.google.zxing.oned.g;
import com.google.zxing.oned.i;
import com.google.zxing.oned.j;
import com.google.zxing.oned.k;
import com.google.zxing.oned.n;
import com.google.zxing.oned.r;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b implements c {
    @Override // com.google.zxing.c
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        c jVar;
        switch (barcodeFormat) {
            case EAN_8:
                jVar = new j();
                break;
            case UPC_E:
                jVar = new r();
                break;
            case EAN_13:
                jVar = new i();
                break;
            case UPC_A:
                jVar = new n();
                break;
            case QR_CODE:
                jVar = new QRCodeWriter();
                break;
            case CODE_39:
                jVar = new e();
                break;
            case CODE_93:
                jVar = new g();
                break;
            case CODE_128:
                jVar = new Code128Writer();
                break;
            case ITF:
                jVar = new k();
                break;
            case PDF_417:
                jVar = new com.google.zxing.pdf417.a();
                break;
            case CODABAR:
                jVar = new com.google.zxing.oned.b();
                break;
            case DATA_MATRIX:
                jVar = new com.google.zxing.datamatrix.a();
                break;
            case AZTEC:
                jVar = new com.google.zxing.a.a();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(barcodeFormat)));
        }
        return jVar.encode(str, barcodeFormat, i, i2, map);
    }
}
