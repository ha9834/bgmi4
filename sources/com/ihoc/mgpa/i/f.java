package com.ihoc.mgpa.i;

import com.adjust.sdk.Constants;
import com.ihoc.mgpa.c.r;
import com.ihoc.mgpa.g.o;
import com.ihoc.mgpa.n.p;
import com.tencent.midas.oversea.api.CocosPayHelper;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class f {
    private static ArrayList<Integer> E = null;

    /* renamed from: a, reason: collision with root package name */
    private static String f5613a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    public static ConcurrentHashMap<Object, String> g;
    private static long t;
    private static ConcurrentHashMap<String, String> f = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, String> h = new ConcurrentHashMap<>();
    public static String i = "1";
    private static String j = "1";
    private static String k = "0";
    public static String l = "";
    public static String m = "";
    public static String n = "";
    public static String o = "";
    private static long p = 0;
    public static String q = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
    public static String r = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
    private static String s = null;
    private static int u = 0;
    public static String v = "0";
    private static String w = v;
    private static String x = null;
    private static String y = null;
    private static String z = null;
    private static String A = null;
    private static String B = null;
    public static long C = 0;
    private static String D = "";
    public static boolean F = false;
    public static boolean G = false;
    private static String H = "0|0|0|0|0|0|0|0";
    private static int I = 0;
    private static int J = 0;
    private static int K = 0;
    private static int L = 0;
    private static int M = 0;
    private static int N = 0;
    private static int O = 0;
    private static int P = 0;
    private static ArrayList<String> Q = new ArrayList<>();
    public static boolean R = false;
    private static String S = Constants.NORMAL;
    public static String T = null;
    public static String U = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
    public static int V = -1;
    private static boolean W = true;
    private static String X = null;
    private static String Y = null;
    private static boolean Z = false;
    public static String aa = null;
    public static boolean ba = false;
    public static boolean ca = false;
    private static String da = null;
    private static boolean ea = false;

    public static int A() {
        return K;
    }

    private static void A(String str) {
        String str2 = h.get(com.ihoc.mgpa.a.e.FRAME_MISS.b());
        if (!p.b(str2)) {
            str = str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str;
        }
        h.put(com.ihoc.mgpa.a.e.FRAME_MISS.b(), str);
    }

    public static int B() {
        return L;
    }

    private static void B(String str) {
        String str2 = h.get(com.ihoc.mgpa.a.e.NET_LATENCY.b());
        if (!p.b(str2)) {
            str = str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str;
        }
        h.put(com.ihoc.mgpa.a.e.NET_LATENCY.b(), str);
    }

    public static int C() {
        return M;
    }

    private static void C(String str) {
        k = str;
        String str2 = h.get(com.ihoc.mgpa.a.e.ROLE_STATUS.b());
        if (str2 != null) {
            str = str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str;
        }
        h.put(com.ihoc.mgpa.a.e.RECORDING.b(), str);
    }

    public static int D() {
        return N;
    }

    private static void D(String str) {
        j = str;
        String str2 = h.get(com.ihoc.mgpa.a.e.ROLE_STATUS.b());
        if (str2 != null) {
            str = str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str;
        }
        h.put(com.ihoc.mgpa.a.e.ROLE_STATUS.b(), str);
    }

    public static int E() {
        return O;
    }

    private static void E(String str) {
        i = str;
        String str2 = h.get(com.ihoc.mgpa.a.e.USERS_COUNT.b());
        if (str2 != null) {
            str = str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2;
        }
        h.put(com.ihoc.mgpa.a.e.USERS_COUNT.b(), str);
    }

    public static int F() {
        return P;
    }

    public static String G() {
        return H;
    }

    public static String H() {
        return x;
    }

    public static boolean I() {
        return o.b().b.Q;
    }

    public static boolean J() {
        return o.b().b.e;
    }

    public static boolean K() {
        return o.b().b.i;
    }

    public static boolean L() {
        return o.b().b.E;
    }

    public static boolean M() {
        return Z;
    }

    public static boolean N() {
        return o.b().b.p;
    }

    public static boolean O() {
        return ea;
    }

    public static boolean P() {
        return o.b().b.y;
    }

    public static boolean Q() {
        return o.b().b.j;
    }

    public static boolean R() {
        return o.b().b.H;
    }

    public static boolean S() {
        return o.b().b.h;
    }

    public static boolean T() {
        return o.b().b.k;
    }

    public static boolean U() {
        return o.b().b.z;
    }

    public static boolean V() {
        return o.b().b.v;
    }

    public static boolean W() {
        return o.b().b.r;
    }

    public static boolean X() {
        return o.b().b.F;
    }

    public static boolean Y() {
        return o.b().b.d;
    }

    public static boolean Z() {
        return o.b().b.I;
    }

    public static int a(String str) {
        return Q.contains(str) ? 1 : 0;
    }

    public static String a() {
        return b;
    }

    public static void a(int i2) {
        V = i2;
    }

    public static void a(int i2, String str) {
        switch (e.f5612a[com.ihoc.mgpa.a.e.a(i2).ordinal()]) {
            case 1:
                m(str);
                return;
            case 2:
                u(str);
                return;
            case 3:
                A(str);
                return;
            case 4:
                w(str);
                return;
            case 5:
                p(str);
                return;
            case 6:
                i(str);
                return;
            case 7:
                r(str);
                return;
            case 8:
                B(str);
                return;
            case 9:
                E(str);
                return;
            case 10:
                D(str);
                return;
            case 11:
                C(str);
                return;
            case 12:
                q(str);
                return;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                return;
            default:
                h.put(String.valueOf(i2), str);
                return;
        }
    }

    public static void a(long j2) {
        C = j2;
    }

    public static void a(Object obj, String str) {
        if (g == null) {
            g = new ConcurrentHashMap<>();
        }
        g.put(obj, str);
    }

    public static void a(String str, String str2) {
        h.put(str, str2);
    }

    public static void a(Map<String, String> map) {
        f.clear();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            f.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
        }
    }

    public static void a(boolean z2) {
        Z = z2;
    }

    public static boolean aa() {
        return o.b().b.w;
    }

    public static String b() {
        return com.ihoc.mgpa.n.b.b(E, "|");
    }

    public static void b(int i2) {
        I = i2;
    }

    public static void b(long j2) {
        p = j2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0070. Please report as an issue. */
    public static void b(String str) {
        char c2;
        ConcurrentHashMap<String, String> concurrentHashMap;
        String str2;
        switch (str.hashCode()) {
            case -828156901:
                if (str.equals("avg_frame_miss")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -244156242:
                if (str.equals("fps_level")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 54:
                if (str.equals(com.tencent.connect.common.Constants.VIA_SHARE_TYPE_INFO)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 1568:
                if (str.equals(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1569:
                if (str.equals(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1570:
                if (str.equals(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 1573:
                if (str.equals(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 235658863:
                if (str.equals("avg_net_latency")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 856385104:
                if (str.equals("dynamic_setting")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 941560665:
                if (str.equals("temp_level")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
                concurrentHashMap = h;
                str2 = "";
                concurrentHashMap.put(str, str2);
                return;
            case 4:
                concurrentHashMap = h;
                str2 = i;
                concurrentHashMap.put(str, str2);
                return;
            case 5:
                concurrentHashMap = h;
                str2 = j;
                concurrentHashMap.put(str, str2);
                return;
            case 6:
                concurrentHashMap = h;
                str2 = k;
                concurrentHashMap.put(str, str2);
                return;
            case 7:
                z("");
                return;
            case '\b':
                j("");
                return;
            case '\t':
                h("");
                return;
            default:
                return;
        }
    }

    public static void b(boolean z2) {
        ea = z2;
    }

    public static boolean ba() {
        return o.b().b.x;
    }

    public static String c() {
        return q;
    }

    public static void c(int i2) {
        J = i2;
    }

    public static void c(String str) {
        Q.add(str);
    }

    public static void c(boolean z2) {
        G = z2;
    }

    public static boolean ca() {
        return o.b().b.C;
    }

    public static String d() {
        return r.equals(CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR) ? q : r;
    }

    public static void d(int i2) {
        K = i2;
    }

    public static void d(String str) {
        A = str;
    }

    public static boolean da() {
        return o.b().b.s;
    }

    public static String e() {
        return z;
    }

    public static void e(int i2) {
        L = i2;
    }

    public static void e(String str) {
        b = str;
    }

    public static boolean ea() {
        return o.b().b.t;
    }

    public static String f() {
        return D;
    }

    public static void f(int i2) {
        M = i2;
    }

    public static void f(String str) {
        q = str;
    }

    public static boolean fa() {
        return o.b().b.u;
    }

    public static Map<String, String> g() {
        return f;
    }

    public static void g(int i2) {
        N = i2;
    }

    public static void g(String str) {
        r = str;
        h.put("trans_id", str);
    }

    public static boolean ga() {
        return o.b().b.f5575a;
    }

    public static long h() {
        return C;
    }

    public static void h(int i2) {
        O = i2;
    }

    public static void h(String str) {
        z = str;
    }

    public static boolean ha() {
        return F;
    }

    public static String i() {
        return B;
    }

    public static void i(int i2) {
        P = i2;
    }

    public static void i(String str) {
        h.put(com.ihoc.mgpa.a.e.EFFECT_LEVEL.b(), str);
        o = str;
    }

    public static boolean ia() {
        return o.b().b.G;
    }

    public static String j() {
        return c;
    }

    public static void j(String str) {
        y = str;
    }

    public static boolean ja() {
        return o.b().b.g;
    }

    public static String k() {
        return v;
    }

    public static void k(String str) {
        D = str;
    }

    public static boolean ka() {
        return o.b().b.o;
    }

    public static int l() {
        return u;
    }

    public static void l(String str) {
        B = str;
    }

    public static boolean la() {
        return o.b().b.n;
    }

    public static long m() {
        return t;
    }

    public static void m(String str) {
        c = str;
        com.ihoc.mgpa.n.o.b("main_version_code", c);
    }

    public static boolean ma() {
        return o.b().b.K;
    }

    public static String n() {
        return s;
    }

    public static void n(String str) {
        if (v.compareTo(str) != 0) {
            u++;
            w = v;
        }
        v = str;
        a(com.ihoc.mgpa.a.f.MAP_ID.a(), str);
    }

    public static boolean na() {
        return o.b().b.B;
    }

    public static int o() {
        return V;
    }

    public static void o(String str) {
        T = str;
    }

    public static boolean oa() {
        return o.b().b.J;
    }

    public static String p() {
        return T;
    }

    public static void p(String str) {
        h.put(com.ihoc.mgpa.a.e.MODEL_LEVEL.b(), str);
        n = str;
    }

    public static boolean pa() {
        return o.b().b.l;
    }

    public static String q() {
        return f5613a;
    }

    public static void q(String str) {
        f5613a = str;
    }

    public static boolean qa() {
        return o.b().b.D;
    }

    public static String r() {
        return X;
    }

    public static void r(String str) {
        h.put(com.ihoc.mgpa.a.e.ROLE_OUTLINE.b(), str);
        m = str;
    }

    public static boolean ra() {
        return G;
    }

    public static long s() {
        return p;
    }

    public static void s(String str) {
        X = str;
    }

    public static boolean sa() {
        return o.b().b.q;
    }

    public static String t() {
        return S;
    }

    public static void t(String str) {
        S = str;
    }

    public static void ta() {
        H = y() + "|" + z() + "|" + A() + "|" + B() + "|" + C() + "|" + D() + "|" + E() + "|" + F();
    }

    public static String u() {
        return d;
    }

    public static void u(String str) {
        d = str;
        com.ihoc.mgpa.n.o.b("sub_version_code", d);
    }

    public static void ua() {
        E = new ArrayList<>();
        E.add(Integer.valueOf(ga() ? 1 : 0));
        E.add(Integer.valueOf(Y() ? 1 : 0));
        E.add(Integer.valueOf(J() ? 1 : 0));
        E.add(Integer.valueOf(da() ? 1 : 0));
        E.add(Integer.valueOf(ja() ? 1 : 0));
        E.add(Integer.valueOf(S() ? 1 : 0));
        E.add(Integer.valueOf(pa() ? 1 : 0));
        E.add(Integer.valueOf(P() ? 1 : 0));
        E.add(Integer.valueOf(V() ? 1 : 0));
        E.add(Integer.valueOf(K() ? 1 : 0));
        E.add(Integer.valueOf(Q() ? 1 : 0));
        E.add(Integer.valueOf(aa() ? 1 : 0));
        E.add(Integer.valueOf(ea() ? 1 : 0));
        E.add(Integer.valueOf(fa() ? 1 : 0));
    }

    public static String v() {
        return Y;
    }

    public static void v(String str) {
        Y = str;
    }

    public static String w() {
        return da;
    }

    public static void w(String str) {
        l = str;
        h.put(com.ihoc.mgpa.a.e.FPS_TARGET.b(), str);
    }

    public static String x() {
        return e;
    }

    public static void x(String str) {
        da = str;
    }

    public static int y() {
        return I;
    }

    public static void y(String str) {
        e = str;
        if (na()) {
            try {
                if (g().isEmpty()) {
                    return;
                }
                r.a(g());
            } catch (Exception unused) {
                com.ihoc.mgpa.n.m.a("TGPA", "report user info exception. ");
            }
        }
    }

    public static int z() {
        return J;
    }

    public static void z(String str) {
        x = str;
    }
}
