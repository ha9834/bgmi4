package com.uqm.crashsight.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f6620a = new AtomicInteger(1);
    private static k b;
    private ScheduledExecutorService c;

    protected k() {
        this.c = null;
        this.c = Executors.newScheduledThreadPool(3, new ThreadFactory(this) { // from class: com.uqm.crashsight.proguard.k.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("CrashSightThread-" + k.f6620a.getAndIncrement());
                return thread;
            }
        });
        ScheduledExecutorService scheduledExecutorService = this.c;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            m.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            if (b == null) {
                b = new k();
            }
            kVar = b;
        }
        return kVar;
    }

    public final synchronized boolean a(Runnable runnable, long j) {
        if (!c()) {
            m.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            m.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        if (j <= 0) {
            j = 0;
        }
        m.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j), runnable.getClass().getName());
        try {
            this.c.schedule(runnable, j, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            if (com.uqm.crashsight.b.c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized boolean a(Runnable runnable) {
        if (!c()) {
            m.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            m.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        m.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.c.execute(runnable);
            return true;
        } catch (Throwable th) {
            if (com.uqm.crashsight.b.c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized void b() {
        if (this.c != null && !this.c.isShutdown()) {
            m.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.c.shutdownNow();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized boolean c() {
        boolean z;
        if (this.c != null) {
            z = this.c.isShutdown() ? false : true;
        }
        return z;
    }
}
