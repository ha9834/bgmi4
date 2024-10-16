package com.facebook.internal;

import android.net.Uri;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.j;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class FetchedAppSettings {
    public static final Companion Companion = new Companion(null);
    private final boolean automaticLoggingEnabled;
    private final boolean codelessEventsEnabled;
    private final Map<String, Map<String, DialogFeatureConfig>> dialogConfigurations;
    private final FacebookRequestErrorClassification errorClassification;
    private final JSONArray eventBindings;
    private final boolean iAPAutomaticLoggingEnabled;
    private final boolean monitorViaDialogEnabled;
    private final String nuxContent;
    private final boolean nuxEnabled;
    private final String rawAamRules;
    private final String restrictiveDataSetting;
    private final String sdkUpdateMessage;
    private final int sessionTimeoutInSeconds;
    private final String smartLoginBookmarkIconURL;
    private final String smartLoginMenuIconURL;
    private final EnumSet<SmartLoginOption> smartLoginOptions;
    private final String suggestedEventsSetting;
    private final boolean supportsImplicitLogging;
    private final boolean trackUninstallEnabled;

    public static final DialogFeatureConfig getDialogFeatureConfig(String str, String str2, String str3) {
        return Companion.getDialogFeatureConfig(str, str2, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FetchedAppSettings(boolean z, String str, boolean z2, int i, EnumSet<SmartLoginOption> enumSet, Map<String, ? extends Map<String, DialogFeatureConfig>> map, boolean z3, FacebookRequestErrorClassification facebookRequestErrorClassification, String str2, String str3, boolean z4, boolean z5, JSONArray jSONArray, String str4, boolean z6, boolean z7, String str5, String str6, String str7) {
        h.b(str, "nuxContent");
        h.b(enumSet, "smartLoginOptions");
        h.b(map, "dialogConfigurations");
        h.b(facebookRequestErrorClassification, "errorClassification");
        h.b(str2, "smartLoginBookmarkIconURL");
        h.b(str3, "smartLoginMenuIconURL");
        h.b(str4, "sdkUpdateMessage");
        this.supportsImplicitLogging = z;
        this.nuxContent = str;
        this.nuxEnabled = z2;
        this.sessionTimeoutInSeconds = i;
        this.smartLoginOptions = enumSet;
        this.dialogConfigurations = map;
        this.automaticLoggingEnabled = z3;
        this.errorClassification = facebookRequestErrorClassification;
        this.smartLoginBookmarkIconURL = str2;
        this.smartLoginMenuIconURL = str3;
        this.iAPAutomaticLoggingEnabled = z4;
        this.codelessEventsEnabled = z5;
        this.eventBindings = jSONArray;
        this.sdkUpdateMessage = str4;
        this.trackUninstallEnabled = z6;
        this.monitorViaDialogEnabled = z7;
        this.rawAamRules = str5;
        this.suggestedEventsSetting = str6;
        this.restrictiveDataSetting = str7;
    }

    public final String getNuxContent() {
        return this.nuxContent;
    }

    public final boolean getNuxEnabled() {
        return this.nuxEnabled;
    }

    public final int getSessionTimeoutInSeconds() {
        return this.sessionTimeoutInSeconds;
    }

    public final EnumSet<SmartLoginOption> getSmartLoginOptions() {
        return this.smartLoginOptions;
    }

    public final Map<String, Map<String, DialogFeatureConfig>> getDialogConfigurations() {
        return this.dialogConfigurations;
    }

    public final boolean getAutomaticLoggingEnabled() {
        return this.automaticLoggingEnabled;
    }

    public final FacebookRequestErrorClassification getErrorClassification() {
        return this.errorClassification;
    }

    public final String getSmartLoginBookmarkIconURL() {
        return this.smartLoginBookmarkIconURL;
    }

    public final String getSmartLoginMenuIconURL() {
        return this.smartLoginMenuIconURL;
    }

    public final boolean getIAPAutomaticLoggingEnabled() {
        return this.iAPAutomaticLoggingEnabled;
    }

    public final boolean getCodelessEventsEnabled() {
        return this.codelessEventsEnabled;
    }

    public final JSONArray getEventBindings() {
        return this.eventBindings;
    }

    public final String getSdkUpdateMessage() {
        return this.sdkUpdateMessage;
    }

    public final boolean getTrackUninstallEnabled() {
        return this.trackUninstallEnabled;
    }

    public final boolean getMonitorViaDialogEnabled() {
        return this.monitorViaDialogEnabled;
    }

    public final String getRawAamRules() {
        return this.rawAamRules;
    }

    public final String getSuggestedEventsSetting() {
        return this.suggestedEventsSetting;
    }

    public final String getRestrictiveDataSetting() {
        return this.restrictiveDataSetting;
    }

    public final boolean supportsImplicitLogging() {
        return this.supportsImplicitLogging;
    }

    /* loaded from: classes.dex */
    public static final class DialogFeatureConfig {
        public static final Companion Companion = new Companion(null);
        private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "|";
        private static final String DIALOG_CONFIG_NAME_KEY = "name";
        private static final String DIALOG_CONFIG_URL_KEY = "url";
        private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
        private final String dialogName;
        private final Uri fallbackUrl;
        private final String featureName;
        private final int[] versionSpec;

        public /* synthetic */ DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr, f fVar) {
            this(str, str2, uri, iArr);
        }

        private DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr) {
            this.dialogName = str;
            this.featureName = str2;
            this.fallbackUrl = uri;
            this.versionSpec = iArr;
        }

        public final String getDialogName() {
            return this.dialogName;
        }

        public final String getFeatureName() {
            return this.featureName;
        }

        public final Uri getFallbackUrl() {
            return this.fallbackUrl;
        }

        public final int[] getVersionSpec() {
            return this.versionSpec;
        }

        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final DialogFeatureConfig parseDialogConfig(JSONObject jSONObject) {
                h.b(jSONObject, "dialogConfigJSON");
                String optString = jSONObject.optString("name");
                if (Utility.isNullOrEmpty(optString)) {
                    return null;
                }
                h.a((Object) optString, "dialogNameWithFeature");
                List a2 = l.a((CharSequence) optString, new String[]{DialogFeatureConfig.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR}, false, 0, 6, (Object) null);
                if (a2.size() != 2) {
                    return null;
                }
                String str = (String) j.c(a2);
                String str2 = (String) j.d(a2);
                if (Utility.isNullOrEmpty(str) || Utility.isNullOrEmpty(str2)) {
                    return null;
                }
                String optString2 = jSONObject.optString("url");
                return new DialogFeatureConfig(str, str2, !Utility.isNullOrEmpty(optString2) ? Uri.parse(optString2) : (Uri) null, parseVersionSpec(jSONObject.optJSONArray(DialogFeatureConfig.DIALOG_CONFIG_VERSIONS_KEY)), null);
            }

            private final int[] parseVersionSpec(JSONArray jSONArray) {
                int[] iArr = (int[]) null;
                if (jSONArray == null) {
                    return iArr;
                }
                int length = jSONArray.length();
                int[] iArr2 = new int[length];
                for (int i = 0; i < length; i++) {
                    int optInt = jSONArray.optInt(i, -1);
                    if (optInt == -1) {
                        String optString = jSONArray.optString(i);
                        if (!Utility.isNullOrEmpty(optString)) {
                            try {
                                h.a((Object) optString, "versionString");
                                optInt = Integer.parseInt(optString);
                            } catch (NumberFormatException e) {
                                Utility.logd(Utility.LOG_TAG, e);
                                optInt = -1;
                            }
                        }
                    }
                    iArr2[i] = optInt;
                }
                return iArr2;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final DialogFeatureConfig getDialogFeatureConfig(String str, String str2, String str3) {
            FetchedAppSettings appSettingsWithoutQuery;
            Map<String, DialogFeatureConfig> map;
            h.b(str, "applicationId");
            h.b(str2, "actionName");
            h.b(str3, "featureName");
            if (Utility.isNullOrEmpty(str2) || Utility.isNullOrEmpty(str3) || (appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(str)) == null || (map = appSettingsWithoutQuery.getDialogConfigurations().get(str2)) == null) {
                return null;
            }
            return map.get(str3);
        }
    }
}
