package com.subao.common;

import android.util.Log;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static b f5948a = new a();

    /* loaded from: classes2.dex */
    public interface b {
        boolean a(String str, int i);
    }

    public static void a(String str, int i, String str2) {
        if (str2 == null || !a(str, i)) {
            return;
        }
        Log.println(i, str, str2);
    }

    public static boolean a(String str, int i) {
        return f5948a.a(str, i);
    }

    public static boolean a(String str) {
        return a(str, 3);
    }

    public static void a(String str, String str2) {
        a(str, 3, str2);
    }

    public static void b(String str, String str2) {
        a(str, 5, str2);
    }

    public static void c(String str, String str2) {
        a(str, 6, str2);
    }

    /* loaded from: classes2.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.subao.common.d.b
        public boolean a(String str, int i) {
            return com.subao.common.f.b.b() || Log.isLoggable(str, i);
        }
    }
}
