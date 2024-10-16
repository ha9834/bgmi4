package com.uqm.crashsight.crashreport;

import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import com.uqm.crashsight.b;
import com.uqm.crashsight.proguard.o;

/* loaded from: classes.dex */
public class CrashSightLog {
    public static void v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = Constants.NULL_VERSION_ID;
        }
        if (b.c) {
            Log.v(str, str2);
        }
        o.a("V", str, str2);
    }

    public static void d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = Constants.NULL_VERSION_ID;
        }
        if (b.c) {
            Log.d(str, str2);
        }
        o.a("D", str, str2);
    }

    public static void i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = Constants.NULL_VERSION_ID;
        }
        if (b.c) {
            Log.i(str, str2);
        }
        o.a("I", str, str2);
    }

    public static void w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = Constants.NULL_VERSION_ID;
        }
        if (b.c) {
            Log.w(str, str2);
        }
        o.a("W", str, str2);
    }

    public static void e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = Constants.NULL_VERSION_ID;
        }
        if (b.c) {
            Log.e(str, str2);
        }
        o.a("E", str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = Constants.NULL_VERSION_ID;
        }
        if (b.c) {
            Log.e(str, str2, th);
        }
        o.a("E", str, th);
    }

    public static void setCache(int i) {
        o.a(i);
    }
}
