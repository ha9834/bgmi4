package com.tencent.abase.utils;

import com.tencent.abase.log.XLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class ThreadPoolUtils {
    private static final String TAG = "THREAD_POOL_UTILS";
    private ExecutorService service;

    private ThreadPoolUtils() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 0) {
            this.service = Executors.newFixedThreadPool(availableProcessors * 2);
        } else {
            XLog.w(TAG, "Get CPU number failed.");
        }
    }

    /* loaded from: classes2.dex */
    private static class SingletonHolder {
        private static final ThreadPoolUtils THREAD_POOL_UTILS = new ThreadPoolUtils();

        private SingletonHolder() {
        }
    }

    public static ThreadPoolUtils getThreadPoolSingleton() {
        return SingletonHolder.THREAD_POOL_UTILS;
    }

    public void execute(Runnable runnable) {
        this.service.execute(runnable);
    }
}
