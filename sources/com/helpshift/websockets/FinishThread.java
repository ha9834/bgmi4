package com.helpshift.websockets;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class FinishThread extends WebSocketThread {
    public FinishThread(WebSocket webSocket) {
        super("FinishThread", webSocket, ThreadType.FINISH_THREAD);
    }

    @Override // com.helpshift.websockets.WebSocketThread
    public void runMain() {
        this.mWebSocket.finish();
    }
}
