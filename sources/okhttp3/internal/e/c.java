package okhttp3.internal.e;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;

/* loaded from: classes.dex */
public class c extends g {
    private c() {
    }

    private Provider b() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // okhttp3.internal.e.g
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) g.a(list).toArray(new String[0]));
            return;
        }
        super.a(sSLSocket, str, list);
    }

    @Override // okhttp3.internal.e.g
    @Nullable
    public String a(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.a(sSLSocket);
    }

    @Override // okhttp3.internal.e.g
    public SSLContext c() {
        try {
            return SSLContext.getInstance("TLSv1.3", b());
        } catch (NoSuchAlgorithmException e) {
            try {
                return SSLContext.getInstance("TLS", b());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e);
            }
        }
    }

    public static c a() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (Conscrypt.isAvailable()) {
                return new c();
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Override // okhttp3.internal.e.g
    public void a(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }
}
