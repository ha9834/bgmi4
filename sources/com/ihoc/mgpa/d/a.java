package com.ihoc.mgpa.d;

import android.content.Context;
import android.os.Build;
import com.ihoc.mgpa.TGPANative;
import com.ihoc.mgpa.n.f;
import com.ihoc.mgpa.n.m;
import com.ihoc.mgpa.n.o;
import com.tencent.midas.oversea.api.CocosPayHelper;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f5510a;
    private static String b;

    public static String a() {
        if (!TGPANative.tryLoadLibrary()) {
            return "-9";
        }
        if (com.ihoc.mgpa.n.a.a() == null) {
            return "-10";
        }
        if (!j()) {
            return "-13";
        }
        String b2 = b(com.ihoc.mgpa.n.a.a());
        if (b2 == null) {
            return "-11";
        }
        if (b2.length() != 66) {
            return "-12";
        }
        o.b("XID", b2.substring(2));
        return b2;
    }

    public static String a(int i) {
        if (!TGPANative.tryLoadLibrary()) {
            return "-9";
        }
        if (!l()) {
            return "-13";
        }
        if (com.ihoc.mgpa.n.a.a() == null) {
            return "-10";
        }
        String goa = TGPANative.goa(com.ihoc.mgpa.n.a.a(), i);
        return goa == null ? "-11" : goa;
    }

    private static synchronized String a(Context context) {
        synchronized (a.class) {
            if (Build.VERSION.SDK_INT < 21 && f.a("android.permission.READ_PHONE_STATE")) {
                return b(context);
            }
            if (f5510a == null) {
                f5510a = TGPANative.yje(context);
            }
            return f5510a;
        }
    }

    public static String b() {
        if (!TGPANative.tryLoadLibrary()) {
            return "-9";
        }
        if (com.ihoc.mgpa.n.a.a() == null) {
            return "-10";
        }
        if (!j()) {
            return "-13";
        }
        String b2 = b(com.ihoc.mgpa.n.a.a());
        if (b2 == null) {
            return "-11";
        }
        if (b2.length() != 66) {
            return "-12";
        }
        String substring = b2.substring(2);
        o.b("XID", substring);
        return substring;
    }

    private static synchronized String b(Context context) {
        String str;
        synchronized (a.class) {
            if (b == null) {
                b = TGPANative.zkf(context);
            }
            str = b;
        }
        return str;
    }

    public static String c() {
        if (!TGPANative.tryLoadLibrary()) {
            return "-9";
        }
        if (com.ihoc.mgpa.n.a.a() == null) {
            return "-10";
        }
        if (!k()) {
            return "-13";
        }
        String a2 = a(com.ihoc.mgpa.n.a.a());
        if (a2 == null) {
            return "-11";
        }
        if (a2.length() == 66) {
            o.b("UID", a2.substring(2));
            return a2;
        }
        m.b("UID length is not right, ple check! errorid: " + a2, new Object[0]);
        return "-12";
    }

    public static String d() {
        if (!TGPANative.tryLoadLibrary()) {
            return "-9";
        }
        if (com.ihoc.mgpa.n.a.a() == null) {
            return "-10";
        }
        if (!k()) {
            return "-13";
        }
        String a2 = a(com.ihoc.mgpa.n.a.a());
        if (a2 == null) {
            return "-11";
        }
        if (a2.length() == 66) {
            String substring = a2.substring(2);
            o.b("UID", substring);
            return substring;
        }
        m.b("UID length is not right, ple check! errorid: " + a2, new Object[0]);
        return "-12";
    }

    public static synchronized String e() {
        synchronized (a.class) {
            if (!TGPANative.tryLoadLibrary()) {
                return "-9";
            }
            if (!i()) {
                return "-13";
            }
            String dbg = TGPANative.dbg();
            return dbg == null ? "-11" : dbg;
        }
    }

    public static String f() {
        if (com.ihoc.mgpa.n.a.a() == null) {
            return "-2";
        }
        String c = c();
        return c.length() == 66 ? c.substring(0, 1) : CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
    }

    public static String g() {
        if (com.ihoc.mgpa.n.a.a() == null) {
            return "-2";
        }
        String c = c();
        return c.length() == 66 ? c.substring(1, 2) : CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
    }

    public static String h() {
        if (com.ihoc.mgpa.n.a.a() == null) {
            return "-2";
        }
        String a2 = a();
        return a2.length() == 66 ? a2.substring(0, 2) : CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
    }

    private static boolean i() {
        return com.ihoc.mgpa.i.f.L();
    }

    private static boolean j() {
        return com.ihoc.mgpa.i.f.ca();
    }

    private static boolean k() {
        return com.ihoc.mgpa.i.f.na();
    }

    private static boolean l() {
        return com.ihoc.mgpa.i.f.qa();
    }
}
