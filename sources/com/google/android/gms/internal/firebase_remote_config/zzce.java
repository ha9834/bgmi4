package com.google.android.gms.internal.firebase_remote_config;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class zzce extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final zzcb f4146a;

    public zzce(InputStream inputStream, Logger logger, Level level, int i) {
        super(inputStream);
        this.f4146a = new zzcb(logger, level, i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int read = super.read();
        this.f4146a.write(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read > 0) {
            this.f4146a.write(bArr, i, read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f4146a.close();
        super.close();
    }
}
