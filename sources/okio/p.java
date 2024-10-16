package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* loaded from: classes.dex */
public interface p extends Closeable, Flushable {
    r a();

    void a_(c cVar, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;
}
