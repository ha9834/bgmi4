package com.helpshift.app;

/* loaded from: classes2.dex */
public class AppLifeCycleStateHolder {
    private static boolean isAppInForeground;

    public static void setAppInForeground(boolean z) {
        isAppInForeground = z;
    }

    public static boolean isAppInForeground() {
        return isAppInForeground;
    }
}
