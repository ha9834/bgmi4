package com.uqm.crashsight.crashreport.biz;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.uqm.crashsight.CrashSightStrategy;
import com.uqm.crashsight.crashreport.biz.a;
import com.uqm.crashsight.crashreport.common.strategy.StrategyBean;
import com.uqm.crashsight.proguard.k;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.q;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static a f6555a = null;
    private static boolean b = false;
    private static int c = 10;
    private static long d = 300000;
    private static long e = 30000;
    private static long f = 0;
    private static int g = 0;
    private static long h = 0;
    private static long i = 0;
    private static long j = 0;
    private static Application.ActivityLifecycleCallbacks k = null;
    private static Class<?> l = null;
    private static boolean m = true;

    static /* synthetic */ String a(String str, String str2) {
        return q.a() + "  " + str + "  " + str2 + "\n";
    }

    static /* synthetic */ int g() {
        int i2 = g;
        g = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(android.content.Context r14, com.uqm.crashsight.CrashSightStrategy r15) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.crashreport.biz.b.c(android.content.Context, com.uqm.crashsight.CrashSightStrategy):void");
    }

    public static void a(final Context context, final CrashSightStrategy crashSightStrategy) {
        long j2;
        if (b) {
            return;
        }
        m = com.uqm.crashsight.crashreport.common.info.a.a(context).e;
        f6555a = new a(context, m);
        b = true;
        if (crashSightStrategy != null) {
            l = crashSightStrategy.getUserInfoActivity();
            j2 = crashSightStrategy.getAppReportDelay();
        } else {
            j2 = 0;
        }
        if (j2 <= 0) {
            c(context, crashSightStrategy);
        } else {
            k.a().a(new Runnable() { // from class: com.uqm.crashsight.crashreport.biz.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(context, crashSightStrategy);
                }
            }, j2);
        }
    }

    public static void a(long j2) {
        if (j2 < 0) {
            j2 = com.uqm.crashsight.crashreport.common.strategy.a.a().c().o;
        }
        f = j2;
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        k a2;
        a aVar = f6555a;
        if (aVar != null && !z && (a2 = k.a()) != null) {
            a2.a(new a.AnonymousClass2());
        }
        if (strategyBean == null) {
            return;
        }
        if (strategyBean.o > 0) {
            e = strategyBean.o;
        }
        if (strategyBean.t > 0) {
            c = strategyBean.t;
        }
        if (strategyBean.u > 0) {
            d = strategyBean.u;
        }
    }

    public static void a() {
        a aVar = f6555a;
        if (aVar != null) {
            aVar.a(2, false, 0L);
        }
    }

    public static void a(Context context) {
        if (!b || context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    if (k != null) {
                        application.unregisterActivityLifecycleCallbacks(k);
                    }
                } catch (Exception e2) {
                    if (!m.a(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        b = false;
    }
}
