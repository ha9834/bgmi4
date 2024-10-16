package com.helpshift.applifecycle;

import android.content.Context;

/* loaded from: classes2.dex */
public abstract class BaseAppLifeCycleTracker {
    private Context context;
    private HSAppLifeCycleListener lifeCycleListener;

    public abstract boolean isAppInForeground();

    public abstract void onManualAppBackgroundAPI();

    public abstract void onManualAppForegroundAPI();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAppLifeCycleTracker(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerAppLifeCycleListener(HSAppLifeCycleListener hSAppLifeCycleListener) {
        this.lifeCycleListener = hSAppLifeCycleListener;
    }

    void unregisterAppLifeCycleListener() {
        this.lifeCycleListener = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyAppForeground() {
        HSAppLifeCycleListener hSAppLifeCycleListener = this.lifeCycleListener;
        if (hSAppLifeCycleListener == null) {
            return;
        }
        hSAppLifeCycleListener.onAppForeground(this.context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyAppBackground() {
        HSAppLifeCycleListener hSAppLifeCycleListener = this.lifeCycleListener;
        if (hSAppLifeCycleListener == null) {
            return;
        }
        hSAppLifeCycleListener.onAppBackground(this.context);
    }
}
