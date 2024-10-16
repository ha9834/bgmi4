package com.intlgame.foundation;

import android.content.Context;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.intlgame.foundation.swig.LogLevel;
import java.io.InputStream;
import java.util.Properties;

/* loaded from: classes2.dex */
public class INTLLog {
    private static final int DEBUG = 3;
    private static final int ERROR = 6;
    private static final int INFO = 4;
    private static final String LOG_TAG = "INTL";
    private static final int STACK_TRACE_DEEP = 5;
    private static final int WARN = 5;
    private static Context mAppContext;
    private static Boolean mEnableConsoleOutput;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LogInfo {
        String logClassName;
        int logLineNumber;
        String logMethodName;

        private LogInfo() {
            this.logClassName = "Unknown";
            this.logMethodName = "Unknown";
            this.logLineNumber = -1;
        }

        public String toString() {
            return "[ (" + this.logClassName + CertificateUtil.DELIMITER + this.logLineNumber + ") " + this.logMethodName + "] : ";
        }
    }

    public static void setAppContext(Context context) {
        mAppContext = context;
    }

    private static boolean isEnable() {
        if (NDKHelper.mIsLoadedSO) {
            return true;
        }
        if (mEnableConsoleOutput == null) {
            try {
                if (mAppContext != null) {
                    InputStream open = mAppContext.getResources().getAssets().open("INTLConfig.ini");
                    Properties properties = new Properties();
                    properties.load(open);
                    String property = properties.getProperty("LOG_CONSOLE_OUTPUT_ENABLE");
                    mEnableConsoleOutput = Boolean.valueOf(property != null && property.equals("1"));
                }
            } catch (Exception e) {
                Log.e(LOG_TAG, "when read config file, " + e.getMessage());
            }
        }
        return mEnableConsoleOutput == Boolean.TRUE;
    }

    private static LogInfo initStackTraceLogInfo(int i) {
        LogInfo logInfo = new LogInfo();
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace == null || i < 0 || i >= stackTrace.length) {
                return logInfo;
            }
            String className = stackTrace[i].getClassName();
            logInfo.logMethodName = stackTrace[i].getMethodName();
            logInfo.logLineNumber = stackTrace[i].getLineNumber();
            int lastIndexOf = className.lastIndexOf(46);
            if (lastIndexOf != -1) {
                logInfo.logClassName = className.substring(lastIndexOf + 1) + ".java";
            }
            return logInfo;
        } catch (Exception unused) {
            return logInfo;
        }
    }

    private static void printLog(String str, int i) {
        LogLevel logLevel;
        if (NDKHelper.mIsLoadedSO && EmptyUtils.isNonEmpty(str)) {
            LogInfo initStackTraceLogInfo = initStackTraceLogInfo(5);
            LogLevel logLevel2 = LogLevel.kLogLevelError;
            switch (i) {
                case 3:
                    logLevel = LogLevel.kLogLevelDebug;
                    break;
                case 4:
                    logLevel = LogLevel.kLogLevelInfo;
                    break;
                case 5:
                    logLevel = LogLevel.kLogLevelWarn;
                    break;
                case 6:
                    logLevel = LogLevel.kLogLevelError;
                    break;
                default:
                    logLevel = logLevel2;
                    break;
            }
            com.intlgame.foundation.swig.Log.GetInstance().OutputLog(logLevel, LOG_TAG, false, false, initStackTraceLogInfo.logClassName, initStackTraceLogInfo.logMethodName, initStackTraceLogInfo.logLineNumber, str);
            return;
        }
        if (!isEnable() || str == null || str.length() == 0) {
            return;
        }
        LogInfo initStackTraceLogInfo2 = initStackTraceLogInfo(5);
        switch (i) {
            case 3:
                Log.d(LOG_TAG, initStackTraceLogInfo2.toString() + str);
                return;
            case 4:
                Log.i(LOG_TAG, initStackTraceLogInfo2.toString() + str);
                return;
            case 5:
                Log.w(LOG_TAG, initStackTraceLogInfo2.toString() + str);
                return;
            case 6:
                Log.e(LOG_TAG, initStackTraceLogInfo2.toString() + str);
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
