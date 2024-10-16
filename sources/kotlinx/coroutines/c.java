package kotlinx.coroutines;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class c extends y {
    public static final c b = new c();
    private static final int e;
    private static boolean f;
    private static volatile Executor pool;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public static final b f6995a = new b();

        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    @Override // kotlinx.coroutines.i
    public String toString() {
        return "CommonPool";
    }

    static {
        String str;
        int i;
        c cVar = b;
        try {
            str = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null) {
            Integer a2 = kotlin.text.l.a(str);
            if (a2 == null || a2.intValue() < 1) {
                throw new IllegalStateException(("Expected positive number in kotlinx.coroutines.default.parallelism, but has " + str).toString());
            }
            i = a2.intValue();
        } else {
            i = -1;
        }
        e = i;
    }

    private c() {
    }

    private final int a() {
        Integer valueOf = Integer.valueOf(e);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        return valueOf != null ? valueOf.intValue() : kotlin.d.d.c(Runtime.getRuntime().availableProcessors() - 1, 1);
    }

    private final ExecutorService b() {
        Class<?> cls;
        ExecutorService executorService;
        if (System.getSecurityManager() != null) {
            return c();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return c();
        }
        if (!f && e < 0) {
            try {
                Method method = cls.getMethod("commonPool", new Class[0]);
                Object invoke = method != null ? method.invoke(null, new Object[0]) : null;
                if (!(invoke instanceof ExecutorService)) {
                    invoke = null;
                }
                executorService = (ExecutorService) invoke;
            } catch (Throwable unused2) {
                executorService = null;
            }
            if (executorService != null) {
                if (!b.a(cls, executorService)) {
                    executorService = null;
                }
                if (executorService != null) {
                    return executorService;
                }
            }
        }
        try {
            Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(b.a()));
            if (!(newInstance instanceof ExecutorService)) {
                newInstance = null;
            }
            executorService2 = (ExecutorService) newInstance;
        } catch (Throwable unused3) {
        }
        return executorService2 != null ? executorService2 : c();
    }

    public final boolean a(Class<?> cls, ExecutorService executorService) {
        Integer num;
        executorService.submit(b.f6995a);
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (!(invoke instanceof Integer)) {
                invoke = null;
            }
            num = (Integer) invoke;
        } catch (Throwable unused) {
            num = null;
        }
        return num != null && num.intValue() >= 1;
    }

    private final ExecutorService c() {
        return Executors.newFixedThreadPool(a(), new a(new AtomicInteger()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f6994a;

        a(AtomicInteger atomicInteger) {
            this.f6994a = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "CommonPool-worker-" + this.f6994a.incrementAndGet());
            thread.setDaemon(true);
            return thread;
        }
    }

    private final synchronized Executor d() {
        ExecutorService executorService;
        executorService = pool;
        if (executorService == null) {
            ExecutorService b2 = b();
            pool = b2;
            executorService = b2;
        }
        return executorService;
    }

    @Override // kotlinx.coroutines.i
    public void a(kotlin.coroutines.e eVar, Runnable runnable) {
        Runnable runnable2;
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = d();
            }
            af a2 = ag.a();
            if (a2 == null || (runnable2 = a2.a(runnable)) == null) {
                runnable2 = runnable;
            }
            executor.execute(runnable2);
        } catch (RejectedExecutionException unused) {
            af a3 = ag.a();
            if (a3 != null) {
                a3.c();
            }
            p.b.a(runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }
}
