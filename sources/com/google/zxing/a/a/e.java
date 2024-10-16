package com.google.zxing.a.a;

/* loaded from: classes2.dex */
final class e extends g {
    private final short b;
    private final short c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar, int i, int i2) {
        super(gVar);
        this.b = (short) i;
        this.c = (short) i2;
    }

    @Override // com.google.zxing.a.a.g
    void a(com.google.zxing.common.a aVar, byte[] bArr) {
        aVar.b(this.b, this.c);
    }

    public String toString() {
        short s = this.b;
        short s2 = this.c;
        return "<" + Integer.toBinaryString((s & ((1 << s2) - 1)) | (1 << s2) | (1 << this.c)).substring(1) + '>';
    }
}
