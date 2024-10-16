package com.helpshift.auth.domainmodel;

import com.helpshift.auth.dto.WebSocketAuthData;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.GETNetwork;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.KVStore;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.ResponseParser;
import com.helpshift.util.HSLogger;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class WebSocketAuthDM {
    private static final String TAG = "Helpshift_WebSocketAuthDM";
    public static final String WEBSOCKET_AUTH_DATA = "websocket_auth_data";
    private WebSocketAuthData cachedAuthData;
    private Domain domain;
    private final Object fetchSyncObject = new Object();
    private KVStore kvStore;
    private Platform platform;
    private ResponseParser responseParser;

    public WebSocketAuthDM(Domain domain, Platform platform) {
        this.domain = domain;
        this.platform = platform;
        this.responseParser = platform.getResponseParser();
        this.kvStore = platform.getKVStore();
    }

    public WebSocketAuthData getAuthToken() {
        if (this.cachedAuthData == null) {
            Object serializable = this.kvStore.getSerializable(WEBSOCKET_AUTH_DATA);
            if (serializable instanceof WebSocketAuthData) {
                this.cachedAuthData = (WebSocketAuthData) serializable;
            }
        }
        if (this.cachedAuthData == null) {
            this.cachedAuthData = fetchNewTokenInternal();
            this.kvStore.setSerializable(WEBSOCKET_AUTH_DATA, this.cachedAuthData);
        }
        return this.cachedAuthData;
    }

    public WebSocketAuthData refreshAuthToken() {
        this.cachedAuthData = fetchNewTokenInternal();
        this.kvStore.setSerializable(WEBSOCKET_AUTH_DATA, this.cachedAuthData);
        return this.cachedAuthData;
    }

    private WebSocketAuthData fetchNewTokenInternal() {
        WebSocketAuthData webSocketAuthData;
        synchronized (this.fetchSyncObject) {
            HSLogger.d(TAG, "Fetching auth token");
            webSocketAuthData = null;
            try {
                webSocketAuthData = this.responseParser.parseAuthToken(new GuardOKNetwork(new GETNetwork("/ws-config/", this.domain, this.platform)).makeRequest(getRequestData()).responseString);
                HSLogger.d(TAG, "Auth token fetch successful");
            } catch (RootAPIException e) {
                HSLogger.e(TAG, "Exception in fetching auth token", e);
            }
        }
        return webSocketAuthData;
    }

    private RequestData getRequestData() {
        HashMap hashMap = new HashMap();
        hashMap.put("platform-id", this.platform.getAppId());
        return new RequestData(hashMap);
    }
}
