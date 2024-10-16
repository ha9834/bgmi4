package okhttp3.internal.e;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends g {

    /* renamed from: a, reason: collision with root package name */
    private final Method f7098a;
    private final Method b;
    private final Method c;
    private final Class<?> d;
    private final Class<?> e;

    e(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f7098a = method;
        this.b = method2;
        this.c = method3;
        this.d = cls;
        this.e = cls2;
    }

    @Override // okhttp3.internal.e.g
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            this.f7098a.invoke(null, sSLSocket, Proxy.newProxyInstance(g.class.getClassLoader(), new Class[]{this.d, this.e}, new a(a(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.internal.c.a("unable to set alpn", (Exception) e);
        }
    }

    @Override // okhttp3.internal.e.g
    public void b(SSLSocket sSLSocket) {
        try {
            this.c.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.internal.c.a("unable to remove alpn", (Exception) e);
        }
    }

    @Override // okhttp3.internal.e.g
    @Nullable
    public String a(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.b.invoke(null, sSLSocket));
            if (!aVar.f7099a && aVar.b == null) {
                g.e().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (aVar.f7099a) {
                return null;
            }
            return aVar.b;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw okhttp3.internal.c.a("unable to get selected protocol", (Exception) e);
        }
    }

    public static g a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new e(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod(ProductAction.ACTION_REMOVE, SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    /* loaded from: classes3.dex */
    private static class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        boolean f7099a;
        String b;
        private final List<String> c;

        a(List<String> list) {
            this.c = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = okhttp3.internal.c.b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f7099a = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.c;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                List list = (List) objArr[0];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (this.c.contains(list.get(i))) {
                        String str = (String) list.get(i);
                        this.b = str;
                        return str;
                    }
                }
                String str2 = this.c.get(0);
                this.b = str2;
                return str2;
            }
            if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                this.b = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }
}
