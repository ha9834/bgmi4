package com.tencent.msdk.stat;

import android.content.Context;
import com.tencent.msdk.stat.common.StatLogger;
import java.util.Map;

/* loaded from: classes.dex */
final class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f6342a;
    final /* synthetic */ Context b;
    final /* synthetic */ StatSpecifyReportedInfo c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(String str, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f6342a = str;
        this.b = context;
        this.c = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        Map map;
        Map map2;
        Map map3;
        String str;
        Map map4;
        String str2;
        StatLogger statLogger2;
        String str3;
        StatLogger statLogger3;
        try {
            map = StatServiceImpl.o;
            synchronized (map) {
                map2 = StatServiceImpl.o;
                if (map2.size() >= StatConfig.getMaxParallelTimmingEvents()) {
                    statLogger3 = StatServiceImpl.q;
                    statLogger3.error("The number of page events exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                    return;
                }
                String unused = StatServiceImpl.m = this.f6342a;
                map3 = StatServiceImpl.o;
                str = StatServiceImpl.m;
                if (!map3.containsKey(str)) {
                    map4 = StatServiceImpl.o;
                    str2 = StatServiceImpl.m;
                    map4.put(str2, Long.valueOf(System.currentTimeMillis()));
                    StatServiceImpl.a(this.b, true, this.c);
                    return;
                }
                statLogger2 = StatServiceImpl.q;
                StringBuilder sb = new StringBuilder();
                sb.append("Duplicate PageID : ");
                str3 = StatServiceImpl.m;
                sb.append(str3);
                sb.append(", onResume() repeated?");
                statLogger2.e(sb.toString());
            }
        } catch (Throwable th) {
            statLogger = StatServiceImpl.q;
            statLogger.e(th);
        }
    }
}
