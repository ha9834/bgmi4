package com.subao.common.n;

import android.os.Looper;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static long f6137a = -1;

    public static long a() {
        if (f6137a < 0) {
            f6137a = Looper.getMainLooper().getThread().getId();
        }
        return f6137a;
    }

    public static boolean b() {
        return Thread.currentThread().getId() == a();
    }
}
