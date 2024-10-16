package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
final class dh extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final long f2120a;
    private long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(InputStream inputStream, long j) {
        super(inputStream);
        this.f2120a = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.b++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.b += read;
        }
        return read;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long a() {
        return this.f2120a - this.b;
    }
}
