package com.tencent.grobot.lite.common;

import android.util.Log;
import com.tencent.grobot.lite.GRobotApplication;

/* loaded from: classes2.dex */
public class TLog {
    public static boolean debugSwitch = true;
    public static boolean isDebug = true;
    private static boolean serverDebug;

    public static boolean isColor() {
        return GRobotApplication.getInstance().isDebug() || debugSwitch;
    }

    public static void e(String str, String str2) {
        if (GRobotApplication.getInstance().isDebug() || debugSwitch) {
            Log.e("GRobot_" + str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (GRobotApplication.getInstance().isDebug() || debugSwitch) {
            Log.d("GRobot_" + str, str2);
        }
    }

    public static void setDebugSwitch(boolean z) {
        debugSwitch = z;
    }

    public static boolean isServerDebug() {
        return serverDebug;
    }

    public static void setServerDebug(boolean z) {
        serverDebug = z;
    }
}
