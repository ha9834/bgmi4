package com.tencent.mtt;

import java.io.File;

/* loaded from: classes.dex */
public class MttTraceEvent {
    public static final int CATEGORY_CUSTOM = 128;
    public static final int CATEGORY_DATABASE = 8;
    public static final int CATEGORY_DEFAULT = 2;
    public static final int CATEGORY_DRAW = 16;
    public static final int CATEGORY_FUNC = 64;
    public static final int CATEGORY_LOAD = 32;
    public static final int CATEGORY_NETWORK = 4;
    public static final int CATEGORY_UI = 64;
    private static final boolean DEBUG = false;
    public static final int LOADTBS = 256;
    private static final String TAG = "MttTraceEvent";
    private static volatile boolean bIsTraceEnabled = true;
    private static volatile int sCategory = 382;
    private static boolean sMttTraceAvailable;
    private static boolean sMttTraceInited;

    private static native void nativeJNIBegin(String str, String str2);

    private static native void nativeJNIEnd(String str, String str2);

    private static native void nativeJNIFinishAsync(String str, long j, String str2);

    private static native void nativeJNIInstant(String str, String str2);

    private static native void nativeJNIStartATrace();

    private static native void nativeJNIStartAsync(String str, long j, String str2);

    private static native void nativeJNIStartTrace();

    private static native void nativeJNIStopATrace();

    private static native void nativeJNIStopTrace();

    private static native boolean nativeJNITraceEnabled();

    public static void init(String str) {
        if (sMttTraceInited) {
            return;
        }
        try {
            String str2 = String.valueOf(str) + File.separator + "libmtttrace.so";
            boolean exists = new File(str2).exists();
            sMttTraceAvailable = exists;
            if (exists) {
                System.load(str2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            sMttTraceAvailable = false;
        }
        sMttTraceInited = true;
    }

    public static void init(File file) {
        if (file != null) {
            init(file.getAbsolutePath());
        }
    }

    public static void clearTraceCategory() {
        sCategory = 0;
    }

    public static void setTraceCategory(int i) {
        sCategory = i;
    }

    public static void addTraceCategory(int i) {
        sCategory = i | sCategory;
    }

    public static void removeTraceCategory(int i) {
        sCategory = (i ^ (-1)) & sCategory;
    }

    public static void setTraceEnableFlag(boolean z) {
        bIsTraceEnabled = z;
    }

    private static boolean enabled(int i) {
        return bIsTraceEnabled && (i & sCategory) != 0 && sMttTraceAvailable;
    }

    public static void instant(int i, String str) {
        if (enabled(i)) {
            nativeJNIInstant(str, null);
        }
    }

    public static void instant(int i, String str, String str2) {
        if (enabled(i)) {
            nativeJNIInstant(str, str2);
        }
    }

    public static void startAsync(int i, long j) {
        if (enabled(i)) {
            nativeJNIStartAsync(getCallerName(), j, null);
        }
    }

    public static void startAsync(int i, String str, long j) {
        if (enabled(i)) {
            nativeJNIStartAsync(str, j, null);
        }
    }

    public static void startAsync(int i, String str, long j, String str2) {
        if (enabled(i)) {
            nativeJNIStartAsync(str, j, str2);
        }
    }

    public static void finishAsync(int i, long j) {
        if (enabled(i)) {
            nativeJNIFinishAsync(getCallerName(), j, null);
        }
    }

    public static void finishAsync(int i, String str, long j) {
        if (enabled(i)) {
            nativeJNIFinishAsync(str, j, null);
        }
    }

    public static void finishAsync(int i, String str, long j, String str2) {
        if (enabled(i)) {
            nativeJNIFinishAsync(str, j, str2);
        }
    }

    public static void begin(int i) {
        if (enabled(i)) {
            nativeJNIBegin(getCallerName(), null);
        }
    }

    public static void begin(int i, String str) {
        if (enabled(i)) {
            nativeJNIBegin(str, null);
        }
    }

    public static void begin(int i, String str, String str2) {
        if (enabled(i)) {
            nativeJNIBegin(str, str2);
        }
    }

    public static void end(int i) {
        if (enabled(i)) {
            nativeJNIEnd(getCallerName(), null);
        }
    }

    public static void end(int i, String str) {
        if (enabled(i)) {
            nativeJNIEnd(str, null);
        }
    }

    public static void end(int i, String str, String str2) {
        if (enabled(i)) {
            nativeJNIEnd(str, str2);
        }
    }

    private static String getCallerName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return String.valueOf(stackTrace[4].getClassName()) + "." + stackTrace[4].getMethodName();
    }

    public static void startTrace() {
        if (bIsTraceEnabled && sMttTraceAvailable) {
            nativeJNIStartTrace();
        }
    }

    public static void stopTrace() {
        if (bIsTraceEnabled && sMttTraceAvailable) {
            nativeJNIStopTrace();
        }
    }

    public static void startATrace() {
        if (bIsTraceEnabled && sMttTraceAvailable) {
            nativeJNIStartATrace();
        }
    }

    public static void stopATrace() {
        if (bIsTraceEnabled && sMttTraceAvailable) {
            nativeJNIStopATrace();
        }
    }
}
