package com.amazonaws.mobileconnectors.s3.transferutility;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TransferThreadPool {
    private static final int WAIT_TIME = 250;
    private static ExecutorService executorMainTask;
    private static ExecutorService executorPartTask;

    TransferThreadPool() {
    }

    private static synchronized void init() {
        synchronized (TransferThreadPool.class) {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            if (executorMainTask == null) {
                executorMainTask = buildExecutor(availableProcessors + 1);
            }
            if (executorPartTask == null) {
                executorPartTask = buildExecutor(availableProcessors + 1);
            }
        }
    }

    public static <T> Future<T> submitTask(Callable<T> callable) {
        init();
        if (callable instanceof UploadPartTask) {
            return executorPartTask.submit(callable);
        }
        return executorMainTask.submit(callable);
    }

    public static void closeThreadPool() {
        shutdown(executorPartTask);
        executorPartTask = null;
        shutdown(executorMainTask);
        executorMainTask = null;
    }

    private static void shutdown(ExecutorService executorService) {
        if (executorService == null) {
            return;
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(250L, TimeUnit.MILLISECONDS)) {
                return;
            }
            executorService.shutdownNow();
        } catch (InterruptedException unused) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private static ExecutorService buildExecutor(int i) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
