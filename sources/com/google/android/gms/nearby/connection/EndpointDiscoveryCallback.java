package com.google.android.gms.nearby.connection;

/* loaded from: classes2.dex */
public abstract class EndpointDiscoveryCallback {
    public abstract void onEndpointFound(String str, DiscoveredEndpointInfo discoveredEndpointInfo);

    public abstract void onEndpointLost(String str);
}
