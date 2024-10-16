package com.helpshift.common.domain.network;

import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.helpshift.util.StringUtils;

/* loaded from: classes2.dex */
public class AuthenticationFailureNetwork implements Network {
    private static final String REASON_AUTH_TOKEN_NOT_PROVIDED = "missing user auth token";
    private static final String REASON_INVALID_AUTH_TOKEN = "invalid user auth token";
    private final Network network;

    public AuthenticationFailureNetwork(Network network) {
        this.network = network;
    }

    @Override // com.helpshift.common.domain.network.Network
    public Response makeRequest(RequestData requestData) {
        Response makeRequest = this.network.makeRequest(requestData);
        if (makeRequest.status == NetworkErrorCodes.UNAUTHORIZED_ACCESS.intValue() && !StringUtils.isEmpty(makeRequest.responseString)) {
            if (REASON_AUTH_TOKEN_NOT_PROVIDED.equalsIgnoreCase(makeRequest.responseString)) {
                NetworkException networkException = NetworkException.AUTH_TOKEN_NOT_PROVIDED;
                networkException.serverStatusCode = NetworkErrorCodes.AUTH_TOKEN_NOT_PROVIDED.intValue();
                throw RootAPIException.wrap(null, networkException);
            }
            if (REASON_INVALID_AUTH_TOKEN.equalsIgnoreCase(makeRequest.responseString)) {
                NetworkException networkException2 = NetworkException.INVALID_AUTH_TOKEN;
                networkException2.serverStatusCode = NetworkErrorCodes.INVALID_AUTH_TOKEN.intValue();
                throw RootAPIException.wrap(null, networkException2);
            }
        }
        return makeRequest;
    }
}
