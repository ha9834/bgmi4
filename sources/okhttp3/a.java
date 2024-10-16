package okhttp3;

import com.facebook.internal.security.CertificateUtil;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.t;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    final t f7043a;
    final o b;
    final SocketFactory c;
    final b d;
    final List<Protocol> e;
    final List<k> f;
    final ProxySelector g;

    @Nullable
    final Proxy h;

    @Nullable
    final SSLSocketFactory i;

    @Nullable
    final HostnameVerifier j;

    @Nullable
    final g k;

    public a(String str, int i, o oVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable g gVar, b bVar, @Nullable Proxy proxy, List<Protocol> list, List<k> list2, ProxySelector proxySelector) {
        this.f7043a = new t.a().a(sSLSocketFactory != null ? "https" : "http").d(str).a(i).c();
        if (oVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.b = oVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.c = socketFactory;
        if (bVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.d = bVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.e = okhttp3.internal.c.a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f = okhttp3.internal.c.a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = gVar;
    }

    public t a() {
        return this.f7043a;
    }

    public o b() {
        return this.b;
    }

    public SocketFactory c() {
        return this.c;
    }

    public b d() {
        return this.d;
    }

    public List<Protocol> e() {
        return this.e;
    }

    public List<k> f() {
        return this.f;
    }

    public ProxySelector g() {
        return this.g;
    }

    @Nullable
    public Proxy h() {
        return this.h;
    }

    @Nullable
    public SSLSocketFactory i() {
        return this.i;
    }

    @Nullable
    public HostnameVerifier j() {
        return this.j;
    }

    @Nullable
    public g k() {
        return this.k;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f7043a.equals(aVar.f7043a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f7043a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Proxy proxy = this.h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        g gVar = this.k;
        return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        return this.b.equals(aVar.b) && this.d.equals(aVar.d) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && okhttp3.internal.c.a(this.h, aVar.h) && okhttp3.internal.c.a(this.i, aVar.i) && okhttp3.internal.c.a(this.j, aVar.j) && okhttp3.internal.c.a(this.k, aVar.k) && a().g() == aVar.a().g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f7043a.f());
        sb.append(CertificateUtil.DELIMITER);
        sb.append(this.f7043a.g());
        if (this.h != null) {
            sb.append(", proxy=");
            sb.append(this.h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.g);
        }
        sb.append("}");
        return sb.toString();
    }
}
