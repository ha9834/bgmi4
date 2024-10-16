package com.shieldtunnel.svpn.common.k;

import android.os.Looper;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static long f5857a = -1;

    public static long a() {
        if (f5857a < 0) {
            f5857a = Looper.getMainLooper().getThread().getId();
        }
        return f5857a;
    }

    public static boolean b() {
        return Thread.currentThread().getId() == a();
    }
}
