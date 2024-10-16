package com.helpshift.common.domain.network;

import com.helpshift.common.domain.Domain;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.KeyValuePair;
import com.helpshift.common.platform.network.Method;
import com.helpshift.common.platform.network.PUTRequest;
import com.helpshift.common.platform.network.Request;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.helpshift.util.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class PUTNetwork extends BaseNetwork implements Network {
    @Override // com.helpshift.common.domain.network.BaseNetwork, com.helpshift.common.domain.network.Network
    public /* bridge */ /* synthetic */ Response makeRequest(RequestData requestData) {
        return super.makeRequest(requestData);
    }

    public PUTNetwork(String str, Domain domain, Platform platform) {
        super(str, domain, platform);
    }

    @Override // com.helpshift.common.domain.network.BaseNetwork
    Request getRequest(RequestData requestData) {
        return new PUTRequest(getURL(), getQuery(NetworkDataRequestUtil.cleanData(requestData.body)), getHeaders(requestData.getRequestId(), requestData), 5000);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.common.domain.network.BaseNetwork
    public List<KeyValuePair> getHeaders(String str, RequestData requestData) {
        List<KeyValuePair> headers = super.getHeaders(str, requestData);
        headers.add(new KeyValuePair("Content-type", NetworkConstants.contentType));
        return headers;
    }

    protected String getQuery(Map<String, String> map) {
        Map<String, String> authData = getAuthData(Method.PUT, map);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : authData.entrySet()) {
            try {
                arrayList.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw RootAPIException.wrap(e, NetworkException.UNSUPPORTED_ENCODING_EXCEPTION);
            }
        }
        return StringUtils.join("&", arrayList);
    }
}
