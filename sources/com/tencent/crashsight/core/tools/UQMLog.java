package com.tencent.crashsight.core.tools;

import android.util.Log;

/* loaded from: classes2.dex */
public class UQMLog {
    private static final int DEBUG = 3;
    private static final int ERROR = 6;
    private static final int INFO = 4;
    private static final String LOG_TAG = "CrashSightCore";
    private static final int WARN = 5;

    private static void printLog(String str, int i) {
        switch (i) {
            case 3:
                Log.d(LOG_TAG, str);
                return;
            case 4:
                Log.i(LOG_TAG, str);
                return;
            case 5:
                Log.w(LOG_TAG, str);
                return;
            case 6:
                Log.e(LOG_TAG, str);
                return;
            default:
                return;
        }
    }

    public static void d(String str) {
        printLog(str, 3);
    }

    public static void i(String str) {
        printLog(str, 4);
    }

    public static void w(String str) {
        printLog(str, 5);
    }

    public static void e(String str) {
        printLog(str, 6);
    }
}
