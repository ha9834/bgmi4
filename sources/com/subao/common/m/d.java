package com.subao.common.m;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static Executor f6131a;

    public static synchronized Executor a() {
        Executor executor;
        synchronized (d.class) {
            if (f6131a == null) {
                f6131a = Executors.newCachedThreadPool();
            }
            executor = f6131a;
        }
        return executor;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
