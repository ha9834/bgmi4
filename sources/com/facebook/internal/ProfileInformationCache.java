package com.facebook.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.h;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ProfileInformationCache {
    public static final ProfileInformationCache INSTANCE = new ProfileInformationCache();
    private static final ConcurrentHashMap<String, JSONObject> infoCache = new ConcurrentHashMap<>();

    private ProfileInformationCache() {
    }

    public static final JSONObject getProfileInformation(String str) {
        h.b(str, SDKConstants.PARAM_ACCESS_TOKEN);
        return infoCache.get(str);
    }

    public static final void putProfileInformation(String str, JSONObject jSONObject) {
        h.b(str, "key");
        h.b(jSONObject, "value");
        infoCache.put(str, jSONObject);
    }
}
