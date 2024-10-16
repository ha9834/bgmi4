package com.tencent.hawk.utils;

import android.app.Activity;
import android.content.Context;
import com.tencent.hawk.bridge.HawkLogger;
import com.tencent.hawk.bridge.RefInvoke;

/* loaded from: classes2.dex */
public class CocosHelper {
    private static final String CLASS_COCOS_ACTIVITY = "org.cocos2dx.lib.Cocos2dxActivity";

    public static Activity getCocosActivity() {
        HawkLogger.d("try get cocos activity");
        try {
            Object invokeStaticMethod = RefInvoke.invokeStaticMethod(CLASS_COCOS_ACTIVITY, "getContext", null, new Class[0]);
            if (invokeStaticMethod != null && (invokeStaticMethod instanceof Activity)) {
                return (Activity) invokeStaticMethod;
            }
        } catch (Exception e) {
            HawkLogger.e("Failed to get the current activity from Cocos2Dx");
            e.printStackTrace();
        }
        return null;
    }

    public static Context getContext() {
        Activity cocosActivity = getCocosActivity();
        if (cocosActivity != null) {
            return cocosActivity.getApplicationContext();
        }
        return null;
    }
}
