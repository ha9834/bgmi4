package okhttp3;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.ab;
import okhttp3.e;
import okhttp3.p;
import okhttp3.s;

/* loaded from: classes.dex */
public class x implements Cloneable, e.a {

    /* renamed from: a, reason: collision with root package name */
    static final List<Protocol> f7163a = okhttp3.internal.c.a(Protocol.HTTP_2, Protocol.HTTP_1_1);
    static final List<k> b = okhttp3.internal.c.a(k.b, k.d);
    final int A;
    final int B;
    final int C;
    final int D;
    final n c;

    @Nullable
    final Proxy d;
    final List<Protocol> e;
    final List<k> f;
    final List<u> g;
    final List<u> h;
    final p.a i;
    final ProxySelector j;
    final m k;

    @Nullable
    final c l;

    @Nullable
    final okhttp3.internal.a.e m;
    final SocketFactory n;
    final SSLSocketFactory o;
    final okhttp3.internal.g.c p;
    final HostnameVerifier q;
    final g r;
    final b s;
    final b t;
    final j u;
    final o v;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    static {
        okhttp3.internal.a.f7061a = new okhttp3.internal.a() { // from class: okhttp3.x.1
            @Override // okhttp3.internal.a
            public void a(s.a aVar, String str) {
                aVar.a(str);
            }

            @Override // okhttp3.internal.a
            public void a(s.a aVar, String str, String str2) {
                aVar.c(str, str2);
            }

            @Override // okhttp3.internal.a
            public boolean a(j jVar, okhttp3.internal.connection.c cVar) {
                return jVar.b(cVar);
            }

            @Override // okhttp3.internal.a
            public okhttp3.internal.connection.c a(j jVar, okhttp3.a aVar, okhttp3.internal.connection.f fVar, ad adVar) {
                return jVar.a(aVar, fVar, adVar);
            }

            @Override // okhttp3.internal.a
            public boolean a(okhttp3.a aVar, okhttp3.a aVar2) {
                return aVar.a(aVar2);
            }

            @Override // okhttp3.internal.a
            public Socket a(j jVar, okhttp3.a aVar, okhttp3.internal.connection.f fVar) {
                return jVar.a(aVar, fVar);
            }

            @Override // okhttp3.internal.a
            public void b(j jVar, okhttp3.internal.connection.c cVar) {
                jVar.a(cVar);
            }

            @Override // okhttp3.internal.a
            public okhttp3.internal.connection.d a(j jVar) {
                return jVar.f7140a;
            }

            @Override // okhttp3.internal.a
            public int a(ab.a aVar) {
                return aVar.c;
            }

            @Override // okhttp3.internal.a
            public void a(k kVar, SSLSocket sSLSocket, boolean z) {
                kVar.a(sSLSocket, z);
            }

            @Override // okhttp3.internal.a
            @Nullable
            public IOException a(e eVar, @Nullable IOException iOException) {
                return ((y) eVar).a(iOException);
            }
        };
    }

