package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.j;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class FetchedAppSettingsManager {
    private static final String APPLICATION_FIELDS = "fields";
    private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
    private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
    private static final String APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES = "android_sdk_error_categories";
    private static final String APP_SETTING_APP_EVENTS_AAM_RULE = "aam_rules";
    private static final String APP_SETTING_APP_EVENTS_EVENT_BINDINGS = "auto_event_mapping_android";
    private static final String APP_SETTING_APP_EVENTS_FEATURE_BITMASK = "app_events_feature_bitmask";
    private static final String APP_SETTING_APP_EVENTS_SESSION_TIMEOUT = "app_events_session_timeout";
    private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
    private static final List<String> APP_SETTING_FIELDS;
    private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
    private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
    private static final String APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD = "restrictive_data_filter_params";
    private static final String APP_SETTING_SMART_LOGIN_OPTIONS = "seamless_login";
    private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
    private static final int AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 8;
    private static final int CODELESS_EVENTS_ENABLED_BITMASK_FIELD = 32;
    private static final int IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 16;
    public static final FetchedAppSettingsManager INSTANCE = new FetchedAppSettingsManager();
    private static final int MONITOR_ENABLED_BITMASK_FIELD = 16384;
    private static final String SDK_UPDATE_MESSAGE = "sdk_update_message";
    private static final String SMART_LOGIN_BOOKMARK_ICON_URL = "smart_login_bookmark_icon_url";
    private static final String SMART_LOGIN_MENU_ICON_URL = "smart_login_menu_icon_url";
    private static final String SUGGESTED_EVENTS_SETTING = "suggested_events_setting";
    private static final String TAG;
    private static final int TRACK_UNINSTALL_ENABLED_BITMASK_FIELD = 256;
    private static final Map<String, FetchedAppSettings> fetchedAppSettings;
    private static final ConcurrentLinkedQueue<FetchedAppSettingsCallback> fetchedAppSettingsCallbacks;
    private static boolean isUnityInit;
    private static final AtomicReference<FetchAppSettingState> loadingState;
    private static boolean printedSDKUpdatedMessage;
    private static JSONArray unityEventBindings;

    /* loaded from: classes.dex */
    public enum FetchAppSettingState {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR
    }

    /* loaded from: classes.dex */
    public interface FetchedAppSettingsCallback {
        void onError();

        void onSuccess(FetchedAppSettings fetchedAppSettings);
    }

    static {
        String simpleName = FetchedAppSettingsManager.class.getSimpleName();
        h.a((Object) simpleName, "FetchedAppSettingsManager::class.java.simpleName");
        TAG = simpleName;
        APP_SETTING_FIELDS = j.b(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, APP_SETTING_NUX_CONTENT, APP_SETTING_NUX_ENABLED, APP_SETTING_DIALOG_CONFIGS, APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES, APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, APP_SETTING_APP_EVENTS_FEATURE_BITMASK, APP_SETTING_APP_EVENTS_EVENT_BINDINGS, APP_SETTING_SMART_LOGIN_OPTIONS, SMART_LOGIN_BOOKMARK_ICON_URL, SMART_LOGIN_MENU_ICON_URL, APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD, APP_SETTING_APP_EVENTS_AAM_RULE, SUGGESTED_EVENTS_SETTING);
        fetchedAppSettings = new ConcurrentHashMap();
        loadingState = new AtomicReference<>(FetchAppSettingState.NOT_LOADED);
        fetchedAppSettingsCallbacks = new ConcurrentLinkedQueue<>();
    }

    private FetchedAppSettingsManager() {
    }

    public static final void loadAppSettingsAsync() {
        final Context applicationContext = FacebookSdk.getApplicationContext();
        final String applicationId = FacebookSdk.getApplicationId();
        if (Utility.isNullOrEmpty(applicationId)) {
            loadingState.set(FetchAppSettingState.ERROR);
            INSTANCE.pollCallbacks();
            return;
        }
        if (fetchedAppSettings.containsKey(applicationId)) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            INSTANCE.pollCallbacks();
            return;
        }
        if (!(loadingState.compareAndSet(FetchAppSettingState.NOT_LOADED, FetchAppSettingState.LOADING) || loadingState.compareAndSet(FetchAppSettingState.ERROR, FetchAppSettingState.LOADING))) {
            INSTANCE.pollCallbacks();
            return;
        }
        l lVar = l.f6973a;
        Object[] objArr = {applicationId};
        final String format = String.format(APP_SETTINGS_PREFS_KEY_FORMAT, Arrays.copyOf(objArr, objArr.length));
        h.a((Object) format, "java.lang.String.format(format, *args)");
        FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.FetchedAppSettingsManager$loadAppSettingsAsync$1
            @Override // java.lang.Runnable
            public final void run() {
                JSONObject appSettingsQueryResponse;
                AtomicReference atomicReference;
                Map map;
                boolean z;
                String str;
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
                        String string = sharedPreferences.getString(format, null);
                        FetchedAppSettings fetchedAppSettings2 = (FetchedAppSettings) null;
                        if (!Utility.isNullOrEmpty(string)) {
                            if (string == null) {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            JSONObject jSONObject = (JSONObject) null;
                            try {
                                jSONObject = new JSONObject(string);
                            } catch (JSONException e) {
                                Utility.logd(Utility.LOG_TAG, e);
                            }
                            if (jSONObject != null) {
                                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                                String str2 = applicationId;
                                h.a((Object) str2, "applicationId");
                                fetchedAppSettings2 = fetchedAppSettingsManager.parseAppSettingsFromJSON(str2, jSONObject);
                            }
                        }
                        FetchedAppSettingsManager fetchedAppSettingsManager2 = FetchedAppSettingsManager.INSTANCE;
                        String str3 = applicationId;
                        h.a((Object) str3, "applicationId");
                        appSettingsQueryResponse = fetchedAppSettingsManager2.getAppSettingsQueryResponse(str3);
                        if (appSettingsQueryResponse != null) {
                            FetchedAppSettingsManager fetchedAppSettingsManager3 = FetchedAppSettingsManager.INSTANCE;
                            String str4 = applicationId;
                            h.a((Object) str4, "applicationId");
                            fetchedAppSettingsManager3.parseAppSettingsFromJSON(str4, appSettingsQueryResponse);
                            sharedPreferences.edit().putString(format, appSettingsQueryResponse.toString()).apply();
                        }
                        if (fetchedAppSettings2 != null) {
                            String sdkUpdateMessage = fetchedAppSettings2.getSdkUpdateMessage();
                            FetchedAppSettingsManager fetchedAppSettingsManager4 = FetchedAppSettingsManager.INSTANCE;
                            z = FetchedAppSettingsManager.printedSDKUpdatedMessage;
                            if (!z && sdkUpdateMessage != null && sdkUpdateMessage.length() > 0) {
                                FetchedAppSettingsManager fetchedAppSettingsManager5 = FetchedAppSettingsManager.INSTANCE;
                                FetchedAppSettingsManager.printedSDKUpdatedMessage = true;
                                FetchedAppSettingsManager fetchedAppSettingsManager6 = FetchedAppSettingsManager.INSTANCE;
                                str = FetchedAppSettingsManager.TAG;
                                Log.w(str, sdkUpdateMessage);
                            }
                        }
                        String str5 = applicationId;
                        h.a((Object) str5, "applicationId");
                        FetchedAppGateKeepersManager.queryAppGateKeepers(str5, true);
                        AutomaticAnalyticsLogger.logActivateAppEvent();
                        FetchedAppSettingsManager fetchedAppSettingsManager7 = FetchedAppSettingsManager.INSTANCE;
                        atomicReference = FetchedAppSettingsManager.loadingState;
                        FetchedAppSettingsManager fetchedAppSettingsManager8 = FetchedAppSettingsManager.INSTANCE;
                        map = FetchedAppSettingsManager.fetchedAppSettings;
                        atomicReference.set(map.containsKey(applicationId) ? FetchedAppSettingsManager.FetchAppSettingState.SUCCESS : FetchedAppSettingsManager.FetchAppSettingState.ERROR);
                        FetchedAppSettingsManager.INSTANCE.pollCallbacks();
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        });
    }

    public static final FetchedAppSettings getAppSettingsWithoutQuery(String str) {
        if (str != null) {
            return fetchedAppSettings.get(str);
        }
        return null;
    }

    public static final void getAppSettingsAsync(FetchedAppSettingsCallback fetchedAppSettingsCallback) {
        h.b(fetchedAppSettingsCallback, "callback");
        fetchedAppSettingsCallbacks.add(fetchedAppSettingsCallback);
        loadAppSettingsAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void pollCallbacks() {
        FetchAppSettingState fetchAppSettingState = loadingState.get();
        if (FetchAppSettingState.NOT_LOADED != fetchAppSettingState && FetchAppSettingState.LOADING != fetchAppSettingState) {
            final FetchedAppSettings fetchedAppSettings2 = fetchedAppSettings.get(FacebookSdk.getApplicationId());
            Handler handler = new Handler(Looper.getMainLooper());
            if (FetchAppSettingState.ERROR == fetchAppSettingState) {
                while (!fetchedAppSettingsCallbacks.isEmpty()) {
                    final FetchedAppSettingsCallback poll = fetchedAppSettingsCallbacks.poll();
                    handler.post(new Runnable() { // from class: com.facebook.internal.FetchedAppSettingsManager$pollCallbacks$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (CrashShieldHandler.isObjectCrashing(this)) {
                                return;
                            }
                            try {
                                if (CrashShieldHandler.isObjectCrashing(this)) {
                                    return;
                                }
                                try {
                                    FetchedAppSettingsManager.FetchedAppSettingsCallback.this.onError();
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            } catch (Throwable th2) {
                                CrashShieldHandler.handleThrowable(th2, this);
                            }
                        }
                    });
                }
            } else {
                while (!fetchedAppSettingsCallbacks.isEmpty()) {
                    final FetchedAppSettingsCallback poll2 = fetchedAppSettingsCallbacks.poll();
                    handler.post(new Runnable() { // from class: com.facebook.internal.FetchedAppSettingsManager$pollCallbacks$2
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (CrashShieldHandler.isObjectCrashing(this)) {
                                return;
                            }
                            try {
                                if (CrashShieldHandler.isObjectCrashing(this)) {
                                    return;
                                }
                                try {
                                    FetchedAppSettingsManager.FetchedAppSettingsCallback.this.onSuccess(fetchedAppSettings2);
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            } catch (Throwable th2) {
                                CrashShieldHandler.handleThrowable(th2, this);
                            }
                        }
                    });
                }
            }
        }
    }

    public static final FetchedAppSettings queryAppSettings(String str, boolean z) {
        h.b(str, "applicationId");
        if (!z && fetchedAppSettings.containsKey(str)) {
            return fetchedAppSettings.get(str);
        }
        JSONObject appSettingsQueryResponse = INSTANCE.getAppSettingsQueryResponse(str);
        if (appSettingsQueryResponse == null) {
            return null;
        }
        FetchedAppSettings parseAppSettingsFromJSON = INSTANCE.parseAppSettingsFromJSON(str, appSettingsQueryResponse);
        if (h.a((Object) str, (Object) FacebookSdk.getApplicationId())) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            INSTANCE.pollCallbacks();
        }
        return parseAppSettingsFromJSON;
    }

    public final FetchedAppSettings parseAppSettingsFromJSON(String str, JSONObject jSONObject) {
        h.b(str, "applicationId");
        h.b(jSONObject, "settingsJSON");
        FacebookRequestErrorClassification createFromJSON = FacebookRequestErrorClassification.Companion.createFromJSON(jSONObject.optJSONArray(APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES));
        FacebookRequestErrorClassification defaultErrorClassification = createFromJSON != null ? createFromJSON : FacebookRequestErrorClassification.Companion.getDefaultErrorClassification();
        int optInt = jSONObject.optInt(APP_SETTING_APP_EVENTS_FEATURE_BITMASK, 0);
        boolean z = (optInt & 8) != 0;
        boolean z2 = (optInt & 16) != 0;
        boolean z3 = (optInt & 32) != 0;
        boolean z4 = (optInt & 256) != 0;
        boolean z5 = (optInt & MONITOR_ENABLED_BITMASK_FIELD) != 0;
        JSONArray optJSONArray = jSONObject.optJSONArray(APP_SETTING_APP_EVENTS_EVENT_BINDINGS);
        unityEventBindings = optJSONArray;
        if (unityEventBindings != null && InternalSettings.isUnityApp()) {
            UnityReflection.sendEventMapping(optJSONArray != null ? optJSONArray.toString() : null);
        }
        boolean optBoolean = jSONObject.optBoolean(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, false);
        String optString = jSONObject.optString(APP_SETTING_NUX_CONTENT, "");
        h.a((Object) optString, "settingsJSON.optString(A…_SETTING_NUX_CONTENT, \"\")");
        boolean optBoolean2 = jSONObject.optBoolean(APP_SETTING_NUX_ENABLED, false);
        int optInt2 = jSONObject.optInt(APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, Constants.getDefaultAppEventsSessionTimeoutInSeconds());
        EnumSet<SmartLoginOption> parseOptions = SmartLoginOption.Companion.parseOptions(jSONObject.optLong(APP_SETTING_SMART_LOGIN_OPTIONS));
        Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations = parseDialogConfigurations(jSONObject.optJSONObject(APP_SETTING_DIALOG_CONFIGS));
        String optString2 = jSONObject.optString(SMART_LOGIN_BOOKMARK_ICON_URL);
        h.a((Object) optString2, "settingsJSON.optString(S…_LOGIN_BOOKMARK_ICON_URL)");
        String optString3 = jSONObject.optString(SMART_LOGIN_MENU_ICON_URL);
        h.a((Object) optString3, "settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL)");
        String optString4 = jSONObject.optString(SDK_UPDATE_MESSAGE);
        h.a((Object) optString4, "settingsJSON.optString(SDK_UPDATE_MESSAGE)");
        FetchedAppSettings fetchedAppSettings2 = new FetchedAppSettings(optBoolean, optString, optBoolean2, optInt2, parseOptions, parseDialogConfigurations, z, defaultErrorClassification, optString2, optString3, z2, z3, optJSONArray, optString4, z4, z5, jSONObject.optString(APP_SETTING_APP_EVENTS_AAM_RULE), jSONObject.optString(SUGGESTED_EVENTS_SETTING), jSONObject.optString(APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD));
        fetchedAppSettings.put(str, fetchedAppSettings2);
        return fetchedAppSettings2;
    }

    public static final void setIsUnityInit(boolean z) {
        isUnityInit = z;
        JSONArray jSONArray = unityEventBindings;
        if (jSONArray == null || !isUnityInit) {
            return;
        }
        UnityReflection.sendEventMapping(String.valueOf(jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject getAppSettingsQueryResponse(String str) {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(APP_SETTING_FIELDS);
        bundle.putString("fields", TextUtils.join(",", arrayList));
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, str, null);
        newGraphPathRequest.setSkipClientToken(true);
        h.a((Object) newGraphPathRequest, "request");
        newGraphPathRequest.setParameters(bundle);
        GraphResponse executeAndWait = newGraphPathRequest.executeAndWait();
        h.a((Object) executeAndWait, "request.executeAndWait()");
        JSONObject jSONObject = executeAndWait.getJSONObject();
        return jSONObject != null ? jSONObject : new JSONObject();
    }

    private final Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations(JSONObject jSONObject) {
        JSONArray optJSONArray;
        HashMap hashMap = new HashMap();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                FetchedAppSettings.DialogFeatureConfig.Companion companion = FetchedAppSettings.DialogFeatureConfig.Companion;
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                h.a((Object) optJSONObject, "dialogConfigData.optJSONObject(i)");
                FetchedAppSettings.DialogFeatureConfig parseDialogConfig = companion.parseDialogConfig(optJSONObject);
                if (parseDialogConfig != null) {
                    String dialogName = parseDialogConfig.getDialogName();
                    HashMap hashMap2 = (Map) hashMap.get(dialogName);
                    if (hashMap2 == null) {
                        hashMap2 = new HashMap();
                        hashMap.put(dialogName, hashMap2);
                    }
                    hashMap2.put(parseDialogConfig.getFeatureName(), parseDialogConfig);
                }
            }
        }
        return hashMap;
    }
}
