package com.helpshift.conversation.dto;

/* loaded from: classes2.dex */
public class WSPingMessage implements WebSocketMessage {
    public final long pingWaitTimeMillis;

    public WSPingMessage(long j) {
        this.pingWaitTimeMillis = j;
    }
}
