package com.tencent.crashsight.core.api.crash;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class UQMCrash {
    public static native byte[] attachmentForException(int i);

    public static native String attachmentMessageForException(int i);

    public static native void configCallbackType(int i);

    public static native void configCallbackTypeBeforeInit(int i);

    public static native void configCrashReporterLogLevelBeforeInit(int i);

    public static native void configCrashServerUrlBeforeInit(String str);

    public static native void configDebugModeBeforeInit(boolean z);

    public static native void configDefaultBeforeInit(String str, String str2, String str3, long j);

    public static native void init(String str, boolean z, boolean z2, String str2);

    public static native void initWithAppId(String str);

    public static native void logInfo(int i, String str, String str2);

    public static native void logRecord(int i, String str);

    public static native void reportException(int i, String str, String str2, String str3, String str4, boolean z);

    public static native void reportException(int i, String str, String str2, String str3, HashMap<String, String> hashMap);

    public static native void restartCrashReport();

    public static native void setAppId(String str);

    public static native void setCrashObserver(UQMCrashObserver uQMCrashObserver);

    public static native void setGameType(int i);

    public static native void setIsAppForeground(boolean z);

    public static native void setScene(int i);

    public static native void setServerUrl(String str);

    public static native void setUserId(String str);

    public static native void setUserSceneTag(String str);

    public static native void setUserValue(String str, String str2);

    public static native void testJavaCrash();

    public static native void testOomCrash();
}
