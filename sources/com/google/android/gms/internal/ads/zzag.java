package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class zzag {

    /* renamed from: a, reason: collision with root package name */
    private static String f2719a = "Volley";
    public static boolean DEBUG = Log.isLoggable("Volley", 2);
    private static final String b = zzag.class.getName();

    public static void v(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(f2719a, a(str, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final boolean f2720a = zzag.DEBUG;
        private final List<y> b = new ArrayList();
        private boolean c = false;

        public final synchronized void a(String str, long j) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.b.add(new y(str, j, SystemClock.elapsedRealtime()));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final synchronized void a(String str) {
            this.c = true;
            long j = this.b.size() == 0 ? 0L : this.b.get(this.b.size() - 1).c - this.b.get(0).c;
            if (j <= 0) {
                return;
            }
            long j2 = this.b.get(0).c;
            zzag.d("(%-4d ms) %s", Long.valueOf(j), str);
            for (y yVar : this.b) {
                long j3 = yVar.c;
                zzag.d("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(yVar.b), yVar.f2627a);
                j2 = j3;
            }
        }

        protected final void finalize() throws Throwable {
            if (this.c) {
                return;
            }
            a("Request on the loose");
            zzag.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static void d(String str, Object... objArr) {
        Log.d(f2719a, a(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        Log.e(f2719a, a(str, objArr));
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        Log.e(f2719a, a(str, objArr), th);
    }

    private static String a(String str, Object... objArr) {
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            }
            if (!stackTrace[i].getClassName().equals(b)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i].getMethodName();
                StringBuilder sb = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(methodName).length());
                sb.append(substring2);
                sb.append(".");
                sb.append(methodName);
                str2 = sb.toString();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
