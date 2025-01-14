package com.adjust.sdk;

import android.content.Context;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes.dex */
public class Reflection {
    public static Object getAdvertisingInfoObject(Context context) throws Exception {
        return invokeStaticMethod("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class}, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> getImeiParameters(Context context, ILogger iLogger) {
        try {
            Object invokeStaticMethod = invokeStaticMethod("com.adjust.sdk.imei.Util", "getImeiParameters", new Class[]{Context.class, ILogger.class}, context, iLogger);
            if (invokeStaticMethod == null || !Map.class.isInstance(invokeStaticMethod)) {
                return null;
            }
            return (Map) invokeStaticMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> getOaidParameters(Context context, ILogger iLogger) {
        try {
            Object invokeStaticMethod = invokeStaticMethod("com.adjust.sdk.oaid.Util", "getOaidParameters", new Class[]{Context.class, ILogger.class}, context, iLogger);
            if (invokeStaticMethod == null || !Map.class.isInstance(invokeStaticMethod)) {
                return null;
            }
            return (Map) invokeStaticMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getPlayAdId(Context context, Object obj) {
        try {
            return (String) invokeInstanceMethod(obj, "getId", null, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean isPlayTrackingEnabled(Context context, Object obj) {
        try {
            Boolean bool = (Boolean) invokeInstanceMethod(obj, "isLimitAdTrackingEnabled", null, new Object[0]);
            if (bool == null) {
                return null;
            }
            return Boolean.valueOf(bool.booleanValue() ? false : true);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class forName(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object createDefaultInstance(String str) {
        Class forName = forName(str);
        if (forName == null) {
            return null;
        }
        return createDefaultInstance(forName);
    }

    public static Object createDefaultInstance(Class cls) {
        try {
            return cls.newInstance();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object createInstance(String str, Class[] clsArr, Object... objArr) {
        try {
            return Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Class[] clsArr, Object... objArr) throws Exception {
        return invokeMethod(Class.forName(str), str2, null, clsArr, objArr);
    }

    public static Object invokeInstanceMethod(Object obj, String str, Class[] clsArr, Object... objArr) throws Exception {
        return invokeMethod(obj.getClass(), str, obj, clsArr, objArr);
    }

    public static Object invokeMethod(Class cls, String str, Object obj, Class[] clsArr, Object... objArr) throws Exception {
        Method method = cls.getMethod(str, clsArr);
        if (method == null) {
            return null;
        }
        return method.invoke(obj, objArr);
    }

    public static Object readField(String str, String str2) throws Exception {
        return readField(str, str2, null);
    }

    public static Object readField(String str, String str2, Object obj) throws Exception {
        Field field;
        Class forName = forName(str);
        if (forName == null || (field = forName.getField(str2)) == null) {
            return null;
        }
        return field.get(obj);
    }
}
