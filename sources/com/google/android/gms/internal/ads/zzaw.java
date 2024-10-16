package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzaw extends ByteArrayOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final zzal f2813a;

    public zzaw(zzal zzalVar, int i) {
        this.f2813a = zzalVar;
        this.buf = this.f2813a.zzc(Math.max(i, 256));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f2813a.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.f2813a.zza(this.buf);
    }

    private final void a(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        byte[] zzc = this.f2813a.zzc((this.count + i) << 1);
        System.arraycopy(this.buf, 0, zzc, 0, this.count);
        this.f2813a.zza(this.buf);
        this.buf = zzc;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        a(1);
        super.write(i);
    }
}
