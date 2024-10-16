package okhttp3.internal.connection;

import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.Headers;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.security.CertificateUtil;
import com.intlgame.core.INTLMethodID;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.i;
import okhttp3.internal.e.g;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.e;
import okhttp3.j;
import okhttp3.p;
import okhttp3.r;
import okhttp3.t;
import okhttp3.u;
import okhttp3.x;
import okhttp3.z;
import okio.k;
import okio.q;

/* loaded from: classes.dex */
public final class c extends e.c implements i {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7086a;
    public int b;
    public int c = 1;
    public final List<Reference<f>> d = new ArrayList();
    public long e = Long.MAX_VALUE;
    private final j g;
    private final ad h;
    private Socket i;
    private Socket j;
    private r k;
    private Protocol l;
    private okhttp3.internal.http2.e m;
    private okio.e n;
    private okio.d o;

    public c(j jVar, ad adVar) {
        this.g = jVar;
        this.h = adVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f6 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0145 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0138  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r17, int r18, int r19, int r20, boolean r21, okhttp3.e r22, okhttp3.p r23) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.c.a(int, int, int, int, boolean, okhttp3.e, okhttp3.p):void");
    }

    private void a(int i, int i2, int i3, okhttp3.e eVar, p pVar) throws IOException {
        z g = g();
        t a2 = g.a();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, eVar, pVar);
            g = a(i2, i3, g, a2);
            if (g == null) {
                return;
            }
            okhttp3.internal.c.a(this.i);
            this.i = null;
            this.o = null;
            this.n = null;
            pVar.a(eVar, this.h.c(), this.h.b(), null);
        }
    }

    private void a(int i, int i2, okhttp3.e eVar, p pVar) throws IOException {
        Socket createSocket;
        Proxy b = this.h.b();
        okhttp3.a a2 = this.h.a();
        if (b.type() == Proxy.Type.DIRECT || b.type() == Proxy.Type.HTTP) {
            createSocket = a2.c().createSocket();
        } else {
            createSocket = new Socket(b);
        }
        this.i = createSocket;
        pVar.a(eVar, this.h.c(), b);
        this.i.setSoTimeout(i2);
        try {
            g.e().a(this.i, this.h.c(), i);
            try {
                this.n = k.a(k.b(this.i));
                this.o = k.a(k.a(this.i));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.h.c());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void a(b bVar, int i, okhttp3.e eVar, p pVar) throws IOException {
        if (this.h.a().i() == null) {
            if (this.h.a().e().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                this.j = this.i;
                this.l = Protocol.H2_PRIOR_KNOWLEDGE;
                a(i);
                return;
            } else {
                this.j = this.i;
                this.l = Protocol.HTTP_1_1;
                return;
            }
        }
        pVar.b(eVar);
        a(bVar);
        pVar.a(eVar, this.k);
        if (this.l == Protocol.HTTP_2) {
            a(i);
        }
    }

    private void a(int i) throws IOException {
        this.j.setSoTimeout(0);
        this.m = new e.a(true).a(this.j, this.h.a().a().f(), this.n, this.o).a(this).a(i).a();
        this.m.c();
    }

    private void a(b bVar) throws IOException {
        SSLSocket sSLSocket;
        Protocol protocol;
        okhttp3.a a2 = this.h.a();
        try {
            try {
                sSLSocket = (SSLSocket) a2.i().createSocket(this.i, a2.a().f(), a2.a().g(), true);
            } catch (Throwable th) {
                th = th;
                sSLSocket = null;
            }
        } catch (AssertionError e) {
            e = e;
        }
        try {
            okhttp3.k a3 = bVar.a(sSLSocket);
            if (a3.d()) {
                g.e().a(sSLSocket, a2.a().f(), a2.e());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            r a4 = r.a(session);
            if (!a2.j().verify(a2.a().f(), session)) {
                List<Certificate> b = a4.b();
                if (!b.isEmpty()) {
                    X509Certificate x509Certificate = (X509Certificate) b.get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + a2.a().f() + " not verified:\n    certificate: " + okhttp3.g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + okhttp3.internal.g.d.a(x509Certificate));
                }
                throw new SSLPeerUnverifiedException("Hostname " + a2.a().f() + " not verified (no certificates)");
            }
            a2.k().a(a2.a().f(), a4.b());
            String a5 = a3.d() ? g.e().a(sSLSocket) : null;
            this.j = sSLSocket;
            this.n = k.a(k.b(this.j));
            this.o = k.a(k.a(this.j));
            this.k = a4;
            if (a5 != null) {
                protocol = Protocol.a(a5);
            } else {
                protocol = Protocol.HTTP_1_1;
            }
            this.l = protocol;
            if (sSLSocket != null) {
                g.e().b(sSLSocket);
            }
        } catch (AssertionError e2) {
            e = e2;
            if (!okhttp3.internal.c.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            if (sSLSocket != null) {
                g.e().b(sSLSocket);
            }
            okhttp3.internal.c.a((Socket) sSLSocket);
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private z a(int i, int i2, z zVar, t tVar) throws IOException {
        String str = "CONNECT " + okhttp3.internal.c.a(tVar, true) + " HTTP/1.1";
        while (true) {
            okhttp3.internal.c.a aVar = new okhttp3.internal.c.a(null, null, this.n, this.o);
            this.n.a().a(i, TimeUnit.MILLISECONDS);
            this.o.a().a(i2, TimeUnit.MILLISECONDS);
            aVar.a(zVar.c(), str);
            aVar.b();
            ab a2 = aVar.a(false).a(zVar).a();
            long a3 = okhttp3.internal.b.e.a(a2);
            if (a3 == -1) {
                a3 = 0;
            }
            q b = aVar.b(a3);
            okhttp3.internal.c.b(b, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            b.close();
            int b2 = a2.b();
            if (b2 == 200) {
                if (this.n.c().f() && this.o.c().f()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (b2 == 407) {
                z authenticate = this.h.a().d().authenticate(this.h, a2);
                if (authenticate == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if ("close".equalsIgnoreCase(a2.a(Headers.CONNECTION))) {
                    return authenticate;
                }
                zVar = authenticate;
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + a2.b());
            }
        }
    }

    private z g() throws IOException {
        z b = new z.a().a(this.h.a().a()).a("CONNECT", (aa) null).a(HttpHeader.HOST, okhttp3.internal.c.a(this.h.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a(HttpHeader.USER_AGENT, okhttp3.internal.d.a()).b();
        z authenticate = this.h.a().d().authenticate(this.h, new ab.a().a(b).a(Protocol.HTTP_1_1).a(INTLMethodID.INTL_METHOD_ID_PUSH_NOTIFICATION_CALLBACK).a("Preemptive Authenticate").a(okhttp3.internal.c.c).a(-1L).b(-1L).a("Proxy-Authenticate", "OkHttp-Preemptive").a());
        return authenticate != null ? authenticate : b;
    }

    public boolean a(okhttp3.a aVar, @Nullable ad adVar) {
        if (this.d.size() >= this.c || this.f7086a || !okhttp3.internal.a.f7061a.a(this.h.a(), aVar)) {
            return false;
        }
        if (aVar.a().f().equals(b().a().a().f())) {
            return true;
        }
        if (this.m == null || adVar == null || adVar.b().type() != Proxy.Type.DIRECT || this.h.b().type() != Proxy.Type.DIRECT || !this.h.c().equals(adVar.c()) || adVar.a().j() != okhttp3.internal.g.d.f7104a || !a(aVar.a())) {
            return false;
        }
        try {
            aVar.k().a(aVar.a().f(), e().b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean a(t tVar) {
        if (tVar.g() != this.h.a().a().g()) {
            return false;
        }
        if (tVar.f().equals(this.h.a().a().f())) {
            return true;
        }
        return this.k != null && okhttp3.internal.g.d.f7104a.a(tVar.f(), (X509Certificate) this.k.b().get(0));
    }

    public okhttp3.internal.b.c a(x xVar, u.a aVar, f fVar) throws SocketException {
        okhttp3.internal.http2.e eVar = this.m;
        if (eVar != null) {
            return new okhttp3.internal.http2.d(xVar, aVar, fVar, eVar);
        }
        this.j.setSoTimeout(aVar.d());
        this.n.a().a(aVar.d(), TimeUnit.MILLISECONDS);
        this.o.a().a(aVar.e(), TimeUnit.MILLISECONDS);
        return new okhttp3.internal.c.a(xVar, fVar, this.n, this.o);
    }

    public ad b() {
        return this.h;
    }

    public void c() {
        okhttp3.internal.c.a(this.i);
    }

    public Socket d() {
        return this.j;
    }

    public boolean a(boolean z) {
        if (this.j.isClosed() || this.j.isInputShutdown() || this.j.isOutputShutdown()) {
            return false;
        }
        okhttp3.internal.http2.e eVar = this.m;
        if (eVar != null) {
            return eVar.b(System.nanoTime());
        }
        if (z) {
            try {
                int soTimeout = this.j.getSoTimeout();
                try {
                    this.j.setSoTimeout(1);
                    return !this.n.f();
                } finally {
                    this.j.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // okhttp3.internal.http2.e.c
    public void a(okhttp3.internal.http2.g gVar) throws IOException {
        gVar.a(ErrorCode.REFUSED_STREAM);
    }

    @Override // okhttp3.internal.http2.e.c
    public void a(okhttp3.internal.http2.e eVar) {
        synchronized (this.g) {
            this.c = eVar.a();
        }
    }

    public r e() {
        return this.k;
    }

    public boolean f() {
        return this.m != null;
    }

    @Override // okhttp3.i
    public Protocol a() {
        return this.l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.h.a().a().f());
        sb.append(CertificateUtil.DELIMITER);
        sb.append(this.h.a().a().g());
        sb.append(", proxy=");
        sb.append(this.h.b());
        sb.append(" hostAddress=");
        sb.append(this.h.c());
        sb.append(" cipherSuite=");
        r rVar = this.k;
        sb.append(rVar != null ? rVar.a() : IntegrityManager.INTEGRITY_TYPE_NONE);
        sb.append(" protocol=");
        sb.append(this.l);
        sb.append('}');
        return sb.toString();
    }
}
