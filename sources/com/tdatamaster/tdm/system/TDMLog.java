package com.tdatamaster.tdm.system;

import android.util.Log;

/* loaded from: classes2.dex */
public class TDMLog {
    private static int LEVEL = 1;

    private TDMLog() {
    }

    public static void setLogLevel(int i) {
        LEVEL = i;
    }

    public static int getLogLevel() {
        return LEVEL;
    }

    public static void d(String str, String str2) {
        if (LEVEL <= 0) {
            Log.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (LEVEL <= 1) {
            Log.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (LEVEL <= 2) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (LEVEL <= 3) {
            Log.e(str, str2);
        }
    }
}
