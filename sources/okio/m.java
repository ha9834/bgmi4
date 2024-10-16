package okio;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class m implements e {

    /* renamed from: a, reason: collision with root package name */
    public final c f7188a = new c();
    public final q b;
    boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(q qVar) {
        if (qVar == null) {
            throw new NullPointerException("source == null");
        }
        this.b = qVar;
    }

    @Override // okio.e
    public c c() {
        return this.f7188a;
    }

    @Override // okio.q
    public long a(c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.f7188a.b == 0 && this.b.a(this.f7188a, 8192L) == -1) {
            return -1L;
        }
        return this.f7188a.a(cVar, Math.min(j, this.f7188a.b));
    }

    @Override // okio.e
    public boolean f() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.f7188a.f() && this.b.a(this.f7188a, 8192L) == -1;
    }

    @Override // okio.e
    public void a(long j) throws IOException {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okio.e
    public boolean b(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (this.f7188a.b < j) {
            if (this.b.a(this.f7188a, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.e
    public byte i() throws IOException {
        a(1L);
        return this.f7188a.i();
    }

    @Override // okio.e
    public ByteString d(long j) throws IOException {
        a(j);
        return this.f7188a.d(j);
    }

    @Override // okio.e
    public byte[] s() throws IOException {
        this.f7188a.a(this.b);
        return this.f7188a.s();
    }

    @Override // okio.e
    public byte[] h(long j) throws IOException {
        a(j);
        return this.f7188a.h(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okio.e
    public void a(byte[] bArr) throws IOException {
        try {
            a(bArr.length);
            this.f7188a.a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f7188a.b > 0) {
                c cVar = this.f7188a;
                int a2 = cVar.a(bArr, i, (int) cVar.b);
                if (a2 == -1) {
                    throw new AssertionError();
                }
                i += a2;
            }
            throw e;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f7188a.b == 0 && this.b.a(this.f7188a, 8192L) == -1) {
            return -1;
        }
        return this.f7188a.read(byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okio.e
    public long a(p pVar) throws IOException {
        if (pVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.b.a(this.f7188a, 8192L) != -1) {
            long h = this.f7188a.h();
            if (h > 0) {
                j += h;
                pVar.a_(this.f7188a, h);
            }
        }
        if (this.f7188a.b() <= 0) {
            return j;
        }
        long b = j + this.f7188a.b();
        c cVar = this.f7188a;
        pVar.a_(cVar, cVar.b());
        return b;
    }

    @Override // okio.e
    public String a(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f7188a.a(this.b);
        return this.f7188a.a(charset);
    }

    @Override // okio.e
    public String q() throws IOException {
        return f(Long.MAX_VALUE);
    }

    @Override // okio.e
    public String f(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long a2 = a((byte) 10, 0L, j2);
        if (a2 != -1) {
            return this.f7188a.g(a2);
        }
        if (j2 < Long.MAX_VALUE && b(j2) && this.f7188a.c(j2 - 1) == 13 && b(1 + j2) && this.f7188a.c(j2) == 10) {
            return this.f7188a.g(j2);
        }
        c cVar = new c();
        c cVar2 = this.f7188a;
        cVar2.a(cVar, 0L, Math.min(32L, cVar2.b()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f7188a.b(), j) + " content=" + cVar.o().e() + (char) 8230);
    }

    @Override // okio.e
    public short j() throws IOException {
        a(2L);
        return this.f7188a.j();
    }

    @Override // okio.e
    public short l() throws IOException {
        a(2L);
        return this.f7188a.l();
    }

    @Override // okio.e
    public int k() throws IOException {
        a(4L);
        return this.f7188a.k();
    }

    @Override // okio.e
    public int m() throws IOException {
        a(4L);
        return this.f7188a.m();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // okio.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long n() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.a(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.b(r3)
            if (r3 == 0) goto L4a
            okio.c r3 = r6.f7188a
            long r4 = (long) r1
            byte r3 = r3.c(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            okio.c r0 = r6.f7188a
            long r0 = r0.n()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.m.n():long");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okio.e
    public void i(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f7188a.b == 0 && this.b.a(this.f7188a, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f7188a.b());
            this.f7188a.i(min);
            j -= min;
        }
    }

    @Override // okio.e
    public long a(byte b) throws IOException {
        return a(b, 0L, Long.MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long a(byte b, long j, long j2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long a2 = this.f7188a.a(b, j, j2);
            if (a2 != -1) {
                return a2;
            }
            long j3 = this.f7188a.b;
            if (j3 >= j2 || this.b.a(this.f7188a, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // okio.e
    public boolean a(long j, ByteString byteString) throws IOException {
        return a(j, byteString, 0, byteString.g());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean a(long j, ByteString byteString, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || byteString.g() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!b(1 + j2) || this.f7188a.c(j2) != byteString.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.e
    public InputStream g() {
        return new InputStream() { // from class: okio.m.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (m.this.c) {
                    throw new IOException("closed");
                }
                if (m.this.f7188a.b == 0 && m.this.b.a(m.this.f7188a, 8192L) == -1) {
                    return -1;
                }
                return m.this.f7188a.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (m.this.c) {
                    throw new IOException("closed");
                }
                s.a(bArr.length, i, i2);
                if (m.this.f7188a.b == 0 && m.this.b.a(m.this.f7188a, 8192L) == -1) {
                    return -1;
                }
                return m.this.f7188a.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (m.this.c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(m.this.f7188a.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                m.this.close();
            }

            public String toString() {
                return m.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.q
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.f7188a.t();
    }

    @Override // okio.q
    public r a() {
        return this.b.a();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
