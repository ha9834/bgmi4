package com.gamesafe.ano;

import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class b {
    public static void a(String str) {
        try {
            byte[] bytes = str.getBytes(a.a("poa-8"));
            if (bytes == null || bytes.length <= 0) {
                return;
            }
            AnoSdk.onruntimeinfo(bytes, bytes.length);
        } catch (Throwable unused) {
        }
    }

    public static void b(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes(a.a("poa-8"));
        if (bytes == null || bytes.length <= 0) {
            return;
        }
        AnoSdk.senddatatosvr(bytes, bytes.length);
    }

    public static String c(String str) {
        return AnoSdk.ioctl(str);
    }

    public static void d(String str) {
        a("*#06#:" + str);
    }
}
