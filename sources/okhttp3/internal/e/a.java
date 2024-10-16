package okhttp3.internal.e;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class a extends b {
    a(Class<?> cls) {
        super(cls, null, null, null, null);
    }

    @Override // okhttp3.internal.e.b, okhttp3.internal.e.g
    @SuppressLint({"NewApi"})
    @IgnoreJRERequirement
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        try {
            c(sSLSocket);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((String[]) g.a(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }

    private void c(SSLSocket sSLSocket) {
        if (SSLSockets.isSupportedSocket(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    @Override // okhttp3.internal.e.b, okhttp3.internal.e.g
    @Nullable
    @IgnoreJRERequirement
    public String a(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }

    @Nullable
    public static g a() {
        if (!g.g()) {
            return null;
        }
        try {
            if (d() >= 29) {
                return new a(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
        } catch (ClassNotFoundException unused) {
        }
        return null;
    }
}
