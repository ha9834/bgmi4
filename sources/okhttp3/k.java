package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class k {
    final boolean e;
    final boolean f;

    @Nullable
    final String[] g;

    @Nullable
    final String[] h;
    private static final h[] i = {h.bl, h.bm, h.bn, h.bo, h.bp, h.aX, h.bb, h.aY, h.bc, h.bi, h.bh};
    private static final h[] j = {h.bl, h.bm, h.bn, h.bo, h.bp, h.aX, h.bb, h.aY, h.bc, h.bi, h.bh, h.aI, h.aJ, h.ag, h.ah, h.E, h.I, h.i};

    /* renamed from: a, reason: collision with root package name */
    public static final k f7142a = new a(true).a(i).a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2).a(true).a();
    public static final k b = new a(true).a(j).a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).a(true).a();
    public static final k c = new a(true).a(j).a(TlsVersion.TLS_1_0).a(true).a();
    public static final k d = new a(false).a();

    k(a aVar) {
        this.e = aVar.f7143a;
        this.g = aVar.b;
        this.h = aVar.c;
        this.f = aVar.d;
    }

    public boolean a() {
        return this.e;
    }

    @Nullable
    public List<h> b() {
        String[] strArr = this.g;
        if (strArr != null) {
            return h.a(strArr);
        }
        return null;
    }

    @Nullable
    public List<TlsVersion> c() {
        String[] strArr = this.h;
        if (strArr != null) {
            return TlsVersion.a(strArr);
        }
        return null;
    }

    public boolean d() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z) {
        k b2 = b(sSLSocket, z);
        String[] strArr = b2.h;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b2.g;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    private k b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.g != null) {
            enabledCipherSuites = okhttp3.internal.c.a(h.f7059a, sSLSocket.getEnabledCipherSuites(), this.g);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.h != null) {
            enabledProtocols = okhttp3.internal.c.a(okhttp3.internal.c.h, sSLSocket.getEnabledProtocols(), this.h);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a2 = okhttp3.internal.c.a(h.f7059a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a2 != -1) {
            enabledCipherSuites = okhttp3.internal.c.a(enabledCipherSuites, supportedCipherSuites[a2]);
        }
        return new a(this).a(enabledCipherSuites).b(enabledProtocols).a();
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.e) {
            return false;
        }
        if (this.h == null || okhttp3.internal.c.b(okhttp3.internal.c.h, this.h, sSLSocket.getEnabledProtocols())) {
            return this.g == null || okhttp3.internal.c.b(h.f7059a, this.g, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        boolean z = this.e;
        if (z != kVar.e) {
            return false;
        }
        return !z || (Arrays.equals(this.g, kVar.g) && Arrays.equals(this.h, kVar.h) && this.f == kVar.f);
    }

    public int hashCode() {
        if (this.e) {
            return ((((527 + Arrays.hashCode(this.g)) * 31) + Arrays.hashCode(this.h)) * 31) + (!this.f ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.e) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.g != null ? b().toString() : "[all enabled]") + ", tlsVersions=" + (this.h != null ? c().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f + ")";
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f7143a;

        @Nullable
        String[] b;

        @Nullable
        String[] c;
        boolean d;

        a(boolean z) {
            this.f7143a = z;
        }

        public a(k kVar) {
            this.f7143a = kVar.e;
            this.b = kVar.g;
            this.c = kVar.h;
            this.d = kVar.f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public a a(h... hVarArr) {
            if (!this.f7143a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[hVarArr.length];
            for (int i = 0; i < hVarArr.length; i++) {
                strArr[i] = hVarArr[i].bq;
            }
            return a(strArr);
        }

        public a a(String... strArr) {
            if (!this.f7143a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.b = (String[]) strArr.clone();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public a a(TlsVersion... tlsVersionArr) {
            if (!this.f7143a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[tlsVersionArr.length];
            for (int i = 0; i < tlsVersionArr.length; i++) {
                strArr[i] = tlsVersionArr[i].javaName;
            }
            return b(strArr);
        }

        public a b(String... strArr) {
            if (!this.f7143a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.c = (String[]) strArr.clone();
            return this;
        }

        public a a(boolean z) {
            if (!this.f7143a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.d = z;
            return this;
        }

        public k a() {
            return new k(this);
        }
    }
}
