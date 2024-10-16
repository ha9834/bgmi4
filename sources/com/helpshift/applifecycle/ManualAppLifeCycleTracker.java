package com.helpshift.applifecycle;

import android.content.Context;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;

/* loaded from: classes2.dex */
class ManualAppLifeCycleTracker extends BaseAppLifeCycleTracker {
    private static String TAG = "MALCTracker";
    private boolean isAppInForeground;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ManualAppLifeCycleTracker(Context context) {
        super(context);
        this.isAppInForeground = false;
    }

    @Override // com.helpshift.applifecycle.BaseAppLifeCycleTracker
    public boolean isAppInForeground() {
        return this.isAppInForeground;
    }

    @Override // com.helpshift.applifecycle.BaseAppLifeCycleTracker
    public void onManualAppForegroundAPI() {
        if (this.isAppInForeground) {
            HSLogger.d(TAG, "Application is already in foreground, so ignore this event");
        } else if (HelpshiftContext.installCallSuccessful.get()) {
            this.isAppInForeground = true;
            notifyAppForeground();
        } else {
            HSLogger.e(TAG, "onManualAppForegroundAPI is called without calling install API");
        }
    }

    @Override // com.helpshift.applifecycle.BaseAppLifeCycleTracker
    public void onManualAppBackgroundAPI() {
        if (!this.isAppInForeground) {
            HSLogger.d(TAG, "Application is already in background, so ignore this event");
        } else if (HelpshiftContext.installCallSuccessful.get()) {
            this.isAppInForeground = false;
            notifyAppBackground();
        } else {
            HSLogger.e(TAG, "onManualAppBackgroundAPI is called without calling install API");
        }
    }
}
