package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f794a = new HashMap();
    private volatile boolean b = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        this.b = true;
        Map<String, Object> map = this.f794a;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.f794a.values().iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T a(String str, T t) {
        Object obj;
        synchronized (this.f794a) {
            obj = this.f794a.get(str);
            if (obj == 0) {
                this.f794a.put(str, t);
            }
        }
        if (obj != 0) {
            t = obj;
        }
        if (this.b) {
            a(t);
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> T b(String str) {
        T t;
        Map<String, Object> map = this.f794a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = (T) this.f794a.get(str);
        }
        return t;
    }

    private static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
