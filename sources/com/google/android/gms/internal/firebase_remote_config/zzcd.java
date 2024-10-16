package com.google.android.gms.internal.firebase_remote_config;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class zzcd extends FilterOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final zzcb f4145a;

    public zzcd(OutputStream outputStream, Logger logger, Level level, int i) {
        super(outputStream);
        this.f4145a = new zzcb(logger, level, i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) throws IOException {
        this.out.write(i);
        this.f4145a.write(i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        this.f4145a.write(bArr, i, i2);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f4145a.close();
        super.close();
    }

    public final zzcb zzcc() {
        return this.f4145a;
    }
}
