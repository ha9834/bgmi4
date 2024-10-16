package androidx.f;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f596a;
    private static Method b;

    @SuppressLint({"NewApi"})
    public static boolean a() {
        try {
            if (b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return c();
    }

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a(str);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a();
        }
    }

    private static boolean c() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (b == null) {
                    f596a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                return ((Boolean) b.invoke(null, Long.valueOf(f596a))).booleanValue();
            } catch (Exception e) {
                a("isTagEnabled", e);
            }
        }
        return false;
    }

    private static void a(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }
}
