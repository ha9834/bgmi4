package com.uqm.crashsight.proguard;

import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static String f6622a = "CrashSightReport";
    public static boolean b = false;
    private static String c = "CrashSightReportInfo";

    private static boolean a(int i, String str, Object... objArr) {
        if (!b) {
            return false;
        }
        if (str == null) {
            str = Constants.NULL_VERSION_ID;
        } else if (objArr != null && objArr.length != 0) {
            str = String.format(Locale.US, str, objArr);
        }
        if (i != 5) {
            switch (i) {
                case 0:
                    Log.i(f6622a, str);
                    return true;
                case 1:
                    Log.d(f6622a, str);
                    return true;
                case 2:
                    Log.w(f6622a, str);
                    return true;
                case 3:
                    Log.e(f6622a, str);
                    return true;
                default:
                    return false;
            }
        }
        Log.i(c, str);
        return true;
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean b(Class cls, String str, Object... objArr) {
        return a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean a(Throwable th) {
        if (b) {
            return a(2, q.a(th), new Object[0]);
        }
        return false;
    }

    public static boolean e(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean b(Throwable th) {
        if (b) {
            return a(3, q.a(th), new Object[0]);
        }
        return false;
    }
}
