package com.google.android.gms.internal.firebase_remote_config;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
final class eq extends BufferedOutputStream {
    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(zzr zzrVar, OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        try {
            flush();
        } catch (IOException unused) {
        }
    }
}
