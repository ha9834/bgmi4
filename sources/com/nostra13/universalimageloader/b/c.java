package com.nostra13.universalimageloader.b;

import android.util.Log;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f5718a = false;
    private static volatile boolean b = true;

    public static void a(boolean z) {
        f5718a = z;
    }

    public static void a(String str, Object... objArr) {
        if (f5718a) {
            a(3, null, str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        a(4, null, str, objArr);
    }

    public static void c(String str, Object... objArr) {
        a(5, null, str, objArr);
    }

    public static void a(Throwable th) {
        a(6, th, null, new Object[0]);
    }

    public static void d(String str, Object... objArr) {
        a(6, null, str, objArr);
    }

    private static void a(int i, Throwable th, String str, Object... objArr) {
        if (b) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (str == null) {
                    str = th.getMessage();
                }
                str = String.format("%1$s\n%2$s", str, Log.getStackTraceString(th));
            }
            Log.println(i, com.nostra13.universalimageloader.core.d.f5744a, str);
        }
    }
}
