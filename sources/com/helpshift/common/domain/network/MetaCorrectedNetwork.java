package com.helpshift.common.domain.network;

import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Jsonifier;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class MetaCorrectedNetwork implements Network {
    private final Jsonifier jsonifier;
    private final Network network;

    public MetaCorrectedNetwork(Network network, Platform platform) {
        this.network = network;
        this.jsonifier = platform.getJsonifier();
    }

    @Override // com.helpshift.common.domain.network.Network
    public Response makeRequest(RequestData requestData) {
        return makeRequest(requestData, 1);
    }

    private Response makeRequest(RequestData requestData, int i) {
        Response makeRequest = this.network.makeRequest(requestData);
        if (makeRequest.status != 413) {
            return makeRequest;
        }
        if (i > 0) {
            HashMap hashMap = new HashMap(requestData.body);
            removeCIFAndCustomMetadata(hashMap);
            return makeRequest(new RequestData(hashMap), i - 1);
        }
        throw RootAPIException.wrap(null, NetworkException.ENTITY_TOO_LARGE_RETRIES_EXHAUSTED);
    }

    private void removeCIFAndCustomMetadata(Map<String, String> map) {
        map.put("meta", this.jsonifier.removeKeyFromJsonObjString(map.get("meta"), "custom_meta"));
        map.remove("custom_fields");
    }
}
