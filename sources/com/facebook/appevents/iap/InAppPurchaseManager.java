package com.facebook.appevents.iap;

import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class InAppPurchaseManager {
    private static final AtomicBoolean enabled = new AtomicBoolean(false);

    private static boolean usingBillingLib2Plus() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class) ? false : false;
    }

    public static void enableAutoLogging() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        try {
            enabled.set(true);
            startTracking();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
        }
    }

    public static void startTracking() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        try {
            if (enabled.get()) {
                if (usingBillingLib2Plus() && FeatureManager.isEnabled(FeatureManager.Feature.IapLoggingLib2)) {
                    return;
                }
                InAppPurchaseActivityLifecycleTracker.startIapLogging();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
        }
    }
}
