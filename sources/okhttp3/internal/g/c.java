package okhttp3.internal.g;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.e.g;

/* loaded from: classes3.dex */
public abstract class c {
    public abstract List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    public static c a(X509TrustManager x509TrustManager) {
        return g.e().a(x509TrustManager);
    }
}
