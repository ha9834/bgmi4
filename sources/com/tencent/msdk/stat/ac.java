package com.tencent.msdk.stat;

import android.content.Context;
import com.tencent.msdk.stat.common.StatLogger;

/* loaded from: classes.dex */
final class ac implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f6298a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Context context) {
        this.f6298a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        StatLogger statLogger2;
        Context context = this.f6298a;
        if (context == null) {
            statLogger2 = StatServiceImpl.q;
            statLogger2.error("The Context of StatService.onStop() can not be null!");
            return;
        }
        StatServiceImpl.flushDataToDB(context);
        if (StatServiceImpl.a()) {
            return;
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (com.tencent.msdk.stat.common.j.A(this.f6298a)) {
            if (StatConfig.isDebugEnable()) {
                statLogger = StatServiceImpl.q;
                statLogger.i("onStop isBackgroundRunning flushDataToDB");
            }
            StatServiceImpl.commitEvents(this.f6298a, -1);
        }
    }
}
