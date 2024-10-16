package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final TlsVersion f7154a;
    private final h b;
    private final List<Certificate> c;
    private final List<Certificate> d;

    private r(TlsVersion tlsVersion, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.f7154a = tlsVersion;
        this.b = hVar;
        this.c = list;
        this.d = list2;
    }

    public static r a(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        h a2 = h.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        TlsVersion a3 = TlsVersion.a(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        if (certificateArr != null) {
            emptyList = okhttp3.internal.c.a(certificateArr);
        } else {
            emptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            emptyList2 = okhttp3.internal.c.a(localCertificates);
        } else {
            emptyList2 = Collections.emptyList();
        }
        return new r(a3, a2, emptyList, emptyList2);
    }

    public h a() {
        return this.b;
    }

    public List<Certificate> b() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f7154a.equals(rVar.f7154a) && this.b.equals(rVar.b) && this.c.equals(rVar.c) && this.d.equals(rVar.d);
    }

    public int hashCode() {
        return ((((((527 + this.f7154a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }
}
