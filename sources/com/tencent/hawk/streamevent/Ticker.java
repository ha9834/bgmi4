package com.tencent.hawk.streamevent;

import com.tencent.hawk.bridge.ActivityStatusChangedInterface;
import com.tencent.hawk.bridge.HawkLogger;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
public class Ticker implements ActivityStatusChangedInterface {
    private Semaphore mNotifySemaphore;
    private final int mTickInterval;
    private Semaphore mWakeupSemaphore;
    private volatile boolean mIsforground = true;
    private volatile boolean mIsFinished = false;
    private volatile boolean mIsTickerActiveted = false;

    public Ticker(Semaphore semaphore, Semaphore semaphore2, int i) {
        this.mTickInterval = i;
        this.mNotifySemaphore = semaphore;
        this.mWakeupSemaphore = semaphore2;
    }

    public void startTick() {
        if (this.mIsTickerActiveted) {
            HawkLogger.w("Ticker already started");
            return;
        }
        Thread thread = new Thread(new Runnable() { // from class: com.tencent.hawk.streamevent.Ticker.1
            @Override // java.lang.Runnable
            public void run() {
                while (!Ticker.this.mIsFinished) {
                    while (!Ticker.this.mIsforground) {
                        try {
                            HawkLogger.d("ticker bg, tick wait signal");
                            Ticker.this.mWakeupSemaphore.acquire();
                            HawkLogger.d("ticker bg, wakeup");
                        } catch (InterruptedException e) {
                            HawkLogger.e("TickThread wakeup error: " + e.getMessage());
                            return;
                        }
                    }
                    if (Ticker.this.mNotifySemaphore != null) {
                        Ticker.this.mNotifySemaphore.release();
                        HawkLogger.d("send tick to committing thread");
                    }
                    if (Ticker.this.mTickInterval <= 0) {
                        return;
                    }
                    try {
                        Thread.sleep(Ticker.this.mTickInterval * 1000);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                HawkLogger.d("Ticker finished in thread");
            }
        });
        thread.setName("TApm Ticker");
        thread.start();
        this.mIsTickerActiveted = true;
    }

    public void finish() {
        this.mIsFinished = true;
        HawkLogger.d("Ticker finished");
    }

    @Override // com.tencent.hawk.bridge.ActivityStatusChangedInterface
    public void backgroud() {
        this.mIsforground = false;
    }

    @Override // com.tencent.hawk.bridge.ActivityStatusChangedInterface
    public void foreground() {
        Semaphore semaphore;
        HawkLogger.d("TickTimer switch to foreground");
        if (!this.mIsTickerActiveted || (semaphore = this.mWakeupSemaphore) == null) {
            return;
        }
        this.mIsforground = true;
        semaphore.release();
    }
}
