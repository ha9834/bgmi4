package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.c;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.datamatrix.encoder.e;
import com.google.zxing.datamatrix.encoder.i;
import com.google.zxing.datamatrix.encoder.j;
import com.google.zxing.datamatrix.encoder.k;
import com.google.zxing.qrcode.a.b;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a implements c {
    @Override // com.google.zxing.c
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        com.google.zxing.a aVar;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(barcodeFormat)));
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i + 'x' + i2);
        }
        SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
        com.google.zxing.a aVar2 = null;
        if (map != null) {
            SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
            if (symbolShapeHint2 != null) {
                symbolShapeHint = symbolShapeHint2;
            }
            aVar = (com.google.zxing.a) map.get(EncodeHintType.MIN_SIZE);
            if (aVar == null) {
                aVar = null;
            }
            com.google.zxing.a aVar3 = (com.google.zxing.a) map.get(EncodeHintType.MAX_SIZE);
            if (aVar3 != null) {
                aVar2 = aVar3;
            }
        } else {
            aVar = null;
        }
        String a2 = j.a(str, symbolShapeHint, aVar, aVar2);
        k a3 = k.a(a2.length(), symbolShapeHint, aVar, aVar2, true);
        e eVar = new e(i.a(a2, a3), a3.b(), a3.c());
        eVar.a();
        return a(eVar, a3, i, i2);
    }

    private static BitMatrix a(e eVar, k kVar, int i, int i2) {
        int b = kVar.b();
        int c = kVar.c();
        b bVar = new b(kVar.d(), kVar.e());
        int i3 = 0;
        for (int i4 = 0; i4 < c; i4++) {
            if (i4 % kVar.c == 0) {
                int i5 = 0;
                for (int i6 = 0; i6 < kVar.d(); i6++) {
                    bVar.a(i5, i3, i6 % 2 == 0);
                    i5++;
                }
                i3++;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < b; i8++) {
                if (i8 % kVar.b == 0) {
                    bVar.a(i7, i3, true);
                    i7++;
                }
                bVar.a(i7, i3, eVar.a(i8, i4));
                i7++;
                if (i8 % kVar.b == kVar.b - 1) {
                    bVar.a(i7, i3, i4 % 2 == 0);
                    i7++;
                }
            }
            i3++;
            if (i4 % kVar.c == kVar.c - 1) {
                int i9 = 0;
                for (int i10 = 0; i10 < kVar.d(); i10++) {
                    bVar.a(i9, i3, true);
                    i9++;
                }
                i3++;
            }
        }
        return a(bVar, i, i2);
    }

    private static BitMatrix a(b bVar, int i, int i2) {
        BitMatrix bitMatrix;
        int b = bVar.b();
        int a2 = bVar.a();
        int max = Math.max(i, b);
        int max2 = Math.max(i2, a2);
        int min = Math.min(max / b, max2 / a2);
        int i3 = (max - (b * min)) / 2;
        int i4 = (max2 - (a2 * min)) / 2;
        if (i2 < a2 || i < b) {
            bitMatrix = new BitMatrix(b, a2);
            i3 = 0;
            i4 = 0;
        } else {
            bitMatrix = new BitMatrix(i, i2);
        }
        bitMatrix.clear();
        int i5 = 0;
        while (i5 < a2) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < b) {
                if (bVar.a(i7, i5) == 1) {
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
