package com.uqm.crashsight.proguard;

import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static String f6621a = "CrashSightReportInfo";
    private static String b = "CrashSightReport";

    private static boolean a(int i, String str, Object... objArr) {
        if (str == null) {
            str = Constants.NULL_VERSION_ID;
        } else if (objArr != null && objArr.length != 0) {
            str = String.format(Locale.US, str, objArr);
        }
        if (i != 5) {
            switch (i) {
                case 0:
                    Log.i(b, str);
                    return true;
                case 1:
                    Log.d(b, str);
                    return true;
                case 2:
                    Log.w(b, str);
                    return true;
                case 3:
                    Log.e(b, str);
                    return true;
                default:
                    return false;
            }
        }
        Log.i(f6621a, str);
        return true;
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean b(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean a(Throwable th) {
        return a(3, q.a(th), new Object[0]);
    }
}
