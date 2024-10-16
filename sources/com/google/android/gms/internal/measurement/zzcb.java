package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* loaded from: classes2.dex */
public class zzcb {

    /* renamed from: a, reason: collision with root package name */
    private static UserManager f4543a;
    private static volatile boolean b = !zzri();
    private static boolean c = false;

    private zzcb() {
    }

    public static boolean zzri() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean isUserUnlocked(Context context) {
        return !zzri() || b(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r2.isUserRunning(android.os.Process.myUserHandle()) == false) goto L15;
     */
    @android.annotation.TargetApi(24)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(android.content.Context r6) {
        /*
            r0 = 1
            r1 = 1
        L2:
            r2 = 2
            r3 = 0
            r4 = 0
            if (r1 > r2) goto L39
            android.os.UserManager r2 = com.google.android.gms.internal.measurement.zzcb.f4543a
            if (r2 != 0) goto L15
            java.lang.Class<android.os.UserManager> r2 = android.os.UserManager.class
            java.lang.Object r2 = r6.getSystemService(r2)
            android.os.UserManager r2 = (android.os.UserManager) r2
            com.google.android.gms.internal.measurement.zzcb.f4543a = r2
        L15:
            android.os.UserManager r2 = com.google.android.gms.internal.measurement.zzcb.f4543a
            if (r2 != 0) goto L1a
            return r0
        L1a:
            boolean r5 = r2.isUserUnlocked()     // Catch: java.lang.NullPointerException -> L2c
            if (r5 != 0) goto L2a
            android.os.UserHandle r5 = android.os.Process.myUserHandle()     // Catch: java.lang.NullPointerException -> L2c
            boolean r6 = r2.isUserRunning(r5)     // Catch: java.lang.NullPointerException -> L2c
            if (r6 != 0) goto L39
        L2a:
            r4 = 1
            goto L39
        L2c:
            r2 = move-exception
            java.lang.String r4 = "DirectBootUtils"
            java.lang.String r5 = "Failed to check if user is unlocked."
            android.util.Log.w(r4, r5, r2)
            com.google.android.gms.internal.measurement.zzcb.f4543a = r3
            int r1 = r1 + 1
            goto L2
        L39:
            if (r4 == 0) goto L3d
            com.google.android.gms.internal.measurement.zzcb.f4543a = r3
        L3d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcb.a(android.content.Context):boolean");
    }

    @TargetApi(24)
    private static boolean b(Context context) {
        if (b) {
            return true;
        }
        synchronized (zzcb.class) {
            if (b) {
                return true;
            }
            boolean a2 = a(context);
            if (a2) {
                b = a2;
            }
            return a2;
        }
    }
}
