package com.tencent.msdk.stat.common;

import android.util.Log;
import com.facebook.internal.security.CertificateUtil;

/* loaded from: classes.dex */
public final class StatLogger {

    /* renamed from: a, reason: collision with root package name */
    private String f6317a;
    private boolean b;
    private int c;

    public StatLogger() {
        this.f6317a = com.huawei.game.gamekit.b.a.f5471a;
        this.b = true;
        this.c = 2;
    }

    public StatLogger(String str) {
        this.f6317a = com.huawei.game.gamekit.b.a.f5471a;
        this.b = true;
        this.c = 2;
        this.f6317a = str;
    }

    private String a() {
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

    public void d(Object obj) {
        if (isDebugEnable()) {
            debug(obj);
        }
    }

    public void debug(Object obj) {
        String str;
        if (this.c <= 3) {
            String a2 = a();
            if (a2 == null) {
                str = obj.toString();
            } else {
                str = a2 + " - " + obj;
            }
            Log.d(this.f6317a, str);
        }
    }

    public void e(Object obj) {
        if (isDebugEnable()) {
            error(obj);
        }
    }

    public void e(Throwable th) {
        if (isDebugEnable()) {
            error(th);
        }
    }

    public void error(Object obj) {
        String str;
        if (this.c <= 6) {
            String a2 = a();
            if (a2 == null) {
                str = obj.toString();
            } else {
                str = a2 + " - " + obj;
            }
            Log.e(this.f6317a, str);
        }
    }

    public void error(Throwable th) {
        if (this.c <= 6) {
            Log.e(this.f6317a, "", th);
        }
    }

    public int getLogLevel() {
        return this.c;
    }

    public void i(Object obj) {
        if (isDebugEnable()) {
            info(obj);
        }
    }

    public void info(Object obj) {
        String str;
        if (this.c <= 4) {
            String a2 = a();
            if (a2 == null) {
                str = obj.toString();
            } else {
                str = a2 + " - " + obj;
            }
            Log.i(this.f6317a, str);
        }
    }

    public boolean isDebugEnable() {
        return this.b;
    }

    public void setDebugEnable(boolean z) {
        this.b = z;
    }

    public void setLogLevel(int i) {
        this.c = i;
    }

    public void setTag(String str) {
        this.f6317a = str;
    }

    public void v(Object obj) {
        if (isDebugEnable()) {
            verbose(obj);
        }
    }

    public void verbose(Object obj) {
        String str;
        if (this.c <= 2) {
            String a2 = a();
            if (a2 == null) {
                str = obj.toString();
            } else {
                str = a2 + " - " + obj;
            }
            Log.v(this.f6317a, str);
        }
    }

    public void w(Object obj) {
        if (isDebugEnable()) {
            warn(obj);
        }
    }

    public void warn(Object obj) {
        String str;
        if (this.c <= 5) {
            String a2 = a();
            if (a2 == null) {
                str = obj.toString();
            } else {
                str = a2 + " - " + obj;
            }
            Log.w(this.f6317a, str);
        }
    }
}
