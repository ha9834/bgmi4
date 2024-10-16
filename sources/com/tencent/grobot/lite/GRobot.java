package com.tencent.grobot.lite;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes2.dex */
public class GRobot {
    public static void handleCallBackOnActivityForResult(int i, int i2, Intent intent) {
    }

    public static void showGRobotView(String str) {
        GRobotEnterManager.startGRobot(str);
    }

    public static void closeGRobotView() {
        GRobotEnterManager.closeGRobtoView(null);
    }

    public static void setActivity(Activity activity) {
        GRobotEnterManager.setHostActivity(activity);
    }
}
