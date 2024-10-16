package kotlinx.coroutines;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final List<CoroutineExceptionHandler> f7021a = kotlin.f.c.b(kotlin.f.c.a(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));

    public static final void a(kotlin.coroutines.e eVar, Throwable th) {
        Iterator<CoroutineExceptionHandler> it = f7021a.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(eVar, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, k.a(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
