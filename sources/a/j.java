package a;

import a.c;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final j f42a = c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Method method) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Executor b() {
        return null;
    }

    j() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a() {
        return f42a;
    }

    private static j c() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            try {
                Class.forName("java.util.Optional");
                return new c();
            } catch (ClassNotFoundException unused2) {
                return new j();
            }
        } catch (ClassNotFoundException unused3) {
            Class.forName("org.robovm.apple.foundation.NSObject");
            return new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c.a a(Executor executor) {
        if (executor != null) {
            return new g(executor);
        }
        return f.f16a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @IgnoreJRERequirement
    /* loaded from: classes.dex */
    public static class c extends j {
        c() {
        }

        @Override // a.j
        boolean a(Method method) {
            return method.isDefault();
        }

        @Override // a.j
        Object a(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends j {
        a() {
        }

        @Override // a.j
        public Executor b() {
            return new ExecutorC0003a();
        }

        @Override // a.j
        c.a a(Executor executor) {
            return new g(executor);
        }

        /* renamed from: a.j$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class ExecutorC0003a implements Executor {

            /* renamed from: a, reason: collision with root package name */
            private final Handler f43a = new Handler(Looper.getMainLooper());

            ExecutorC0003a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f43a.post(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends j {
        b() {
        }

        @Override // a.j
        public Executor b() {
            return new a();
        }

        @Override // a.j
        c.a a(Executor executor) {
            return new g(executor);
        }

        /* loaded from: classes.dex */
        static class a implements Executor {

            /* renamed from: a, reason: collision with root package name */
            private static Object f44a;
            private static Method b;

            a() {
            }

            static {
                try {
                    Class<?> cls = Class.forName("org.robovm.apple.foundation.NSOperationQueue");
                    f44a = cls.getDeclaredMethod("getMainQueue", new Class[0]).invoke(null, new Object[0]);
                    b = cls.getDeclaredMethod("addOperation", Runnable.class);
                } catch (Exception e) {
                    throw new AssertionError(e);
                }
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                try {
                    b.invoke(f44a, runnable);
                } catch (IllegalAccessException e) {
                    e = e;
                    throw new AssertionError(e);
                } catch (IllegalArgumentException e2) {
                    e = e2;
                    throw new AssertionError(e);
                } catch (InvocationTargetException e3) {
                    Throwable cause = e3.getCause();
                    if (cause instanceof RuntimeException) {
                        throw ((RuntimeException) cause);
                    }
                    if (cause instanceof Error) {
                        throw ((Error) cause);
                    }
                    throw new RuntimeException(cause);
                }
            }
        }
    }
}
