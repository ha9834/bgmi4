package okhttp3;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class c implements Closeable, Flushable {

    /* renamed from: a, reason: collision with root package name */
    final okhttp3.internal.a.e f7053a;
    final okhttp3.internal.a.d b;

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.b.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }
}
