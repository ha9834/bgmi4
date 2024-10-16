package com.shieldtunnel.svpn;

import android.app.Activity;
import android.util.Log;
import com.shieldtunnel.svpn.common.LogTag;

/* loaded from: classes2.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private final Class f5777a;

    public b() {
        Class<?> cls;
        try {
            cls = Class.forName("com.unity3d.player.UnityPlayer");
        } catch (ClassNotFoundException unused) {
            Log.w(LogTag.MAIN, "UnityPlayer not found");
            cls = null;
        }
        this.f5777a = cls;
    }

    public Activity a() {
        Class cls = this.f5777a;
        if (cls == null) {
            return null;
        }
        try {
            Object obj = cls.getDeclaredField("currentActivity").get(null);
            if (obj instanceof Activity) {
                return (Activity) obj;
            }
        } catch (Error | Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean a(String str, String str2, String str3) {
        Class cls = this.f5777a;
        if (cls == null) {
            return false;
        }
        try {
            cls.getDeclaredMethod("UnitySendMessage", String.class, String.class, String.class).invoke(null, str, str2, str3);
            return true;
        } catch (Error | Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
