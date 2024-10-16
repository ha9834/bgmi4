package com.tencent.midas.http.core;

import android.os.Process;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class Dispatcher {
    private static final int MAX_CURRENCY_NETWORK_THREAD = 5;
    private ExecutorService executorService = getExecutorService();

    public synchronized void enqueue(ExecutableCall executableCall) {
        if (executableCall == null) {
            return;
        }
        this.executorService.execute(executableCall);
    }

    private synchronized ExecutorService getExecutorService() {
        if (this.executorService == null) {
            this.executorService = Executors.newFixedThreadPool(5, threadFactory("Network Thread", false));
        }
        return this.executorService;
    }

    private static ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.tencent.midas.http.core.Dispatcher.1
            private AtomicInteger netThreadCount = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str + " " + this.netThreadCount.getAndIncrement());
                Process.setThreadPriority(10);
                thread.setDaemon(z);
                return thread;
            }
        };
    }
}
