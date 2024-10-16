package com.tencent.grobot.lite.common.thread;

import android.os.Handler;
import android.os.Looper;
import com.tencent.grobot.lite.common.ComponentRef;
import com.tencent.grobot.lite.common.TLog;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class ThreadManager implements ComponentRef {
    private static final int BG_THREAD_CORE_COUNT = 2;
    private static final int NET_THREAD_CORE_COUNT = 2;
    private static final String TAG = "ThreadManager";
    private static ThreadManager sMgr;
    private final Object lock = new Object();
    private Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private ScheduledThreadPoolExecutor netExecutor = null;
    private ScheduledThreadPoolExecutor bgExecutor = null;

    public static ThreadManager get() {
        if (sMgr == null) {
            synchronized (ThreadManager.class) {
                if (sMgr == null) {
                    sMgr = new ThreadManager();
                }
            }
        }
        return sMgr;
    }

    public static void destory() {
        ThreadManager threadManager = sMgr;
        if (threadManager != null) {
            threadManager.onDestroy();
            sMgr = null;
        }
    }

    private ThreadManager() {
        TLog.d(TAG, "ThreadManager Create.");
    }

    public void postToUiThread(Runnable runnable) {
        checkUiHandlerReady();
        this.mainThreadHandler.post(runnable);
    }

    public void postDelayToUiThread(Runnable runnable, long j) {
        checkUiHandlerReady();
        this.mainThreadHandler.postDelayed(runnable, j);
    }

    public void removeFromUiThread(Runnable runnable) {
        checkUiHandlerReady();
        this.mainThreadHandler.removeCallbacks(runnable);
    }

    public Future postToNetThread(Callable callable) {
        checkNetThreadReady();
        return this.netExecutor.submit(callable);
    }

    public Future postToNetThread(Runnable runnable) {
        checkNetThreadReady();
        return this.netExecutor.submit(runnable);
    }

    public Future postDelayToNetThread(Runnable runnable, long j) {
        checkNetThreadReady();
        return this.netExecutor.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public Future postToBackgroundThread(Runnable runnable) {
        checkBgThreadReady();
        return this.bgExecutor.submit(runnable);
    }

    public Future postDelayToBackgroundThread(Runnable runnable, long j) {
        checkBgThreadReady();
        return this.bgExecutor.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
        Handler handler = this.mainThreadHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mainThreadHandler = null;
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.netExecutor;
        if (scheduledThreadPoolExecutor != null && !scheduledThreadPoolExecutor.isShutdown()) {
            this.netExecutor.shutdownNow();
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = this.bgExecutor;
        if (scheduledThreadPoolExecutor2 == null || scheduledThreadPoolExecutor2.isShutdown()) {
            return;
        }
        this.bgExecutor.shutdownNow();
    }

    private void checkUiHandlerReady() {
        if (this.mainThreadHandler == null) {
            synchronized (this.lock) {
                if (this.mainThreadHandler == null) {
                    TLog.d(TAG, "create main thread handler");
                    this.mainThreadHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
    }

    private void checkNetThreadReady() {
        if (this.netExecutor == null) {
            synchronized (this.lock) {
                if (this.netExecutor == null) {
                    this.netExecutor = new ScheduledThreadPoolExecutor(2, new CommonThreadFactory("net"));
                    this.netExecutor.setKeepAliveTime(30L, TimeUnit.SECONDS);
                    this.netExecutor.allowCoreThreadTimeOut(true);
                    this.netExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
                    TLog.d(TAG, "crate net executors.");
                }
            }
        }
    }

    private void checkBgThreadReady() {
        if (this.bgExecutor == null) {
            synchronized (this.lock) {
                if (this.bgExecutor == null) {
                    this.bgExecutor = new ScheduledThreadPoolExecutor(2, new CommonThreadFactory("background"));
                    this.netExecutor.setKeepAliveTime(30L, TimeUnit.SECONDS);
                    this.netExecutor.allowCoreThreadTimeOut(true);
                    this.netExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
                    TLog.d(TAG, "crate bg executors.");
                }
            }
        }
    }
}
