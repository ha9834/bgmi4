package okhttp3.internal.connection;

import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.ad;
import okhttp3.p;
import okhttp3.t;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final okhttp3.a f7088a;
    private final d b;
    private final okhttp3.e c;
    private final p d;
    private int f;
    private List<Proxy> e = Collections.emptyList();
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<ad> h = new ArrayList();

    public e(okhttp3.a aVar, d dVar, okhttp3.e eVar, p pVar) {
        this.f7088a = aVar;
        this.b = dVar;
        this.c = eVar;
        this.d = pVar;
        a(aVar.a(), aVar.h());
    }

    public boolean a() {
        return c() || !this.h.isEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public a b() throws IOException {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (c()) {
            Proxy d = d();
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                ad adVar = new ad(this.f7088a, d, this.g.get(i));
                if (this.b.c(adVar)) {
                    this.h.add(adVar);
                } else {
                    arrayList.add(adVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.h);
            this.h.clear();
        }
        return new a(arrayList);
    }

    public void a(ad adVar, IOException iOException) {
        if (adVar.b().type() != Proxy.Type.DIRECT && this.f7088a.g() != null) {
            this.f7088a.g().connectFailed(this.f7088a.a().a(), adVar.b().address(), iOException);
        }
        this.b.a(adVar);
    }

    private void a(t tVar, Proxy proxy) {
        List<Proxy> a2;
        if (proxy != null) {
            this.e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f7088a.g().select(tVar.a());
            if (select != null && !select.isEmpty()) {
                a2 = okhttp3.internal.c.a(select);
            } else {
                a2 = okhttp3.internal.c.a(Proxy.NO_PROXY);
            }
            this.e = a2;
        }
        this.f = 0;
    }

    private boolean c() {
        return this.f < this.e.size();
    }

    private Proxy d() throws IOException {
        if (!c()) {
            throw new SocketException("No route to " + this.f7088a.a().f() + "; exhausted proxy configurations: " + this.e);
        }
        List<Proxy> list = this.e;
        int i = this.f;
        this.f = i + 1;
        Proxy proxy = list.get(i);
        a(proxy);
        return proxy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void a(Proxy proxy) throws IOException {
        String f;
        int g;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            f = this.f7088a.a().f();
            g = this.f7088a.a().g();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            f = a(inetSocketAddress);
            g = inetSocketAddress.getPort();
        }
        if (g < 1 || g > 65535) {
            throw new SocketException("No route to " + f + CertificateUtil.DELIMITER + g + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(f, g));
            return;
        }
        this.d.a(this.c, f);
        List<InetAddress> a2 = this.f7088a.b().a(f);
        if (a2.isEmpty()) {
            throw new UnknownHostException(this.f7088a.b() + " returned no addresses for " + f);
        }
        this.d.a(this.c, f, a2);
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            this.g.add(new InetSocketAddress(a2.get(i), g));
        }
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<ad> f7089a;
        private int b = 0;

        a(List<ad> list) {
            this.f7089a = list;
        }

        public boolean a() {
            return this.b < this.f7089a.size();
        }

        public ad b() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            List<ad> list = this.f7089a;
            int i = this.b;
            this.b = i + 1;
            return list.get(i);
        }

        public List<ad> c() {
            return new ArrayList(this.f7089a);
        }
    }
}
