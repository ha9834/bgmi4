package com.epicgames.ue4;

import android.util.Log;

/* loaded from: classes.dex */
public class Logger {
    private static boolean bAllowExceptionLogging = true;
    private static boolean bAllowLogging = true;
    private String mTag;

    public static void SuppressLogs() {
        bAllowExceptionLogging = false;
        bAllowLogging = false;
    }

    public Logger(String str) {
        this.mTag = str;
    }

    public void debug(String str) {
        if (bAllowLogging) {
            Log.d(this.mTag, str);
        }
    }

    public void warn(String str) {
        if (bAllowLogging) {
            Log.w(this.mTag, str);
        }
    }

    public void error(String str) {
        if (bAllowLogging) {
            Log.e(this.mTag, str);
        }
    }
}
