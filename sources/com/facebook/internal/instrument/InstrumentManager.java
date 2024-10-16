package com.facebook.internal.instrument;

import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import com.facebook.internal.instrument.threadcheck.ThreadCheckHandler;

/* loaded from: classes.dex */
public final class InstrumentManager {
    public static final InstrumentManager INSTANCE = new InstrumentManager();

    private InstrumentManager() {
    }

    public static final void start() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            FeatureManager.checkFeature(FeatureManager.Feature.CrashReport, new FeatureManager.Callback() { // from class: com.facebook.internal.instrument.InstrumentManager$start$1
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    if (z) {
                        CrashHandler.Companion.enable();
                        if (FeatureManager.isEnabled(FeatureManager.Feature.CrashShield)) {
                            ExceptionAnalyzer.enable();
                            CrashShieldHandler.enable();
                        }
                        if (FeatureManager.isEnabled(FeatureManager.Feature.ThreadCheck)) {
                            ThreadCheckHandler.enable();
                        }
                    }
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, new FeatureManager.Callback() { // from class: com.facebook.internal.instrument.InstrumentManager$start$2
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    if (z) {
                        ErrorReportHandler.enable();
                    }
                }
            });
        }
    }
}
