package com.ihoc.mgpa.n;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class n {
    public static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            m.b("Didn't find class %s !", str);
            return null;
        }
    }

    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object a(String str, String str2) {
        return a(str, str2, (Class[]) null, (Object[]) null);
    }

    public static Object a(String str, String str2, Class[] clsArr, Object[] objArr) {
        Object[] objArr2;
        String str3;
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (ClassNotFoundException unused) {
            m.b("Didn't find class %s !", str);
            return null;
        } catch (NoSuchMethodException unused2) {
            objArr2 = new Object[]{str, str2};
            str3 = "Didn't find class %s 's method %s !";
            m.b(str3, objArr2);
            return null;
        } catch (Exception unused3) {
            objArr2 = new Object[]{str, str2};
            str3 = "Class %s 's mehod %s invoke exception!";
            m.b(str3, objArr2);
            return null;
        }
    }

    public static Method a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception unused) {
            m.b("Didn't find class method %s with %d arg!", str, Integer.valueOf(clsArr.length));
            return null;
        }
    }

    public static Method a(Object obj, String str, Class[] clsArr) {
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception unused) {
            m.b("Didn't find class method %s !", str);
            return null;
        }
    }
}
