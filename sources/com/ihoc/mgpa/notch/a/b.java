package com.ihoc.mgpa.notch.a;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static Class f5681a;
    private static Method b;

    public static String a(String str) {
        return a(str, null);
    }

    public static String a(String str, String str2) {
        try {
            if (f5681a == null) {
                f5681a = Class.forName("android.os.SystemProperties");
            }
            if (b == null) {
                b = f5681a.getMethod("get", String.class, String.class);
            }
            return (String) b.invoke(null, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
