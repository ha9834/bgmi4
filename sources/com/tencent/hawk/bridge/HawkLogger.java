package com.tencent.hawk.bridge;

import android.util.Log;

/* loaded from: classes2.dex */
public class HawkLogger {
    public static final String LOG_TAG = "xclient";
    public static boolean mEnableDebugLog;
    private static boolean sTMode;

    public static void enableTMode() {
        sTMode = true;
    }

    public static void enableDebug() {
        mEnableDebugLog = true;
    }

    public static void d(String str) {
        if (str != null && sTMode) {
            Log.d(LOG_TAG, str);
        }
    }

    public static void w(String str) {
        if (str == null) {
            return;
        }
        Log.w(LOG_TAG, str);
    }

    public static void i(String str) {
        if (str == null) {
            return;
        }
        if (mEnableDebugLog || sTMode) {
            Log.i(LOG_TAG, str);
        }
    }

    public static void e(String str) {
        if (str == null) {
            return;
        }
        Log.e(LOG_TAG, str);
    }
}
