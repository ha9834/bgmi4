package com.uqm.crashsight.crashreport.crash;

import android.content.Context;
import com.uqm.crashsight.crashreport.common.strategy.StrategyBean;
import com.uqm.crashsight.proguard.k;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.o;
import com.uqm.crashsight.proguard.q;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f6594a;
    private com.uqm.crashsight.crashreport.common.strategy.a b;
    private com.uqm.crashsight.crashreport.common.info.a c;
    private b d;
    private Context e;

    static /* synthetic */ void a(d dVar) {
        m.c("[ExtraCrashManager] Trying to notify CrashSight agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.uqm.crashsight.agent.GameAgent");
            String str = "com.uqm.crashsight";
            dVar.c.getClass();
            if (!"".equals("")) {
                str = "com.uqm.crashsight.";
            }
            q.a(cls, "sdkPackageName", str, null);
            m.c("[ExtraCrashManager] CrashSight game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            m.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void a(d dVar, Thread thread, int i, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        String str6;
        if (thread == null) {
            thread = Thread.currentThread();
        }
        if (i != 1000) {
            switch (i) {
                case 4:
                    str4 = "Unity";
                    break;
                case 5:
                case 6:
                    str4 = "Cocos";
                    break;
                default:
                    switch (i) {
                        case 8:
                            str4 = "H5";
                            break;
                        case 9:
                            str4 = "OOM";
                            break;
                        default:
                            m.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i));
                            return;
                    }
            }
        } else {
            str4 = "EnterSubMap";
        }
        String str7 = str4;
        m.e("[ExtraCrashManager] %s Crash Happen", str7);
        try {
            try {
                if (!dVar.b.b()) {
                    m.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
                }
                StrategyBean c = dVar.b.c();
                if (!c.e && dVar.b.b()) {
                    m.e("[ExtraCrashManager] Crash report was closed by remote , will not upload to CrashSight , print local for helpful!", new Object[0]);
                    b.a(str7, q.a(), dVar.c.d, thread.getName(), str + "\n" + str2 + "\n" + str3, null);
                    m.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
                switch (i) {
                    case 5:
                    case 6:
                        if (!c.j) {
                            m.e("[ExtraCrashManager] %s report is disabled.", str7);
                            m.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                            return;
                        }
                        break;
                    case 8:
                        if (!c.k) {
                            m.e("[ExtraCrashManager] %s report is disabled.", str7);
                            m.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                            return;
                        }
                        break;
                }
                if (i == 8) {
                    i = 5;
                }
                CrashDetailBean crashDetailBean = new CrashDetailBean();
                crashDetailBean.D = com.uqm.crashsight.crashreport.common.info.c.k();
                crashDetailBean.E = com.uqm.crashsight.crashreport.common.info.c.h();
                crashDetailBean.F = com.uqm.crashsight.crashreport.common.info.c.m();
                crashDetailBean.G = dVar.c.o();
                crashDetailBean.H = dVar.c.n();
                crashDetailBean.I = dVar.c.p();
                crashDetailBean.x = q.a(dVar.e, c.e, (String) null);
                crashDetailBean.b = i;
                crashDetailBean.e = dVar.c.h();
                crashDetailBean.f = dVar.c.k;
                crashDetailBean.g = dVar.c.u();
                com.uqm.crashsight.crashreport.common.info.a aVar = dVar.c;
                crashDetailBean.m = com.uqm.crashsight.crashreport.common.info.a.g();
                crashDetailBean.n = str;
                crashDetailBean.o = str2;
                str5 = "";
                if (str3 != null) {
                    String[] split = str3.split("\n");
                    str5 = split.length > 0 ? split[0] : "";
                    str6 = str3;
                } else {
                    str6 = "";
                }
                crashDetailBean.p = str5;
                crashDetailBean.q = str6;
                crashDetailBean.s = System.currentTimeMillis();
                crashDetailBean.v = q.a(crashDetailBean.q.getBytes());
                crashDetailBean.A = q.a(c.f, false);
                crashDetailBean.B = dVar.c.d;
                crashDetailBean.C = thread.getName() + "(" + thread.getId() + ")";
                crashDetailBean.J = dVar.c.w();
                crashDetailBean.h = dVar.c.t();
                crashDetailBean.N = dVar.c.f6569a;
                crashDetailBean.O = dVar.c.a();
                if (!c.a().p()) {
                    dVar.d.d(crashDetailBean);
                }
                crashDetailBean.R = dVar.c.E();
                crashDetailBean.S = dVar.c.F();
                crashDetailBean.T = dVar.c.x();
                crashDetailBean.U = dVar.c.C();
                crashDetailBean.z = o.a();
                if (crashDetailBean.P == null) {
                    crashDetailBean.P = new LinkedHashMap();
                }
                if (map != null) {
                    crashDetailBean.P.putAll(map);
                }
                b.a(str7, q.a(), dVar.c.d, thread.getName(), str + "\n" + str2 + "\n" + str3, crashDetailBean);
                if (!dVar.d.a(crashDetailBean)) {
                    dVar.d.a(crashDetailBean, 3000L, false);
                }
                m.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th) {
                if (!m.a(th)) {
                    th.printStackTrace();
                }
                m.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            }
        } catch (Throwable th2) {
            m.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            throw th2;
        }
    }

    private d(Context context) {
        c a2 = c.a();
        if (a2 == null) {
            return;
        }
        this.b = com.uqm.crashsight.crashreport.common.strategy.a.a();
        this.c = com.uqm.crashsight.crashreport.common.info.a.a(context);
        this.d = a2.p;
        this.e = context;
        k.a().a(new Runnable() { // from class: com.uqm.crashsight.crashreport.crash.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.a(d.this);
            }
        });
    }

    public static d a(Context context) {
        if (f6594a == null) {
            f6594a = new d(context);
        }
        return f6594a;
    }

    public static void a(final Thread thread, final int i, final String str, final String str2, final String str3, final Map<String, String> map) {
        k.a().a(new Runnable() { // from class: com.uqm.crashsight.crashreport.crash.d.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (d.f6594a != null) {
                        d.a(d.f6594a, thread, i, str, str2, str3, map);
                    } else {
                        m.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    }
                } catch (Throwable th) {
                    if (!m.b(th)) {
                        th.printStackTrace();
                    }
                    m.e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }
}
