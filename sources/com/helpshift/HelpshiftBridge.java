package com.helpshift;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.exceptions.InstallException;
import com.helpshift.support.AlertToRateAppListener;
import com.helpshift.support.ApiConfig;
import com.helpshift.support.Metadata;
import com.helpshift.support.Support;
import com.helpshift.util.HSLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/* loaded from: classes2.dex */
public class HelpshiftBridge {
    private static final String HS_ENABLE_CONTACT_US = "enableContactUs";
    private static final String HS_ENABLE_FULL_PRIVACY = "enableFullPrivacy";
    private static final String HS_ENABLE_TYPING_INDICATOR = "enableTypingIndicator";
    private static final String HS_GOTO_CONVERSATION_AFTER_CONTACT_US = "gotoConversationAfterContactUs";
    private static final String HS_HIDE_NAME_AND_EMAIL = "hideNameAndEmail";
    private static final String HS_REQUIRE_EMAIL = "requireEmail";
    private static final String HS_SHOW_CONVERSATION_INFO_SCREEN = "showConversationInfoScreen";
    private static final String HS_SHOW_CONVERSATION_RESOLUTION_QUESTION = "showConversationResolutionQuestion";
    private static final String HS_SHOW_SEARCH_ON_NEW_CONVERSATION = "showSearchOnNewConversation";
    private static final String TAG = "HelpshiftBridge";
    private static Activity activity = null;
    public static long mReceivePointer = 0;
    public static long mSessionBeganPointer = 0;
    public static long mSessionEndPointer = 0;
    private static final String pluginVersion = "4.0.0";
    public static Map<String, String> metadata = new HashMap();
    public static String[] tags = new String[0];
    public static Map<String, Vector<String>> issuefields = new HashMap();
    public static Map<String, Integer> apiConfigs = new HashMap();

    public static void addProperties(HashMap hashMap) {
    }

    public static boolean addProperty(String str, double d) {
        return false;
    }

    public static boolean addProperty(String str, int i) {
        return false;
    }

    public static boolean addProperty(String str, String str2) {
        return false;
    }

    public static boolean addProperty(String str, boolean z) {
        return false;
    }

    public static native void authenticationFailed(HelpshiftUser helpshiftUser, int i);

    public static native void didReceiveNotificationCount(long j, int i);

    public static int getCountOfUnreadMessages() {
        return 0;
    }

    public static native void helpshiftSessionBegan(long j);

    public static native void helpshiftSessionEnded(long j);

    public static void showInbox() {
    }

    public static void init(Activity activity2) {
        activity = activity2;
    }

    public static void initListener(long j, long j2, long j3) {
        mReceivePointer = j;
        mSessionBeganPointer = j2;
        mSessionEndPointer = j3;
    }

    private static HashMap parseConfigDictionary(HashMap hashMap) {
        HashMap parseConfigDictionary = ConfigParserUtil.parseConfigDictionary(activity, hashMap);
        if (parseConfigDictionary.get("supportedFileFormats") != null) {
            HelpshiftUE4Delegates.setSupportedFileFormats((String[]) parseConfigDictionary.get("supportedFileFormats"));
            parseConfigDictionary.remove("supportedFileFormats");
        }
        return parseConfigDictionary;
    }

    public static void install(Activity activity2, String str, String str2, String str3) throws InstallException {
        install(activity2, str, str2, str3, new HashMap());
    }

    public static void install(Activity activity2, String str, String str2, String str3, HashMap hashMap) throws InstallException {
        activity = activity2;
        HashMap parseConfigDictionary = parseConfigDictionary(hashMap);
        parseConfigDictionary.put(SDKConfigurationDM.SDK_TYPE, "cocos2dx");
        parseConfigDictionary.put(SDKConfigurationDM.PLUGIN_VERSION, "4.0.0");
        Core.init(Support.getInstance());
        Core.install(activity2.getApplication(), str, str2, str3, hashMap);
        HSLogger.d(TAG, "install - config : " + hashMap);
        Support.setDelegate(new HelpshiftUE4Delegates());
    }

    public static void showConversation() {
        if (metadata.size() > 0) {
            HashMap hashMap = new HashMap();
            Iterator<String> it = metadata.keySet().iterator();
            while (it.hasNext()) {
                String obj = it.next().toString();
                hashMap.put(obj, metadata.get(obj));
            }
            Metadata metadata2 = new Metadata(hashMap, tags);
            ApiConfig.Builder builder = new ApiConfig.Builder();
            builder.setCustomMetadata(metadata2);
            Support.showConversation(activity, builder.build());
            return;
        }
        showConversation(new HashMap());
    }

    public static void showConversation(HashMap hashMap) {
        HSLogger.d(TAG, "showConversation - config : " + hashMap);
        Support.showConversation(activity, parseConfigDictionary(hashMap));
    }

    public static void showFAQSection(String str) {
        showFAQSection(str, new HashMap());
    }

    public static void showFAQSection(String str, HashMap hashMap) {
        HSLogger.d(TAG, "showFAQSection - sectionPublishId : " + str + " config : " + hashMap);
        Support.showFAQSection(activity, str, parseConfigDictionary(hashMap));
    }

    public static void showSingleFAQ(String str) {
        showSingleFAQ(str, new HashMap());
    }

    public static void showSingleFAQ(String str, HashMap hashMap) {
        HSLogger.d(TAG, "showSingleFAQ - questionPublishId : " + str + " config : " + hashMap);
        Support.showSingleFAQ(activity, str, parseConfigDictionary(hashMap));
    }

