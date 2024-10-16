package com.helpshift.conversation.activeconversation;

import com.helpshift.auth.dto.WebSocketAuthData;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.F;
import com.helpshift.common.platform.Device;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.websockets.HSWebSocket;
import com.helpshift.common.platform.network.websockets.IHSWebSocketListener;
import com.helpshift.conversation.dto.WSPingMessage;
import com.helpshift.conversation.dto.WSTypingActionMessage;
import com.helpshift.conversation.dto.WebSocketMessage;
import com.helpshift.util.HSLogger;
import com.helpshift.util.StringUtils;
import com.helpshift.websockets.WebSocketExtension;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class LiveUpdateDM implements IHSWebSocketListener {
    public static final int MESSAGE_TYPE_EVENT = 100;
    public static final int MESSAGE_TYPE_PING = 107;
    private static final String TAG = "Helpshift_LiveUpdateDM";
    private String conversationServerId;
    Domain domain;
    boolean isAgentTyping;
    boolean isConnecting;
    boolean isTokenRefreshed;
    TypingIndicatorListener listener;
    Platform platform;
    final String sdkVersionHeaderValue;
    boolean shouldDisconnectOnConnect;
    boolean socketConnected;
    HSWebSocket webSocket;
    final long NETWORK_PROPOGATION_DELAY = TimeUnit.SECONDS.toMillis(3);
    private final String MESSAGE_TYPE_PONG = "[110]";
    private final String SDK_VERSION_HEADER_KEY = "hs-sdk-ver";
    F disconnectWebSocketF = new F() { // from class: com.helpshift.conversation.activeconversation.LiveUpdateDM.1
        @Override // com.helpshift.common.domain.F
        public void f() {
            if (LiveUpdateDM.this.webSocket != null) {
                if (LiveUpdateDM.this.isConnecting) {
                    LiveUpdateDM.this.shouldDisconnectOnConnect = true;
                    return;
                }
                try {
                    HSLogger.d(LiveUpdateDM.TAG, "Disconnecting web-socket");
                    LiveUpdateDM.this.webSocket.disconnect();
                } catch (Exception e) {
                    HSLogger.e(LiveUpdateDM.TAG, "Exception in disconnecting web-socket", e);
                }
                LiveUpdateDM.this.webSocket = null;
            }
        }
    };
    private F refreshAuthTokenAndConnectF = new F() { // from class: com.helpshift.conversation.activeconversation.LiveUpdateDM.2
        @Override // com.helpshift.common.domain.F
        public void f() {
            if (LiveUpdateDM.this.listener != null) {
                LiveUpdateDM.this.domain.getWebSocketAuthDM().refreshAuthToken();
                LiveUpdateDM liveUpdateDM = LiveUpdateDM.this;
                liveUpdateDM.isTokenRefreshed = true;
                new ConnectWebSocketF(liveUpdateDM.pingCount.incrementAndGet()).f();
            }
        }
    };
    AtomicInteger pingCount = new AtomicInteger(-1);
    AtomicInteger startTypingId = new AtomicInteger(-1);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface TypingIndicatorListener {
        void onAgentTypingUpdate(boolean z);
    }

    public LiveUpdateDM(Domain domain, Platform platform) {
        this.domain = domain;
        this.platform = platform;
        Device device = platform.getDevice();
        this.sdkVersionHeaderValue = device.getPlatformName().toLowerCase() + "-" + device.getSDKVersion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAgentTyping() {
        return this.isAgentTyping;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void registerListener(TypingIndicatorListener typingIndicatorListener, String str) {
        if (this.listener == null) {
            this.listener = typingIndicatorListener;
            this.conversationServerId = str;
            this.isTokenRefreshed = false;
            this.shouldDisconnectOnConnect = false;
            this.domain.runParallel(new ConnectWebSocketF(this.pingCount.incrementAndGet()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void unregisterListener() {
        if (this.listener != null) {
            this.isAgentTyping = false;
            notifyListener();
            this.startTypingId.incrementAndGet();
            this.pingCount.incrementAndGet();
            this.listener = null;
        }
        this.domain.runParallel(this.disconnectWebSocketF);
    }

    @Override // com.helpshift.common.platform.network.websockets.IHSWebSocketListener
    public void onConnected(HSWebSocket hSWebSocket) {
        HSLogger.d(TAG, "web-socket connected");
        this.isConnecting = false;
        this.socketConnected = true;
        if (this.shouldDisconnectOnConnect) {
            this.disconnectWebSocketF.f();
        } else {
            if (this.listener != null) {
                HSLogger.d(TAG, "Subscribing to conversation topic");
                hSWebSocket.sendMessage(getTopicRequest());
                this.domain.runDelayedInParallel(new PingTimeoutF(this.pingCount.incrementAndGet()), TimeUnit.SECONDS.toMillis(60L));
                return;
            }
            this.disconnectWebSocketF.f();
        }
    }

    @Override // com.helpshift.common.platform.network.websockets.IHSWebSocketListener
    public void onDisconnected() {
        HSLogger.d(TAG, "web-socket disconnected");
        this.socketConnected = false;
        this.shouldDisconnectOnConnect = false;
    }

    @Override // com.helpshift.common.platform.network.websockets.IHSWebSocketListener
    public void onMessage(HSWebSocket hSWebSocket, String str) {
        this.domain.runParallel(new HandleWebSocketMessageF(str));
    }

    @Override // com.helpshift.common.platform.network.websockets.IHSWebSocketListener
    public void onError(HSWebSocket hSWebSocket, String str) {
        HSLogger.d(TAG, "Error in web-socket connection: " + str);
        this.isConnecting = false;
        if (this.listener != null) {
            if (getErrorCode(str) == 403) {
                if (this.isTokenRefreshed) {
                    return;
                }
                this.domain.runParallel(this.refreshAuthTokenAndConnectF);
                return;
            }
            scheduleConnectionRetry();
        }
    }

    private int getErrorCode(String str) {
        String[] split = str.split("The status line is: ");
        if (2 != split.length) {
            return -1;
        }
        String[] split2 = split[1].split(" +");
        return (split2.length < 2 || !"403".equals(split2[1])) ? -1 : 403;
    }

    private String getTopicRequest() {
        return "[104, [\"agent_type_act.issue." + this.conversationServerId + "\"]]";
    }

    String getWebSocketPath(WebSocketAuthData webSocketAuthData) {
        String appId = this.platform.getAppId();
        String[] split = this.platform.getDomain().split("\\.");
        String str = split.length == 3 ? split[0] : "";
        String str2 = "";
        try {
            str2 = URLEncoder.encode(webSocketAuthData.authToken, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            HSLogger.e(TAG, "Exception in encoding authToken", e);
        }
        if (StringUtils.isEmpty(str2) || StringUtils.isEmpty(webSocketAuthData.webSocketRoute)) {
            return null;
        }
        return webSocketAuthData.webSocketRoute + "/subscribe/websocket/?origin_v3=" + str2 + "&platform_id=" + appId + "&domain=" + str;
    }

    void scheduleConnectionRetry() {
        this.domain.runDelayedInParallel(new ConnectWebSocketF(this.pingCount.incrementAndGet()), TimeUnit.SECONDS.toMillis(10L));
    }

    void notifyListener() {
        TypingIndicatorListener typingIndicatorListener = this.listener;
        if (typingIndicatorListener != null) {
            typingIndicatorListener.onAgentTypingUpdate(this.isAgentTyping);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ConnectWebSocketF extends F {
        private final int id;

        ConnectWebSocketF(int i) {
            this.id = i;
        }

        @Override // com.helpshift.common.domain.F
        public void f() {
            if (LiveUpdateDM.this.listener == null || this.id != LiveUpdateDM.this.pingCount.get() || LiveUpdateDM.this.socketConnected || LiveUpdateDM.this.isConnecting) {
                return;
            }
            WebSocketAuthData authToken = LiveUpdateDM.this.domain.getWebSocketAuthDM().getAuthToken();
            if (authToken == null) {
                LiveUpdateDM.this.scheduleConnectionRetry();
                return;
            }
            HSLogger.d(LiveUpdateDM.TAG, "Connecting web-socket");
            try {
                LiveUpdateDM.this.webSocket = new HSWebSocket.Builder(LiveUpdateDM.this.getWebSocketPath(authToken)).setConnectionTimeout((int) TimeUnit.SECONDS.toMillis(60L)).addExtension(WebSocketExtension.PERMESSAGE_DEFLATE).addExtension("client_no_context_takeover").addExtension("server_no_context_takeover").addProtocol("dirigent-pubsub-v1").addHeader("hs-sdk-ver", LiveUpdateDM.this.sdkVersionHeaderValue).setWebSocketListener(LiveUpdateDM.this).build();
                LiveUpdateDM.this.isConnecting = true;
                LiveUpdateDM.this.webSocket.connect();
            } catch (Exception e) {
                HSLogger.e(LiveUpdateDM.TAG, "Exception in connecting web-socket", e);
                LiveUpdateDM.this.scheduleConnectionRetry();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class StartTypingTimeoutF extends F {
        int id;

        StartTypingTimeoutF(int i) {
            this.id = i;
        }

        @Override // com.helpshift.common.domain.F
        public void f() {
            if (this.id != LiveUpdateDM.this.startTypingId.get() || LiveUpdateDM.this.listener == null) {
                return;
            }
            HSLogger.d(LiveUpdateDM.TAG, "Start Typing action timed out, disabling TAI");
            LiveUpdateDM liveUpdateDM = LiveUpdateDM.this;
            liveUpdateDM.isAgentTyping = false;
            liveUpdateDM.notifyListener();
        }
    }

    /* loaded from: classes2.dex */
    private class PingTimeoutF extends F {
        int pingId;

        PingTimeoutF(int i) {
            this.pingId = i;
        }

        @Override // com.helpshift.common.domain.F
        public void f() {
            if (this.pingId != LiveUpdateDM.this.pingCount.get() || LiveUpdateDM.this.listener == null) {
                return;
            }
            HSLogger.d(LiveUpdateDM.TAG, "Ping timed out, resetting connection");
            LiveUpdateDM.this.disconnectWebSocketF.f();
            LiveUpdateDM liveUpdateDM = LiveUpdateDM.this;
            new ConnectWebSocketF(liveUpdateDM.pingCount.incrementAndGet()).f();
        }
    }

    /* loaded from: classes2.dex */
    private class HandleWebSocketMessageF extends F {
        private final String message;

        HandleWebSocketMessageF(String str) {
            this.message = str;
        }

        @Override // com.helpshift.common.domain.F
        public void f() {
            WebSocketMessage parseWebSocketMessage = LiveUpdateDM.this.platform.getResponseParser().parseWebSocketMessage(this.message);
            if (parseWebSocketMessage instanceof WSPingMessage) {
                long j = ((WSPingMessage) parseWebSocketMessage).pingWaitTimeMillis + LiveUpdateDM.this.NETWORK_PROPOGATION_DELAY;
                Domain domain = LiveUpdateDM.this.domain;
                LiveUpdateDM liveUpdateDM = LiveUpdateDM.this;
                domain.runDelayedInParallel(new PingTimeoutF(liveUpdateDM.pingCount.incrementAndGet()), j);
                if (LiveUpdateDM.this.webSocket != null) {
                    LiveUpdateDM.this.webSocket.sendMessage("[110]");
                    return;
                }
                return;
            }
            if (LiveUpdateDM.this.listener == null || !(parseWebSocketMessage instanceof WSTypingActionMessage)) {
                return;
            }
            WSTypingActionMessage wSTypingActionMessage = (WSTypingActionMessage) parseWebSocketMessage;
            if (wSTypingActionMessage.isAgentTyping) {
                LiveUpdateDM.this.isAgentTyping = true;
                long j2 = wSTypingActionMessage.typingActionTimeoutMillis + LiveUpdateDM.this.NETWORK_PROPOGATION_DELAY;
                Domain domain2 = LiveUpdateDM.this.domain;
                LiveUpdateDM liveUpdateDM2 = LiveUpdateDM.this;
                domain2.runDelayedInParallel(new StartTypingTimeoutF(liveUpdateDM2.startTypingId.incrementAndGet()), j2);
            } else {
                LiveUpdateDM.this.isAgentTyping = false;
            }
            LiveUpdateDM.this.notifyListener();
        }
    }
}
