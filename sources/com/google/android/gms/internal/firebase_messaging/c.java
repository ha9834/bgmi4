package com.google.android.gms.internal.firebase_messaging;

import java.io.OutputStream;

/* loaded from: classes2.dex */
final class c extends OutputStream {
    public final String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        zzg.checkNotNull(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        zzg.checkNotNull(bArr);
    }
}