    public x() {
        this(new a());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    x(a aVar) {
        this.c = aVar.f7164a;
        this.d = aVar.b;
        this.e = aVar.c;
        this.f = aVar.d;
        this.g = okhttp3.internal.c.a(aVar.e);
        this.h = okhttp3.internal.c.a(aVar.f);
        this.i = aVar.g;
        this.j = aVar.h;
        this.k = aVar.i;
        this.l = aVar.j;
        this.m = aVar.k;
        this.n = aVar.l;
        Iterator<k> it = this.f.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = z || it.next().a();
        }
        if (aVar.m != null || !z) {
            this.o = aVar.m;
            this.p = aVar.n;
        } else {
            X509TrustManager a2 = okhttp3.internal.c.a();
            this.o = a(a2);
            this.p = okhttp3.internal.g.c.a(a2);
        }
        if (this.o != null) {
            okhttp3.internal.e.g.e().a(this.o);
        }
        this.q = aVar.o;
        this.r = aVar.p.a(this.p);
        this.s = aVar.q;
        this.t = aVar.r;
        this.u = aVar.s;
        this.v = aVar.t;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        this.C = aVar.A;
        this.D = aVar.B;
        if (this.g.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.g);
        }
        if (this.h.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.h);
        }
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext c = okhttp3.internal.e.g.e().c();
            c.init(null, new TrustManager[]{x509TrustManager}, null);
            return c.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw okhttp3.internal.c.a("No System TLS", (Exception) e);
        }
    }

    public int a() {
        return this.z;
    }

    public int b() {
        return this.A;
    }

    public int c() {
        return this.B;
    }

    public int d() {
        return this.C;
    }

    public int e() {
        return this.D;
    }

    @Nullable
    public Proxy f() {
        return this.d;
    }

    public ProxySelector g() {
        return this.j;
    }

    public m h() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public okhttp3.internal.a.e i() {
        c cVar = this.l;
        return cVar != null ? cVar.f7053a : this.m;
    }

    public o j() {
        return this.v;
    }

    public SocketFactory k() {
        return this.n;
    }

    public SSLSocketFactory l() {
        return this.o;
    }

    public HostnameVerifier m() {
        return this.q;
    }

    public g n() {
        return this.r;
    }

    public b o() {
        return this.t;
    }

    public b p() {
        return this.s;
    }

    public j q() {
        return this.u;
    }

    public boolean r() {
        return this.w;
    }

    public boolean s() {
        return this.x;
    }

    public boolean t() {
        return this.y;
    }

    public n u() {
        return this.c;
    }

    public List<Protocol> v() {
        return this.e;
    }

    public List<k> w() {
        return this.f;
    }

    public List<u> x() {
        return this.g;
    }

    public List<u> y() {
        return this.h;
    }

    public p.a z() {
        return this.i;
    }

    @Override // okhttp3.e.a
    public e a(z zVar) {
        return y.a(this, zVar, false);
    }

    public a A() {
        return new a(this);
    }

    /* loaded from: classes.dex */
    public static final class a {
        int A;
        int B;

        /* renamed from: a, reason: collision with root package name */
        n f7164a;

        @Nullable
        Proxy b;
        List<Protocol> c;
        List<k> d;
        final List<u> e;
        final List<u> f;
        p.a g;
        ProxySelector h;
        m i;

        @Nullable
        c j;

        @Nullable
        okhttp3.internal.a.e k;
        SocketFactory l;

        @Nullable
        SSLSocketFactory m;

        @Nullable
        okhttp3.internal.g.c n;
        HostnameVerifier o;
        g p;
        b q;
        b r;
        j s;
        o t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public a() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.f7164a = new n();
            this.c = x.f7163a;
            this.d = x.b;
            this.g = p.a(p.f7150a);
            this.h = ProxySelector.getDefault();
            if (this.h == null) {
                this.h = new okhttp3.internal.f.a();
            }
            this.i = m.f7147a;
            this.l = SocketFactory.getDefault();
            this.o = okhttp3.internal.g.d.f7104a;
            this.p = g.f7056a;
            this.q = b.f7052a;
            this.r = b.f7052a;
            this.s = new j();
            this.t = o.f7149a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        a(x xVar) {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.f7164a = xVar.c;
            this.b = xVar.d;
            this.c = xVar.e;
            this.d = xVar.f;
            this.e.addAll(xVar.g);
            this.f.addAll(xVar.h);
            this.g = xVar.i;
            this.h = xVar.j;
            this.i = xVar.k;
            this.k = xVar.m;
            this.j = xVar.l;
            this.l = xVar.n;
            this.m = xVar.o;
            this.n = xVar.p;
            this.o = xVar.q;
            this.p = xVar.r;
            this.q = xVar.s;
            this.r = xVar.t;
            this.s = xVar.u;
            this.t = xVar.v;
            this.u = xVar.w;
            this.v = xVar.x;
            this.w = xVar.y;
            this.x = xVar.z;
            this.y = xVar.A;
            this.z = xVar.B;
            this.A = xVar.C;
            this.B = xVar.D;
        }

        public a a(long j, TimeUnit timeUnit) {
            this.y = okhttp3.internal.c.a("timeout", j, timeUnit);
            return this;
        }

        public a b(long j, TimeUnit timeUnit) {
            this.z = okhttp3.internal.c.a("timeout", j, timeUnit);
            return this;
        }

        public a c(long j, TimeUnit timeUnit) {
            this.A = okhttp3.internal.c.a("timeout", j, timeUnit);
            return this;
        }

        public a a(@Nullable c cVar) {
            this.j = cVar;
            this.k = null;
            return this;
        }

        public a a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager == null) {
                throw new NullPointerException("trustManager == null");
            }
            this.m = sSLSocketFactory;
            this.n = okhttp3.internal.g.c.a(x509TrustManager);
            return this;
        }

        public a a(g gVar) {
            if (gVar == null) {
                throw new NullPointerException("certificatePinner == null");
            }
            this.p = gVar;
            return this;
        }

        public a a(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("authenticator == null");
            }
            this.r = bVar;
            return this;
        }

        public a a(boolean z) {
            this.u = z;
            return this;
        }

        public a b(boolean z) {
            this.v = z;
            return this;
        }

        public a a(List<k> list) {
            this.d = okhttp3.internal.c.a(list);
            return this;
        }

        public a a(u uVar) {
            if (uVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.e.add(uVar);
            return this;
        }

        public a b(u uVar) {
            if (uVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f.add(uVar);
            return this;
        }

        public x a() {
            return new x(this);
        }
    }
}
