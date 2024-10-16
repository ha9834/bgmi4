package okhttp3.internal.c;

import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.internal.b.h;
import okhttp3.internal.b.i;
import okhttp3.s;
import okhttp3.t;
import okhttp3.x;
import okhttp3.z;
import okio.k;
import okio.p;
import okio.q;
import okio.r;

/* loaded from: classes3.dex */
public final class a implements okhttp3.internal.b.c {

    /* renamed from: a, reason: collision with root package name */
    final x f7080a;
    final okhttp3.internal.connection.f b;
    final okio.e c;
    final okio.d d;
    int e = 0;
    private long f = 262144;

    public a(x xVar, okhttp3.internal.connection.f fVar, okio.e eVar, okio.d dVar) {
        this.f7080a = xVar;
        this.b = fVar;
        this.c = eVar;
        this.d = dVar;
    }

    @Override // okhttp3.internal.b.c
    public p a(z zVar, long j) {
        if ("chunked".equalsIgnoreCase(zVar.a("Transfer-Encoding"))) {
            return e();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.b.c
    public void c() {
        okhttp3.internal.connection.c c2 = this.b.c();
        if (c2 != null) {
            c2.c();
        }
    }

    @Override // okhttp3.internal.b.c
    public void a(z zVar) throws IOException {
        a(zVar.c(), i.a(zVar, this.b.c().b().b().type()));
    }

    @Override // okhttp3.internal.b.c
    public ac a(ab abVar) throws IOException {
        this.b.c.f(this.b.b);
        String a2 = abVar.a("Content-Type");
        if (!okhttp3.internal.b.e.b(abVar)) {
            return new h(a2, 0L, k.a(b(0L)));
        }
        if ("chunked".equalsIgnoreCase(abVar.a("Transfer-Encoding"))) {
            return new h(a2, -1L, k.a(a(abVar.a().a())));
        }
        long a3 = okhttp3.internal.b.e.a(abVar);
        if (a3 != -1) {
            return new h(a2, a3, k.a(b(a3)));
        }
        return new h(a2, -1L, k.a(f()));
    }

    @Override // okhttp3.internal.b.c
    public void a() throws IOException {
        this.d.flush();
    }

    @Override // okhttp3.internal.b.c
    public void b() throws IOException {
        this.d.flush();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a(s sVar, String str) throws IOException {
        if (this.e != 0) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.d.b(str).b(APLogFileUtil.SEPARATOR_LINE);
        int a2 = sVar.a();
        for (int i = 0; i < a2; i++) {
            this.d.b(sVar.a(i)).b(": ").b(sVar.b(i)).b(APLogFileUtil.SEPARATOR_LINE);
        }
        this.d.b(APLogFileUtil.SEPARATOR_LINE);
        this.e = 1;
    }

    @Override // okhttp3.internal.b.c
    public ab.a a(boolean z) throws IOException {
        int i = this.e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.e);
        }
        try {
            okhttp3.internal.b.k a2 = okhttp3.internal.b.k.a(g());
            ab.a a3 = new ab.a().a(a2.f7077a).a(a2.b).a(a2.c).a(d());
            if (z && a2.b == 100) {
                return null;
            }
            if (a2.b == 100) {
                this.e = 3;
                return a3;
            }
            this.e = 4;
            return a3;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    private String g() throws IOException {
        String f2 = this.c.f(this.f);
        this.f -= f2.length();
        return f2;
    }

    public s d() throws IOException {
        s.a aVar = new s.a();
        while (true) {
            String g = g();
            if (g.length() != 0) {
                okhttp3.internal.a.f7061a.a(aVar, g);
            } else {
                return aVar.a();
            }
        }
    }

    public p e() {
        if (this.e != 1) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 2;
        return new b();
    }

    public p a(long j) {
        if (this.e != 1) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 2;
        return new d(j);
    }

    public q b(long j) throws IOException {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 5;
        return new e(j);
    }

    public q a(t tVar) throws IOException {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 5;
        return new c(tVar);
    }

    public q f() throws IOException {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        okhttp3.internal.connection.f fVar = this.b;
        if (fVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.e = 5;
        fVar.e();
        return new f();
    }

    void a(okio.h hVar) {
        r a2 = hVar.a();
        hVar.a(r.c);
        a2.f();
        a2.h_();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class d implements p {
        private final okio.h b;
        private boolean c;
        private long d;

        d(long j) {
            this.b = new okio.h(a.this.d.a());
            this.d = j;
        }

        @Override // okio.p
        public r a() {
            return this.b;
        }

        @Override // okio.p
        public void a_(okio.c cVar, long j) throws IOException {
            if (this.c) {
                throw new IllegalStateException("closed");
            }
            okhttp3.internal.c.a(cVar.b(), 0L, j);
            if (j > this.d) {
                throw new ProtocolException("expected " + this.d + " bytes but received " + j);
            }
            a.this.d.a_(cVar, j);
            this.d -= j;
        }

        @Override // okio.p, java.io.Flushable
        public void flush() throws IOException {
            if (this.c) {
                return;
            }
            a.this.d.flush();
        }

        @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.c) {
                return;
            }
            this.c = true;
            if (this.d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            a.this.a(this.b);
            a.this.e = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class b implements p {
        private final okio.h b;
        private boolean c;

        b() {
            this.b = new okio.h(a.this.d.a());
        }

        @Override // okio.p
        public r a() {
            return this.b;
        }

        @Override // okio.p
        public void a_(okio.c cVar, long j) throws IOException {
            if (this.c) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            a.this.d.l(j);
            a.this.d.b(APLogFileUtil.SEPARATOR_LINE);
            a.this.d.a_(cVar, j);
            a.this.d.b(APLogFileUtil.SEPARATOR_LINE);
        }

        @Override // okio.p, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.c) {
                return;
            }
            a.this.d.flush();
        }

        @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.c) {
                return;
            }
            this.c = true;
            a.this.d.b("0\r\n\r\n");
            a.this.a(this.b);
            a.this.e = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: okhttp3.internal.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public abstract class AbstractC0229a implements q {

        /* renamed from: a, reason: collision with root package name */
        protected final okio.h f7081a;
        protected boolean b;
        protected long c;

        private AbstractC0229a() {
            this.f7081a = new okio.h(a.this.c.a());
            this.c = 0L;
        }

        @Override // okio.q
        public r a() {
            return this.f7081a;
        }

        @Override // okio.q
        public long a(okio.c cVar, long j) throws IOException {
            try {
                long a2 = a.this.c.a(cVar, j);
                if (a2 > 0) {
                    this.c += a2;
                }
                return a2;
            } catch (IOException e) {
                a(false, e);
                throw e;
            }
        }

        protected final void a(boolean z, IOException iOException) throws IOException {
            if (a.this.e == 6) {
                return;
            }
            if (a.this.e != 5) {
                throw new IllegalStateException("state: " + a.this.e);
            }
            a.this.a(this.f7081a);
            a aVar = a.this;
            aVar.e = 6;
            if (aVar.b != null) {
                a.this.b.a(!z, a.this, this.c, iOException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class e extends AbstractC0229a {
        private long f;

        e(long j) throws IOException {
            super();
            this.f = j;
            if (this.f == 0) {
                a(true, (IOException) null);
            }
        }

        @Override // okhttp3.internal.c.a.AbstractC0229a, okio.q
        public long a(okio.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.f;
            if (j2 == 0) {
                return -1L;
            }
            long a2 = super.a(cVar, Math.min(j2, j));
            if (a2 == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, (IOException) protocolException);
                throw protocolException;
            }
            this.f -= a2;
            if (this.f == 0) {
                a(true, (IOException) null);
            }
            return a2;
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.f != 0 && !okhttp3.internal.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends AbstractC0229a {
        private final t f;
        private long g;
        private boolean h;

        c(t tVar) {
            super();
            this.g = -1L;
            this.h = true;
            this.f = tVar;
        }

        @Override // okhttp3.internal.c.a.AbstractC0229a, okio.q
        public long a(okio.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (!this.h) {
                return -1L;
            }
            long j2 = this.g;
            if (j2 == 0 || j2 == -1) {
                b();
                if (!this.h) {
                    return -1L;
                }
            }
            long a2 = super.a(cVar, Math.min(j, this.g));
            if (a2 == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, (IOException) protocolException);
                throw protocolException;
            }
            this.g -= a2;
            return a2;
        }

        private void b() throws IOException {
            if (this.g != -1) {
                a.this.c.q();
            }
            try {
                this.g = a.this.c.n();
                String trim = a.this.c.q().trim();
                if (this.g < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + trim + "\"");
                }
                if (this.g == 0) {
                    this.h = false;
                    okhttp3.internal.b.e.a(a.this.f7080a.h(), this.f, a.this.d());
                    a(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.h && !okhttp3.internal.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class f extends AbstractC0229a {
        private boolean f;

        f() {
            super();
        }

        @Override // okhttp3.internal.c.a.AbstractC0229a, okio.q
        public long a(okio.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (this.f) {
                return -1L;
            }
            long a2 = super.a(cVar, j);
            if (a2 != -1) {
                return a2;
            }
            this.f = true;
            a(true, (IOException) null);
            return -1L;
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (!this.f) {
                a(false, (IOException) null);
            }
            this.b = true;
        }
    }
}
