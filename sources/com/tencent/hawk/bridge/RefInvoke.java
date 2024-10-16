package com.tencent.hawk.bridge;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class RefInvoke {
    public static Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object[] objArr) throws SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, IllegalAccessException {
        return Class.forName(str).getMethod(str2, clsArr).invoke(null, objArr);
    }

    public static Object invokeMethod(String str, String str2, Object obj, Class<?>[] clsArr, Object[] objArr) throws SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, IllegalAccessException {
        return Class.forName(str).getMethod(str2, clsArr).invoke(obj, objArr);
    }

    public static Object invokeMethod(Class<?> cls, String str, Object obj, Class<?>[] clsArr, Object[] objArr) throws SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, IllegalAccessException {
        return cls.getMethod(str, clsArr).invoke(obj, objArr);
    }

    public static Object getFieldObject(String str, Object obj, String str2) throws SecurityException, ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = Class.forName(str).getDeclaredField(str2);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object getStaticFieldObject(String str, String str2) throws SecurityException, ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = Class.forName(str).getDeclaredField(str2);
        declaredField.setAccessible(true);
        return declaredField.get(null);
    }

    public static void setFieldObject(String str, String str2, Object obj, Object obj2) throws SecurityException, ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = Class.forName(str).getDeclaredField(str2);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public static void setStaticFieldObject(String str, String str2, Object obj) throws SecurityException, ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = Class.forName(str).getDeclaredField(str2);
        declaredField.setAccessible(true);
        declaredField.set(null, obj);
    }
}
