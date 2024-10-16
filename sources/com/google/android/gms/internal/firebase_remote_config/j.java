package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
final class j extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    long f4100a;

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.f4100a += i2;
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        this.f4100a++;
    }
}
