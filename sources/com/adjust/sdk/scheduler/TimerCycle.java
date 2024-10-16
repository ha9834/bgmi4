package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.Util;
import java.text.DecimalFormat;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class TimerCycle {
    private Runnable command;
    private long cycleDelay;
    private long initialDelay;
    private boolean isPaused = true;
    private ILogger logger = AdjustFactory.getLogger();
    private String name;
    private FutureScheduler scheduler;
    private ScheduledFuture waitingTask;

    public TimerCycle(Runnable runnable, long j, long j2, String str) {
        this.scheduler = new SingleThreadFutureScheduler(str, true);
        this.name = str;
        this.command = runnable;
        this.initialDelay = j;
        this.cycleDelay = j2;
        DecimalFormat decimalFormat = Util.SecondsDisplayFormat;
        double d = j2;
        Double.isNaN(d);
        String format = decimalFormat.format(d / 1000.0d);
        DecimalFormat decimalFormat2 = Util.SecondsDisplayFormat;
        double d2 = j;
        Double.isNaN(d2);
        this.logger.verbose("%s configured to fire after %s seconds of starting and cycles every %s seconds", str, decimalFormat2.format(d2 / 1000.0d), format);
    }

    public void start() {
        if (!this.isPaused) {
            this.logger.verbose("%s is already started", this.name);
            return;
        }
        this.logger.verbose("%s starting", this.name);
        this.waitingTask = this.scheduler.scheduleFutureWithFixedDelay(new Runnable() { // from class: com.adjust.sdk.scheduler.TimerCycle.1
            @Override // java.lang.Runnable
            public void run() {
                TimerCycle.this.logger.verbose("%s fired", TimerCycle.this.name);
                TimerCycle.this.command.run();
            }
        }, this.initialDelay, this.cycleDelay);
        this.isPaused = false;
    }

    public void suspend() {
        if (this.isPaused) {
            this.logger.verbose("%s is already suspended", this.name);
            return;
        }
        this.initialDelay = this.waitingTask.getDelay(TimeUnit.MILLISECONDS);
        this.waitingTask.cancel(false);
        DecimalFormat decimalFormat = Util.SecondsDisplayFormat;
        double d = this.initialDelay;
        Double.isNaN(d);
        this.logger.verbose("%s suspended with %s seconds left", this.name, decimalFormat.format(d / 1000.0d));
        this.isPaused = true;
    }

    private void cancel(boolean z) {
        ScheduledFuture scheduledFuture = this.waitingTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(z);
        }
        this.waitingTask = null;
    }

    public void teardown() {
        cancel(true);
        FutureScheduler futureScheduler = this.scheduler;
        if (futureScheduler != null) {
            futureScheduler.teardown();
        }
        this.scheduler = null;
    }
}
