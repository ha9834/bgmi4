package com.tencent.gsdk.utils;

import android.util.Log;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6245a = false;
    private static String b = "gsdk";

    public static void a(String str) {
        if (f6245a) {
            Log.i(b, str);
        }
    }

    public static void b(String str) {
        if (f6245a) {
            Log.d(b, str);
        }
    }

    public static void c(String str) {
        if (f6245a) {
            Log.w(b, str);
        }
    }

    public static void d(String str) {
        if (f6245a) {
            Log.e(b, str);
        }
    }
}
