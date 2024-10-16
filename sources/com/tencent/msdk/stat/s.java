package com.tencent.msdk.stat;

import android.content.Context;
import com.tencent.msdk.stat.common.StatLogger;
import java.util.Map;

/* loaded from: classes.dex */
final class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f6338a;
    final /* synthetic */ com.tencent.msdk.stat.a.c b;
    final /* synthetic */ Context c;
    final /* synthetic */ StatSpecifyReportedInfo d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(String str, com.tencent.msdk.stat.a.c cVar, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f6338a = str;
        this.b = cVar;
        this.c = context;
        this.d = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        Map map;
        StatLogger statLogger2;
        StatLogger statLogger3;
        try {
            if (StatServiceImpl.a(this.f6338a)) {
                statLogger3 = StatServiceImpl.q;
                statLogger3.error("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
                return;
            }
            map = StatServiceImpl.e;
            Long l = (Long) map.remove(this.b);
            if (l != null) {
                com.tencent.msdk.stat.a.b bVar = new com.tencent.msdk.stat.a.b(this.c, StatServiceImpl.a(this.c, false, this.d), this.b.f6290a, this.d);
                bVar.b().c = this.b.c;
                Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                bVar.a(Long.valueOf(valueOf.longValue() <= 0 ? 1L : valueOf.longValue()).longValue());
                new af(bVar).a();
                return;
            }
            statLogger2 = StatServiceImpl.q;
            statLogger2.warn("No start time found for custom event: " + this.b.toString() + ", lost trackCustomBeginKVEvent()?");
        } catch (Throwable th) {
            statLogger = StatServiceImpl.q;
            statLogger.e(th);
        }
    }
}
