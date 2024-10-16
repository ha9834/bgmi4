package com.tencent.msdk.stat;

import android.content.Context;
import com.tencent.msdk.stat.common.StatLogger;

/* loaded from: classes.dex */
final class ab implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f6297a;
    final /* synthetic */ StatSpecifyReportedInfo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f6297a = context;
        this.b = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        try {
            StatServiceImpl.a(this.f6297a, false, this.b);
        } catch (Throwable th) {
            statLogger = StatServiceImpl.q;
            statLogger.e(th);
        }
    }
}
