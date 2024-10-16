package com.tencent.msdk.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.msdk.stat.common.StatConstants;
import com.tencent.msdk.stat.common.StatLogger;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class StatServiceImpl {
    private static Handler d;
    private static volatile Map<com.tencent.msdk.stat.a.c, Long> e = new ConcurrentHashMap();
    private static volatile Map<String, Properties> f = new ConcurrentHashMap();
    private static volatile Map<Integer, Integer> g = new ConcurrentHashMap(10);
    private static volatile long h = 0;
    private static volatile long i = 0;
    private static volatile long j = 0;
    private static String k = "";
    private static volatile int l = 0;
    private static volatile String m = "";
    private static volatile String n = "";
    private static Map<String, Long> o = new ConcurrentHashMap();
    private static Map<String, Long> p = new ConcurrentHashMap();
    private static StatLogger q = com.tencent.msdk.stat.common.j.b();
    private static Thread.UncaughtExceptionHandler r = null;
    private static volatile boolean s = true;

    /* renamed from: a, reason: collision with root package name */
    static volatile int f6285a = 0;
    static volatile long b = 0;
    private static Context t = null;
    static volatile long c = 0;
    private static volatile boolean u = false;
    private static volatile boolean v = false;
    private static volatile boolean w = true;
    private static Handler x = null;
    private static List<g> y = new CopyOnWriteArrayList();
    private static volatile Runnable z = null;
    private static volatile long A = -1;
    private static StatSpecifyReportedInfo B = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context, boolean z2, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z3 = z2 && currentTimeMillis - i >= ((long) StatConfig.getSessionTimoutMillis());
        i = currentTimeMillis;
        if (j == 0) {
            j = com.tencent.msdk.stat.common.j.c();
        }
        if (currentTimeMillis >= j) {
            j = com.tencent.msdk.stat.common.j.c();
            if (aj.a(context).b(context).d() != 1) {
                aj.a(context).b(context).a(1);
            }
            StatConfig.b(0);
            f6285a = 0;
            k = com.tencent.msdk.stat.common.j.a(0);
            z3 = true;
        }
        String str = k;
        if (com.tencent.msdk.stat.common.j.a(statSpecifyReportedInfo)) {
            str = statSpecifyReportedInfo.getAppKey() + k;
        }
        if (!p.containsKey(str)) {
            z3 = true;
        }
        if (z3) {
            if (com.tencent.msdk.stat.common.j.a(statSpecifyReportedInfo)) {
                a(context, statSpecifyReportedInfo);
            } else if (StatConfig.c() < StatConfig.getMaxDaySessionNumbers()) {
                com.tencent.msdk.stat.common.j.w(context);
                a(context, null);
            } else {
                q.e("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
            p.put(str, 1L);
        }
        boolean z4 = s;
        s = false;
        return l;
    }

    static synchronized void a(Context context) {
        synchronized (StatServiceImpl.class) {
            if (context == null) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (d == null) {
                if (!b(applicationContext)) {
                    return;
                }
                t = applicationContext;
                HandlerThread handlerThread = new HandlerThread("StatService");
                handlerThread.start();
                d = new Handler(handlerThread.getLooper());
                k = com.tencent.msdk.stat.common.j.a(0);
                h = System.currentTimeMillis() + StatConfig.i;
                d.post(new n(applicationContext));
            }
        }
    }

    static void a(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (c(context) != null) {
            if (StatConfig.isDebugEnable()) {
                q.d("start new session, specifyReport:" + statSpecifyReportedInfo);
            }
            if (statSpecifyReportedInfo == null || l == 0) {
                l = com.tencent.msdk.stat.common.j.a();
            }
            StatConfig.a(0);
            StatConfig.b();
            new af(new com.tencent.msdk.stat.a.h(context, l, b(), statSpecifyReportedInfo)).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        if (f6285a < 2) {
            return false;
        }
        b = System.currentTimeMillis();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static void addActionListener(g gVar) {
        y.add(gVar);
    }

    static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (StatConfig.b.d != 0) {
                jSONObject2.put("v", StatConfig.b.d);
            }
            jSONObject.put(Integer.toString(StatConfig.b.f6329a), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (StatConfig.f6283a.d != 0) {
                jSONObject3.put("v", StatConfig.f6283a.d);
            }
            jSONObject.put(Integer.toString(StatConfig.f6283a.f6329a), jSONObject3);
        } catch (JSONException e2) {
            q.e((Throwable) e2);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, f fVar, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        try {
            new af(new com.tencent.msdk.stat.a.a(context, a(context, false, statSpecifyReportedInfo), fVar, statSpecifyReportedInfo)).a();
        } catch (Throwable th) {
            q.e(th);
        }
    }

    static boolean b(Context context) {
        boolean z2;
        long a2 = com.tencent.msdk.stat.common.o.a(context, StatConfig.c, 0L);
        long b2 = com.tencent.msdk.stat.common.j.b(StatConstants.VERSION);
        boolean z3 = false;
        if (b2 <= a2) {
            q.error("MTA is disable for current version:" + b2 + ",wakeup version:" + a2);
            z2 = false;
        } else {
            z2 = true;
        }
        long a3 = com.tencent.msdk.stat.common.o.a(context, StatConfig.d, 0L);
        if (a3 > System.currentTimeMillis()) {
            q.error("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + a3);
        } else {
            z3 = z2;
        }
        StatConfig.setEnableStatService(z3);
        return z3;
    }

    static Handler c(Context context) {
        if (d == null) {
            synchronized (StatServiceImpl.class) {
                if (d == null) {
                    try {
                        a(context);
                    } catch (Throwable th) {
                        q.error(th);
                        StatConfig.setEnableStatService(false);
                    }
                }
            }
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        f6285a = 0;
        b = 0L;
    }

    public static void commitEvents(Context context, int i2) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            if (StatConfig.isDebugEnable()) {
                q.i("commitEvents, maxNumber=" + i2);
            }
            Context context2 = getContext(context);
            if (context2 == null) {
                statLogger = q;
                str = "The Context of StatService.commitEvents() can not be null!";
            } else {
                if (i2 >= -1 && i2 != 0) {
                    if (a.a(context2).f() && c(context2) != null) {
                        d.post(new t(context2, i2));
                        return;
                    }
                    return;
                }
                statLogger = q;
                str = "The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.";
            }
            statLogger.error(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        f6285a++;
        b = System.currentTimeMillis();
        flushDataToDB(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context) {
        c = System.currentTimeMillis() + (StatConfig.getSendPeriodMinutes() * 60000);
        com.tencent.msdk.stat.common.o.b(context, "last_period_ts", c);
        commitEvents(context, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Context context) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                q.error("The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                k.b(context2).a(new com.tencent.msdk.stat.a.f(context2), new u());
            } catch (Throwable th) {
                q.e(th);
            }
        }
    }

    public static void flushDataToDB(Context context) {
        if (StatConfig.isEnableStatService() && StatConfig.m > 0) {
            Context context2 = getContext(context);
            if (context2 == null) {
                q.error("The Context of StatService.testSpeed() can not be null!");
            } else {
                aj.a(context2).c();
            }
        }
    }

    public static Properties getCommonKeyValueForKVEvent(String str) {
        return f.get(str);
    }

    public static Context getContext(Context context) {
        return context != null ? context : t;
    }

    public static boolean isBackground() {
        return v;
    }

    public static boolean isForeground() {
        return v;
    }

    public static void onLowMemory(Context context) {
        if (StatConfig.isEnableStatService() && c(getContext(context)) != null) {
            d.post(new ad(context));
        }
    }

    public static void onStop(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (c(context2) != null) {
                d.post(new ac(context2));
            }
        }
    }

    public static void removeActionListener(g gVar) {
        y.remove(gVar);
    }

    public static void reportQQ(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                q.error("context is null in reportQQ()");
                return;
            }
            StatConfig.f = str;
            if (c(context2) != null) {
                d.post(new aa(str, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void setCommonKeyValueForKVEvent(String str, Properties properties) {
        if (!com.tencent.msdk.stat.common.j.c(str)) {
            q.e("event_id or commonProp for setCommonKeyValueForKVEvent is invalid.");
        } else if (properties == null || properties.size() <= 0) {
            f.remove(str);
        } else {
            f.put(str, (Properties) properties.clone());
        }
    }

    public static void setContext(Context context) {
        if (context != null) {
            t = context.getApplicationContext();
        }
    }

    public static void setEnvAttributes(Context context, Map<String, String> map) {
        if (map == null || map.size() > 512) {
            q.error("The map in setEnvAttributes can't be null or its size can't exceed 512.");
            return;
        }
        try {
            com.tencent.msdk.stat.common.b.a(context, map);
        } catch (JSONException e2) {
            q.e((Throwable) e2);
        }
    }

    public static void startNewSession(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                q.error("The Context of StatService.startNewSession() can not be null!");
            } else if (c(context2) != null) {
                d.post(new z(context2, statSpecifyReportedInfo));
            }
        }
    }

    public static boolean startStatService(Context context, String str, String str2, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        try {
            if (!StatConfig.isEnableStatService()) {
                q.error("MTA StatService is disable.");
                return false;
            }
            if (StatConfig.isDebugEnable()) {
                q.d("MTA SDK version, current: " + StatConstants.VERSION + " ,required: " + str2);
            }
            if (context != null && str2 != null) {
                if (com.tencent.msdk.stat.common.j.b(StatConstants.VERSION) >= com.tencent.msdk.stat.common.j.b(str2)) {
                    if (str != null) {
                        StatConfig.setAppKey(context, str);
                    }
                    if (c(context) == null) {
                        return true;
                    }
                    d.post(new ab(context, statSpecifyReportedInfo));
                    return true;
                }
                q.error(("MTA SDK version conflicted, current: " + StatConstants.VERSION + ",required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                StatConfig.setEnableStatService(false);
                return false;
            }
            q.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
            StatConfig.setEnableStatService(false);
            return false;
        } catch (Throwable th) {
            q.e(th);
            return false;
        }
    }

    public static void stopSession() {
        i = 0L;
    }

    public static void trackBeginPage(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null || str == null || str.length() == 0) {
                q.error("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (c(context2) != null) {
                d.post(new x(str2, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void trackCustomBeginEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                q.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
                return;
            }
            com.tencent.msdk.stat.a.c cVar = new com.tencent.msdk.stat.a.c(str, strArr, null);
            if (c(context2) != null) {
                d.post(new p(str, cVar));
            }
        }
    }

    public static void trackCustomBeginKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                q.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
                return;
            }
            com.tencent.msdk.stat.a.c cVar = new com.tencent.msdk.stat.a.c(str, null, properties);
            if (c(context2) != null) {
                d.post(new r(str, cVar));
            }
        }
    }

    public static void trackCustomEndEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                q.error("The Context of StatService.trackCustomEndEvent() can not be null!");
                return;
            }
            com.tencent.msdk.stat.a.c cVar = new com.tencent.msdk.stat.a.c(str, strArr, null);
            if (c(context2) != null) {
                d.post(new q(str, cVar, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void trackCustomEndKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                q.error("The Context of StatService.trackCustomEndEvent() can not be null!");
                return;
            }
            com.tencent.msdk.stat.a.c cVar = new com.tencent.msdk.stat.a.c(str, null, properties);
            if (c(context2) != null) {
                d.post(new s(str, cVar, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void trackCustomEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                statLogger = q;
                str2 = "The Context of StatService.trackCustomEvent() can not be null!";
            } else {
                if (!a(str)) {
                    com.tencent.msdk.stat.a.c cVar = new com.tencent.msdk.stat.a.c(str, strArr, null);
                    if (c(context2) != null) {
                        d.post(new ae(context2, statSpecifyReportedInfo, cVar));
                        return;
                    }
                    return;
                }
                statLogger = q;
                str2 = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                statLogger = q;
                str2 = "The Context of StatService.trackCustomEvent() can not be null!";
            } else {
                if (!a(str)) {
                    com.tencent.msdk.stat.a.c cVar = new com.tencent.msdk.stat.a.c(str, null, properties);
                    if (c(context2) != null) {
                        d.post(new o(context2, statSpecifyReportedInfo, cVar));
                        return;
                    }
                    return;
                }
                statLogger = q;
                str2 = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomKVTimeIntervalEvent(Context context, String str, Properties properties, int i2, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                statLogger = q;
                str2 = "The Context of StatService.trackCustomEndEvent() can not be null!";
            } else {
                if (!a(str)) {
                    com.tencent.msdk.stat.a.c cVar = new com.tencent.msdk.stat.a.c(str, null, properties);
                    if (c(context2) != null) {
                        d.post(new v(context2, statSpecifyReportedInfo, cVar, i2));
                        return;
                    }
                    return;
                }
                statLogger = q;
                str2 = "The event_id of StatService.trackCustomEndEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackEndPage(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null || str == null || str.length() == 0) {
                q.error("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (c(context2) != null) {
                d.post(new y(context2, str2, statSpecifyReportedInfo));
            }
        }
    }
}
