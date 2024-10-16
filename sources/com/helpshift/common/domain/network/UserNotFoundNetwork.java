package com.helpshift.common.domain.network;

import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;

/* loaded from: classes2.dex */
public class UserNotFoundNetwork implements Network {
    private final Network network;

    public UserNotFoundNetwork(Network network) {
        this.network = network;
    }

    @Override // com.helpshift.common.domain.network.Network
    public Response makeRequest(RequestData requestData) {
        Response makeRequest = this.network.makeRequest(requestData);
        if (makeRequest.status != NetworkErrorCodes.CONTENT_NOT_FOUND.intValue()) {
            return makeRequest;
        }
        throw RootAPIException.wrap(null, NetworkException.USER_NOT_FOUND);
    }
}
