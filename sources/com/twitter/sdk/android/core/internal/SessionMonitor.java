package com.twitter.sdk.android.core.internal;

import android.app.Activity;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.internal.ActivityLifecycleManager;
import java.util.Calendar;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class SessionMonitor<T extends Session> {
    private final ExecutorService executorService;
    protected final MonitorState monitorState;
    private final SessionManager<T> sessionManager;
    private final SessionVerifier sessionVerifier;
    private final SystemCurrentTimeProvider time;

    public SessionMonitor(SessionManager<T> sessionManager, ExecutorService executorService, SessionVerifier<T> sessionVerifier) {
        this(sessionManager, new SystemCurrentTimeProvider(), executorService, new MonitorState(), sessionVerifier);
    }

    SessionMonitor(SessionManager<T> sessionManager, SystemCurrentTimeProvider systemCurrentTimeProvider, ExecutorService executorService, MonitorState monitorState, SessionVerifier sessionVerifier) {
        this.time = systemCurrentTimeProvider;
        this.sessionManager = sessionManager;
        this.executorService = executorService;
        this.monitorState = monitorState;
        this.sessionVerifier = sessionVerifier;
    }

    public void monitorActivityLifecycle(ActivityLifecycleManager activityLifecycleManager) {
        activityLifecycleManager.registerCallbacks(new ActivityLifecycleManager.Callbacks() { // from class: com.twitter.sdk.android.core.internal.SessionMonitor.1
            @Override // com.twitter.sdk.android.core.internal.ActivityLifecycleManager.Callbacks
            public void onActivityStarted(Activity activity) {
                SessionMonitor.this.triggerVerificationIfNecessary();
            }
        });
    }

    public void triggerVerificationIfNecessary() {
        if (this.sessionManager.getActiveSession() != null && this.monitorState.beginVerification(this.time.getCurrentTimeMillis())) {
            this.executorService.submit(new Runnable() { // from class: com.twitter.sdk.android.core.internal.SessionMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    SessionMonitor.this.verifyAll();
                }
            });
        }
    }

    protected void verifyAll() {
        Iterator<T> it = this.sessionManager.getSessionMap().values().iterator();
        while (it.hasNext()) {
            this.sessionVerifier.verifySession(it.next());
        }
        this.monitorState.endVerification(this.time.getCurrentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class MonitorState {
        private static final long TIME_THRESHOLD_IN_MILLIS = 21600000;
        public long lastVerification;
        private final Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        public boolean verifying;

        public synchronized boolean beginVerification(long j) {
            boolean z = j - this.lastVerification > TIME_THRESHOLD_IN_MILLIS;
            boolean z2 = !isOnSameDate(j, this.lastVerification);
            if (this.verifying || !(z || z2)) {
                return false;
            }
            this.verifying = true;
            return true;
        }

        public synchronized void endVerification(long j) {
            this.verifying = false;
            this.lastVerification = j;
        }

        private boolean isOnSameDate(long j, long j2) {
            this.utcCalendar.setTimeInMillis(j);
            int i = this.utcCalendar.get(6);
            int i2 = this.utcCalendar.get(1);
            this.utcCalendar.setTimeInMillis(j2);
            return i == this.utcCalendar.get(6) && i2 == this.utcCalendar.get(1);
        }
    }
}
