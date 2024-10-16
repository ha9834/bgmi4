package com.helpshift.common.domain.network;

import com.helpshift.common.domain.Domain;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.POSTRequest;
import com.helpshift.common.platform.network.Request;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.util.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public class CustomAuthDataPOSTNetwork extends POSTNetwork {
    private Map<String, String> customAuthData;

    public CustomAuthDataPOSTNetwork(String str, Domain domain, Platform platform, Map<String, String> map) {
        super(str, domain, platform);
        this.customAuthData = map;
    }

    @Override // com.helpshift.common.domain.network.POSTNetwork, com.helpshift.common.domain.network.BaseNetwork
    Request getRequest(RequestData requestData) {
        return new POSTRequest(getURL(), getQuery(NetworkDataRequestUtil.cleanData(requestData.body)), getHeaders(requestData.getRequestId(), requestData), 5000);
    }

    @Override // com.helpshift.common.domain.network.POSTNetwork
    protected String getQuery(Map<String, String> map) {
        map.putAll(this.customAuthData);
        Map<String, String> cleanData = NetworkDataRequestUtil.cleanData(map);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : cleanData.entrySet()) {
            try {
                arrayList.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw RootAPIException.wrap(e, NetworkException.UNSUPPORTED_ENCODING_EXCEPTION);
            }
        }
        return StringUtils.join("&", arrayList);
    }
}
