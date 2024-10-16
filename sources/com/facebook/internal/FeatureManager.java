package com.facebook.internal;

import android.R;
import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.tencent.mtt.spcialcall.SpecialCallActivity;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.text.l;

/* loaded from: classes.dex */
public final class FeatureManager {
    private static final String FEATURE_MANAGER_STORE = "com.facebook.internal.FEATURE_MANAGER";
    public static final FeatureManager INSTANCE = new FeatureManager();
    private static final Map<Feature, String[]> featureMapping = new HashMap();

    /* loaded from: classes.dex */
    public interface Callback {
        void onCompleted(boolean z);
    }

    private FeatureManager() {
    }

    public static final void checkFeature(final Feature feature, final Callback callback) {
        h.b(feature, "feature");
        h.b(callback, "callback");
        FetchedAppGateKeepersManager.loadAppGateKeepersAsync(new FetchedAppGateKeepersManager.Callback() { // from class: com.facebook.internal.FeatureManager$checkFeature$1
            @Override // com.facebook.internal.FetchedAppGateKeepersManager.Callback
            public void onCompleted() {
                FeatureManager.Callback.this.onCompleted(FeatureManager.isEnabled(feature));
            }
        });
    }

    public static final boolean isEnabled(Feature feature) {
        h.b(feature, "feature");
        if (Feature.Unknown == feature) {
            return false;
        }
        if (Feature.Core == feature) {
            return true;
        }
        String string = FacebookSdk.getApplicationContext().getSharedPreferences(FEATURE_MANAGER_STORE, 0).getString(feature.toKey(), null);
        if (string != null && h.a((Object) string, (Object) FacebookSdk.getSdkVersion())) {
            return false;
        }
        Feature parent = feature.getParent();
        if (parent == feature) {
            return INSTANCE.getGKStatus(feature);
        }
        return isEnabled(parent) && INSTANCE.getGKStatus(feature);
    }

    public static final void disableFeature(Feature feature) {
        h.b(feature, "feature");
        FacebookSdk.getApplicationContext().getSharedPreferences(FEATURE_MANAGER_STORE, 0).edit().putString(feature.toKey(), FacebookSdk.getSdkVersion()).apply();
    }

    public static final Feature getFeature(String str) {
        h.b(str, "className");
        INSTANCE.initializeFeatureMapping();
        for (Map.Entry<Feature, String[]> entry : featureMapping.entrySet()) {
            Feature key = entry.getKey();
            for (String str2 : entry.getValue()) {
                if (l.a(str, str2, false, 2, (Object) null)) {
                    return key;
                }
            }
        }
        return Feature.Unknown;
    }

    private final synchronized void initializeFeatureMapping() {
        if (featureMapping.isEmpty()) {
            featureMapping.put(Feature.AAM, new String[]{"com.facebook.appevents.aam."});
            featureMapping.put(Feature.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
            featureMapping.put(Feature.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
            featureMapping.put(Feature.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
            featureMapping.put(Feature.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
            featureMapping.put(Feature.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
            featureMapping.put(Feature.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
            featureMapping.put(Feature.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
            featureMapping.put(Feature.OnDeviceEventProcessing, new String[]{"com.facebook.appevents.ondeviceprocessing."});
            featureMapping.put(Feature.IapLogging, new String[]{"com.facebook.appevents.iap."});
            featureMapping.put(Feature.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
        }
    }

    private final boolean getGKStatus(Feature feature) {
        return FetchedAppGateKeepersManager.getGateKeeperForKey(feature.toKey(), FacebookSdk.getApplicationId(), defaultStatus(feature));
    }

    private final boolean defaultStatus(Feature feature) {
        switch (feature) {
            case RestrictiveDataFiltering:
            case Instrument:
            case CrashReport:
            case CrashShield:
            case ThreadCheck:
            case ErrorReport:
            case AAM:
            case PrivacyProtection:
            case SuggestedEvents:
            case IntelligentIntegrity:
            case ModelRequest:
            case EventDeactivation:
            case OnDeviceEventProcessing:
            case OnDevicePostInstallEventProcessing:
            case IapLogging:
            case IapLoggingLib2:
            case ChromeCustomTabsPrefetching:
            case Monitoring:
            case IgnoreAppSwitchToLoggedOut:
                return false;
            default:
                return true;
        }
    }

    /* loaded from: classes.dex */
    public enum Feature {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        IntelligentIntegrity(66562),
        ModelRequest(66563),
        EventDeactivation(66816),
        OnDeviceEventProcessing(67072),
        OnDevicePostInstallEventProcessing(67073),
        IapLogging(67328),
        IapLoggingLib2(67329),
        Instrument(131072),
        CrashReport(131328),
        CrashShield(131329),
        ThreadCheck(131330),
        ErrorReport(131584),
        Monitoring(196608),
        Login(SpecialCallActivity.FLAG_HARDWARE_ACCELERATED),
        ChromeCustomTabsPrefetching(R.attr.theme),
        IgnoreAppSwitchToLoggedOut(R.id.background),
        Share(33554432),
        Places(50331648);

        public static final Companion Companion = new Companion(null);
        private final int code;

        Feature(int i) {
            this.code = i;
        }

        @Override // java.lang.Enum
        public String toString() {
            switch (this) {
                case Core:
                    return "CoreKit";
                case AppEvents:
                    return "AppEvents";
                case CodelessEvents:
                    return "CodelessEvents";
                case RestrictiveDataFiltering:
                    return "RestrictiveDataFiltering";
                case Instrument:
                    return "Instrument";
                case CrashReport:
                    return "CrashReport";
                case CrashShield:
                    return "CrashShield";
                case ThreadCheck:
                    return "ThreadCheck";
                case ErrorReport:
                    return "ErrorReport";
                case AAM:
                    return "AAM";
                case PrivacyProtection:
                    return "PrivacyProtection";
                case SuggestedEvents:
                    return "SuggestedEvents";
                case IntelligentIntegrity:
                    return "IntelligentIntegrity";
                case ModelRequest:
                    return "ModelRequest";
                case EventDeactivation:
                    return "EventDeactivation";
                case OnDeviceEventProcessing:
                    return "OnDeviceEventProcessing";
                case OnDevicePostInstallEventProcessing:
                    return "OnDevicePostInstallEventProcessing";
                case IapLogging:
                    return "IAPLogging";
                case IapLoggingLib2:
                    return "IAPLoggingLib2";
                case Monitoring:
                    return "Monitoring";
                case Login:
                    return "LoginKit";
                case ChromeCustomTabsPrefetching:
                    return "ChromeCustomTabsPrefetching";
                case IgnoreAppSwitchToLoggedOut:
                    return "IgnoreAppSwitchToLoggedOut";
                case Share:
                    return "ShareKit";
                case Places:
                    return "PlacesKit";
                default:
                    return "unknown";
            }
        }

        public final String toKey() {
            return "FBSDKFeature" + this;
        }

        public final Feature getParent() {
            int i = this.code;
            if ((i & 255) > 0) {
                return Companion.fromInt(i & (-256));
            }
            if ((65280 & i) > 0) {
                return Companion.fromInt(i & (-65536));
            }
            if ((16711680 & i) > 0) {
                return Companion.fromInt(i & WebView.NIGHT_MODE_COLOR);
            }
            return Companion.fromInt(0);
        }

        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final Feature fromInt(int i) {
                for (Feature feature : Feature.values()) {
                    if (feature.code == i) {
                        return feature;
                    }
                }
                return Feature.Unknown;
            }
        }
    }
}
