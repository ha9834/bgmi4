package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.CommonUtils;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public abstract class EventsHandler<T> implements EventsStorageListener {
    protected final Context context;
    protected final ScheduledExecutorService executor;
    protected EventsStrategy<T> strategy;

    protected abstract EventsStrategy<T> getDisabledEventsStrategy();

    public EventsHandler(Context context, EventsStrategy<T> eventsStrategy, EventsFilesManager eventsFilesManager, ScheduledExecutorService scheduledExecutorService) {
        this.context = context.getApplicationContext();
        this.executor = scheduledExecutorService;
        this.strategy = eventsStrategy;
        eventsFilesManager.registerRollOverListener(this);
    }

    public void recordEventAsync(final T t, final boolean z) {
        executeAsync(new Runnable() { // from class: com.twitter.sdk.android.core.internal.scribe.EventsHandler.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventsHandler.this.strategy.recordEvent(t);
                    if (z) {
                        EventsHandler.this.strategy.rollFileOver();
                    }
                } catch (Exception e) {
                    CommonUtils.logControlledError(EventsHandler.this.context, "Failed to record event.", e);
                }
            }
        });
    }

    public void recordEventSync(final T t) {
        executeSync(new Runnable() { // from class: com.twitter.sdk.android.core.internal.scribe.EventsHandler.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventsHandler.this.strategy.recordEvent(t);
                } catch (Exception e) {
                    CommonUtils.logControlledError(EventsHandler.this.context, "Failed to record event", e);
                }
            }
        });
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorageListener
    public void onRollOver(String str) {
        executeAsync(new Runnable() { // from class: com.twitter.sdk.android.core.internal.scribe.EventsHandler.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventsHandler.this.strategy.sendEvents();
                } catch (Exception e) {
                    CommonUtils.logControlledError(EventsHandler.this.context, "Failed to send events files.", e);
                }
            }
        });
    }

    public void disable() {
        executeAsync(new Runnable() { // from class: com.twitter.sdk.android.core.internal.scribe.EventsHandler.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventsStrategy<T> eventsStrategy = EventsHandler.this.strategy;
                    EventsHandler.this.strategy = EventsHandler.this.getDisabledEventsStrategy();
                    eventsStrategy.deleteAllEvents();
                } catch (Exception e) {
                    CommonUtils.logControlledError(EventsHandler.this.context, "Failed to disable events.", e);
                }
            }
        });
    }

    protected void executeSync(Runnable runnable) {
        try {
            this.executor.submit(runnable).get();
        } catch (Exception e) {
            CommonUtils.logControlledError(this.context, "Failed to run events task", e);
        }
    }

    protected void executeAsync(Runnable runnable) {
        try {
            this.executor.submit(runnable);
        } catch (Exception e) {
            CommonUtils.logControlledError(this.context, "Failed to submit events task", e);
        }
    }
}
