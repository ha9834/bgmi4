package com.tencent.msdk.stat;

import android.content.Context;
import com.tencent.msdk.stat.common.StatLogger;
import java.util.Map;

/* loaded from: classes.dex */
final class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f6343a;
    final /* synthetic */ String b;
    final /* synthetic */ StatSpecifyReportedInfo c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f6343a = context;
        this.b = str;
        this.c = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        Map map;
        Map map2;
        Long l;
        StatLogger statLogger2;
        String str;
        String str2;
        StatLogger statLogger3;
        try {
            StatServiceImpl.flushDataToDB(this.f6343a);
            map = StatServiceImpl.o;
            synchronized (map) {
                map2 = StatServiceImpl.o;
                l = (Long) map2.remove(this.b);
            }
            if (l == null) {
                statLogger2 = StatServiceImpl.q;
                statLogger2.e("Starttime for PageID:" + this.b + " not found, lost onResume()?");
                return;
            }
            Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
            if (valueOf.longValue() <= 0) {
                valueOf = 1L;
            }
            Long l2 = valueOf;
            str = StatServiceImpl.n;
            if (str != null && str.equals(this.b)) {
                str = "-";
            }
            com.tencent.msdk.stat.a.g gVar = new com.tencent.msdk.stat.a.g(this.f6343a, str, this.b, StatServiceImpl.a(this.f6343a, false, this.c), l2, this.c);
            String str3 = this.b;
            str2 = StatServiceImpl.m;
            if (!str3.equals(str2)) {
                statLogger3 = StatServiceImpl.q;
                statLogger3.warn("Invalid invocation since previous onResume on diff page.");
            }
            new af(gVar).a();
            String unused = StatServiceImpl.n = this.b;
        } catch (Throwable th) {
            statLogger = StatServiceImpl.q;
            statLogger.e(th);
        }
    }
}
