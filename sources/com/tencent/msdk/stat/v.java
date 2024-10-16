package com.tencent.msdk.stat;

import android.content.Context;
import com.tencent.msdk.stat.common.StatLogger;

/* loaded from: classes.dex */
final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f6340a;
    final /* synthetic */ StatSpecifyReportedInfo b;
    final /* synthetic */ com.tencent.msdk.stat.a.c c;
    final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, com.tencent.msdk.stat.a.c cVar, int i) {
        this.f6340a = context;
        this.b = statSpecifyReportedInfo;
        this.c = cVar;
        this.d = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        try {
            com.tencent.msdk.stat.a.b bVar = new com.tencent.msdk.stat.a.b(this.f6340a, StatServiceImpl.a(this.f6340a, false, this.b), this.c.f6290a, this.b);
            bVar.b().c = this.c.c;
            Long valueOf = Long.valueOf(this.d);
            bVar.a(Long.valueOf(valueOf.longValue() <= 0 ? 1L : valueOf.longValue()).longValue());
            new af(bVar).a();
        } catch (Throwable th) {
            statLogger = StatServiceImpl.q;
            statLogger.e(th);
        }
    }
}
