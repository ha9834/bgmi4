package com.tencent.hawk.bridge;

import android.content.Context;
import com.tencent.hawk.bridge.CC;
import com.tencent.hawk.receiver.BatteryMgr;
import com.tencent.hawk.utils.CpuUtil;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
public class Routine implements ActivityStatusChangedInterface, Runnable {
    private CC mCCMgr;
    private Context mContext;
    private int mCpuCurFreqsIntervals;
    private volatile boolean mIsBackgroud = false;
    private volatile boolean mIsLevelEnabled = false;
    private volatile int maxPSS = 0;
    private Semaphore mFbSem = new Semaphore(0);
    private Semaphore mLevelMarkSem = new Semaphore(0);

    public Routine(Context context, CC cc) {
        this.mCCMgr = cc;
        this.mContext = context;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.setName("Routine");
        thread.start();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        this.maxPSS = 0;
        CC.Strategy strategy = CC.getStrategy();
        boolean isJavaLevelPssEnabled = strategy.isJavaLevelPssEnabled();
        if (isJavaLevelPssEnabled) {
            HawkLogger.d("Javapss is enabled");
        } else {
            HawkLogger.d("Javapss is disabled");
        }
        this.mCpuCurFreqsIntervals = strategy.getCpuFreqIntervals();
        HawkLogger.d("cpu intervals: " + this.mCpuCurFreqsIntervals);
        int i2 = 0;
        while (true) {
            if (!strategy.isJavaLevelPssEnabled() && !strategy.isBatteryEnabled) {
                HawkLogger.w("Routine: java pss and battery disabled");
                return;
            }
            while (!this.mIsLevelEnabled) {
                try {
                    HawkLogger.i("level is not mark, wait");
                    this.mLevelMarkSem.acquire();
                    HawkLogger.i("level is marked, wakeup");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (this.mIsBackgroud) {
                try {
                    HawkLogger.i("Routine current state is background, wait");
                    this.mFbSem.acquire();
                    HawkLogger.i("Routine current state wakwup");
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                if (strategy.getJavaPssIntervals() != 0 && isJavaLevelPssEnabled) {
                    if (i % strategy.getJavaPssIntervals() == 0) {
                        int pssMemorySize = PssFetcher.getPssMemorySize(this.mContext);
                        HawkNative.postPssValue(pssMemorySize);
                        if (pssMemorySize > this.maxPSS) {
                            this.maxPSS = pssMemorySize;
                        }
                        try {
                            HawkLogger.d("PSS SZ: " + pssMemorySize);
                            i2 = pssMemorySize;
                        } catch (Exception unused) {
                            i2 = pssMemorySize;
                        }
                    } else {
                        HawkNative.postPssValue(i2);
                    }
                }
                if (strategy.getBatteryFetchIntervals() != 0 && strategy.isCCBatteryEnabled() && i % strategy.getBatteryFetchIntervals() == 0) {
                    BatteryMgr.postBatteryInfoManual(this.mContext);
                }
            } catch (Exception unused2) {
            }
            int i3 = this.mCpuCurFreqsIntervals;
            if (i3 > 0 && i3 < 32 && i % i3 == 0) {
                try {
                    int[] cpuCurFreqs = CpuUtil.getCpuCurFreqs();
                    if (cpuCurFreqs != null) {
                        HawkNative.postCpuCurFreqs(cpuCurFreqs);
                    }
                } catch (Exception unused3) {
                }
            }
            i++;
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException unused4) {
            }
        }
    }

    public void markLevel() {
        this.mIsLevelEnabled = true;
        this.mLevelMarkSem.release();
    }

    public void markLevelFin() {
        this.mIsLevelEnabled = false;
    }

    @Override // com.tencent.hawk.bridge.ActivityStatusChangedInterface
    public void backgroud() {
        this.mIsBackgroud = true;
    }

    @Override // com.tencent.hawk.bridge.ActivityStatusChangedInterface
    public void foreground() {
        if (this.mIsBackgroud) {
            this.mIsBackgroud = false;
            this.mFbSem.release();
        }
    }

    public int getSceneMaxPss() {
        return this.maxPSS;
    }
}
