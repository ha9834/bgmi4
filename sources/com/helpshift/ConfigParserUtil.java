package com.helpshift;

import android.content.Context;
import android.util.Log;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.support.Support;
import com.helpshift.support.util.DynamicFormUtil;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class ConfigParserUtil {
    private static final String TAG = "ConfigParserUtil";

    ConfigParserUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HashMap parseConfigDictionary(Context context, HashMap hashMap) {
        if (hashMap == null) {
            return new HashMap();
        }
        if (hashMap.get(SDKConfigurationDM.ENABLE_CONTACT_US) != null) {
            if (hashMap.get(SDKConfigurationDM.ENABLE_CONTACT_US).equals("yes") || hashMap.get(SDKConfigurationDM.ENABLE_CONTACT_US).equals("always")) {
                hashMap.put(SDKConfigurationDM.ENABLE_CONTACT_US, Support.EnableContactUs.ALWAYS);
            } else if (hashMap.get(SDKConfigurationDM.ENABLE_CONTACT_US).equals("no") || hashMap.get(SDKConfigurationDM.ENABLE_CONTACT_US).equals("never")) {
                hashMap.put(SDKConfigurationDM.ENABLE_CONTACT_US, Support.EnableContactUs.NEVER);
            } else if (hashMap.get(SDKConfigurationDM.ENABLE_CONTACT_US).equals("after_viewing_faqs")) {
                hashMap.put(SDKConfigurationDM.ENABLE_CONTACT_US, Support.EnableContactUs.AFTER_VIEWING_FAQS);
            } else if (hashMap.get(SDKConfigurationDM.ENABLE_CONTACT_US).equals("after_marking_answer_unhelpful")) {
                hashMap.put(SDKConfigurationDM.ENABLE_CONTACT_US, Support.EnableContactUs.AFTER_MARKING_ANSWER_UNHELPFUL);
            }
        }
        HashSet hashSet = new HashSet();
        hashSet.add(SDKConfigurationDM.ENABLE_IN_APP_NOTIFICATION);
        hashSet.add(SDKConfigurationDM.REQUIRE_EMAIL);
        hashSet.add(SDKConfigurationDM.HIDE_NAME_AND_EMAIL);
        hashSet.add("enableFullPrivacy");
        hashSet.add(SDKConfigurationDM.SHOW_SEARCH_ON_NEW_CONVERSATION);
        hashSet.add(SDKConfigurationDM.GOTO_CONVERSATION_AFTER_CONTACT_US);
        hashSet.add(SDKConfigurationDM.SHOW_CONVERSATION_RESOLUTION_QUESTION_API);
        hashSet.add("enableDefaultFallbackLanguage");
        hashSet.add("enableInboxPolling");
        hashSet.add("enableLogging");
        hashSet.add("disableHelpshiftBranding");
        hashSet.add("disableErrorReporting");
        hashSet.add(SDKConfigurationDM.SHOW_CONVERSATION_INFO_SCREEN);
        hashSet.add(SDKConfigurationDM.ENABLE_TYPING_INDICATOR);
        HashMap replaceWithBoolean = replaceWithBoolean(hashSet, hashMap);
        HashMap hashMap2 = (HashMap) replaceWithBoolean.get("hs-custom-metadata");
        if (hashMap2 != null) {
            ArrayList arrayList = (ArrayList) hashMap2.get(Support.TagsKey);
            if (arrayList != null && arrayList.size() > 0) {
                hashMap2.put(Support.TagsKey, (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            replaceWithBoolean.put("hs-custom-metadata", hashMap2);
        }
        HashMap hashMap3 = (HashMap) replaceWithBoolean.get("withTagsMatching");
        if (hashMap3 != null) {
            ArrayList arrayList2 = (ArrayList) hashMap3.get("tags");
            if (arrayList2 != null && arrayList2.size() > 0) {
                hashMap3.put("tags", (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
            replaceWithBoolean.put("withTagsMatching", hashMap3);
        }
        List parseFlowListForKey = parseFlowListForKey(context, replaceWithBoolean, "customContactUsFlows");
        if (parseFlowListForKey != null) {
            replaceWithBoolean.put("customContactUsFlows", parseFlowListForKey);
        }
        return replaceWithBoolean;
    }

    private static List parseFlowListForKey(Context context, HashMap hashMap, String str) {
        List list;
        try {
            list = (List) hashMap.get(str);
        } catch (ClassCastException e) {
            Log.i(TAG, "parseFlowListForKey", e);
            list = null;
        }
        if (list != null) {
            return parseFlowList(context, list);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List parseFlowList(Context context, List<HashMap<String, Object>> list) {
        for (HashMap<String, Object> hashMap : list) {
            if ("dynamicFormFlow".equals(hashMap.get("type"))) {
                parseFlowListForKey(context, hashMap, "data");
            } else {
                hashMap.put(ConfigDBHelper.TABLE_NAME_CONFIG, parseConfigDictionary(context, (HashMap) hashMap.get(ConfigDBHelper.TABLE_NAME_CONFIG)));
            }
        }
        return DynamicFormUtil.toFlowList(context, list);
    }

    private static HashMap replaceWithBoolean(HashSet hashSet, HashMap hashMap) {
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Object obj = hashMap.get(str);
            if (obj instanceof String) {
                if (obj.toString().equals("yes")) {
                    hashMap.put(str, true);
                } else if (obj.toString().equals("no")) {
                    hashMap.put(str, false);
                }
            }
        }
        return hashMap;
    }
}
