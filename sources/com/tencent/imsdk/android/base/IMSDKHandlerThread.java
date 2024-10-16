package com.tencent.imsdk.android.base;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public class IMSDKHandlerThread extends HandlerThread {
    private static Handler mHandler;
    private static volatile IMSDKHandlerThread mInstance;
    private static int mRunningTaskAmounts;

    static /* synthetic */ int access$010() {
        int i = mRunningTaskAmounts;
        mRunningTaskAmounts = i - 1;
        return i;
    }

    public IMSDKHandlerThread() {
        super("IMSDKHandlerThread", 0);
    }

    public static void prepareThread() {
        if (mInstance == null) {
            mRunningTaskAmounts = 0;
            mInstance = new IMSDKHandlerThread();
            mInstance.start();
            mHandler = new Handler(mInstance.getLooper());
            IMLogger.w("IMSDKHandlerThread instance create", new Object[0]);
        }
    }

    public static void destroyThread() {
        if (mInstance != null) {
            mInstance.quit();
            mInstance = null;
            mHandler = null;
            IMLogger.w("IMSDKHandlerThread have been destroy", new Object[0]);
        }
    }

    public static void post(Runnable runnable) {
        postDelay(runnable, 0L);
    }

    public static void post(Runnable runnable, boolean z) {
        postDelay(runnable, 0L, true);
    }

    public static void postDelay(Runnable runnable, long j) {
        postDelay(runnable, j, true);
    }

    public static void postDelay(final Runnable runnable, long j, final boolean z) {
        prepareThread();
        mRunningTaskAmounts++;
        mHandler.postDelayed(new Runnable() { // from class: com.tencent.imsdk.android.base.IMSDKHandlerThread.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
                IMSDKHandlerThread.access$010();
                if (!z || IMSDKHandlerThread.mRunningTaskAmounts > 0) {
                    return;
                }
                IMSDKHandlerThread.destroyThread();
            }
        }, j);
    }
}
