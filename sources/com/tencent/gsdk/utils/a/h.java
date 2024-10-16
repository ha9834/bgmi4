package com.tencent.gsdk.utils.a;

import android.content.Context;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes2.dex */
final class h {

    /* renamed from: a, reason: collision with root package name */
    private static Class f6239a;
    private static Object b;
    private static Method c;

    static {
        try {
            f6239a = Class.forName("com.tencent.tdm.TDataMaster");
            b = f6239a.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.b("Call TDataMaster.getInstance() failed for " + e.toString());
            f6239a = null;
            b = null;
        }
    }

    public static boolean a(Context context) {
        if (b == null) {
            return false;
        }
        try {
            f6239a.getMethod("initialize", Context.class).invoke(b, context);
            return true;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.b("Call TDataMaster.getInstance().initialize() failed for " + e.toString());
            return false;
        }
    }

    public static boolean a() {
        if (b == null) {
            return false;
        }
        try {
            f6239a.getMethod("onResume", new Class[0]).invoke(b, new Object[0]);
            return true;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.b("Call TDataMaster.getInstance().onResume() failed for " + e.toString());
            return false;
        }
    }

    public static boolean b() {
        if (b == null) {
            return false;
        }
        try {
            f6239a.getMethod("onStart", new Class[0]).invoke(b, new Object[0]);
            return true;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.b("Call TDataMaster.getInstance().onStart() failed for " + e.toString());
            return false;
        }
    }

    public static boolean c() {
        if (b == null) {
            return false;
        }
        try {
            f6239a.getMethod("onPause", new Class[0]).invoke(b, new Object[0]);
            return true;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.b("Call TDataMaster.getInstance().onPause() failed for " + e.toString());
            return false;
        }
    }

    public static boolean d() {
        if (b == null) {
            return false;
        }
        try {
            f6239a.getMethod("onStop", new Class[0]).invoke(b, new Object[0]);
            return true;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.b("Call TDataMaster.getInstance().onStop() failed for " + e.toString());
            return false;
        }
    }

    public static boolean e() {
        if (b == null) {
            return false;
        }
        try {
            f6239a.getMethod("onDestroy", new Class[0]).invoke(b, new Object[0]);
            return true;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.b("Call TDataMaster.getInstance().onDestroy() failed for " + e.toString());
            return false;
        }
    }

    public static boolean a(String str, Map<String, String> map) {
        if (b == null) {
            return false;
        }
        try {
            if (c == null) {
                c = f6239a.getMethod("reportEvent", Integer.TYPE, String.class, Map.class);
            }
            c.invoke(b, 2006, str, map);
            return true;
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.b("Call TDataMaster.getInstance().reportEvent() failed for " + e.toString());
            return false;
        }
    }
}
