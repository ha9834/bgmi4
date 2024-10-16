package com.tencent.msdk.stat;

import android.content.Context;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class d {
    private static volatile d b;

    /* renamed from: a, reason: collision with root package name */
    private Timer f6326a;
    private Context c;

    private d(Context context) {
        this.f6326a = null;
        this.c = null;
        this.c = context.getApplicationContext();
        this.f6326a = new Timer(false);
    }

    public static d a(Context context) {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d(context);
                }
            }
        }
        return b;
    }

    public void a() {
        if (StatConfig.getStatSendStrategy() == StatReportStrategy.PERIOD) {
            long sendPeriodMinutes = StatConfig.getSendPeriodMinutes() * 60 * 1000;
            if (StatConfig.isDebugEnable()) {
                com.tencent.msdk.stat.common.j.b().i("setupPeriodTimer delay:" + sendPeriodMinutes);
            }
            a(new e(this), sendPeriodMinutes);
        }
    }

    public void a(TimerTask timerTask, long j) {
        if (this.f6326a == null) {
            if (StatConfig.isDebugEnable()) {
                com.tencent.msdk.stat.common.j.b().w("setupPeriodTimer schedule timer == null");
                return;
            }
            return;
        }
        if (StatConfig.isDebugEnable()) {
            com.tencent.msdk.stat.common.j.b().i("setupPeriodTimer schedule delay:" + j);
        }
        this.f6326a.schedule(timerTask, j);
    }
}
