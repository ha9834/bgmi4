package okhttp3.internal.http2;

import com.amazonaws.http.HttpHeader;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.s;
import okhttp3.u;
import okhttp3.x;
import okhttp3.z;
import okio.ByteString;
import okio.p;
import okio.q;

/* loaded from: classes3.dex */
public final class d implements okhttp3.internal.b.c {
    private static final List<String> b = okhttp3.internal.c.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    private static final List<String> c = okhttp3.internal.c.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    final okhttp3.internal.connection.f f7111a;
    private final u.a d;
    private final e e;
    private g f;
    private final Protocol g;

    public d(x xVar, u.a aVar, okhttp3.internal.connection.f fVar, e eVar) {
        Protocol protocol;
        this.d = aVar;
        this.f7111a = fVar;
        this.e = eVar;
        if (xVar.v().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol = Protocol.HTTP_2;
        }
        this.g = protocol;
    }

    @Override // okhttp3.internal.b.c
    public p a(z zVar, long j) {
        return this.f.h();
    }

    @Override // okhttp3.internal.b.c
    public void a(z zVar) throws IOException {
        if (this.f != null) {
            return;
        }
        this.f = this.e.a(b(zVar), zVar.d() != null);
        this.f.e().a(this.d.d(), TimeUnit.MILLISECONDS);
        this.f.f().a(this.d.e(), TimeUnit.MILLISECONDS);
    }

    @Override // okhttp3.internal.b.c
    public void a() throws IOException {
        this.e.b();
    }

    @Override // okhttp3.internal.b.c
    public void b() throws IOException {
        this.f.h().close();
    }

    @Override // okhttp3.internal.b.c
    public ab.a a(boolean z) throws IOException {
        ab.a a2 = a(this.f.d(), this.g);
        if (z && okhttp3.internal.a.f7061a.a(a2) == 100) {
            return null;
        }
        return a2;
    }

    public static List<okhttp3.internal.http2.a> b(z zVar) {
        s c2 = zVar.c();
        ArrayList arrayList = new ArrayList(c2.a() + 4);
        arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.c, zVar.b()));
        arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.d, okhttp3.internal.b.i.a(zVar.a())));
        String a2 = zVar.a(HttpHeader.HOST);
        if (a2 != null) {
            arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.f, a2));
        }
        arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.e, zVar.a().b()));
        int a3 = c2.a();
        for (int i = 0; i < a3; i++) {
            ByteString a4 = ByteString.a(c2.a(i).toLowerCase(Locale.US));
            if (!b.contains(a4.a())) {
                arrayList.add(new okhttp3.internal.http2.a(a4, c2.b(i)));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ab.a a(s sVar, Protocol protocol) throws IOException {
        s.a aVar = new s.a();
        int a2 = sVar.a();
        okhttp3.internal.b.k kVar = null;
        for (int i = 0; i < a2; i++) {
            String a3 = sVar.a(i);
            String b2 = sVar.b(i);
            if (a3.equals(":status")) {
                kVar = okhttp3.internal.b.k.a("HTTP/1.1 " + b2);
            } else if (!c.contains(a3)) {
                okhttp3.internal.a.f7061a.a(aVar, a3, b2);
            }
        }
        if (kVar == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        return new ab.a().a(protocol).a(kVar.b).a(kVar.c).a(aVar.a());
    }

    @Override // okhttp3.internal.b.c
    public ac a(ab abVar) throws IOException {
        this.f7111a.c.f(this.f7111a.b);
        return new okhttp3.internal.b.h(abVar.a("Content-Type"), okhttp3.internal.b.e.a(abVar), okio.k.a(new a(this.f.g())));
    }

    @Override // okhttp3.internal.b.c
    public void c() {
        g gVar = this.f;
        if (gVar != null) {
            gVar.b(ErrorCode.CANCEL);
        }
    }

    /* loaded from: classes3.dex */
    class a extends okio.g {

        /* renamed from: a, reason: collision with root package name */
        boolean f7112a;
        long b;

        a(q qVar) {
            super(qVar);
            this.f7112a = false;
            this.b = 0L;
        }

        @Override // okio.g, okio.q
        public long a(okio.c cVar, long j) throws IOException {
            try {
                long a2 = b().a(cVar, j);
                if (a2 > 0) {
                    this.b += a2;
                }
                return a2;
            } catch (IOException e) {
                a(e);
                throw e;
            }
        }

        @Override // okio.g, okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }

        private void a(IOException iOException) {
            if (this.f7112a) {
                return;
            }
            this.f7112a = true;
            d.this.f7111a.a(false, d.this, this.b, iOException);
        }
    }
}
