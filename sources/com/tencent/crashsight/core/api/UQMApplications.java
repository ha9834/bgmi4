package com.tencent.crashsight.core.api;

import android.annotation.SuppressLint;
import android.app.Application;
import com.tencent.crashsight.core.tools.UQMLog;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class UQMApplications {

    @SuppressLint({"StaticFieldLeak"})
    private static Application CURRENT;

    public static Application context() {
        return CURRENT;
    }

    static {
        try {
            Object activityThread = getActivityThread();
            CURRENT = (Application) activityThread.getClass().getMethod("getApplication", new Class[0]).invoke(activityThread, new Object[0]);
        } catch (Throwable unused) {
            UQMLog.e("Can not access Application context by magic code, boom!");
        }
    }

    private static Object getActivityThread() {
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            return method.invoke(null, new Object[0]);
        } catch (Exception e) {
            UQMLog.e("getActivityThread: " + e.toString());
            return null;
        }
    }
}
