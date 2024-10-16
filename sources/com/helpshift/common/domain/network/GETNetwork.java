package com.helpshift.common.domain.network;

import com.helpshift.common.domain.Domain;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.GETRequest;
import com.helpshift.common.platform.network.Method;
import com.helpshift.common.platform.network.Request;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.helpshift.util.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public class GETNetwork extends BaseNetwork {
    @Override // com.helpshift.common.domain.network.BaseNetwork, com.helpshift.common.domain.network.Network
    public /* bridge */ /* synthetic */ Response makeRequest(RequestData requestData) {
        return super.makeRequest(requestData);
    }

    public GETNetwork(String str, Domain domain, Platform platform) {
        super(str, domain, platform);
    }

    @Override // com.helpshift.common.domain.network.BaseNetwork
    Request getRequest(RequestData requestData) {
        return new GETRequest(getURL() + "?" + getQuery(NetworkDataRequestUtil.cleanData(requestData.body)), getHeaders(requestData.getRequestId(), requestData), 5000);
    }

    private String getQuery(Map<String, String> map) {
        Map<String, String> authData = getAuthData(Method.GET, map);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : authData.entrySet()) {
            try {
                arrayList.add(entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw RootAPIException.wrap(e, NetworkException.UNSUPPORTED_ENCODING_EXCEPTION);
            }
        }
        return StringUtils.join("&", arrayList);
    }
}
