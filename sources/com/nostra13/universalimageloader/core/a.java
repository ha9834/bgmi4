package com.nostra13.universalimageloader.core;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.amazonaws.services.s3.internal.Constants;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class a {
    public static Executor a(int i, int i2, QueueProcessingType queueProcessingType) {
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>) (queueProcessingType == QueueProcessingType.LIFO ? new LIFOLinkedBlockingDeque() : new LinkedBlockingQueue()), a(i2, "uil-pool-"));
    }

    public static Executor a() {
        return Executors.newCachedThreadPool(a(5, "uil-pool-d-"));
    }

    public static com.nostra13.universalimageloader.a.a.b.a b() {
        return new com.nostra13.universalimageloader.a.a.b.b();
    }

    public static com.nostra13.universalimageloader.a.a.a a(Context context, com.nostra13.universalimageloader.a.a.b.a aVar, long j, int i) {
        File b = b(context);
        if (j > 0 || i > 0) {
            try {
                return new com.nostra13.universalimageloader.a.a.a.a.b(com.nostra13.universalimageloader.b.e.b(context), b, aVar, j, i);
            } catch (IOException e) {
                com.nostra13.universalimageloader.b.c.a(e);
            }
        }
        return new com.nostra13.universalimageloader.a.a.a.b(com.nostra13.universalimageloader.b.e.a(context), b, aVar);
    }

    private static File b(Context context) {
        File a2 = com.nostra13.universalimageloader.b.e.a(context, false);
        File file = new File(a2, "uil-images");
        return (file.exists() || file.mkdir()) ? file : a2;
    }

    public static com.nostra13.universalimageloader.a.b.a a(Context context, int i) {
        if (i == 0) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = activityManager.getMemoryClass();
            if (d() && c(context)) {
                memoryClass = a(activityManager);
            }
            i = (memoryClass * Constants.MB) / 8;
        }
        return new com.nostra13.universalimageloader.a.b.a.b(i);
    }

    private static boolean d() {
        return Build.VERSION.SDK_INT >= 11;
    }

    @TargetApi(11)
    private static boolean c(Context context) {
        return (context.getApplicationInfo().flags & Constants.MB) != 0;
    }

    @TargetApi(11)
    private static int a(ActivityManager activityManager) {
        return activityManager.getLargeMemoryClass();
    }

    public static ImageDownloader a(Context context) {
        return new com.nostra13.universalimageloader.core.download.a(context);
    }

    public static com.nostra13.universalimageloader.core.a.b a(boolean z) {
        return new com.nostra13.universalimageloader.core.a.a(z);
    }

    public static com.nostra13.universalimageloader.core.b.a c() {
        return new com.nostra13.universalimageloader.core.b.b();
    }

    private static ThreadFactory a(int i, String str) {
        return new ThreadFactoryC0143a(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.nostra13.universalimageloader.core.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0143a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private static final AtomicInteger f5723a = new AtomicInteger(1);
        private final String d;
        private final int e;
        private final AtomicInteger c = new AtomicInteger(1);
        private final ThreadGroup b = Thread.currentThread().getThreadGroup();

        ThreadFactoryC0143a(int i, String str) {
            this.e = i;
            this.d = str + f5723a.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.b, runnable, this.d + this.c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.e);
            return thread;
        }
    }
}
