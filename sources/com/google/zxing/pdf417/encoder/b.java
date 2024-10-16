package com.google.zxing.pdf417.encoder;

/* loaded from: classes2.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f5424a;
    private int b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        this.f5424a = new byte[i];
    }

    private void a(int i, boolean z) {
        this.f5424a[i] = z ? (byte) 1 : (byte) 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.b;
            this.b = i3 + 1;
            a(i3, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a(int i) {
        byte[] bArr = new byte[this.f5424a.length * i];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = this.f5424a[i2 / i];
        }
        return bArr;
    }
}
