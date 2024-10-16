package com.helpshift.support;

import com.helpshift.common.domain.HSThreadFactory;
import com.helpshift.meta.dto.DebugLogDTO;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes2.dex */
public final class Log {
    private static final String TAG = "Helpshift_Log";
    private static final ExecutorService executor = Executors.newSingleThreadExecutor(new HSThreadFactory("sup-log"));

    private static void appendLog(Integer num, String str, String str2) {
        appendLog(num, str, str2, null);
    }

    private static void appendLog(Integer num, String str, Throwable th) {
        appendLog(num, str, null, th);
    }

    private static void appendLog(Integer num, String str, String str2, Throwable th) {
        final DebugLogDTO debugLogDTO = new DebugLogDTO(num, str, str2, getStackTraceString(th));
        try {
            executor.submit(new Runnable() { // from class: com.helpshift.support.Log.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HelpshiftContext.getCoreApi().getMetaDataDM().addDebugLog(DebugLogDTO.this);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            HSLogger.e(TAG, "Error executing support logs update", e);
        }
    }

    public static int v(String str, String str2) {
        return v(str, str2, null);
    }

    public static int v(String str, String str2, Throwable th) {
        int v = android.util.Log.v(str, str2, th);
        appendLog(2, str, str2, th);
        return v;
    }

    public static int d(String str, String str2) {
        return d(str, str2, null);
    }

    public static int d(String str, String str2, Throwable th) {
        int d = android.util.Log.d(str, str2, th);
        appendLog(3, str, str2, th);
        return d;
    }

    public static int i(String str, String str2) {
        return i(str, str2, null);
    }

    public static int i(String str, String str2, Throwable th) {
        int i = android.util.Log.i(str, str2, th);
        appendLog(4, str, str2, th);
        return i;
    }

    public static int w(String str, String str2) {
        return w(str, str2, null);
    }

    public static int w(String str, String str2, Throwable th) {
        int e = android.util.Log.e(str, str2, th);
        appendLog(5, str, str2, th);
        return e;
    }

    public static boolean isLoggable(String str, int i) {
        return android.util.Log.isLoggable(str, i);
    }

    public static int w(String str, Throwable th) {
        return w(str, "", th);
    }

    public static int e(String str, String str2) {
        return e(str, str2, null);
    }

    public static int e(String str, String str2, Throwable th) {
        int e = android.util.Log.e(str, str2, th);
        appendLog(6, str, str2, th);
        return e;
    }

    public static int wtf(String str, String str2) {
        return wtf(str, str2, null);
    }

    public static int wtf(String str, Throwable th) {
        return wtf(str, "", th);
    }

    public static int wtf(String str, String str2, Throwable th) {
        int wtf = android.util.Log.wtf(str, str2, th);
        appendLog(-1, str, str2, th);
        return wtf;
    }

    public static String getStackTraceString(Throwable th) {
        return android.util.Log.getStackTraceString(th);
    }

    public static int println(int i, String str, String str2) {
        return android.util.Log.println(i, str, str2);
    }
}
