package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.ac;

/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final ac f7013a;
    public static final i b;
    private static final boolean c;

    static {
        i iVar = new i();
        b = iVar;
        c = n.a("kotlinx.coroutines.fast.service.loader", true);
        f7013a = iVar.a();
    }

    private i() {
    }

    private final ac a() {
        Object next;
        ac a2;
        try {
            List<MainDispatcherFactory> a3 = c ? e.f7008a.a() : kotlin.f.c.b(kotlin.f.c.a(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
            Iterator<T> it = a3.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            return (mainDispatcherFactory == null || (a2 = j.a(mainDispatcherFactory, a3)) == null) ? j.a(null, null, 3, null) : a2;
        } catch (Throwable th) {
            return j.a(th, null, 2, null);
        }
    }
}
