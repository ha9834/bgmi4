package com.shieldtunnel.svpn.common;

import android.util.Log;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static c f5778a = new C0147b();

    /* renamed from: com.shieldtunnel.svpn.common.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0147b implements c {
        private C0147b() {
        }

        @Override // com.shieldtunnel.svpn.common.b.c
        public boolean a(String str, int i) {
            return Log.isLoggable(str, i);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean a(String str, int i);
    }

    public static void a(String str, int i, String str2) {
        if (str2 == null || !a(str, i)) {
            return;
        }
        Log.println(i, str, str2);
    }

    public static void b(String str, String str2) {
        Log.e(str, str2);
    }

    public static void c(String str, String str2) {
        a(str, 5, str2);
    }

    public static boolean a(String str, int i) {
        return f5778a.a(str, i);
    }

    public static boolean a(String str) {
        return a(str, 3);
    }

    public static void a(String str, String str2) {
        a(str, 3, str2);
    }
}
