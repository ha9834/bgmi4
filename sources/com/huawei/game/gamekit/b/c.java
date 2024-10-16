package com.huawei.game.gamekit.b;

import android.util.Log;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f5473a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5;
    private static int g = 3;

    private c() {
    }

    public static void a(String str, String str2) {
        if (g >= 4) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (g >= 3) {
            Log.i(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (g >= 2) {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (g > 0) {
            Log.e(str, str2);
        }
    }

    private static void e(String str, String str2) {
        if (g >= 5) {
            Log.v(str, str2);
        }
    }
}
