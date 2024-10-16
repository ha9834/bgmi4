package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

@zzard
/* loaded from: classes2.dex */
final class kf implements zzdsw {

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f2287a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kf(ByteBuffer byteBuffer) {
        this.f2287a = byteBuffer.duplicate();
    }

    @Override // com.google.android.gms.internal.ads.zzdsw, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzdsw
    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f2287a.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.f2287a.remaining());
        byte[] bArr = new byte[min];
        this.f2287a.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzdsw
    public final long size() throws IOException {
        return this.f2287a.limit();
    }

    @Override // com.google.android.gms.internal.ads.zzdsw
    public final long position() throws IOException {
        return this.f2287a.position();
    }

    @Override // com.google.android.gms.internal.ads.zzdsw
    public final void zzff(long j) throws IOException {
        this.f2287a.position((int) j);
    }

    @Override // com.google.android.gms.internal.ads.zzdsw
    public final ByteBuffer zzi(long j, long j2) throws IOException {
        int position = this.f2287a.position();
        this.f2287a.position((int) j);
        ByteBuffer slice = this.f2287a.slice();
        slice.limit((int) j2);
        this.f2287a.position(position);
        return slice;
    }
}
