package com.tencent.ieg.gpc.globalization.utils;

import android.util.Log;

/* loaded from: classes2.dex */
public class GGLog {
    private static int logLevel = 6;

    public static void setLogLevel(int i) {
        if (i >= 2 && i <= 7) {
            logLevel = i;
            return;
        }
        if (i < 2) {
            logLevel = 2;
        } else if (i > 7) {
            logLevel = 7;
        } else {
            logLevel = 7;
        }
    }

    public static void d(String str, String str2) {
        if (logLevel >= 3) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (logLevel >= 6) {
            Log.e(str, str2);
        }
    }
}
