package com.ihoc.mgpa.n;

import android.annotation.SuppressLint;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static Class<?> f5677a;
    private static Method b;

    @SuppressLint({"PrivateApi"})
    public static String a(String str) {
        try {
            if (f5677a == null) {
                f5677a = Class.forName("android.os.SystemProperties");
            }
            if (b == null) {
                b = f5677a.getMethod("get", String.class, String.class);
            }
            return (String) b.invoke(null, str, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(String str, String str2) {
        String a2 = a(str);
        return p.b(a2) ? str2 : a2;
    }
}
