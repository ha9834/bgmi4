package com.helpshift.common.domain.network;

import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.helpshift.common.platform.network.ResponseParser;

/* loaded from: classes2.dex */
public class GuardAgainstConversationReOpenExpiryNetwork implements Network {
    private final Network network;
    private final ResponseParser responseParser;

    public GuardAgainstConversationReOpenExpiryNetwork(Network network, Platform platform) {
        this.network = network;
        this.responseParser = platform.getResponseParser();
    }

    @Override // com.helpshift.common.domain.network.Network
    public Response makeRequest(RequestData requestData) {
        Response makeRequest = this.network.makeRequest(requestData);
        if (makeRequest.status == 410 && "resolution question timer expired".equals(this.responseParser.parseErrorMessage(makeRequest.responseString))) {
            throw RootAPIException.wrap(null, NetworkException.CONVERSATION_REOPEN_EXPIRED);
        }
        return makeRequest;
    }
}
