package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public interface c {
    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException;
}
