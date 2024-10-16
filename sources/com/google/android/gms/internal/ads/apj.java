package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* loaded from: classes2.dex */
final class apj extends PushbackInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ apg f2032a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public apj(apg apgVar, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.f2032a = apgVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.f2032a.f2029a.a();
        super.close();
    }
}
