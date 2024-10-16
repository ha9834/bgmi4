package com.tencent.midas.comm;

import android.annotation.SuppressLint;
import android.util.Log;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.internal.APLogger;
import com.tencent.midas.comm.log.util.APLogFileUtil;

/* loaded from: classes.dex */
public class APLog {
    private static APLogger logger;

    @SuppressLint({"StaticFieldLeak"})
    private static APLogInfo logInfo = new APLogInfo();
    private static boolean shouldWriteLog = false;
    private static boolean shouldPrintLog = true;

    private APLog() {
    }

    public static void init(APLogInfo aPLogInfo) {
        try {
            Log.d(APLogInfo.LOG_TAG, "Log init");
            if (aPLogInfo == null) {
                Log.e(APLogInfo.LOG_TAG, "Log init failed: info null");
                return;
            }
            logInfo = aPLogInfo;
            logInfo.init();
            APLogFileInfo.create();
            APLogFileUtil.readLogKeepConf(logInfo.getContext());
            shouldPrintLog = logInfo.shouldPrintLog();
            if (APLogFileUtil.initLogDir(APLogFileInfo.dirName)) {
                shouldWriteLog = logInfo.isWriteLog();
                logger = APLogger.open();
            }
        } catch (Throwable th) {
            Log.e(APLogInfo.LOG_TAG, "Log init failed: " + th.toString());
        }
    }

    public static APLogInfo getLogInfo() {
        return logInfo;
    }

    public static void i(String str, String str2) {
        String composeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            APLogger.log(3, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
    }

    public static void i(String str, String str2, Object... objArr) {
        i(str, String.format(str2, objArr));
    }

    public static void d(String str, String str2) {
        String composeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            APLogger.log(2, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
    }

    public static void d(String str, String str2, Object... objArr) {
        d(str, String.format(str2, objArr));
    }

    public static void v(String str, String str2) {
        String composeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            APLogger.log(1, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
    }

    public static void v(String str, String str2, Object... objArr) {
        v(str, String.format(str2, objArr));
    }

    public static void w(String str, String str2) {
        String composeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            APLogger.log(4, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
    }

    public static void w(String str, String str2, Object... objArr) {
        w(str, String.format(str2, objArr));
    }

    public static void e(String str, String str2) {
        String composeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog) {
            APLogger.log(5, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
    }

    public static void e(String str, String str2, Object... objArr) {
        e(str, String.format(str2, objArr));
    }

    public static void s(boolean z, String str, String str2) {
        String composeLogMsg = composeLogMsg(str, str2);
        if (shouldPrintLog && !z) {
            APLogger.log(6, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
    }

    public static void s(boolean z, String str, String str2, Object... objArr) {
        s(z, str, String.format(str2, objArr));
    }

    public static void s(String str, String str2) {
        writeLog(composeLogMsg(str, str2));
    }

    public static void s(String str, String str2, Object... objArr) {
        s(str, String.format(str2, objArr));
    }

    private static void writeLog(String str) {
        if (shouldWriteLog) {
            write(str);
        }
    }

    private static void write(String str) {
        try {
            if (logger != null) {
                logger.write(str);
            }
        } catch (Throwable th) {
            Log.e(APLogInfo.LOG_TAG, "Log write error: " + th.toString());
        }
    }

    public static void closeLog() {
        flush();
    }

    public static void flush() {
        try {
            if (logger != null) {
                logger.flush();
                Log.d(APLogInfo.LOG_TAG, "Log flushing...!!!");
            }
        } catch (Throwable th) {
            Log.i(APLogInfo.LOG_TAG, "flush log error: " + th.toString());
        }
    }

    private static String composeLogMsg(String str, String str2) {
        return str + APLogFileUtil.SEPARATOR_LOG + Thread.currentThread().getName() + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LINE;
    }
}
