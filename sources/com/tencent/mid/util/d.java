package com.tencent.mid.util;

import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.tencent.midas.comm.log.util.APLogFileUtil;

/* loaded from: classes.dex */
public final class d {
    private static boolean b;

    /* renamed from: a, reason: collision with root package name */
    private String f6274a;
    private int c;

    public boolean a() {
        return b;
    }

    public void a(boolean z) {
        b = z;
    }

    public d() {
        this.f6274a = com.huawei.game.gamekit.b.a.f5471a;
        this.c = 2;
    }

    public d(String str) {
        this.f6274a = com.huawei.game.gamekit.b.a.f5471a;
        this.c = 2;
        this.f6274a = str;
    }

    private String b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    public void a(Object obj) {
        String str;
        if (this.c <= 4) {
            String b2 = b();
            if (b2 == null) {
                str = obj.toString();
            } else {
                str = b2 + " - " + obj;
            }
            Log.i(this.f6274a, str);
        }
    }

    public void b(Object obj) {
        if (a()) {
            a(obj);
        }
    }

    public void c(Object obj) {
        String str;
        if (this.c <= 5) {
            String b2 = b();
            if (b2 == null) {
                str = obj.toString();
            } else {
                str = b2 + " - " + obj;
            }
            Log.w(this.f6274a, str);
        }
    }

    public void d(Object obj) {
        if (a()) {
            c(obj);
        }
    }

    public void e(Object obj) {
        String str;
        if (this.c <= 6) {
            String b2 = b();
            if (b2 == null) {
                str = obj.toString();
            } else {
                str = b2 + " - " + obj;
            }
            Log.e(this.f6274a, str);
        }
    }

    public void a(Exception exc) {
        if (this.c <= 6) {
            StringBuffer stringBuffer = new StringBuffer();
            String b2 = b();
            StackTraceElement[] stackTrace = exc.getStackTrace();
            if (b2 != null) {
                stringBuffer.append(b2 + " - " + exc + APLogFileUtil.SEPARATOR_LINE);
            } else {
                stringBuffer.append(exc + APLogFileUtil.SEPARATOR_LINE);
            }
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        stringBuffer.append("[ " + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + " ]\r\n");
                    }
                }
            }
            Log.e(this.f6274a, stringBuffer.toString());
        }
    }

    public void f(Object obj) {
        if (a()) {
            e(obj);
        }
    }

    public void b(Exception exc) {
        if (a()) {
            a(exc);
        }
    }

    public void g(Object obj) {
        String str;
        if (this.c <= 3) {
            String b2 = b();
            if (b2 == null) {
                str = obj.toString();
            } else {
                str = b2 + " - " + obj;
            }
            Log.d(this.f6274a, str);
        }
    }

    public void h(Object obj) {
        if (a()) {
            g(obj);
        }
    }
}
