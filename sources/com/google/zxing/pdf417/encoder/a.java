package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b[] f5423a;
    private int b;
    private final int c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, int i2) {
        this.f5423a = new b[i];
        int length = this.f5423a.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f5423a[i3] = new b(((i2 + 4) * 17) + 1);
        }
        this.d = i2 * 17;
        this.c = i;
        this.b = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.b++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b() {
        return this.f5423a[this.b];
    }

    public byte[][] a(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, this.c * i2, this.d * i);
        int i3 = this.c * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.f5423a[i4 / i2].a(i);
        }
        return bArr;
    }
}
