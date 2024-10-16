package com.helpshift.support.db;

import com.helpshift.util.HSLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class SupportDBNameRepo {
    private static final String FAQS_DB_NAME = "faqs_db";
    private static final String ISSUES_DB_NAME = "issues_db";
    private static final String KEYVALUE_DB_NAME = "keyvalue_db";
    private static final String LEGACY_PROFILE_DB_NAME = "legacy_profile_db";
    private static final String LOG_STORE_DB = "log_store_db";
    private static final String NETWORK_DB_NAME = "network_db";
    private static final String SEARCH_DB_NAME = "search_db";
    private static final String SMART_INTENT_DB_NAME = "smart_intent_db";
    private static final String SUPPORT_KV_DB_NAME = "support_kv_db";
    private static final String USER_DB_NAME = "user_db";
    public static final Map<String, String> dbNames;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(ISSUES_DB_NAME, "__hs__db_issues");
        hashMap.put(FAQS_DB_NAME, "__hs__db_faq");
        hashMap.put(NETWORK_DB_NAME, "__hs_db_network_metadata");
        hashMap.put(KEYVALUE_DB_NAME, "__hs__db_key_values");
        hashMap.put(SUPPORT_KV_DB_NAME, "__hs__db_support_key_values");
        hashMap.put(LEGACY_PROFILE_DB_NAME, "__hs__db_profiles");
        hashMap.put(SEARCH_DB_NAME, "__hs__db_search");
        hashMap.put(SMART_INTENT_DB_NAME, "__hs_db_smart_intent");
        hashMap.put(USER_DB_NAME, "__hs_db_helpshift_users");
        hashMap.put(LOG_STORE_DB, HSLogger.LOG_STORE_DB_NAME);
        dbNames = Collections.unmodifiableMap(hashMap);
    }

    public static String getIssuesDbName() {
        return dbNames.get(ISSUES_DB_NAME);
    }

    public static String getFaqsDbName() {
        return dbNames.get(FAQS_DB_NAME);
    }

    public static String getNetworkDbName() {
        return dbNames.get(NETWORK_DB_NAME);
    }

    public static String getKeyvalueDbName() {
        return dbNames.get(KEYVALUE_DB_NAME);
    }

    public static String getLegacyProfileDbName() {
        return dbNames.get(LEGACY_PROFILE_DB_NAME);
    }

    public static String getSearchDbName() {
        return dbNames.get(SEARCH_DB_NAME);
    }

    public static String getSmartIntentDbName() {
        return dbNames.get(SMART_INTENT_DB_NAME);
    }

    public static String getSupportKvDbName() {
        return dbNames.get(SUPPORT_KV_DB_NAME);
    }

    public static String getUserDbName() {
        return dbNames.get(USER_DB_NAME);
    }
}
