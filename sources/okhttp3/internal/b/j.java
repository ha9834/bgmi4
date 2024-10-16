package okhttp3.internal.b;

import com.amazonaws.http.HttpHeader;
import com.intlgame.core.INTLMethodID;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.p;
import okhttp3.t;
import okhttp3.u;
import okhttp3.x;
import okhttp3.z;

/* loaded from: classes3.dex */
public final class j implements u {

    /* renamed from: a, reason: collision with root package name */
    private final x f7076a;
    private final boolean b;
    private volatile okhttp3.internal.connection.f c;
    private Object d;
    private volatile boolean e;

    public j(x xVar, boolean z) {
        this.f7076a = xVar;
        this.b = z;
    }

    public void a() {
        this.e = true;
        okhttp3.internal.connection.f fVar = this.c;
        if (fVar != null) {
            fVar.f();
        }
    }

    public boolean b() {
        return this.e;
    }

    public void a(Object obj) {
        this.d = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okhttp3.u
    public ab intercept(u.a aVar) throws IOException {
        ab a2;
        z a3;
        z a4 = aVar.a();
        g gVar = (g) aVar;
        okhttp3.e h = gVar.h();
        p i = gVar.i();
        okhttp3.internal.connection.f fVar = new okhttp3.internal.connection.f(this.f7076a.q(), a(a4.a()), h, i, this.d);
        this.c = fVar;
        ab abVar = null;
        int i2 = 0;
        while (!this.e) {
            try {
                try {
                    a2 = gVar.a(a4, fVar, null, null);
                    if (abVar != null) {
                        a2 = a2.h().c(abVar.h().a((ac) null).a()).a();
                    }
                    try {
                        a3 = a(a2, fVar.b());
                    } catch (IOException e) {
                        fVar.d();
                        throw e;
                    }
                } catch (IOException e2) {
                    if (!a(e2, fVar, !(e2 instanceof ConnectionShutdownException), a4)) {
                        throw e2;
                    }
                } catch (RouteException e3) {
                    if (!a(e3.b(), fVar, false, a4)) {
                        throw e3.a();
                    }
                }
                if (a3 == null) {
                    fVar.d();
                    return a2;
                }
                okhttp3.internal.c.a(a2.g());
                int i3 = i2 + 1;
                if (i3 > 20) {
                    fVar.d();
                    throw new ProtocolException("Too many follow-up requests: " + i3);
                }
                if (a3.d() instanceof l) {
                    fVar.d();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", a2.b());
                }
                if (!a(a2, a3.a())) {
                    fVar.d();
                    fVar = new okhttp3.internal.connection.f(this.f7076a.q(), a(a3.a()), h, i, this.d);
                    this.c = fVar;
                } else if (fVar.a() != null) {
                    throw new IllegalStateException("Closing the body of " + a2 + " didn't close its backing stream. Bad interceptor?");
                }
                abVar = a2;
                a4 = a3;
                i2 = i3;
            } catch (Throwable th) {
                fVar.a((IOException) null);
                fVar.d();
                throw th;
            }
        }
        fVar.d();
        throw new IOException("Canceled");
    }

    private okhttp3.a a(t tVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        okhttp3.g gVar;
        if (tVar.c()) {
            SSLSocketFactory l = this.f7076a.l();
            hostnameVerifier = this.f7076a.m();
            sSLSocketFactory = l;
            gVar = this.f7076a.n();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new okhttp3.a(tVar.f(), tVar.g(), this.f7076a.j(), this.f7076a.k(), sSLSocketFactory, hostnameVerifier, gVar, this.f7076a.p(), this.f7076a.f(), this.f7076a.v(), this.f7076a.w(), this.f7076a.g());
    }

    private boolean a(IOException iOException, okhttp3.internal.connection.f fVar, boolean z, z zVar) {
        fVar.a(iOException);
        if (this.f7076a.t()) {
            return !(z && a(iOException, zVar)) && a(iOException, z) && fVar.g();
        }
        return false;
    }

    private boolean a(IOException iOException, z zVar) {
        return (zVar.d() instanceof l) || (iOException instanceof FileNotFoundException);
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private z a(ab abVar, ad adVar) throws IOException {
        String a2;
        t c;
        if (abVar == null) {
            throw new IllegalStateException();
        }
        int b = abVar.b();
        String b2 = abVar.a().b();
        switch (b) {
            case 300:
            case 301:
            case 302:
            case INTLMethodID.INTL_METHOD_ID_WEBVIEW_JS_CALL /* 303 */:
                break;
            case 307:
            case 308:
                if (!b2.equals("GET") && !b2.equals("HEAD")) {
                    return null;
                }
                break;
            case 401:
                return this.f7076a.o().authenticate(adVar, abVar);
            case INTLMethodID.INTL_METHOD_ID_PUSH_NOTIFICATION_CALLBACK /* 407 */:
                if (adVar.b().type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.f7076a.p().authenticate(adVar, abVar);
            case INTLMethodID.INTL_METHOD_ID_PUSH_NOTIFICATION_SHOW /* 408 */:
                if (!this.f7076a.t() || (abVar.a().d() instanceof l)) {
                    return null;
                }
                if ((abVar.i() == null || abVar.i().b() != 408) && a(abVar, 0) <= 0) {
                    return abVar.a();
                }
                return null;
            case 503:
                if ((abVar.i() == null || abVar.i().b() != 503) && a(abVar, Integer.MAX_VALUE) == 0) {
                    return abVar.a();
                }
                return null;
            default:
                return null;
        }
        if (!this.f7076a.s() || (a2 = abVar.a(HttpHeader.LOCATION)) == null || (c = abVar.a().a().c(a2)) == null) {
            return null;
        }
        if (!c.b().equals(abVar.a().a().b()) && !this.f7076a.r()) {
            return null;
        }
        z.a e = abVar.a().e();
        if (f.c(b2)) {
            boolean d = f.d(b2);
            if (f.e(b2)) {
                e.a("GET", (aa) null);
            } else {
                e.a(b2, d ? abVar.a().d() : null);
            }
            if (!d) {
                e.b("Transfer-Encoding");
                e.b("Content-Length");
                e.b("Content-Type");
            }
        }
        if (!a(abVar, c)) {
            e.b("Authorization");
        }
        return e.a(c).b();
    }

    private int a(ab abVar, int i) {
        String a2 = abVar.a("Retry-After");
        if (a2 == null) {
            return i;
        }
        if (a2.matches("\\d+")) {
            return Integer.valueOf(a2).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean a(ab abVar, t tVar) {
        t a2 = abVar.a().a();
        return a2.f().equals(tVar.f()) && a2.g() == tVar.g() && a2.b().equals(tVar.b());
    }
}
