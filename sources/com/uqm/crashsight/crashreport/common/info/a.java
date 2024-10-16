package com.uqm.crashsight.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class a {
    private static String J = "unknown";
    private static a af;
    private static final Object au = new Object();
    public boolean B;
    public SharedPreferences F;
    private final Context G;
    private String H;
    private String I;
    private String aa;
    public String c;
    public final String d;
    public final String g;
    public final String h;
    public final String i;
    public long j;
    public String k;
    public String l;
    public String m;
    public List<String> p;
    public boolean v;
    public String w;
    public String x;
    public String y;
    public String z;
    public boolean e = true;
    public String f = "4.2.5";
    private String K = "unknown";
    private String L = "";
    private String M = null;
    private String N = null;
    private String O = null;
    private String P = null;
    private long Q = -1;
    private long R = -1;
    private long S = -1;
    private long T = -1;
    private long U = -1;
    private String V = null;
    private String W = null;
    private Map<String, PlugInBean> X = null;
    private boolean Y = true;
    private String Z = null;
    private Boolean ab = null;
    private String ac = null;
    public String n = null;
    public String o = null;
    private Map<String, PlugInBean> ad = null;
    private Map<String, PlugInBean> ae = null;
    private int ag = -1;
    private String ah = "";
    private int ai = -1;
    private Map<String, String> aj = new HashMap();
    private Map<String, String> ak = new HashMap();
    private Map<String, String> al = new HashMap();
    private boolean am = true;
    public String q = "unknown";
    public long r = 0;
    public long s = 0;
    public long t = 0;
    public long u = 0;
    public boolean A = false;
    private Boolean an = null;
    private Boolean ao = null;
    public HashMap<String, String> C = new HashMap<>();
    public List<String> D = new ArrayList();
    public com.uqm.crashsight.crashreport.a E = null;
    private final Object ap = new Object();
    private final Object aq = new Object();
    private final Object ar = new Object();
    private final Object as = new Object();

    /* renamed from: at, reason: collision with root package name */
    private final Object f6570at = new Object();
    private final Object av = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final long f6569a = System.currentTimeMillis();
    public final byte b = 1;

    private a(Context context) {
        this.k = null;
        this.l = null;
        this.aa = null;
        this.m = null;
        this.p = null;
        this.v = false;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = "";
        this.B = false;
        this.G = q.a(context);
        PackageInfo b = AppInfo.b(context);
        if (b != null) {
            try {
                this.k = b.versionName;
                this.w = this.k;
                this.x = Integer.toString(b.versionCode);
            } catch (Throwable th) {
                if (!m.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.c = AppInfo.a(context);
        this.d = AppInfo.a(Process.myPid());
        this.g = c.o();
        this.h = c.a();
        this.l = AppInfo.c(context);
        this.i = "Android " + c.b() + ",level " + c.c();
        String str = this.h + ";" + this.i;
        Map<String, String> d = AppInfo.d(context);
        if (d != null) {
            try {
                this.p = AppInfo.a(d);
                String str2 = d.get("CS_APPID");
                if (str2 != null) {
                    this.aa = str2;
                    c("APP_ID", this.aa);
                }
                String str3 = d.get("CS_APP_VERSION");
                if (str3 != null) {
                    this.k = str3;
                }
                String str4 = d.get("CS_APP_CHANNEL");
                if (str4 != null) {
                    this.m = str4;
                }
                String str5 = d.get("CS_ENABLE_DEBUG");
                if (str5 != null) {
                    this.v = str5.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
                String str6 = d.get("");
                if (str6 != null) {
                    this.y = str6;
                }
                String str7 = d.get("CS_APP_BUILD_NO");
                if (!TextUtils.isEmpty(str7)) {
                    Integer.parseInt(str7);
                }
                String str8 = d.get("CS_AREA");
                if (str8 != null) {
                    this.z = str8;
                }
            } catch (Throwable th2) {
                if (!m.a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("crashSight_db_").exists()) {
                this.B = true;
                m.c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (com.uqm.crashsight.b.c) {
                th3.printStackTrace();
            }
        }
        this.F = q.a("CS_COMMON_VALUES", context);
        m.c("com info create end", new Object[0]);
    }

    public final boolean a() {
        return this.am;
    }

    public final void a(boolean z) {
        this.am = z;
        com.uqm.crashsight.crashreport.a aVar = this.E;
        if (aVar != null) {
            aVar.setNativeIsAppForeground(z);
        }
        d a2 = d.a();
        if (a2 != null) {
            a2.a(this.am);
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (af == null) {
                af = new a(context);
            }
            aVar = af;
        }
        return aVar;
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            aVar = af;
        }
        return aVar;
    }

    public final String c() {
        return this.f;
    }

    public final void d() {
        synchronized (this.ap) {
            this.H = UUID.randomUUID().toString();
        }
    }

    public final String e() {
        String str;
        synchronized (this.ap) {
            if (this.H == null) {
                synchronized (this.ap) {
                    this.H = UUID.randomUUID().toString();
                }
            }
            str = this.H;
        }
        return str;
    }

    public final String f() {
        if (q.a((String) null)) {
            return this.aa;
        }
        return null;
    }

    public final void a(String str) {
        this.aa = str;
        c("APP_ID", str);
    }

    public static String g() {
        String str;
        synchronized (au) {
            str = J;
        }
        return str;
    }

    public static void b(String str) {
        synchronized (au) {
            if (str == null) {
                str = "10000";
            }
            J = str;
        }
    }

    public final void b(boolean z) {
        this.Y = z;
    }

    public final String h() {
        String str;
        String str2 = this.I;
        if (str2 != null) {
            return str2;
        }
        if (this.Y) {
            if (this.P == null) {
                this.P = c.a(this.G);
            }
            str = this.P;
        } else {
            str = "";
        }
        this.I = str;
        return this.I;
    }

    public final void c(String str) {
        this.I = str;
        synchronized (this.av) {
            this.ak.put("E8", str);
        }
    }

    public final synchronized String i() {
        return this.K;
    }

    public final synchronized void d(String str) {
        this.K = str;
    }

    public final synchronized String j() {
        return this.L;
    }

    public final synchronized void e(String str) {
        this.L = str;
    }

    public final String k() {
        if (!this.Y) {
            return "";
        }
        if (this.M == null) {
            Context context = this.G;
            this.M = c.d();
        }
        return this.M;
    }

    public final String l() {
        if (!this.Y) {
            return "";
        }
        String str = this.N;
        if (str == null || !str.contains(CertificateUtil.DELIMITER)) {
            Context context = this.G;
            this.N = c.f();
        }
        return this.N;
    }

    public final String m() {
        if (!this.Y) {
            return "";
        }
        if (this.O == null) {
            Context context = this.G;
            this.O = c.e();
        }
        return this.O;
    }

    public final long n() {
        if (this.Q <= 0) {
            this.Q = c.g();
        }
        return this.Q;
    }

    public final long o() {
        if (this.R <= 0) {
            this.R = c.i();
        }
        return this.R;
    }

    public final long p() {
        if (this.U <= 0) {
            this.U = c.l();
        }
        return this.U;
    }

    public final String q() {
        if (this.V == null) {
            this.V = c.b(this.G, true);
        }
        return this.V;
    }

    public final String r() {
        if (this.W == null) {
            this.W = c.d(this.G);
        }
        return this.W;
    }

    public final void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        synchronized (this.aq) {
            this.C.put(str, str2);
        }
    }

    public final String s() {
        try {
            Map<String, ?> all = this.G.getSharedPreferences("CrashSightSdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.aq) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        try {
                            this.C.put(entry.getKey(), entry.getValue().toString());
                        } catch (Throwable th) {
                            m.a(th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            m.a(th2);
        }
        if (!this.C.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry2 : this.C.entrySet()) {
                sb.append("[");
                sb.append(entry2.getKey());
                sb.append(",");
                sb.append(entry2.getValue());
                sb.append("] ");
            }
            m.c("SDK_INFO = %s", sb.toString());
            c("SDK_INFO", sb.toString());
            return sb.toString();
        }
        m.c("SDK_INFO is empty", new Object[0]);
        return null;
    }

    public final synchronized Map<String, PlugInBean> t() {
        return null;
    }

    public final String u() {
        if (this.Z == null) {
            this.Z = c.n();
        }
        return this.Z;
    }

    public final Boolean v() {
        if (this.ab == null) {
            this.ab = Boolean.valueOf(c.p());
        }
        return this.ab;
    }

    public final String w() {
        if (this.ac == null) {
            this.ac = c.c(this.G);
            m.a("ROM ID: %s", this.ac);
        }
        return this.ac;
    }

    public final Map<String, String> x() {
        synchronized (this.ar) {
            if (this.aj.size() <= 0) {
                return null;
            }
            return new HashMap(this.aj);
        }
    }

    public final String f(String str) {
        String remove;
        if (q.a(str)) {
            m.d("key should not be empty %s", str);
            return null;
        }
        synchronized (this.ar) {
            remove = this.aj.remove(str);
        }
        return remove;
    }

    public final void y() {
        synchronized (this.ar) {
            this.aj.clear();
        }
    }

    public final String g(String str) {
        String str2;
        if (q.a(str)) {
            m.d("key should not be empty %s", str);
            return null;
        }
        synchronized (this.ar) {
            str2 = this.aj.get(str);
        }
        return str2;
    }

    public final void b(String str, String str2) {
        if (q.a(str) || q.a(str2)) {
            m.d("key&value should not be empty %s %s", str, str2);
            return;
        }
        synchronized (this.ar) {
            this.aj.put(str, str2);
        }
    }

    public final int z() {
        int size;
        synchronized (this.ar) {
            size = this.aj.size();
        }
        return size;
    }

    public final Set<String> A() {
        Set<String> keySet;
        synchronized (this.ar) {
            keySet = this.aj.keySet();
        }
        return keySet;
    }

    public final Map<String, String> B() {
        synchronized (this.av) {
            if (this.ak.size() <= 0) {
                return null;
            }
            return new HashMap(this.ak);
        }
    }

    public final void c(String str, String str2) {
        if (q.a(str) || q.a(str2)) {
            m.d("server key&value should not be empty %s %s", str, str2);
            return;
        }
        synchronized (this.as) {
            this.al.put(str, str2);
        }
    }

    public final Map<String, String> C() {
        synchronized (this.as) {
            if (this.al.size() <= 0) {
                return null;
            }
            return new HashMap(this.al);
        }
    }

    public final void a(int i) {
        synchronized (this.f6570at) {
            int i2 = this.ag;
            if (i2 != i) {
                this.ag = i;
                m.a("user scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(this.ag));
            }
        }
    }

    public final void h(String str) {
        synchronized (this.f6570at) {
            String str2 = this.ah;
            if (str2 == null || !str2.equals(str)) {
                this.ah = str;
                m.a("user scene tag %s changed to tag %s", str2, this.ah);
            }
        }
    }

    public final String D() {
        String str;
        synchronized (this.f6570at) {
            str = this.ah;
        }
        return str;
    }

    public final int E() {
        int i;
        synchronized (this.f6570at) {
            i = this.ag;
        }
        return i;
    }

    public final void b(int i) {
        int i2 = this.ai;
        if (i2 != 24096) {
            this.ai = 24096;
            m.a("server scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(this.ai));
        }
    }

    public final int F() {
        return this.ai;
    }

    public final synchronized Map<String, PlugInBean> G() {
        return null;
    }

    public static int H() {
        return c.c();
    }

    public final boolean I() {
        if (this.an == null) {
            this.an = Boolean.valueOf(c.e(this.G));
            m.a("Is it a virtual machine? " + this.an, new Object[0]);
        }
        return this.an.booleanValue();
    }

    public final boolean J() {
        if (this.ao == null) {
            this.ao = Boolean.valueOf(c.f(this.G));
            m.a("Does it has hook frame? " + this.ao, new Object[0]);
        }
        return this.ao.booleanValue();
    }

    public final long K() {
        return this.S;
    }

    public final long L() {
        return this.T;
    }

    public final long M() {
        return this.f6569a;
    }
}
