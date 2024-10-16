package com.tencent.hawk.utils;

import android.app.Activity;
import android.content.Context;
import com.tencent.hawk.bridge.HawkLogger;
import com.tencent.hawk.bridge.RefInvoke;

/* loaded from: classes2.dex */
public class UnityHelper {
    private static Context sUnityContext;

    private static synchronized Context getUnityAppContext() {
        synchronized (UnityHelper.class) {
            try {
                Object fieldObject = RefInvoke.getFieldObject("android.app.ActivityThread", RefInvoke.invokeStaticMethod("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]), "mInitialApplication");
                if (fieldObject == null) {
                    return null;
                }
                return (Context) fieldObject;
            } catch (Exception unused) {
                HawkLogger.e("get unity app context failed");
                return null;
            }
        }
    }

    private static synchronized Activity getUnityCurrentActivity() {
        synchronized (UnityHelper.class) {
            try {
                Object staticFieldObject = RefInvoke.getStaticFieldObject("com.unity3d.player.UnityPlayer", "currentActivity");
                if (staticFieldObject != null && (staticFieldObject instanceof Activity)) {
                    return (Activity) staticFieldObject;
                }
            } catch (Exception unused) {
                HawkLogger.e("Failed to get the current activity from UnityPlayer ");
            }
            return null;
        }
    }

    public static Context getUnityContext() {
        Context context = sUnityContext;
        if (context != null) {
            return context;
        }
        sUnityContext = getUnityAppContext();
        if (sUnityContext == null) {
            sUnityContext = getUnityCurrentActivity();
        }
        return sUnityContext;
    }
}
