package com.tencent.midas.http.core;

/* loaded from: classes.dex */
public class HttpLog {
    static IHttpLog httpLogInterface;

    public static void e(String str, String str2) {
        IHttpLog iHttpLog = httpLogInterface;
        if (iHttpLog != null) {
            iHttpLog.e(str, str2);
        }
    }

    public static void d(String str, String str2) {
        IHttpLog iHttpLog = httpLogInterface;
        if (iHttpLog != null) {
            iHttpLog.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        IHttpLog iHttpLog = httpLogInterface;
        if (iHttpLog != null) {
            iHttpLog.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        IHttpLog iHttpLog = httpLogInterface;
        if (iHttpLog != null) {
            iHttpLog.w(str, str2);
        }
    }
}
