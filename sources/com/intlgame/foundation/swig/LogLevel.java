package com.intlgame.foundation.swig;

/* loaded from: classes2.dex */
public final class LogLevel {
    private final String swigName;
    private final int swigValue;
    public static final LogLevel kLogLevelDebug = new LogLevel("kLogLevelDebug", INTLFoundationJNI.kLogLevelDebug_get());
    public static final LogLevel kLogLevelInfo = new LogLevel("kLogLevelInfo", INTLFoundationJNI.kLogLevelInfo_get());
    public static final LogLevel kLogLevelWarn = new LogLevel("kLogLevelWarn", INTLFoundationJNI.kLogLevelWarn_get());
    public static final LogLevel kLogLevelError = new LogLevel("kLogLevelError", INTLFoundationJNI.kLogLevelError_get());
    private static LogLevel[] swigValues = {kLogLevelDebug, kLogLevelInfo, kLogLevelWarn, kLogLevelError};
    private static int swigNext = 0;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LogLevel swigToEnum(int i) {
        LogLevel[] logLevelArr = swigValues;
        if (i < logLevelArr.length && i >= 0 && logLevelArr[i].swigValue == i) {
            return logLevelArr[i];
        }
        int i2 = 0;
        while (true) {
            LogLevel[] logLevelArr2 = swigValues;
            if (i2 < logLevelArr2.length) {
                if (logLevelArr2[i2].swigValue == i) {
                    return logLevelArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + LogLevel.class + " with value " + i);
            }
        }
    }

    private LogLevel(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private LogLevel(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private LogLevel(String str, LogLevel logLevel) {
        this.swigName = str;
        this.swigValue = logLevel.swigValue;
        swigNext = this.swigValue + 1;
    }
}
