package okio;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes.dex */
public interface q extends Closeable {
    long a(c cVar, long j) throws IOException;

    r a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
