package com.uqm.crashsight.crashreport.crash;

import android.content.Context;
import com.tencent.imsdk.android.tools.log.LogUtils;
import com.uqm.crashsight.CrashSightStrategy;
import com.uqm.crashsight.crashreport.common.info.AppInfo;
import com.uqm.crashsight.crashreport.common.strategy.StrategyBean;
import com.uqm.crashsight.crashreport.crash.jni.NativeCrashHandler;
import com.uqm.crashsight.proguard.f;
import com.uqm.crashsight.proguard.i;
import com.uqm.crashsight.proguard.k;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f6591a = 0;
    public static boolean b = false;
    public static int c = 2;
    public static boolean d = true;
    public static int e = 20480;
    public static int f = 20480;
    public static long g = 604800000;
    public static String h = null;
    public static boolean i = false;
    public static String j = null;
    public static int k = 5000;
    public static boolean l = true;
    public static boolean m;
    public static String n;
    public static String o;
    private static c r;
    public final b p;
    private final Context q;
    private final e s;
    private final NativeCrashHandler t;
    private com.uqm.crashsight.crashreport.common.strategy.a u;
    private k v;
    private final com.uqm.crashsight.crashreport.crash.anr.b w;
    private Boolean x;
    private int y = 31;
    private boolean z = false;

    private c(int i2, Context context, k kVar, boolean z, CrashSightStrategy.a aVar, com.uqm.crashsight.proguard.c cVar, String str) {
        f6591a = i2;
        Context a2 = q.a(context);
        this.q = a2;
        this.u = com.uqm.crashsight.crashreport.common.strategy.a.a();
        this.v = kVar;
        i a3 = i.a();
        com.uqm.crashsight.proguard.d a4 = com.uqm.crashsight.proguard.d.a();
        this.p = new b(i2, a2, a3, a4, this.u, aVar, cVar);
        com.uqm.crashsight.crashreport.common.info.a a5 = com.uqm.crashsight.crashreport.common.info.a.a(a2);
        this.s = new e(a2, this.p, this.u, a5);
        this.t = NativeCrashHandler.getInstance(a2, a5, this.p, this.u, kVar, z, str);
        NativeCrashHandler nativeCrashHandler = this.t;
        a5.E = nativeCrashHandler;
        com.uqm.crashsight.crashreport.common.info.d.a(nativeCrashHandler);
        this.w = com.uqm.crashsight.crashreport.crash.anr.b.a(a2, this.u, a5, kVar, a4, this.p, aVar);
    }

    public static synchronized c a(int i2, Context context, boolean z, CrashSightStrategy.a aVar, com.uqm.crashsight.proguard.c cVar, String str) {
        c cVar2;
        synchronized (c.class) {
            if (r == null) {
                r = new c(1004, context, k.a(), z, aVar, null, null);
            }
            cVar2 = r;
        }
        return cVar2;
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            cVar = r;
        }
        return cVar;
    }

    public final void a(StrategyBean strategyBean) {
        this.s.a(strategyBean);
        this.t.onStrategyChanged(strategyBean);
        this.w.d();
        k.a().a(new AnonymousClass2(), 3000L);
    }

    public final boolean b() {
        Boolean bool = this.x;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = com.uqm.crashsight.crashreport.common.info.a.b().d;
        List<f> a2 = com.uqm.crashsight.proguard.d.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (a2 != null && a2.size() > 0) {
            for (f fVar : a2) {
                if (str.equals(fVar.c)) {
                    this.x = true;
                    arrayList.add(fVar);
                }
            }
            if (arrayList.size() > 0) {
                com.uqm.crashsight.proguard.d.a().a(arrayList);
            }
            return true;
        }
        this.x = false;
        return false;
    }

    public final synchronized void c() {
        this.s.a();
        this.t.setUserOpened(true);
        this.w.a(true);
    }

    public final synchronized void d() {
        this.s.b();
        this.t.setUserOpened(false);
        this.w.a(false);
    }

    public final void e() {
        this.s.b();
    }

    public final void f() {
        this.s.a();
    }

    public final void g() {
        this.t.setUserOpened(false);
    }

    public final void h() {
        this.t.setUserOpened(true);
    }

    public final void i() {
        this.t.enableCatchAnrTrace();
    }

    public final void a(int i2) {
        this.t.setCrashHandleTimeout(i2);
    }

    public final synchronized void a(boolean z, boolean z2, boolean z3) {
        this.t.testNativeCrash(z, z2, z3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void j() {
        com.uqm.crashsight.crashreport.crash.anr.b bVar = this.w;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 < 30) {
                try {
                    m.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i3));
                    q.b(5000L);
                    i2 = i3;
                } catch (Throwable th) {
                    if (m.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            }
        }
    }

    public final boolean k() {
        return this.w.b();
    }

    public final void a(final Thread thread, final Throwable th, boolean z, String str, byte[] bArr, final boolean z2) {
        final boolean z3 = false;
        final String str2 = null;
        final byte[] bArr2 = null;
        this.v.a(new Runnable() { // from class: com.uqm.crashsight.crashreport.crash.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    m.c("post a throwable %b", Boolean.valueOf(z3));
                    c.this.s.a(thread, th, false, str2, bArr2);
                    if (z2) {
                        m.a("clear user datas", new Object[0]);
                        com.uqm.crashsight.crashreport.common.info.a.a(c.this.q).y();
                    }
                } catch (Throwable th2) {
                    if (!m.b(th2)) {
                        th2.printStackTrace();
                    }
                    m.e("java catch error: %s", th.toString());
                }
            }
        });
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.p.e(crashDetailBean);
    }

    /* renamed from: com.uqm.crashsight.crashreport.crash.c$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    final class AnonymousClass2 extends Thread {
        AnonymousClass2() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            List<CrashDetailBean> list;
            if (q.a(c.this.q, "local_crash_lock", LogUtils.LOG_FUSE_TIME)) {
                List<CrashDetailBean> a2 = c.this.p.a();
                if (a2 != null && a2.size() > 0) {
                    m.c("Size of crash list: %s", Integer.valueOf(a2.size()));
                    int size = a2.size();
                    if (size > 20) {
                        ArrayList arrayList = new ArrayList();
                        Collections.sort(a2);
                        for (int i = 0; i < 20; i++) {
                            arrayList.add(a2.get((size - 1) - i));
                        }
                        list = arrayList;
                    } else {
                        list = a2;
                    }
                    c.this.p.a(list, 0L, false, false, false);
                }
                q.b(c.this.q, "local_crash_lock");
            }
        }
    }

    public final void a(long j2) {
        k.a().a(new AnonymousClass2(), j2);
    }

    public final void l() {
        this.t.checkUploadRecordCrash();
    }

    public final void m() {
        this.t.checkUploadMmkvliteRecordCrash();
    }

    public final void n() {
        this.t.checkUploadOomMmkvliteRecordCrash();
    }

    public final void o() {
        if (com.uqm.crashsight.crashreport.common.info.a.b().d.equals(AppInfo.a(this.q))) {
            this.t.removeEmptyNativeRecordFiles();
        }
    }

    public final void b(int i2) {
        this.y = i2;
    }

    public final void a(boolean z) {
        this.z = z;
    }

    public final boolean p() {
        return this.z;
    }

    public final boolean q() {
        return (this.y & 16) > 0;
    }

    public final boolean r() {
        return (this.y & 8) > 0;
    }

    public final boolean s() {
        return (this.y & 4) > 0;
    }

    public final boolean t() {
        return (this.y & 2) > 0;
    }

    public final boolean u() {
        return (this.y & 1) > 0;
    }
}
