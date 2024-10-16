package okhttp3;

import com.facebook.internal.security.CertificateUtil;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f7056a = new a().a();
    private final Set<b> b;

    @Nullable
    private final okhttp3.internal.g.c c;

    g(Set<b> set, @Nullable okhttp3.internal.g.c cVar) {
        this.b = set;
        this.c = cVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (okhttp3.internal.c.a(this.c, gVar.c) && this.b.equals(gVar.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        okhttp3.internal.g.c cVar = this.c;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.b.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> a2 = a(str);
        if (a2.isEmpty()) {
            return;
        }
        okhttp3.internal.g.c cVar = this.c;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = a2.size();
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                b bVar = a2.get(i2);
                if (bVar.c.equals("sha256/")) {
                    if (byteString == null) {
                        byteString = b(x509Certificate);
                    }
                    if (bVar.d.equals(byteString)) {
                        return;
                    }
                } else if (bVar.c.equals("sha1/")) {
                    if (byteString2 == null) {
                        byteString2 = a(x509Certificate);
                    }
                    if (bVar.d.equals(byteString2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + bVar.c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(CertificateUtil.DELIMITER);
        int size4 = a2.size();
        for (int i4 = 0; i4 < size4; i4++) {
            b bVar2 = a2.get(i4);
            sb.append("\n    ");
            sb.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.b) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g a(@Nullable okhttp3.internal.g.c cVar) {
        return okhttp3.internal.c.a(this.c, cVar) ? this : new g(this.b, cVar);
    }

    public static String a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + b((X509Certificate) certificate).b();
    }

    static ByteString a(X509Certificate x509Certificate) {
        return ByteString.a(x509Certificate.getPublicKey().getEncoded()).c();
    }

    static ByteString b(X509Certificate x509Certificate) {
        return ByteString.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final String f7058a;
        final String b;
        final String c;
        final ByteString d;

        b(String str, String str2) {
            String f;
            this.f7058a = str;
            if (str.startsWith("*.")) {
                f = t.f("http://" + str.substring(2)).f();
            } else {
                f = t.f("http://" + str).f();
            }
            this.b = f;
            if (str2.startsWith("sha1/")) {
                this.c = "sha1/";
                this.d = ByteString.b(str2.substring(5));
            } else if (str2.startsWith("sha256/")) {
                this.c = "sha256/";
                this.d = ByteString.b(str2.substring(7));
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
            }
            if (this.d != null) {
                return;
            }
            throw new IllegalArgumentException("pins must be base64: " + str2);
        }

        boolean a(String str) {
            if (this.f7058a.startsWith("*.")) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.b.length()) {
                    String str2 = this.b;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f7058a.equals(bVar.f7058a) && this.c.equals(bVar.c) && this.d.equals(bVar.d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f7058a.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return this.c + this.d.b();
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<b> f7057a = new ArrayList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public a a(String str, String... strArr) {
            if (str == null) {
                throw new NullPointerException("pattern == null");
            }
            for (String str2 : strArr) {
                this.f7057a.add(new b(str, str2));
            }
            return this;
        }

        public g a() {
            return new g(new LinkedHashSet(this.f7057a), null);
        }
    }
}
