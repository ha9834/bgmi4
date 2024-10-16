package com.tencent.smtt.utils;

import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class a {
    public static boolean a() {
        Class<?> cls;
        Method declaredMethod;
        Object invoke;
        Method declaredMethod2;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (Build.VERSION.SDK_INT < 21 || (cls = Class.forName("dalvik.system.VMRuntime")) == null || (declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0])) == null || (invoke = declaredMethod.invoke(null, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0])) == null) {
            return false;
        }
        Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
        if (invoke2 instanceof Boolean) {
            return ((Boolean) invoke2).booleanValue();
        }
        return false;
    }
}
