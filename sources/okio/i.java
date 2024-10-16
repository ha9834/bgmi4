package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: classes3.dex */
public final class i implements q {
    private final e b;
    private final Inflater c;
    private final j d;

    /* renamed from: a, reason: collision with root package name */
    private int f7181a = 0;
    private final CRC32 e = new CRC32();

    public i(q qVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.c = new Inflater(true);
        this.b = k.a(qVar);
        this.d = new j(this.b, this.c);
    }

    @Override // okio.q
    public long a(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f7181a == 0) {
            b();
            this.f7181a = 1;
        }
        if (this.f7181a == 1) {
            long j2 = cVar.b;
            long a2 = this.d.a(cVar, j);
            if (a2 != -1) {
                a(cVar, j2, a2);
                return a2;
            }
            this.f7181a = 2;
        }
        if (this.f7181a == 2) {
            c();
            this.f7181a = 3;
            if (!this.b.f()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void b() throws IOException {
        this.b.a(10L);
        byte c = this.b.c().c(3L);
        boolean z = ((c >> 1) & 1) == 1;
        if (z) {
            a(this.b.c(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.b.j());
        this.b.i(8L);
        if (((c >> 2) & 1) == 1) {
            this.b.a(2L);
            if (z) {
                a(this.b.c(), 0L, 2L);
            }
            long l = this.b.c().l();
            this.b.a(l);
            if (z) {
                a(this.b.c(), 0L, l);
            }
            this.b.i(l);
        }
        if (((c >> 3) & 1) == 1) {
            long a2 = this.b.a((byte) 0);
            if (a2 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.b.c(), 0L, a2 + 1);
            }
            this.b.i(a2 + 1);
        }
        if (((c >> 4) & 1) == 1) {
            long a3 = this.b.a((byte) 0);
            if (a3 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.b.c(), 0L, a3 + 1);
            }
            this.b.i(a3 + 1);
        }
        if (z) {
            a("FHCRC", this.b.l(), (short) this.e.getValue());
            this.e.reset();
        }
    }

    private void c() throws IOException {
        a("CRC", this.b.m(), (int) this.e.getValue());
        a("ISIZE", this.b.m(), (int) this.c.getBytesWritten());
    }

    @Override // okio.q
    public r a() {
        return this.b.a();
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
    }

    private void a(c cVar, long j, long j2) {
        n nVar = cVar.f7175a;
        while (j >= nVar.c - nVar.b) {
            j -= nVar.c - nVar.b;
            nVar = nVar.f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(nVar.c - r6, j2);
            this.e.update(nVar.f7190a, (int) (nVar.b + j), min);
            j2 -= min;
            nVar = nVar.f;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
