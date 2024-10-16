package com.tencent.midas.oversea.comm;

import android.os.Handler;
import android.os.Message;
import com.tencent.midas.comm.APLog;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class MCycleTimer {
    private static final int MSG_TIMER_UPDATE = 1;
    public static final String TAG = "MCycleTimer";
    private static boolean isGlobalTiming;
    private int count = 2;
    private long period = 0;
    private Timer timer = null;
    private MainThreadHandler mainThreadHandler = null;

    /* loaded from: classes.dex */
    public interface CycleTimerUpdateNotifier {
        void onUpdate();
    }

    static /* synthetic */ int access$010(MCycleTimer mCycleTimer) {
        int i = mCycleTimer.count;
        mCycleTimer.count = i - 1;
        return i;
    }

    public void start() {
        if (isGlobalTiming || this.period <= 0) {
            return;
        }
        if (this.timer == null) {
            this.timer = new Timer();
        }
        isGlobalTiming = true;
        Timer timer = this.timer;
        TimerTask timerTask = new TimerTask() { // from class: com.tencent.midas.oversea.comm.MCycleTimer.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (MCycleTimer.access$010(MCycleTimer.this) > 0) {
                    if (MCycleTimer.this.mainThreadHandler != null) {
                        MCycleTimer.this.mainThreadHandler.sendEmptyMessage(1);
                        return;
                    }
                    return;
                }
                MCycleTimer.this.release();
            }
        };
        long j = this.period;
        timer.schedule(timerTask, j, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        Timer timer = this.timer;
        if (timer != null && isGlobalTiming) {
            isGlobalTiming = false;
            timer.cancel();
            this.timer = null;
        }
        this.mainThreadHandler = null;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private MCycleTimer cycleTimer = new MCycleTimer();

        public Builder setPeriod(long j) {
            this.cycleTimer.period = j;
            return this;
        }

        public Builder setCount(int i) {
            this.cycleTimer.count = i;
            return this;
        }

        public Builder setUpdateNotifier(CycleTimerUpdateNotifier cycleTimerUpdateNotifier) {
            this.cycleTimer.mainThreadHandler = new MainThreadHandler(cycleTimerUpdateNotifier);
            return this;
        }

        public MCycleTimer build() {
            return this.cycleTimer;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class MainThreadHandler extends Handler {
        private CycleTimerUpdateNotifier notifier;

        public MainThreadHandler(CycleTimerUpdateNotifier cycleTimerUpdateNotifier) {
            this.notifier = null;
            this.notifier = cycleTimerUpdateNotifier;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            if (message.what != 1 || this.notifier == null) {
                return;
            }
            APLog.d(MCycleTimer.TAG, "timer update.");
            this.notifier.onUpdate();
        }
    }
}
