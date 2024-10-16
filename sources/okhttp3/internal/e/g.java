package okhttp3.internal.e;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.x;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final g f7101a = a();
    private static final Logger b = Logger.getLogger(x.class.getName());

    @Nullable
    public String a(SSLSocket sSLSocket) {
        return null;
    }

    public void a(SSLSocket sSLSocket, @Nullable String str, List<Protocol> list) throws IOException {
    }

    public void a(SSLSocketFactory sSLSocketFactory) {
    }

    public void b(SSLSocket sSLSocket) {
    }

    public boolean b(String str) {
        return true;
    }

    public static g e() {
        return f7101a;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(int i, String str, @Nullable Throwable th) {
        b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public static List<String> a(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    public okhttp3.internal.g.c a(X509TrustManager x509TrustManager) {
        return new okhttp3.internal.g.a(b(x509TrustManager));
    }

    public static boolean f() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    private static g a() {
        if (g()) {
            return d();
        }
        return b();
    }

    public static boolean g() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    private static g b() {
        c a2;
        if (f() && (a2 = c.a()) != null) {
            return a2;
        }
        d a3 = d.a();
        if (a3 != null) {
            return a3;
        }
        g a4 = e.a();
        return a4 != null ? a4 : new g();
    }

    private static g d() {
        g a2 = a.a();
        if (a2 != null) {
            return a2;
        }
        g b2 = b.b();
        if (b2 != null) {
            return b2;
        }
        throw new NullPointerException("No platform found on Android");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b(List<Protocol> list) {
        okio.c cVar = new okio.c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                cVar.i(protocol.toString().length());
                cVar.b(protocol.toString());
            }
        }
        return cVar.s();
    }

    public SSLContext c() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public okhttp3.internal.g.e b(X509TrustManager x509TrustManager) {
        return new okhttp3.internal.g.b(x509TrustManager.getAcceptedIssuers());
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
