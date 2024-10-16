package com.shieldtunnel.svpn.common.intf;

/* loaded from: classes2.dex */
public interface TunnelEventListener {

    /* loaded from: classes2.dex */
    public enum Event {
        DIAL_UP,
        DIAL_UP_RESULT,
        HANG_UP,
        KEEP_ALIVE_FAIL,
        NETWORK_CHANGE,
        EXCEPTION,
        SERVER_HANG_UP,
        NODE_LIST_UPDATE
    }

    void onEvent(Event event, int i, String str);
}
