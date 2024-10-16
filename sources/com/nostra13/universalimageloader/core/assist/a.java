package com.nostra13.universalimageloader.core.assist;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class a extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f5735a;
    private final int b;

    public a(InputStream inputStream, int i) {
        this.f5735a = inputStream;
        this.b = i;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5735a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f5735a.mark(i);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f5735a.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.f5735a.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f5735a.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.f5735a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.f5735a.skip(j);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f5735a.markSupported();
    }
}
