package com.tencent.msdk.stat;

import android.content.Context;
import com.tencent.msdk.stat.common.StatLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f6334a;
    final /* synthetic */ StatSpecifyReportedInfo b;
    final /* synthetic */ com.tencent.msdk.stat.a.c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, com.tencent.msdk.stat.a.c cVar) {
        this.f6334a = context;
        this.b = statSpecifyReportedInfo;
        this.c = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        try {
            com.tencent.msdk.stat.a.b bVar = new com.tencent.msdk.stat.a.b(this.f6334a, StatServiceImpl.a(this.f6334a, false, this.b), this.c.f6290a, this.b);
            bVar.b().c = this.c.c;
            new af(bVar).a();
        } catch (Throwable th) {
            statLogger = StatServiceImpl.q;
            statLogger.e(th);
        }
    }
}
