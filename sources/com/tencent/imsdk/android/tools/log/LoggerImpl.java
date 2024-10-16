package com.tencent.imsdk.android.tools.log;

import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LoggerImpl {
    private static final String BOTTOM_BORDER = "+================================================================================================================";
    private static final char BOTTOM_LEFT_CORNER = '+';
    private static final int CHUNK_SIZE = 4000;
    private static final int DEBUG = 3;
    private static final String DEFAULT_TAG = "iMSDK";
    private static final String DOUBLE_DIVIDER = "========================================================";
    private static final int ERROR = 6;
    private static final char HORIZONTAL_DOUBLE_LINE = '|';
    private static final int INFO = 4;
    private static final int JSON_INDENT = 2;
    public static final int METHOD_COUNT = 1;
    private static final String MIDDLE_BORDER = "|----------------------------------------------------------------------------------------------------------------";
    private static final char MIDDLE_CORNER = '|';
    private static final int MIN_STACK_OFFSET = 3;
    private static final String SINGLE_DIVIDER = "--------------------------------------------------------";
    private static final String TOP_BORDER = "+================================================================================================================";
    private static final char TOP_LEFT_CORNER = '+';
    private static final int WARN = 5;

    public void d(String str, Object... objArr) {
        log(3, str, null, objArr);
    }

    public void d(Object obj) {
        String obj2;
        if (obj == null) {
            obj2 = "Warning : object is Null";
        } else if (obj.getClass().isArray()) {
            obj2 = Arrays.deepToString((Object[]) obj);
        } else if (obj instanceof Exception) {
            obj2 = ((Exception) obj).getMessage().toString();
        } else {
            obj2 = obj.toString();
        }
        log(3, obj2, null, new Object[0]);
    }

    public void e(String str, Object... objArr) {
        e(str, null, objArr);
    }

    public void e(String str, Throwable th, Object... objArr) {
        log(6, str, th, objArr);
    }

    public void w(String str, Object... objArr) {
        log(5, str, null, objArr);
    }

    public void i(String str, Object... objArr) {
        log(4, str, null, objArr);
    }

    private String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public synchronized void log(int i, String str, Throwable th, Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    str = String.format(str, objArr);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (th != null && str != null) {
            str = str + " : " + getStackTraceString(th);
        }
        if (th != null && str == null) {
            str = getStackTraceString(th);
        }
        if (str == null) {
            str = "No message/exception is set";
        }
        if (str == null || str.length() == 0) {
            str = "Empty/NULL log message";
        }
        if (printConsoleLog(i, str)) {
            FileLogger.getInstance().saveLogToFile(i, str);
        }
    }

    private boolean printConsoleLog(int i, String str) {
        logChunk(i, "+================================================================================================================");
        if (!logHeaderContent(i)) {
            return false;
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            logDivider(i);
            logContent(i, str);
            logBottomBorder(i);
            return true;
        }
        logDivider(i);
        for (int i2 = 0; i2 < length; i2 += 4000) {
            logContent(i, new String(bytes, i2, Math.min(length - i2, 4000)));
        }
        logBottomBorder(i);
        return true;
    }

    private boolean logHeaderContent(int i) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < stackTrace.length; i2++) {
            if (stackTrace[i2].getClassName().equals(IMLogger.class.getName())) {
                if (arrayList.contains(stackTrace[i2])) {
                    return false;
                }
                arrayList.add(stackTrace[i2]);
            }
        }
        arrayList.clear();
        String str = "";
        int stackOffset = getStackOffset(stackTrace);
        for (int length = stackOffset + 1 > stackTrace.length ? (stackTrace.length - stackOffset) - 1 : 1; length > 0; length--) {
            int i3 = length + stackOffset;
            if (i3 < stackTrace.length) {
                str = str + "   ";
                logChunk(i, "| " + str + getSimpleClassName(stackTrace[i3].getClassName()) + "." + stackTrace[i3].getMethodName() + "  (" + stackTrace[i3].getFileName() + CertificateUtil.DELIMITER + stackTrace[i3].getLineNumber() + ")");
            }
        }
        return true;
    }

    private void logBottomBorder(int i) {
        logChunk(i, "+================================================================================================================");
    }

    private void logDivider(int i) {
        logChunk(i, MIDDLE_BORDER);
    }

    private void logContent(int i, String str) {
        for (String str2 : str.split(System.getProperty("line.separator"))) {
            logChunk(i, "| " + str2);
        }
    }

    private void logChunk(int i, String str) {
        switch (i) {
            case 4:
                Log.i("iMSDK", str);
                return;
            case 5:
                Log.w("iMSDK", str);
                return;
            case 6:
                Log.e("iMSDK", str);
                return;
            default:
                Log.d("iMSDK", str);
                return;
        }
    }

    private String getSimpleClassName(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    private int getStackOffset(StackTraceElement[] stackTraceElementArr) {
        for (int i = 3; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!className.equals(LoggerImpl.class.getName()) && !className.equals(IMLogger.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }
}
