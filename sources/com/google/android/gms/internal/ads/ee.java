package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

/* loaded from: classes2.dex */
final class ee extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final HttpURLConnection f2143a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ee(java.net.HttpURLConnection r2) {
        /*
            r1 = this;
            java.io.InputStream r0 = com.google.android.gms.internal.ads.zzat.a(r2)
            r1.<init>(r0)
            r1.f2143a = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ee.<init>(java.net.HttpURLConnection):void");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        this.f2143a.disconnect();
    }
}
