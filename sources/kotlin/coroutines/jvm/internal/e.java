package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f6955a = new e();
    private static final a b = new a(null, null, null);
    private static a c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Method f6956a;
        public final Method b;
        public final Method c;

        public a(Method method, Method method2, Method method3) {
            this.f6956a = method;
            this.b = method2;
            this.c = method3;
        }
    }

    private e() {
    }

    public final String a(BaseContinuationImpl baseContinuationImpl) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        h.b(baseContinuationImpl, "continuation");
        a aVar = c;
        if (aVar == null) {
            aVar = b(baseContinuationImpl);
        }
        if (aVar == b || (method = aVar.f6956a) == null || (invoke = method.invoke(baseContinuationImpl.getClass(), new Object[0])) == null || (method2 = aVar.b) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (!(invoke3 instanceof String)) {
            invoke3 = null;
        }
        return (String) invoke3;
    }

    private final a b(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = b;
            c = aVar2;
            return aVar2;
        }
    }
}
