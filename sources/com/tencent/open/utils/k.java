package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class k {
    private static Handler c;
    private static HandlerThread d;
    private static Object b = new Object();

    /* renamed from: a, reason: collision with root package name */
    public static final Executor f6408a = c();

    private static Executor c() {
        return new ThreadPoolExecutor(0, 3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static void a(Runnable runnable) {
        try {
            f6408a.execute(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }

    public static Handler a() {
        if (c == null) {
            synchronized (k.class) {
                d = new HandlerThread("SDK_SUB");
                d.start();
                c = new Handler(d.getLooper());
            }
        }
        return c;
    }

    public static void b(Runnable runnable) {
        a().post(runnable);
    }

    public static Executor b() {
        return new a();
    }

    /* loaded from: classes.dex */
    private static class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        final Queue<Runnable> f6409a;
        Runnable b;

        private a() {
            this.f6409a = new LinkedList();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f6409a.offer(new Runnable() { // from class: com.tencent.open.utils.k.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }

        protected synchronized void a() {
            Runnable poll = this.f6409a.poll();
            this.b = poll;
            if (poll != null) {
                k.f6408a.execute(this.b);
            }
        }
    }
}
