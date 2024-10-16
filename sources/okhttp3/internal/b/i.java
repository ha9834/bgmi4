package okhttp3.internal.b;

import java.net.Proxy;
import okhttp3.t;
import okhttp3.z;

/* loaded from: classes3.dex */
public final class i {
    public static String a(z zVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(zVar.b());
        sb.append(' ');
        if (b(zVar, type)) {
            sb.append(zVar.a());
        } else {
            sb.append(a(zVar.a()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(z zVar, Proxy.Type type) {
        return !zVar.g() && type == Proxy.Type.HTTP;
    }

    public static String a(t tVar) {
        String h = tVar.h();
        String k = tVar.k();
        if (k == null) {
            return h;
        }
        return h + '?' + k;
    }
}
