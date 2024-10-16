package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public interface zzdsw extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long position() throws IOException;

    int read(ByteBuffer byteBuffer) throws IOException;

    long size() throws IOException;

    void zzff(long j) throws IOException;

    ByteBuffer zzi(long j, long j2) throws IOException;
}
