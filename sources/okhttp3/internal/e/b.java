package okhttp3.internal.e;

import android.os.Build;
import android.util.Log;
import com.google.android.gms.games.GamesStatusCodes;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends g {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f7093a;
    private final f<Socket> b;
    private final f<Socket> c;
    private final f<Socket> d;
    private final f<Socket> e;
    private final c f = c.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Class<?> cls, f<Socket> fVar, f<Socket> fVar2, f<Socket> fVar3, f<Socket> fVar4) {
        this.f7093a = cls;
        this.b = fVar;
        this.c = fVar2;
        this.d = fVar3;
        this.e = fVar4;
    }

    @Override // okhttp3.internal.e.g
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!okhttp3.internal.c.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e2);
                throw iOException;
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        }
    }

    @Override // okhttp3.internal.e.g
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        if (str != null) {
            this.b.b(sSLSocket, true);
            this.c.b(sSLSocket, str);
        }
        f<Socket> fVar = this.e;
        if (fVar == null || !fVar.a((f<Socket>) sSLSocket)) {
            return;
        }
        this.e.d(sSLSocket, b(list));
    }

    @Override // okhttp3.internal.e.g
    @Nullable
    public String a(SSLSocket sSLSocket) {
        byte[] bArr;
        f<Socket> fVar = this.d;
        if (fVar == null || !fVar.a((f<Socket>) sSLSocket) || (bArr = (byte[]) this.d.d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, okhttp3.internal.c.e);
    }

    @Override // okhttp3.internal.e.g
    public void a(int i, String str, @Nullable Throwable th) {
        int min;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                } else {
                    i3 = min;
                }
            }
            i3 = min + 1;
        }
    }

    @Override // okhttp3.internal.e.g
    public Object a(String str) {
        return this.f.a(str);
    }

    @Override // okhttp3.internal.e.g
    public void a(String str, Object obj) {
        if (this.f.a(obj)) {
            return;
        }
        a(5, str, (Throwable) null);
    }

    @Override // okhttp3.internal.e.g
    public boolean b(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return super.b(str);
        }
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException e) {
            e = e;
            throw okhttp3.internal.c.a("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw okhttp3.internal.c.a("unable to determine cleartext support", e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw okhttp3.internal.c.a("unable to determine cleartext support", e);
        }
    }

    private boolean a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return b(str, cls, obj);
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.b(str);
        }
    }

    private static boolean a() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // okhttp3.internal.e.g
    public okhttp3.internal.g.c a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    public static g b() {
        Class<?> cls;
        f fVar;
        f fVar2;
        if (!g.g()) {
            return null;
        }
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            f fVar3 = new f(null, "setUseSessionTickets", Boolean.TYPE);
            f fVar4 = new f(null, "setHostname", String.class);
            if (a()) {
                f fVar5 = new f(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                fVar2 = new f(null, "setAlpnProtocols", byte[].class);
                fVar = fVar5;
            } else {
                fVar = null;
                fVar2 = null;
            }
            return new b(cls, fVar3, fVar4, fVar, fVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    @Override // okhttp3.internal.e.g
    public okhttp3.internal.g.e b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new C0230b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(x509TrustManager);
        }
    }

    /* loaded from: classes3.dex */
    static final class a extends okhttp3.internal.g.c {

        /* renamed from: a, reason: collision with root package name */
        private final Object f7094a;
        private final Method b;

        public int hashCode() {
            return 0;
        }

        a(Object obj, Method method) {
            this.f7094a = obj;
            this.b = method;
        }

        @Override // okhttp3.internal.g.c
        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.b.invoke(this.f7094a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }
    }

    /* loaded from: classes3.dex */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Method f7096a;
        private final Method b;
        private final Method c;

        c(Method method, Method method2, Method method3) {
            this.f7096a = method;
            this.b = method2;
            this.c = method3;
        }

        Object a(String str) {
            Method method = this.f7096a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        static c a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new c(method3, method2, method);
        }
    }

    /* renamed from: okhttp3.internal.e.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0230b implements okhttp3.internal.g.e {

        /* renamed from: a, reason: collision with root package name */
        private final X509TrustManager f7095a;
        private final Method b;

        C0230b(X509TrustManager x509TrustManager, Method method) {
            this.b = method;
            this.f7095a = x509TrustManager;
        }

        @Override // okhttp3.internal.g.e
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.b.invoke(this.f7095a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw okhttp3.internal.c.a("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0230b)) {
                return false;
            }
            C0230b c0230b = (C0230b) obj;
            return this.f7095a.equals(c0230b.f7095a) && this.b.equals(c0230b.b);
        }

        public int hashCode() {
            return this.f7095a.hashCode() + (this.b.hashCode() * 31);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000b, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 22) goto L10;
     */
    @Override // okhttp3.internal.e.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public javax.net.ssl.SSLContext c() {
        /*
            r3 = this;
            r0 = 1
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NoClassDefFoundError -> Lf
            r2 = 16
            if (r1 < r2) goto Le
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NoClassDefFoundError -> Lf
            r2 = 22
            if (r1 >= r2) goto Le
            goto Lf
        Le:
            r0 = 0
        Lf:
            if (r0 == 0) goto L18
            java.lang.String r0 = "TLSv1.2"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch: java.security.NoSuchAlgorithmException -> L18
            return r0
        L18:
            java.lang.String r0 = "TLS"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch: java.security.NoSuchAlgorithmException -> L1f
            return r0
        L1f:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "No TLS provider"
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.e.b.c():javax.net.ssl.SSLContext");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }
}
