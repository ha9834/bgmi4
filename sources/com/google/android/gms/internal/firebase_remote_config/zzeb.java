package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public final class zzeb {

    /* renamed from: a, reason: collision with root package name */
    @NullableDecl
    private static final Object f4158a;

    @NullableDecl
    private static final Method b;

    @NullableDecl
    private static final Method c;

    @Deprecated
    public static RuntimeException zzb(Throwable th) {
        zzdt.checkNotNull(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new RuntimeException(th);
    }

    @NullableDecl
    private static Object a() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    @NullableDecl
    private static Method b() {
        try {
            Method a2 = a("getStackTraceDepth", Throwable.class);
            if (a2 == null) {
                return null;
            }
            a2.invoke(a(), new Throwable());
            return a2;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    @NullableDecl
    private static Method a(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    static {
        Object a2 = a();
        f4158a = a2;
        b = a2 == null ? null : a("getStackTraceElement", Throwable.class, Integer.TYPE);
        c = f4158a != null ? b() : null;
    }
}
