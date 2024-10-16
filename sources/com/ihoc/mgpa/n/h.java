package com.ihoc.mgpa.n;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<Activity> f5671a;
    private static Class<?> b;
    private static Method c;

    public static Activity a() {
        Activity c2 = c();
        if (c2 != null) {
            m.a("get game main activity success.", new Object[0]);
            return c2;
        }
        Activity f = f();
        if (f != null) {
            m.a("get unity activity success.", new Object[0]);
            return f;
        }
        Activity d = d();
        if (d != null) {
            m.a("get ue4 activity success.", new Object[0]);
            return d;
        }
        Activity b2 = b();
        if (b2 != null) {
            m.a("get cocos activity success.", new Object[0]);
            return b2;
        }
        Activity e = e();
        if (e != null) {
            m.a("get ufo activity success.", new Object[0]);
            return e;
        }
        m.b("get game main activity failed, ple check!", new Object[0]);
        return null;
    }

    public static void a(Activity activity) {
        f5671a = new WeakReference<>(activity);
    }

    public static void a(String str) {
        Method method;
        try {
            if (b == null) {
                b = Class.forName("com.unity3d.player.UnityPlayer");
            }
            if (c == null) {
                c = b.getMethod("UnitySendMessage", String.class, String.class, String.class);
            }
        } catch (Throwable unused) {
            m.b("Callback: getUnityPlayerClass error.", new Object[0]);
        }
        Class<?> cls = b;
        if (cls == null || (method = c) == null) {
            return;
        }
        try {
            Object[] objArr = new Object[3];
            objArr[0] = "TGPAGameObject";
            objArr[1] = "notifySystemInfo";
            objArr[2] = str;
            method.invoke(cls, objArr);
        } catch (Throwable unused2) {
            m.b("Callback: invoke unity send message failed.", new Object[0]);
        }
    }

    private static Activity b() {
        try {
            Class<?> cls = Class.forName("org.cocos2dx.lib.Cocos2dxActivity");
            return (Activity) cls.getMethod("getContext", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            m.b("get cocos GameActivity exception. ", new Object[0]);
            return null;
        }
    }

    private static Activity c() {
        WeakReference<Activity> weakReference = f5671a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static Activity d() {
        try {
            Class<?> cls = Class.forName("com.epicgames.ue4.GameActivity");
            return (Activity) cls.getMethod("Get", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            m.b("get ue4 GameActivity exception. ", new Object[0]);
            return null;
        }
    }

    private static Activity e() {
        try {
            Class<?> cls = Class.forName("com.tencent.main.ActivityMain");
            return (Activity) cls.getField("mActivity").get(cls);
        } catch (Throwable unused) {
            m.b("get ufo GameActivity exception. ", new Object[0]);
            return null;
        }
    }

    private static Activity f() {
        try {
            Class<?> cls = Class.forName("com.unity3d.player.UnityPlayer");
            return (Activity) cls.getField("currentActivity").get(cls);
        } catch (Throwable unused) {
            m.b("try get unity main activity exception.", new Object[0]);
            return null;
        }
    }
}
