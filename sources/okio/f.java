package okio;

import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class f implements p {

    /* renamed from: a, reason: collision with root package name */
    private final p f7178a;

    public f(p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f7178a = pVar;
    }

    @Override // okio.p
    public void a_(c cVar, long j) throws IOException {
        this.f7178a.a_(cVar, j);
    }

    @Override // okio.p, java.io.Flushable
    public void flush() throws IOException {
        this.f7178a.flush();
    }

    @Override // okio.p
    public r a() {
        return this.f7178a.a();
    }

    @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f7178a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f7178a.toString() + ")";
    }
}
