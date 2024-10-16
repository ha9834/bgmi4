package com.gamesafe.ano;

import android.app.Activity;
import android.content.Context;
import java.util.Collection;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Context f1093a;

    public static Boolean a(Object obj) {
        try {
            return (Boolean) j.a("android.app.ActivityThread$ActivityClientRecord", obj, "paused");
        } catch (Exception unused) {
            return true;
        }
    }

    public static void a() {
        b.a("jar_ver:5.8.12(2020/11/10)-jar-version");
    }

    public static Context b() {
        if (f1093a == null) {
            try {
                f1093a = (Context) j.a("android.app.ActivityThread", j.a("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]), "mInitialApplication");
            } catch (Exception unused) {
                f1093a = null;
            }
        }
        return f1093a;
    }

    public static Activity c() {
        try {
            return (Activity) j.a("com.unity3d.player.UnityPlayer", "currentActivity");
        } catch (Exception unused) {
            return null;
        }
    }

    public static Activity d() {
        Activity c = c();
        return c == null ? e() : c;
    }

    private static Activity e() {
        try {
            Activity activity = null;
            for (Object obj : ((Collection) j.a("java.util.Map", "values", j.a("android.app.ActivityThread", j.a("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]), "mActivities"), new Class[0], new Object[0])).toArray()) {
                if (obj != null) {
                    Object a2 = j.a("android.app.ActivityThread$ActivityClientRecord", obj, "activity");
                    Boolean a3 = a(obj);
                    if (a2 != null && (activity == null || !a3.booleanValue())) {
                        activity = (Activity) a2;
                    }
                }
            }
            return activity;
        } catch (Exception unused) {
            return null;
        }
    }
}
