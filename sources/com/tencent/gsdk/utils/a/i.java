package com.tencent.gsdk.utils.a;

import android.content.Context;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static Class f6240a;
    private static Method b;

    static {
        try {
            f6240a = Class.forName("com.tencent.beacon.event.UserAction");
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.b("Can not find UserAction class for " + e.toString());
            f6240a = null;
        }
    }

    public static boolean a(String str) {
        Class cls = f6240a;
        if (cls == null) {
            return false;
        }
        try {
            cls.getMethod("setAppkey", String.class).invoke(null, str);
            return true;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.b("Call UserAction.setAppkey() failed for " + e.toString());
            return false;
        }
    }

    public static boolean a(Context context) {
        Class cls = f6240a;
        if (cls == null) {
            return false;
        }
        try {
            cls.getMethod("initUserAction", Context.class).invoke(null, context);
            return true;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.b("Call UserAction.initUserAction() failed for " + e.toString());
            return false;
        }
    }

    public static boolean a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        Class cls = f6240a;
        if (cls == null) {
            return false;
        }
        try {
            try {
                if (b == null) {
                    b = cls.getMethod("onUserAction", String.class, Boolean.TYPE, Long.TYPE, Long.TYPE, Map.class, Boolean.TYPE, Boolean.TYPE);
                }
                return ((Boolean) b.invoke(null, str, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), map, Boolean.valueOf(z2), true)).booleanValue();
            } catch (Exception e) {
                com.tencent.gsdk.utils.g.b("Call UserAction.onUserAction() failed for " + e.toString());
                return false;
            }
        } catch (Exception unused) {
            if (b == null) {
                b = f6240a.getMethod("onUserAction", String.class, Boolean.TYPE, Long.TYPE, Long.TYPE, Map.class, Boolean.TYPE);
            }
            return ((Boolean) b.invoke(null, str, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), map, Boolean.valueOf(z2))).booleanValue();
        }
    }
}
