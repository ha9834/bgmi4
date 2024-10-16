package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes3.dex */
public final class j implements q {

    /* renamed from: a, reason: collision with root package name */
    private final e f7182a;
    private final Inflater b;
    private int c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f7182a = eVar;
        this.b = inflater;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okio.q
    public long a(c cVar, long j) throws IOException {
        boolean b;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            b = b();
            try {
                n e = cVar.e(1);
                int inflate = this.b.inflate(e.f7190a, e.c, (int) Math.min(j, 8192 - e.c));
                if (inflate > 0) {
                    e.c += inflate;
                    long j2 = inflate;
                    cVar.b += j2;
                    return j2;
                }
                if (!this.b.finished() && !this.b.needsDictionary()) {
                }
                c();
                if (e.b != e.c) {
                    return -1L;
                }
                cVar.f7175a = e.b();
                o.a(e);
                return -1L;
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        } while (!b);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean b() throws IOException {
        if (!this.b.needsInput()) {
            return false;
        }
        c();
        if (this.b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f7182a.f()) {
            return true;
        }
        n nVar = this.f7182a.c().f7175a;
        this.c = nVar.c - nVar.b;
        this.b.setInput(nVar.f7190a, nVar.b, this.c);
        return false;
    }

    private void c() throws IOException {
        int i = this.c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.b.getRemaining();
        this.c -= remaining;
        this.f7182a.i(remaining);
    }

    @Override // okio.q
    public r a() {
        return this.f7182a.a();
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.d) {
            return;
        }
        this.b.end();
        this.d = true;
        this.f7182a.close();
    }
}
