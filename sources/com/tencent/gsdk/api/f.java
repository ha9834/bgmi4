package com.tencent.gsdk.api;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes2.dex */
public class f {
    public static String A = "mem";
    public static String B = "battery";
    public static String C = "netflow";
    public static String D = "frequency";
    public static String E = "fcntx0";
    public static String F = "pcntx00";
    public static String G = "0";
    public static String H = "0";
    public static String I = "0";
    public static String J = "wifi";
    public static String K = "fps_cycle";
    public static String L = "fps_cycle";
    public static String M = "fps_cycle";

    /* renamed from: a, reason: collision with root package name */
    public static String f6234a = "gsdk_prefs";
    public static String b = "login";
    public static String c = "pay";
    public static String d = "open_id";
    public static String e = "domain1";
    public static String f = "domain2";
    public static String g = "domain3";
    public static String h = "domain4";
    public static String i = "domain5";
    public static String j = "domain6";
    public static String k = "port1";
    public static String l = "port2";
    public static String m = "port3";
    public static String n = "port4";
    public static String o = "port5";
    public static String p = "port6";
    public static String q = "errno";
    public static String r = "domain";
    public static String s = "errmsg";
    public static String t = "c_errno";
    public static String u = "c_errmsg";
    public static String v = "sip";
    public static String w = "sport";
    public static String x = "fps";
    public static String y = "ping";
    public static String z = "cpu";

    public static void a(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putBoolean(b, true);
            edit.putBoolean(c, true);
            edit.putString(d, "NULL");
            edit.putString(e, null);
            edit.putString(f, null);
            edit.putString(g, null);
            edit.putString(h, null);
            edit.putString(i, null);
            edit.putString(j, null);
            edit.putInt(k, -1);
            edit.putInt(l, -1);
            edit.putInt(m, -1);
            edit.putInt(n, -1);
            edit.putInt(o, -1);
            edit.putInt(p, -1);
            edit.putInt(q, -1);
            edit.putInt(r, -1);
            edit.putString(s, null);
            edit.putInt(t, -1);
            edit.putString(u, null);
            edit.putString(v, null);
            edit.putInt(w, -1);
            edit.putInt(x, -1);
            edit.putInt(y, -1);
            edit.putInt(z, -1);
            edit.putInt(A, -1);
            edit.putInt(B, -1);
            edit.putInt(C, -1);
            edit.putInt(D, -1);
            edit.putInt(E, -1);
            edit.putInt(F, -1);
            edit.putInt(G, -1);
            edit.putInt(H, -1);
            edit.putInt(I, -1);
            edit.putInt(J, -1);
            edit.putInt(K, -1);
            edit.putInt(L, -1);
            edit.putInt(M, -1);
            edit.commit();
        } catch (Exception e2) {
            com.tencent.gsdk.utils.g.d("createPreferences error:" + e2.getMessage());
        }
    }

    public static void a(Context context, String str, String str2, Boolean bool) {
        if (context == null || str == null || str2 == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putBoolean(str2, bool.booleanValue());
            edit.commit();
        } catch (Exception e2) {
            com.tencent.gsdk.utils.g.d("updateBooleanPreferences error:" + e2.getMessage());
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || str == null || str2 == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            edit.commit();
        } catch (Exception e2) {
            com.tencent.gsdk.utils.g.d("updateStringPreferences error:" + e2.getMessage());
        }
    }

    public static void a(Context context, String str, String str2, int i2) {
        if (context == null || str == null || str2 == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putInt(str2, i2);
            edit.commit();
        } catch (Exception e2) {
            com.tencent.gsdk.utils.g.d("updateIntPreferences error:" + e2.getMessage());
        }
    }

    public static boolean a(Context context, String str, String str2) {
        boolean z2 = false;
        if (context == null || str == null || str2 == null) {
            return false;
        }
        try {
            z2 = context.getSharedPreferences(str, 0).getBoolean(str2, true);
            com.tencent.gsdk.utils.g.b(str2 + "boolean value is " + z2);
            return z2;
        } catch (Exception e2) {
            com.tencent.gsdk.utils.g.d("getBooleanPreferences error:" + e2.getMessage());
            return z2;
        }
    }

    public static String b(Context context, String str, String str2) {
        String str3 = "NULL";
        if (context == null || str == null || str2 == null) {
            return "NULL";
        }
        try {
            str3 = context.getSharedPreferences(str, 0).getString(str2, "NULL");
            com.tencent.gsdk.utils.g.b(str2 + " value is " + str3);
            return str3;
        } catch (Exception e2) {
            com.tencent.gsdk.utils.g.d("getStringPreferences error:" + e2.getMessage());
            return str3;
        }
    }

    public static int c(Context context, String str, String str2) {
        int i2 = 0;
        if (context == null || str == null || str2 == null) {
            return 0;
        }
        try {
            i2 = context.getSharedPreferences(str, 0).getInt(str2, 0);
            com.tencent.gsdk.utils.g.b(str2 + "int value is " + i2);
            return i2;
        } catch (Exception e2) {
            com.tencent.gsdk.utils.g.d("getIntPreferences error:" + e2.getMessage());
            return i2;
        }
    }
}
