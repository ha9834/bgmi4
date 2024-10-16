package com.helpshift.network.connectivity;

/* loaded from: classes2.dex */
public interface HSAndroidConnectivityManager {
    HSConnectivityStatus getConnectivityStatus();

    HSConnectivityType getConnectivityType();

    void startListeningConnectivityChange(HSNetworkConnectivityCallback hSNetworkConnectivityCallback);

    void stopListeningConnectivityChange();
}
