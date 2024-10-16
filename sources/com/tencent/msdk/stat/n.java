package com.tencent.msdk.stat;

import android.content.Context;
import com.tencent.msdk.stat.common.StatLogger;
import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f6333a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context) {
        this.f6333a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        StatLogger statLogger;
        context = StatServiceImpl.t;
        a.a(context).h();
        com.tencent.msdk.stat.common.j.a(this.f6333a, true);
        aj.a(this.f6333a);
        k.b(this.f6333a);
        Thread.UncaughtExceptionHandler unused = StatServiceImpl.r = Thread.getDefaultUncaughtExceptionHandler();
        if (StatConfig.getStatSendStrategy() == StatReportStrategy.APP_LAUNCH) {
            StatServiceImpl.commitEvents(this.f6333a, -1);
        }
        if (StatConfig.isDebugEnable()) {
            statLogger = StatServiceImpl.q;
            statLogger.d("Init MTA StatService success, sdk version:2.1.9");
        }
    }
}
