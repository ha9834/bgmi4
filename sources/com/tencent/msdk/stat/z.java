package com.tencent.msdk.stat;

import android.content.Context;
import com.tencent.msdk.stat.common.StatLogger;

/* loaded from: classes.dex */
final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f6344a;
    final /* synthetic */ StatSpecifyReportedInfo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f6344a = context;
        this.b = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        try {
            StatServiceImpl.stopSession();
            StatServiceImpl.a(this.f6344a, true, this.b);
        } catch (Throwable th) {
            statLogger = StatServiceImpl.q;
            statLogger.e(th);
        }
    }
}
