package com.helpshift.common.domain.network;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Jsonifier;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.Method;
import com.helpshift.common.platform.network.NetworkRequestDAO;
import com.helpshift.crypto.CryptoDM;
import com.helpshift.support.res.values.HSConsts;
import com.helpshift.util.StringUtils;
import com.tencent.open.SocialOperation;
import com.tencent.smtt.sdk.TbsReaderView;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public class AuthDataProvider {
    final String apiKey;
    final String appId;
    final CryptoDM cryptoDM;
    final Jsonifier jsonifier;
    final NetworkRequestDAO networkRequestDAO;
    final String route;

    public AuthDataProvider(Domain domain, Platform platform, String str) {
        this.apiKey = platform.getAPIKey();
        this.appId = platform.getAppId();
        this.route = str;
        this.cryptoDM = domain.getCryptoDM();
        this.networkRequestDAO = platform.getNetworkRequestDAO();
        this.jsonifier = platform.getJsonifier();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, String> getAuthData(Method method, Map<String, String> map) throws GeneralSecurityException {
        if (map == null || StringUtils.isEmpty(map.get(ShareConstants.MEDIA_URI))) {
            throw new IllegalArgumentException("No value for uri in auth data.");
        }
        map.put("platform-id", this.appId);
        map.put(FirebaseAnalytics.Param.METHOD, method.name());
        map.put("timestamp", NetworkDataRequestUtil.getAdjustedTimestamp(this.networkRequestDAO));
        map.put(HSConsts.SDK_META, this.jsonifier.jsonify(NetworkDataRequestUtil.getSdkMeta()));
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            if (!str.equals(TbsReaderView.KEY_FILE_PATH) && !str.equals("meta") && !str.equals("originalFileName")) {
                arrayList2.add(str + "=" + map.get(str));
            }
        }
        map.put(SocialOperation.GAME_SIGNATURE, this.cryptoDM.getSignature(StringUtils.join("&", arrayList2), this.apiKey));
        map.remove(FirebaseAnalytics.Param.METHOD);
        map.remove(ShareConstants.MEDIA_URI);
        return map;
    }
}
