package com.shieldtunnel.svpn.common.j;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Executor f5854a;

    private c() {
    }

    public static Executor a() {
        Executor executor = f5854a;
        if (executor == null) {
            synchronized (c.class) {
                if (f5854a == null) {
                    f5854a = Executors.newCachedThreadPool();
                }
                executor = f5854a;
            }
        }
        return executor;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
