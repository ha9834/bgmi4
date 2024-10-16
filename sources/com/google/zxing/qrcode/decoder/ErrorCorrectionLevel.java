package com.google.zxing.qrcode.decoder;

/* loaded from: classes2.dex */
public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);

    private static final ErrorCorrectionLevel[] e;
    private final int bits;

    static {
        ErrorCorrectionLevel errorCorrectionLevel = L;
        ErrorCorrectionLevel errorCorrectionLevel2 = M;
        ErrorCorrectionLevel errorCorrectionLevel3 = Q;
        e = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, H, errorCorrectionLevel3};
    }

    ErrorCorrectionLevel(int i) {
        this.bits = i;
    }

    public int a() {
        return this.bits;
    }
}
