package com.subao.common.d;

import java.io.InputStream;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f5949a;
    private int b;

    public a(int i) {
        this.f5949a = new byte[i];
    }

    public int a(InputStream inputStream, int i) {
        byte[] bArr = this.f5949a;
        int length = i - (bArr.length - this.b);
        if (length > 0) {
            int max = Math.max(bArr.length / 2, length);
            byte[] bArr2 = this.f5949a;
            byte[] bArr3 = new byte[bArr2.length + max];
            System.arraycopy(bArr2, 0, bArr3, 0, this.b);
            this.f5949a = bArr3;
        }
        int read = inputStream.read(this.f5949a, this.b, i);
        if (read > 0) {
            this.b += read;
        }
        return read;
    }

    public byte[] a() {
        int i = this.b;
        byte[] bArr = new byte[i];
        if (i > 0) {
            System.arraycopy(this.f5949a, 0, bArr, 0, i);
        }
        return bArr;
    }
}
