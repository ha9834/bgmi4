package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class EnabledEventsStrategy<T> implements EventsStrategy<T> {
    static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    protected final Context context;
    final ScheduledExecutorService executorService;
    protected final EventsFilesManager<T> filesManager;
    volatile int rolloverIntervalSeconds = -1;
    final AtomicReference<ScheduledFuture<?>> scheduledRolloverFutureRef = new AtomicReference<>();

    public EnabledEventsStrategy(Context context, ScheduledExecutorService scheduledExecutorService, EventsFilesManager<T> eventsFilesManager) {
        this.context = context;
        this.executorService = scheduledExecutorService;
        this.filesManager = eventsFilesManager;
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.FileRollOverManager
    public void scheduleTimeBasedRollOverIfNeeded() {
        if (this.rolloverIntervalSeconds != -1) {
            scheduleTimeBasedFileRollOver(this.rolloverIntervalSeconds, this.rolloverIntervalSeconds);
        }
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsManager
    public void sendEvents() {
        sendAndCleanUpIfSuccess();
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.FileRollOverManager
    public void cancelTimeBasedFileRollOver() {
        if (this.scheduledRolloverFutureRef.get() != null) {
            CommonUtils.logControlled(this.context, "Cancelling time-based rollover because no events are currently being generated.");
            this.scheduledRolloverFutureRef.get().cancel(false);
            this.scheduledRolloverFutureRef.set(null);
        }
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsManager
    public void deleteAllEvents() {
        this.filesManager.deleteAllEventsFiles();
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsManager
    public void recordEvent(T t) {
        CommonUtils.logControlled(this.context, t.toString());
        try {
            this.filesManager.writeEvent(t);
        } catch (IOException e) {
            CommonUtils.logControlledError(this.context, "Failed to write event.", e);
        }
        scheduleTimeBasedRollOverIfNeeded();
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.FileRollOverManager
    public boolean rollFileOver() {
        try {
            return this.filesManager.rollFileOver();
        } catch (IOException e) {
            CommonUtils.logControlledError(this.context, "Failed to roll file over.", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void configureRollover(int i) {
        this.rolloverIntervalSeconds = i;
        scheduleTimeBasedFileRollOver(0L, this.rolloverIntervalSeconds);
    }

    public int getRollover() {
        return this.rolloverIntervalSeconds;
    }

    void scheduleTimeBasedFileRollOver(long j, long j2) {
        if (this.scheduledRolloverFutureRef.get() == null) {
            TimeBasedFileRollOverRunnable timeBasedFileRollOverRunnable = new TimeBasedFileRollOverRunnable(this.context, this);
            CommonUtils.logControlled(this.context, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.scheduledRolloverFutureRef.set(this.executorService.scheduleAtFixedRate(timeBasedFileRollOverRunnable, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                CommonUtils.logControlledError(this.context, "Failed to schedule time based file roll over", e);
            }
        }
    }

    void sendAndCleanUpIfSuccess() {
        FilesSender filesSender = getFilesSender();
        if (filesSender == null) {
            CommonUtils.logControlled(this.context, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.logControlled(this.context, "Sending all files");
        List<File> batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
        int i = 0;
        while (batchOfFilesToSend.size() > 0) {
            try {
                CommonUtils.logControlled(this.context, String.format(Locale.US, "attempt to send batch of %d files", Integer.valueOf(batchOfFilesToSend.size())));
                boolean send = filesSender.send(batchOfFilesToSend);
                if (send) {
                    i += batchOfFilesToSend.size();
                    this.filesManager.deleteSentFiles(batchOfFilesToSend);
                }
                if (!send) {
                    break;
                } else {
                    batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
                }
            } catch (Exception e) {
                CommonUtils.logControlledError(this.context, "Failed to send batch of analytics files to server: " + e.getMessage(), e);
            }
        }
        if (i == 0) {
            this.filesManager.deleteOldestInRollOverIfOverMax();
        }
    }
}
