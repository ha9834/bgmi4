package com.tencent.msdk.stat;

import android.content.Context;
import com.tencent.msdk.stat.common.StatLogger;

/* loaded from: classes.dex */
final class ae implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f6300a;
    final /* synthetic */ StatSpecifyReportedInfo b;
    final /* synthetic */ com.tencent.msdk.stat.a.c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, com.tencent.msdk.stat.a.c cVar) {
        this.f6300a = context;
        this.b = statSpecifyReportedInfo;
        this.c = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        try {
            com.tencent.msdk.stat.a.b bVar = new com.tencent.msdk.stat.a.b(this.f6300a, StatServiceImpl.a(this.f6300a, false, this.b), this.c.f6290a, this.b);
            bVar.b().b = this.c.b;
            new af(bVar).a();
        } catch (Throwable th) {
            statLogger = StatServiceImpl.q;
            statLogger.e(th);
        }
    }
}
