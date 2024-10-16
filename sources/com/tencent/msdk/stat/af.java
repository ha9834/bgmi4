package com.tencent.msdk.stat;

import android.content.Context;
import com.tencent.msdk.stat.common.StatLogger;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af {
    private static volatile long f;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.msdk.stat.a.d f6301a;
    private StatReportStrategy b;
    private boolean c;
    private Context d;
    private long e = System.currentTimeMillis();

    public af(com.tencent.msdk.stat.a.d dVar) {
        this.b = null;
        this.c = false;
        this.d = null;
        this.f6301a = dVar;
        this.b = StatConfig.getStatSendStrategy();
        this.c = dVar.f();
        this.d = dVar.e();
    }

    private void a(j jVar) {
        Context context;
        context = StatServiceImpl.t;
        k.b(context).a(this.f6301a, jVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d6, code lost:
    
        if (com.tencent.msdk.stat.a.a(r0).c() == 1) goto L50;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0097. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.msdk.stat.af.b():void");
    }

    private void c() {
        if ((aj.b().f6305a <= 0 || !StatConfig.l) && this.f6301a.a() != com.tencent.msdk.stat.a.e.BACKGROUND) {
            a(new ai(this));
        } else {
            aj.b().a(this.f6301a, (j) null, this.c, true);
            aj.b().a(-1);
        }
    }

    private boolean d() {
        long j;
        Map map;
        Map map2;
        Map map3;
        StatLogger statLogger;
        Map map4;
        StatLogger statLogger2;
        long j2;
        if (StatConfig.h <= 0) {
            return false;
        }
        long j3 = this.e;
        j = StatServiceImpl.h;
        if (j3 > j) {
            map4 = StatServiceImpl.g;
            map4.clear();
            long unused = StatServiceImpl.h = this.e + StatConfig.i;
            if (StatConfig.isDebugEnable()) {
                statLogger2 = StatServiceImpl.q;
                StringBuilder sb = new StringBuilder();
                sb.append("clear methodsCalledLimitMap, nextLimitCallClearTime=");
                j2 = StatServiceImpl.h;
                sb.append(j2);
                statLogger2.i(sb.toString());
            }
        }
        Integer valueOf = Integer.valueOf(this.f6301a.a().a());
        map = StatServiceImpl.g;
        Integer num = (Integer) map.get(valueOf);
        if (num == null) {
            map2 = StatServiceImpl.g;
            map2.put(valueOf, 1);
            return false;
        }
        map3 = StatServiceImpl.g;
        map3.put(valueOf, Integer.valueOf(num.intValue() + 1));
        if (num.intValue() <= StatConfig.h) {
            return false;
        }
        if (StatConfig.isDebugEnable()) {
            statLogger = StatServiceImpl.q;
            statLogger.e("event " + this.f6301a.g() + " was discard, cause of called limit, current:" + num + ", limit:" + StatConfig.h + ", period:" + StatConfig.i + " ms");
        }
        return true;
    }

    public void a() {
        StatLogger statLogger;
        StatLogger statLogger2;
        if (d()) {
            return;
        }
        if (StatConfig.m > 0 && this.e >= f) {
            StatServiceImpl.flushDataToDB(this.d);
            f = this.e + StatConfig.n;
            if (StatConfig.isDebugEnable()) {
                statLogger2 = StatServiceImpl.q;
                statLogger2.i("nextFlushTime=" + f);
            }
        }
        if (!a.a(this.d).f()) {
            aj.a(this.d).a(this.f6301a, (j) null, this.c, false);
            return;
        }
        if (StatConfig.isDebugEnable()) {
            statLogger = StatServiceImpl.q;
            statLogger.i("sendFailedCount=" + StatServiceImpl.f6285a);
        }
        if (!StatServiceImpl.a()) {
            b();
            return;
        }
        aj.a(this.d).a(this.f6301a, (j) null, this.c, false);
        if (this.e - StatServiceImpl.b > 1800000) {
            StatServiceImpl.e(this.d);
        }
    }
}
