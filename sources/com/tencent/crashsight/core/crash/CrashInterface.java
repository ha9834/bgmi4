package com.tencent.crashsight.core.crash;

import java.util.HashMap;

/* loaded from: classes2.dex */
public interface CrashInterface {
    void closeCrashReport();

    void configCallbackTypeBeforeInit(int i);

    void configCrashHandleTimeout(int i);

    void configCrashReporterLogLevelBeforeInit(int i);

    void configCrashServerUrlBeforeInit(String str);

    void configDebugModeBeforeInit(boolean z);

    void configDefaultBeforeInit(String str, String str2, String str3, long j);

    void init(String str, boolean z, boolean z2, String str2);

    void initWithAppId(String str);

    void logInfo(int i, String str, String str2);

    void printLog(int i, String str);

    void reportException(int i, String str, String str2, String str3, String str4, boolean z);

    void reportException(int i, String str, String str2, String str3, HashMap<String, String> hashMap);

    void setAppId(String str);

    void setAppVersion(String str);

    void setGameType(int i);

    void setIsAppForeground(boolean z);

    void setScene(int i);

    void setUserId(String str);

    void setUserSceneTag(String str);

    void setUserValue(String str, String str2);

    void startCrashReport();

    void testJavaCrash();

    void testOomCrash();
}