    public static void showFAQs() {
        if (metadata.size() > 0 || tags.length > 0 || issuefields.size() > 0 || apiConfigs.size() > 0) {
            HashMap hashMap = new HashMap();
            Iterator<String> it = metadata.keySet().iterator();
            while (it.hasNext()) {
                String obj = it.next().toString();
                hashMap.put(obj, metadata.get(obj));
            }
            Metadata metadata2 = new Metadata(hashMap, tags);
            ApiConfig.Builder builder = new ApiConfig.Builder();
            builder.setCustomMetadata(metadata2);
            HashMap hashMap2 = new HashMap();
            Iterator<String> it2 = issuefields.keySet().iterator();
            while (it2.hasNext()) {
                String obj2 = it2.next().toString();
                hashMap2.put(obj2, issuefields.get(obj2).toArray(new String[issuefields.get(obj2).size()]));
            }
            builder.setCustomIssueFields(hashMap2);
            if (apiConfigs.containsKey("enableContactUs")) {
                builder.setEnableContactUs(apiConfigs.get("enableContactUs"));
            } else {
                if (apiConfigs.containsKey(HS_ENABLE_FULL_PRIVACY)) {
                    builder.setEnableFullPrivacy(apiConfigs.get(HS_ENABLE_FULL_PRIVACY).intValue() == 1);
                } else if (apiConfigs.containsKey("showConversationInfoScreen")) {
                    builder.setShowConversationInfoScreen(apiConfigs.get("showConversationInfoScreen").intValue() == 1);
                }
            }
            Support.showFAQs(activity, builder.build());
            return;
        }
        showFAQs(new HashMap());
    }

    public static void showFAQs(HashMap hashMap) {
        HSLogger.d(TAG, "showFAQs - config : " + hashMap);
        Support.showFAQs(activity, parseConfigDictionary(hashMap));
    }

    public static void setNameAndEmail(String str, String str2) {
        Core.setNameAndEmail(str, str2);
    }

    public static void login(String str, String str2, String str3) {
        Core.login(str, str2, str3);
    }

    public static void login(HelpshiftUser helpshiftUser) {
        Core.login(helpshiftUser);
    }

    public static void logout() {
        Core.logout();
    }

    public static void clearAnonymousUser() {
        Core.clearAnonymousUser();
    }

    public static void setUserIdentifier(String str) {
        Support.setUserIdentifier(str);
    }

    public static void registerDeviceToken(String str) {
        Core.registerDeviceToken(activity, str);
    }

    public static void leaveBreadCrumb(String str) {
        Support.leaveBreadCrumb(str);
    }

    public static void clearBreadCrumbs() {
        Support.clearBreadCrumbs();
    }

    public static int getNotificationCount(boolean z) {
        if (!z) {
            return Support.getNotificationCount().intValue();
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.helpshift.HelpshiftBridge.1
            @Override // java.lang.Runnable
            public void run() {
                Support.getNotificationCount(new Handler() { // from class: com.helpshift.HelpshiftBridge.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        super.handleMessage(message);
                        HelpshiftBridge.didReceiveNotificationCount(HelpshiftBridge.mReceivePointer, Integer.valueOf(((Bundle) message.obj).getInt("value")).intValue());
                    }
                }, new Handler());
            }
        });
        return -1;
    }

    public static void handlePush(HashMap hashMap) {
        Bundle bundle = new Bundle();
        HSLogger.d(TAG, "handlePush - notification : " + hashMap);
        for (String str : hashMap.keySet()) {
            bundle.putString(str, (String) hashMap.get(str));
        }
        Core.handlePush(activity, bundle);
    }

    public static void handlePush(Map<String, String> map) {
        Core.handlePush(activity, map);
    }

    public static void showAlertToRateApp(String str) {
        Support.showAlertToRateApp(str, new AlertToRateAppListener() { // from class: com.helpshift.HelpshiftBridge.2
            @Override // com.helpshift.support.AlertToRateAppListener
            public void onAction(int i) {
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    default:
                        return;
                }
            }
        });
    }

    public static boolean isConversationActive() {
        return Support.isConversationActive();
    }

    public static void setSDKLanguage(String str) {
        Support.setSDKLanguage(str);
    }

    public static void showDynamicForm(List<HashMap<String, Object>> list) {
        HSLogger.d(TAG, "showDynamicForm - data : " + list);
        Activity activity2 = activity;
        Support.showDynamicForm(activity2, ConfigParserUtil.parseFlowList(activity2, list));
    }

    public static void setMetadata(Map<String, String> map) {
        metadata.clear();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String obj = it.next().toString();
            metadata.put(obj, map.get(obj));
        }
    }

    public static void setTags(Map<String, String> map) {
        if (map.size() > 0) {
            String[] strArr = new String[map.size()];
            Iterator<String> it = map.keySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                strArr[i] = it.next();
                i++;
            }
            tags = new String[strArr.length];
            int i2 = 0;
            for (String str : strArr) {
                tags[i2] = str;
                i2++;
            }
            return;
        }
        tags = new String[0];
    }

    public static void setIssueFields(Map<String, Vector<String>> map) {
        issuefields.clear();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String obj = it.next().toString();
            issuefields.put(obj, map.get(obj));
        }
    }

    public static void setApiConfig(Map<String, Integer> map) {
        apiConfigs.clear();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String obj = it.next().toString();
            apiConfigs.put(obj, map.get(obj));
        }
    }
}
