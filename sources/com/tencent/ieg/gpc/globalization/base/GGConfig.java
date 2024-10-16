package com.tencent.ieg.gpc.globalization.base;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import com.tencent.ieg.gpc.globalization.utils.GGLog;

/* loaded from: classes2.dex */
public class GGConfig {
    private static String TAG = "GGConfig";
    private static ApplicationInfo appInfo;

    public static void initialize(Activity activity) {
        try {
            appInfo = activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 128);
        } catch (Exception e) {
            GGLog.e(TAG, e.getMessage());
        }
    }

    public static String getConfig(String str) {
        ApplicationInfo applicationInfo = appInfo;
        if (applicationInfo == null) {
            GGLog.e(TAG, "Please call GGConfig.initialize first!!");
            return "";
        }
        String string = applicationInfo.metaData.getString(str);
        if (string == null) {
            string = "";
        }
        GGLog.d(TAG, String.format("GetConfig: %s = %s", str, string));
        return string;
    }
}
