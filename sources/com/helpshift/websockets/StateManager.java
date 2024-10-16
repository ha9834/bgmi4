package com.helpshift.websockets;

/* loaded from: classes2.dex */
class StateManager {
    private CloseInitiator mCloseInitiator = CloseInitiator.NONE;
    private WebSocketState mState = WebSocketState.CREATED;

    /* loaded from: classes2.dex */
    enum CloseInitiator {
        NONE,
        SERVER,
        CLIENT
    }

    public WebSocketState getState() {
        return this.mState;
    }

    public void setState(WebSocketState webSocketState) {
        this.mState = webSocketState;
    }

    public void changeToClosing(CloseInitiator closeInitiator) {
        this.mState = WebSocketState.CLOSING;
        if (this.mCloseInitiator == CloseInitiator.NONE) {
            this.mCloseInitiator = closeInitiator;
        }
    }

    public boolean getClosedByServer() {
        return this.mCloseInitiator == CloseInitiator.SERVER;
    }
}
