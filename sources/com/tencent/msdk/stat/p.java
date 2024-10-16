package com.tencent.msdk.stat;

import com.tencent.msdk.stat.common.StatLogger;
import java.util.Map;

/* loaded from: classes.dex */
final class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f6335a;
    final /* synthetic */ com.tencent.msdk.stat.a.c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, com.tencent.msdk.stat.a.c cVar) {
        this.f6335a = str;
        this.b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        Map map;
        Map map2;
        StatLogger statLogger2;
        Map map3;
        StatLogger statLogger3;
        StatLogger statLogger4;
        StatLogger statLogger5;
        try {
            if (StatServiceImpl.a(this.f6335a)) {
                statLogger5 = StatServiceImpl.q;
                statLogger5.error("The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
                return;
            }
            if (StatConfig.isDebugEnable()) {
                statLogger4 = StatServiceImpl.q;
                statLogger4.i("add begin key:" + this.b.toString());
            }
            map = StatServiceImpl.e;
            if (map.containsKey(this.b)) {
                statLogger3 = StatServiceImpl.q;
                statLogger3.error("Duplicate CustomEvent key: " + this.b.toString() + ", trackCustomBeginEvent() repeated?");
                return;
            }
            map2 = StatServiceImpl.e;
            if (map2.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                map3 = StatServiceImpl.e;
                map3.put(this.b, Long.valueOf(System.currentTimeMillis()));
                return;
            }
            statLogger2 = StatServiceImpl.q;
            statLogger2.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
        } catch (Throwable th) {
            statLogger = StatServiceImpl.q;
            statLogger.e(th);
        }
    }
}
