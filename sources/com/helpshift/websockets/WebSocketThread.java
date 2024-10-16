package com.helpshift.websockets;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class WebSocketThread extends Thread {
    private final ThreadType mThreadType;
    protected final WebSocket mWebSocket;

    protected abstract void runMain();

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketThread(String str, WebSocket webSocket, ThreadType threadType) {
        super(str);
        this.mWebSocket = webSocket;
        this.mThreadType = threadType;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ListenerManager listenerManager = this.mWebSocket.getListenerManager();
        if (listenerManager != null) {
            listenerManager.callOnThreadStarted(this.mThreadType, this);
        }
        runMain();
        if (listenerManager != null) {
            listenerManager.callOnThreadStopping(this.mThreadType, this);
        }
    }

    public void callOnThreadCreated() {
        ListenerManager listenerManager = this.mWebSocket.getListenerManager();
        if (listenerManager != null) {
            listenerManager.callOnThreadCreated(this.mThreadType, this);
        }
    }
}
