package com.helpshift.util.concurrent;

import com.helpshift.util.HSLogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class NotifyingRunnable implements Runnable {
    private static final String TAG = "Helpshift_NotiRunnable";
    private final Runnable runnable;
    private final Object syncLock = new Object();
    private AtomicBoolean isFinished = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotifyingRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void waitForCompletion() {
        synchronized (this.syncLock) {
            while (!this.isFinished.get()) {
                try {
                    this.syncLock.wait();
                } catch (InterruptedException e) {
                    HSLogger.d(TAG, "Exception in NotifyingRunnable", e);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.syncLock) {
            try {
                this.runnable.run();
            } finally {
                this.isFinished.set(true);
                this.syncLock.notifyAll();
            }
        }
    }
}
