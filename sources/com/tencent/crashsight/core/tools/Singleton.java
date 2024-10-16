package com.tencent.crashsight.core.tools;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public class Singleton {
    private static final ConcurrentMap<Class, Object> map = new ConcurrentHashMap();

    public static <T> T getSingleton(Class<T> cls) {
        T t = (T) map.get(cls);
        if (t == null) {
            try {
                synchronized (map) {
                    t = cls.newInstance();
                    map.put(cls, t);
                }
            } catch (IllegalAccessException e) {
                UQMLog.e(e.getMessage());
            } catch (InstantiationException e2) {
                UQMLog.e(e2.getMessage());
            }
        }
        return t;
    }

    public static <T> T getSingleton(Class<T> cls, String str) {
        T t = (T) map.get(cls);
        if (t == null) {
            try {
                synchronized (map) {
                    t = cls.getDeclaredConstructor(String.class).newInstance(str);
                    map.put(cls, t);
                }
            } catch (IllegalAccessException e) {
                UQMLog.e(e.getMessage());
            } catch (InstantiationException e2) {
                UQMLog.e(e2.getMessage());
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        return t;
    }

    public static <T> void Remove(Class<T> cls) {
        map.remove(cls);
    }
}
