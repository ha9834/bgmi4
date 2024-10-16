package com.google.android.gms.internal.firebase_remote_config;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
final class c extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private long f4053a;
    private final /* synthetic */ a b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, InputStream inputStream) {
        super(inputStream);
        this.b = aVar;
        this.f4053a = 0L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read == -1) {
            a();
        } else {
            this.f4053a += read;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int read = this.in.read();
        if (read == -1) {
            a();
        } else {
            this.f4053a++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long skip = this.in.skip(j);
        this.f4053a += skip;
        return skip;
    }

    private final void a() throws IOException {
        long a2 = this.b.a();
        if (a2 == -1) {
            return;
        }
        long j = this.f4053a;
        if (j == 0 || j >= a2) {
            return;
        }
        StringBuilder sb = new StringBuilder(102);
        sb.append("Connection closed prematurely: bytesRead = ");
        sb.append(j);
        sb.append(", Content-Length = ");
        sb.append(a2);
        throw new IOException(sb.toString());
    }
}
