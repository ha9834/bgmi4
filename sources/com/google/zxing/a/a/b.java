package com.google.zxing.a.a;

/* loaded from: classes2.dex */
final class b extends g {
    private final short b;
    private final short c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(g gVar, int i, int i2) {
        super(gVar);
        this.b = (short) i;
        this.c = (short) i2;
    }

    @Override // com.google.zxing.a.a.g
    public void a(com.google.zxing.common.a aVar, byte[] bArr) {
        int i = 0;
        while (true) {
            short s = this.c;
            if (i >= s) {
                return;
            }
            if (i == 0 || (i == 31 && s <= 62)) {
                aVar.b(31, 5);
                short s2 = this.c;
                if (s2 > 62) {
                    aVar.b(s2 - 31, 16);
                } else if (i == 0) {
                    aVar.b(Math.min((int) s2, 31), 5);
                } else {
                    aVar.b(s2 - 31, 5);
                }
            }
            aVar.b(bArr[this.b + i], 8);
            i++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.b);
        sb.append("::");
        sb.append((this.b + this.c) - 1);
        sb.append('>');
        return sb.toString();
    }
}
