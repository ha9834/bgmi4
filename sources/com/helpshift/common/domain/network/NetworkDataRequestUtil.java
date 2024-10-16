package com.helpshift.common.domain.network;

import com.helpshift.account.domainmodel.ClearedUserDM;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.platform.network.NetworkRequestDAO;
import com.helpshift.db.legacy_profile.tables.ProfileTable;
import com.helpshift.support.res.values.HSConsts;
import com.helpshift.util.StringUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class NetworkDataRequestUtil {
    public static HashMap<String, String> getUserRequestData(UserDM userDM) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (userDM != null) {
            if (!StringUtils.isEmpty(userDM.getDeviceId())) {
                hashMap.put(ProfileTable.Columns.COLUMN_DID, userDM.getDeviceId());
            }
            if (!StringUtils.isEmpty(userDM.getIdentifier())) {
                hashMap.put("uid", userDM.getIdentifier());
            }
            if (!StringUtils.isEmpty(userDM.getEmail())) {
                hashMap.put("email", userDM.getEmail());
            }
            if (!StringUtils.isEmpty(userDM.getAuthToken())) {
                hashMap.put("user_auth_token", userDM.getAuthToken());
            }
        }
        return hashMap;
    }

    public static HashMap<String, String> getUserRequestData(ClearedUserDM clearedUserDM) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (clearedUserDM != null) {
            if (!StringUtils.isEmpty(clearedUserDM.deviceId)) {
                hashMap.put(ProfileTable.Columns.COLUMN_DID, clearedUserDM.deviceId);
            }
            if (!StringUtils.isEmpty(clearedUserDM.identifier)) {
                hashMap.put("uid", clearedUserDM.identifier);
            }
            if (!StringUtils.isEmpty(clearedUserDM.email)) {
                hashMap.put("email", clearedUserDM.email);
            }
            if (!StringUtils.isEmpty(clearedUserDM.authToken)) {
                hashMap.put("user_auth_token", clearedUserDM.authToken);
            }
        }
        return hashMap;
    }

    public static Map<String, String> cleanData(Map<String, String> map) {
        String str;
        HashMap hashMap = new HashMap();
        for (String str2 : map.keySet()) {
            if (str2 != null && (str = map.get(str2)) != null) {
                hashMap.put(str2, str);
            }
        }
        return hashMap;
    }

    public static Map<String, Object> getSdkMeta() {
        HashMap hashMap = new HashMap();
        hashMap.put(HSConsts.ISSUE_ARCHIVAL_KEY, true);
        hashMap.put(HSConsts.READ_STATUS_KEY, true);
        hashMap.put(HSConsts.CORRECT_LANGUAGE_CODE_KEY, true);
        hashMap.put(HSConsts.AGENT_TYPING_INDICATOR_KEY, true);
        hashMap.put(HSConsts.ENABLE_FULL_PRIVACY_KEY, true);
        hashMap.put("cb", true);
        return hashMap;
    }

    public static String getAdjustedTimestamp(NetworkRequestDAO networkRequestDAO) {
        float serverTimeDelta = networkRequestDAO.getServerTimeDelta();
        DecimalFormat decimalFormat = new DecimalFormat("0.000", new DecimalFormatSymbols(Locale.US));
        double currentTimeMillis = System.currentTimeMillis();
        Double.isNaN(currentTimeMillis);
        double d = serverTimeDelta;
        Double.isNaN(d);
        return decimalFormat.format((currentTimeMillis / 1000.0d) + d);
    }
}
