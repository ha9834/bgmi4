package com.uqm.crashsight.crashreport.common.strategy;

import android.content.Context;
import com.uqm.crashsight.crashreport.biz.b;
import com.uqm.crashsight.crashreport.common.info.SightPkg;
import com.uqm.crashsight.proguard.c;
import com.uqm.crashsight.proguard.d;
import com.uqm.crashsight.proguard.f;
import com.uqm.crashsight.proguard.k;
import com.uqm.crashsight.proguard.l;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.q;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f6575a = 1000;
    private static a b;
    private static String h;
    private final List<com.uqm.crashsight.a> c;
    private final k d;
    private final StrategyBean e;
    private Context g;
    private StrategyBean f = null;
    private String i = null;

    private a(Context context, List<com.uqm.crashsight.a> list) {
        this.g = context;
        if (com.uqm.crashsight.crashreport.common.info.a.a(context) != null) {
            String str = com.uqm.crashsight.crashreport.common.info.a.a(context).z;
            if ("oversea".equals(str) || "na_https".equals(str)) {
                StrategyBean.f6574a = "https://android.crashsight.qq.com/rqd/pb/async";
                StrategyBean.b = "https://android.crashsight.qq.com/rqd/pb/async";
            }
        }
        this.e = new StrategyBean();
        this.c = list;
        this.d = k.a();
    }

    public static synchronized a a(Context context, List<com.uqm.crashsight.a> list) {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a(context, list);
            }
            aVar = b;
        }
        return aVar;
    }

    public final void a(long j) {
        this.d.a(new Thread() { // from class: com.uqm.crashsight.crashreport.common.strategy.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    Map<String, byte[]> a2 = d.a().a(a.f6575a, (c) null, true);
                    if (a2 != null) {
                        byte[] bArr = a2.get("device");
                        byte[] bArr2 = a2.get("gateway");
                        if (bArr != null) {
                            com.uqm.crashsight.crashreport.common.info.a.a(a.this.g).e(new String(bArr));
                        }
                        if (bArr2 != null) {
                            com.uqm.crashsight.crashreport.common.info.a.a(a.this.g).d(new String(bArr2));
                        }
                    }
                    a aVar = a.this;
                    a aVar2 = a.this;
                    aVar.f = a.d();
                    if (a.this.f != null) {
                        if (q.a(a.h) || !q.c(a.h)) {
                            a.this.f.p = StrategyBean.f6574a;
                            a.this.f.q = StrategyBean.b;
                        } else {
                            a.this.f.p = a.h;
                            a.this.f.q = a.h;
                        }
                    }
                } catch (Throwable th) {
                    if (!m.a(th)) {
                        th.printStackTrace();
                    }
                }
                if (a.this.f == null) {
                    l.a("localStrategy is null", new Object[0]);
                }
                a aVar3 = a.this;
                aVar3.a(aVar3.f, false);
            }
        }, j);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            aVar = b;
        }
        return aVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized boolean b() {
        return this.f != null;
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.f;
        if (strategyBean != null) {
            if (!q.c(strategyBean.p)) {
                this.f.p = StrategyBean.f6574a;
            }
            if (!q.c(this.f.q)) {
                this.f.q = StrategyBean.b;
            }
            return this.f;
        }
        if (!q.a(h) && q.c(h)) {
            StrategyBean strategyBean2 = this.e;
            String str = h;
            strategyBean2.p = str;
            strategyBean2.q = str;
        }
        return this.e;
    }

    protected final void a(StrategyBean strategyBean, boolean z) {
        m.c("[Strategy] Notify %s", b.class.getName());
        b.a(strategyBean, z);
        for (com.uqm.crashsight.a aVar : this.c) {
            try {
                m.c("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!m.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (q.a(str) || !q.c(str)) {
            m.d("URL user set is invalid.", new Object[0]);
        } else {
            h = str;
        }
    }

    public final void a(SightPkg.RqdStrategy rqdStrategy) {
        if (rqdStrategy == null) {
            return;
        }
        if (this.f != null && rqdStrategy.getStrategylastUpdateTime() == this.f.n) {
            l.a("localStrategy strategyLastUpdateTime == downloadStrategy strategyLastUpdateTime", new Object[0]);
            return;
        }
        StrategyBean strategyBean = new StrategyBean();
        strategyBean.e = rqdStrategy.getEnable();
        strategyBean.g = rqdStrategy.getEnableQuery();
        strategyBean.f = rqdStrategy.getEnableUserInfo();
        if (q.a(h) || !q.c(h)) {
            if (q.c(rqdStrategy.getUrl())) {
                m.c("[Strategy] Upload url changes to %s", rqdStrategy.getUrl());
                strategyBean.p = rqdStrategy.getUrl();
            }
            if (q.c(rqdStrategy.getExpUrl())) {
                m.c("[Strategy] Exception upload url changes to %s", rqdStrategy.getExpUrl());
                strategyBean.q = rqdStrategy.getExpUrl();
            }
        }
        if (rqdStrategy.getSecurity() != null && !q.a(rqdStrategy.getSecurity().getEncKey())) {
            strategyBean.r = rqdStrategy.getSecurity().getEncKey();
        }
        if (rqdStrategy.getStrategylastUpdateTime() != 0) {
            strategyBean.n = rqdStrategy.getStrategylastUpdateTime();
        }
        if (rqdStrategy.getValueMap() != null && rqdStrategy.getValueMap().size() > 0) {
            strategyBean.s = rqdStrategy.getValueMap();
            String str = rqdStrategy.getValueMap().get("B11");
            if (str != null && str.equals("1")) {
                strategyBean.h = true;
            } else {
                strategyBean.h = false;
            }
            String str2 = rqdStrategy.getValueMap().get("B3");
            if (str2 != null) {
                strategyBean.v = Long.valueOf(str2).longValue();
            }
            strategyBean.o = rqdStrategy.getEventTimeInterval();
            strategyBean.u = rqdStrategy.getEventTimeInterval();
            String str3 = rqdStrategy.getValueMap().get("B27");
            if (str3 != null && str3.length() > 0) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (parseInt > 0) {
                        strategyBean.t = parseInt;
                    }
                } catch (Exception e) {
                    if (!m.a(e)) {
                        e.printStackTrace();
                    }
                }
            }
            String str4 = rqdStrategy.getValueMap().get("B25");
            if (str4 != null && str4.equals("0")) {
                strategyBean.j = false;
            } else {
                strategyBean.j = true;
            }
        }
        m.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean.e), Boolean.valueOf(strategyBean.g), Boolean.valueOf(strategyBean.f), Boolean.valueOf(strategyBean.h), Boolean.valueOf(strategyBean.i), Boolean.valueOf(strategyBean.l), Boolean.valueOf(strategyBean.m), Long.valueOf(strategyBean.o), Boolean.valueOf(strategyBean.j), Long.valueOf(strategyBean.n));
        this.f = strategyBean;
        if (!q.c(rqdStrategy.getUrl())) {
            m.c("[Strategy] download url is null", new Object[0]);
            this.f.p = "";
        }
        if (!q.c(rqdStrategy.getExpUrl())) {
            m.c("[Strategy] download crashurl is null", new Object[0]);
            this.f.q = "";
        }
        d.a().b(2);
        f fVar = new f();
        fVar.b = 2;
        fVar.f6614a = strategyBean.c;
        fVar.e = strategyBean.d;
        fVar.g = q.a(strategyBean);
        d.a().a(fVar);
        a(strategyBean, true);
    }

    public static StrategyBean d() {
        List<f> a2 = d.a().a(2);
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        f fVar = a2.get(0);
        if (fVar.g != null) {
            return (StrategyBean) q.a(fVar.g, StrategyBean.CREATOR);
        }
        return null;
    }

    public final void a(SightPkg.RqdStrategy rqdStrategy, int i) {
        if (i != 840) {
            return;
        }
        for (com.uqm.crashsight.a aVar : this.c) {
            try {
                m.c("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onSelfDefiedStrategyChanged(rqdStrategy);
            } catch (Throwable th) {
                if (!m.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final synchronized void b(String str) {
        m.c("[Strategy] Cloud Strategy is  %s", str.toString());
        this.i = str;
    }

    public final synchronized String e() {
        return this.i;
    }
}
