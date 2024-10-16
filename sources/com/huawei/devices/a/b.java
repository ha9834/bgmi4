package com.huawei.devices.a;

import android.util.Log;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5458a = 6;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    private static final String g = "log message error : ";

    private b() {
    }

    private static void a(String str, String str2) {
        Log.e(str, str2);
    }

    private static void b(String str, String str2) {
        Log.w(str, str2);
    }

    private static void c(String str, String str2) {
        Log.i(str, str2);
    }

    private static void d(String str, String str2) {
        Log.d(str, str2);
    }

    private static void e(String str, String str2) {
        Log.v(str, str2);
    }
}
