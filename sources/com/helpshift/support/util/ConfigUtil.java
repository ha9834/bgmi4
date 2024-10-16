package com.helpshift.support.util;

import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.model.AppInfoModel;
import com.helpshift.support.ApiConfig;
import com.helpshift.support.Support;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ConfigUtil {
    private static final Map<String, Object> defaultApiConfig = new HashMap();
    private static final Map<String, Object> defaultInstallConfig = new HashMap();

    public static Map<String, Object> getDefaultApiConfig() {
        if (defaultApiConfig.size() == 0) {
            defaultApiConfig.put(SDKConfigurationDM.ENABLE_CONTACT_US, Support.EnableContactUs.ALWAYS);
            defaultApiConfig.put(SDKConfigurationDM.GOTO_CONVERSATION_AFTER_CONTACT_US, false);
            defaultApiConfig.put(SDKConfigurationDM.SHOW_SEARCH_ON_NEW_CONVERSATION, false);
            defaultApiConfig.put(SDKConfigurationDM.REQUIRE_EMAIL, false);
            defaultApiConfig.put(SDKConfigurationDM.HIDE_NAME_AND_EMAIL, false);
            defaultApiConfig.put("enableFullPrivacy", false);
            defaultApiConfig.put(SDKConfigurationDM.SHOW_CONVERSATION_RESOLUTION_QUESTION_API, false);
            defaultApiConfig.put(SDKConfigurationDM.SHOW_CONVERSATION_INFO_SCREEN, false);
            defaultApiConfig.put(SDKConfigurationDM.ENABLE_TYPING_INDICATOR, false);
        }
        return defaultApiConfig;
    }

    public static Map<String, Object> getDefaultInstallConfig() {
        if (defaultInstallConfig.size() == 0) {
            defaultInstallConfig.put("enableLogging", false);
            defaultInstallConfig.put("disableHelpshiftBranding", false);
            defaultInstallConfig.put(SDKConfigurationDM.DISABLE_APP_LAUNCH_EVENT, false);
            defaultInstallConfig.put(SDKConfigurationDM.ENABLE_IN_APP_NOTIFICATION, true);
            defaultInstallConfig.put("enableDefaultFallbackLanguage", true);
            defaultInstallConfig.put(SDKConfigurationDM.DISABLE_ANIMATION, false);
            defaultInstallConfig.put("font", null);
            defaultInstallConfig.put(SDKConfigurationDM.SUPPORT_NOTIFICATION_CHANNEL_ID, null);
            defaultInstallConfig.put(AppInfoModel.SCREEN_ORIENTATION_KEY, -1);
            defaultInstallConfig.put("manualLifecycleTracking", false);
        }
        return defaultInstallConfig;
    }

    public static Map<String, Object> validateAndConvertToMap(ApiConfig apiConfig) {
        HashMap hashMap = new HashMap();
        if (apiConfig != null) {
            hashMap.putAll(apiConfig.toMap());
        }
        return hashMap;
    }
}
