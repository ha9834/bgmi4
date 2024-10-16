package com.subao.common.i;

import android.util.Log;

/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public interface b {
        void a(String str, String str2);
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static boolean f6028a;
        private static boolean b;
        private static boolean c;
        private static boolean d;

        public static void a(boolean z, boolean z2, boolean z3, boolean z4) {
            f6028a = z;
            b = z2;
            c = z3;
            d = z4;
            if (com.subao.common.d.a("SubaoMessage")) {
                Log.d("SubaoMessage", String.format("ReportAllow set: tg=%b, auth=%b, missedLink=%b, wifiAccelSwitch=%b", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)));
            }
        }

        public static boolean a() {
            return f6028a;
        }

        public static boolean b() {
            return b;
        }

        public static boolean c() {
            return c;
        }

        public static boolean d() {
            return d;
        }
    }
}
