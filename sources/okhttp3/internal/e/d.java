package okhttp3.internal.e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends g {

    /* renamed from: a, reason: collision with root package name */
    final Method f7097a;
    final Method b;

    d(Method method, Method method2) {
        this.f7097a = method;
        this.b = method2;
    }

    @Override // okhttp3.internal.e.g
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a2 = a(list);
            this.f7097a.invoke(sSLParameters, a2.toArray(new String[a2.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.internal.c.a("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // okhttp3.internal.e.g
    @Nullable
    public String a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.b.invoke(sSLSocket, new Object[0]);
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
            return null;
        } catch (IllegalAccessException e) {
            throw okhttp3.internal.c.a("failed to get ALPN selected protocol", (Exception) e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof UnsupportedOperationException) {
                return null;
            }
            throw okhttp3.internal.c.a("failed to get ALPN selected protocol", (Exception) e2);
        }
    }

    public static d a() {
        try {
            return new d(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
