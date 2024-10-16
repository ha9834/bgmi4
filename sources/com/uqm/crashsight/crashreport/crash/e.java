package com.uqm.crashsight.crashreport.crash;

import android.content.Context;
import com.facebook.internal.security.CertificateUtil;
import com.uqm.crashsight.crashreport.common.strategy.StrategyBean;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.o;
import com.uqm.crashsight.proguard.q;
import java.lang.Thread;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class e implements Thread.UncaughtExceptionHandler {
    private static String h;
    private static final Object i = new Object();

    /* renamed from: a, reason: collision with root package name */
    private Context f6597a;
    private b b;
    private com.uqm.crashsight.crashreport.common.strategy.a c;
    private com.uqm.crashsight.crashreport.common.info.a d;
    private Thread.UncaughtExceptionHandler e;
    private Thread.UncaughtExceptionHandler f;
    private boolean g = false;
    private int j;

    public e(Context context, b bVar, com.uqm.crashsight.crashreport.common.strategy.a aVar, com.uqm.crashsight.crashreport.common.info.a aVar2) {
        this.f6597a = context;
        this.b = bVar;
        this.c = aVar;
        this.d = aVar2;
    }

    public final synchronized void a() {
        if (this.j >= 10) {
            m.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                m.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f = defaultUncaughtExceptionHandler;
                this.e = defaultUncaughtExceptionHandler;
            } else {
                m.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.j++;
        m.a("registered java monitor: %s", toString());
    }

    public final synchronized void b() {
        this.g = false;
        m.a("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("crashSight")) {
            m.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.e);
            this.j--;
        }
    }

    private CrashDetailBean b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String a2;
        if (th == null) {
            m.d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean k = c.a().k();
        String str2 = (k && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![CrashSight]" : "";
        if (k && z) {
            m.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.D = com.uqm.crashsight.crashreport.common.info.c.k();
        crashDetailBean.E = com.uqm.crashsight.crashreport.common.info.c.h();
        crashDetailBean.F = com.uqm.crashsight.crashreport.common.info.c.m();
        crashDetailBean.G = this.d.o();
        crashDetailBean.H = this.d.n();
        crashDetailBean.I = this.d.p();
        crashDetailBean.x = q.a(this.f6597a, c.e, (String) null);
        crashDetailBean.z = o.a();
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(crashDetailBean.z == null ? 0 : crashDetailBean.z.length);
        m.a("user log size:%d", objArr);
        crashDetailBean.b = z ? 0 : 2;
        crashDetailBean.e = this.d.h();
        crashDetailBean.f = this.d.k;
        crashDetailBean.g = this.d.u();
        com.uqm.crashsight.crashreport.common.info.a aVar = this.d;
        crashDetailBean.m = com.uqm.crashsight.crashreport.common.info.a.g();
        String name = th.getClass().getName();
        String b = b(th, 1000);
        if (b == null) {
            b = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        m.e("stack frame :%d, has cause %b", objArr2);
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 != null && th2 != th) {
            crashDetailBean.n = th2.getClass().getName();
            crashDetailBean.o = b(th2, 1000);
            if (crashDetailBean.o == null) {
                crashDetailBean.o = "";
            }
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(CertificateUtil.DELIMITER);
            sb.append(b);
            sb.append("\n");
            sb.append(stackTraceElement);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.n);
            sb.append(CertificateUtil.DELIMITER);
            sb.append(crashDetailBean.o);
            sb.append("\n");
            a2 = a(th2, c.f);
            sb.append(a2);
            crashDetailBean.q = sb.toString();
        } else {
            crashDetailBean.n = name;
            crashDetailBean.o = b + str2;
            if (crashDetailBean.o == null) {
                crashDetailBean.o = "";
            }
            crashDetailBean.p = stackTraceElement;
            a2 = a(th, c.f);
            crashDetailBean.q = a2;
        }
        crashDetailBean.s = System.currentTimeMillis();
        crashDetailBean.v = q.a(crashDetailBean.q.getBytes());
        try {
            crashDetailBean.A = q.a(c.f, false);
            crashDetailBean.B = this.d.d;
            crashDetailBean.C = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.A.put(crashDetailBean.C, a2);
            crashDetailBean.J = this.d.w();
            crashDetailBean.h = this.d.t();
            crashDetailBean.i = this.d.G();
            crashDetailBean.N = this.d.f6569a;
            crashDetailBean.O = this.d.a();
            if (z) {
                this.b.d(crashDetailBean);
            } else {
                boolean z2 = str != null && str.length() > 0;
                boolean z3 = bArr != null && bArr.length > 0;
                if (z2) {
                    crashDetailBean.P = new HashMap(1);
                    crashDetailBean.P.put("UserData", str);
                }
                if (z3) {
                    crashDetailBean.V = bArr;
                }
            }
            crashDetailBean.R = this.d.E();
            crashDetailBean.S = this.d.F();
            crashDetailBean.T = this.d.x();
            crashDetailBean.U = this.d.C();
        } catch (Throwable th3) {
            m.e("handle crash error %s", th3.toString());
        }
        return crashDetailBean;
    }

    private static boolean a(Thread thread) {
        synchronized (i) {
            if (h != null && thread.getName().equals(h)) {
                return true;
            }
            h = thread.getName();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01f1, code lost:
    
        if (r8.f != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b1, code lost:
    
        if (r8.f != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01b5, code lost:
    
        com.uqm.crashsight.proguard.m.e("crashreport last handle start!", new java.lang.Object[0]);
        com.uqm.crashsight.proguard.m.e("current process die", new java.lang.Object[0]);
        android.os.Process.killProcess(android.os.Process.myPid());
        java.lang.System.exit(1);
        com.uqm.crashsight.proguard.m.e("crashreport last handle end!", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01d4, code lost:
    
        return;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Thread r9, java.lang.Throwable r10, boolean r11, java.lang.String r12, byte[] r13) {
        /*
            Method dump skipped, instructions count: 592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.crashreport.crash.e.a(java.lang.Thread, java.lang.Throwable, boolean, java.lang.String, byte[]):void");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (i) {
            com.uqm.crashsight.crashreport.common.info.d.a().b(true);
            a(thread, th, true, null, null);
        }
    }

    private static boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public final synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.e != this.g) {
                m.a("java changed to %b", Boolean.valueOf(strategyBean.e));
                if (strategyBean.e) {
                    a();
                    return;
                }
                b();
            }
        }
    }

    private static String a(Throwable th, int i2) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i2 > 0 && sb.length() >= i2) {
                        sb.append("\n[Stack over limit size :" + i2 + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Throwable th2) {
            m.e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    private static String b(Throwable th, int i2) {
        if (th.getMessage() == null) {
            return "";
        }
        if (th.getMessage().length() <= 1000) {
            return th.getMessage();
        }
        return th.getMessage().substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }
}
