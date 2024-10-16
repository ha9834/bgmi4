package com.google.android.gms.internal.firebase_messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
final class d extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private long f4011a;
    private long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(InputStream inputStream, long j) {
        super(inputStream);
        this.b = -1L;
        zzg.checkNotNull(inputStream);
        this.f4011a = 1048576L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        return (int) Math.min(this.in.available(), this.f4011a);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        this.in.mark(i);
        this.b = this.f4011a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.f4011a == 0) {
            return -1;
        }
        int read = this.in.read();
        if (read != -1) {
            this.f4011a--;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f4011a;
        if (j == 0) {
            return -1;
        }
        int read = this.in.read(bArr, i, (int) Math.min(i2, j));
        if (read != -1) {
            this.f4011a -= read;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.b == -1) {
            throw new IOException("Mark not set");
        }
        this.in.reset();
        this.f4011a = this.b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long skip = this.in.skip(Math.min(j, this.f4011a));
        this.f4011a -= skip;
        return skip;
    }
}
