package com.facebook.internal;

import com.facebook.FacebookRequestError;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.w;
import kotlin.i;
import kotlin.jvm.internal.f;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class FacebookRequestErrorClassification {
    public static final Companion Companion = new Companion(null);
    public static final int EC_APP_NOT_INSTALLED = 412;
    public static final int EC_APP_TOO_MANY_CALLS = 4;
    public static final int EC_INVALID_SESSION = 102;
    public static final int EC_INVALID_TOKEN = 190;
    public static final int EC_RATE = 9;
    public static final int EC_SERVICE_UNAVAILABLE = 2;
    public static final int EC_TOO_MANY_USER_ACTION_CALLS = 341;
    public static final int EC_USER_TOO_MANY_CALLS = 17;
    public static final int ESC_APP_INACTIVE = 493;
    public static final int ESC_APP_NOT_INSTALLED = 458;
    public static final String KEY_LOGIN_RECOVERABLE = "login_recoverable";
    public static final String KEY_NAME = "name";
    public static final String KEY_OTHER = "other";
    public static final String KEY_RECOVERY_MESSAGE = "recovery_message";
    public static final String KEY_TRANSIENT = "transient";
    private static FacebookRequestErrorClassification defaultInstance;
    private final Map<Integer, Set<Integer>> loginRecoverableErrors;
    private final String loginRecoverableRecoveryMessage;
    private final Map<Integer, Set<Integer>> otherErrors;
    private final String otherRecoveryMessage;
    private final Map<Integer, Set<Integer>> transientErrors;
    private final String transientRecoveryMessage;

    public static final FacebookRequestErrorClassification createFromJSON(JSONArray jSONArray) {
        return Companion.createFromJSON(jSONArray);
    }

    public static final synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
        FacebookRequestErrorClassification defaultErrorClassification;
        synchronized (FacebookRequestErrorClassification.class) {
            defaultErrorClassification = Companion.getDefaultErrorClassification();
        }
        return defaultErrorClassification;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FacebookRequestErrorClassification(Map<Integer, ? extends Set<Integer>> map, Map<Integer, ? extends Set<Integer>> map2, Map<Integer, ? extends Set<Integer>> map3, String str, String str2, String str3) {
        this.otherErrors = map;
        this.transientErrors = map2;
        this.loginRecoverableErrors = map3;
        this.otherRecoveryMessage = str;
        this.transientRecoveryMessage = str2;
        this.loginRecoverableRecoveryMessage = str3;
    }

    public final Map<Integer, Set<Integer>> getOtherErrors() {
        return this.otherErrors;
    }

    public final Map<Integer, Set<Integer>> getTransientErrors() {
        return this.transientErrors;
    }

    public final Map<Integer, Set<Integer>> getLoginRecoverableErrors() {
        return this.loginRecoverableErrors;
    }

    public final String getRecoveryMessage(FacebookRequestError.Category category) {
        if (category != null) {
            switch (category) {
                case OTHER:
                    return this.otherRecoveryMessage;
                case LOGIN_RECOVERABLE:
                    return this.loginRecoverableRecoveryMessage;
                case TRANSIENT:
                    return this.transientRecoveryMessage;
            }
        }
        return null;
    }

    public final FacebookRequestError.Category classify(int i, int i2, boolean z) {
        Set<Integer> set;
        Set<Integer> set2;
        Set<Integer> set3;
        if (z) {
            return FacebookRequestError.Category.TRANSIENT;
        }
        Map<Integer, Set<Integer>> map = this.otherErrors;
        if (map != null && map.containsKey(Integer.valueOf(i)) && ((set3 = this.otherErrors.get(Integer.valueOf(i))) == null || set3.contains(Integer.valueOf(i2)))) {
            return FacebookRequestError.Category.OTHER;
        }
        Map<Integer, Set<Integer>> map2 = this.loginRecoverableErrors;
        if (map2 != null && map2.containsKey(Integer.valueOf(i)) && ((set2 = this.loginRecoverableErrors.get(Integer.valueOf(i))) == null || set2.contains(Integer.valueOf(i2)))) {
            return FacebookRequestError.Category.LOGIN_RECOVERABLE;
        }
        Map<Integer, Set<Integer>> map3 = this.transientErrors;
        if (map3 != null && map3.containsKey(Integer.valueOf(i)) && ((set = this.transientErrors.get(Integer.valueOf(i))) == null || set.contains(Integer.valueOf(i2)))) {
            return FacebookRequestError.Category.TRANSIENT;
        }
        return FacebookRequestError.Category.OTHER;
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public static /* synthetic */ void getDefaultErrorClassification$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
            FacebookRequestErrorClassification facebookRequestErrorClassification;
            if (FacebookRequestErrorClassification.defaultInstance == null) {
                FacebookRequestErrorClassification.defaultInstance = FacebookRequestErrorClassification.Companion.getDefaultErrorClassificationImpl();
            }
            facebookRequestErrorClassification = FacebookRequestErrorClassification.defaultInstance;
            if (facebookRequestErrorClassification == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.FacebookRequestErrorClassification");
            }
            return facebookRequestErrorClassification;
        }

        private final FacebookRequestErrorClassification getDefaultErrorClassificationImpl() {
            return new FacebookRequestErrorClassification(null, w.c(i.a(2, null), i.a(4, null), i.a(9, null), i.a(17, null), i.a(Integer.valueOf(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS), null)), w.c(i.a(102, null), i.a(Integer.valueOf(FacebookRequestErrorClassification.EC_INVALID_TOKEN), null), i.a(412, null)), null, null, null);
        }

        private final Map<Integer, Set<Integer>> parseJSONDefinition(JSONObject jSONObject) {
            int optInt;
            JSONArray optJSONArray = jSONObject.optJSONArray("items");
            if (optJSONArray.length() == 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null && (optInt = optJSONObject.optInt("code")) != 0) {
                    HashSet hashSet = (Set) null;
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("subcodes");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        hashSet = new HashSet();
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            int optInt2 = optJSONArray2.optInt(i2);
                            if (optInt2 != 0) {
                                hashSet.add(Integer.valueOf(optInt2));
                            }
                        }
                    }
                    hashMap.put(Integer.valueOf(optInt), hashSet);
                }
            }
            return hashMap;
        }

        public final FacebookRequestErrorClassification createFromJSON(JSONArray jSONArray) {
            String optString;
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            Map<Integer, Set<Integer>> map = (Map) null;
            Map<Integer, Set<Integer>> map2 = map;
            Map<Integer, Set<Integer>> map3 = map2;
            String str = (String) null;
            String str2 = str;
            String str3 = str2;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && (optString = optJSONObject.optString("name")) != null) {
                    if (l.a(optString, "other", true)) {
                        String optString2 = optJSONObject.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, null);
                        map = parseJSONDefinition(optJSONObject);
                        str = optString2;
                    } else if (l.a(optString, FacebookRequestErrorClassification.KEY_TRANSIENT, true)) {
                        String optString3 = optJSONObject.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, null);
                        map2 = parseJSONDefinition(optJSONObject);
                        str2 = optString3;
                    } else if (l.a(optString, FacebookRequestErrorClassification.KEY_LOGIN_RECOVERABLE, true)) {
                        String optString4 = optJSONObject.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, null);
                        map3 = parseJSONDefinition(optJSONObject);
                        str3 = optString4;
                    }
                }
            }
            return new FacebookRequestErrorClassification(map, map2, map3, str, str2, str3);
        }
    }
}
