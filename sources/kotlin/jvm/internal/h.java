package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.UninitializedPropertyAccessException;

/* loaded from: classes3.dex */
public class h {
    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    private h() {
    }

    public static String a(String str, Object obj) {
        return str + obj;
    }

    public static void a(Object obj) {
        if (obj == null) {
            a();
        }
    }

    public static void a() {
        throw ((NullPointerException) a(new NullPointerException()));
    }

    public static void a(String str) {
        throw ((UninitializedPropertyAccessException) a(new UninitializedPropertyAccessException(str)));
    }

    public static void b(String str) {
        a("lateinit property " + str + " has not been initialized");
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) a(new NullPointerException(str + " must not be null")));
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            c(str);
        }
    }

    private static void c(String str) {
        throw ((NullPointerException) a(new NullPointerException(d(str))));
    }

    private static String d(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static <T extends Throwable> T a(T t) {
        return (T) a((Throwable) t, h.class.getName());
    }

    static <T extends Throwable> T a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }
}
