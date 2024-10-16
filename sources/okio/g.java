package okio;

import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class g implements q {

    /* renamed from: a, reason: collision with root package name */
    private final q f7179a;

    public g(q qVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f7179a = qVar;
    }

    public final q b() {
        return this.f7179a;
    }

    @Override // okio.q
    public long a(c cVar, long j) throws IOException {
        return this.f7179a.a(cVar, j);
    }

    @Override // okio.q
    public r a() {
        return this.f7179a.a();
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f7179a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f7179a.toString() + ")";
    }
}
