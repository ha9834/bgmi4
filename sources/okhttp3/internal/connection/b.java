package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.k;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<k> f7085a;
    private int b = 0;
    private boolean c;
    private boolean d;

    public b(List<k> list) {
        this.f7085a = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public k a(SSLSocket sSLSocket) throws IOException {
        k kVar;
        int i = this.b;
        int size = this.f7085a.size();
        while (true) {
            if (i >= size) {
                kVar = null;
                break;
            }
            kVar = this.f7085a.get(i);
            if (kVar.a(sSLSocket)) {
                this.b = i + 1;
                break;
            }
            i++;
        }
        if (kVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.f7085a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.c = b(sSLSocket);
        okhttp3.internal.a.f7061a.a(kVar, sSLSocket, this.d);
        return kVar;
    }

    public boolean a(IOException iOException) {
        this.d = true;
        if (!this.c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.b; i < this.f7085a.size(); i++) {
            if (this.f7085a.get(i).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
