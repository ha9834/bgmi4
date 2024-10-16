package com.tencent.imsdk.android.tools;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

@TargetApi(14)
/* loaded from: classes.dex */
public class IMSDKContext {
    private static Application mApplication;

    public static Application getApplication() {
        if (Build.VERSION.SDK_INT < 14 || mApplication != null) {
            return mApplication;
        }
        if (Build.VERSION.SDK_INT <= 27) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                mApplication = (Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, (Object[]) null), (Object[]) null);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return mApplication;
    }

    public static Context getAppContext() {
        if (mApplication == null) {
            mApplication = getApplication();
        }
        Application application = mApplication;
        if (application != null) {
            return application.getApplicationContext();
        }
        return null;
    }
}
