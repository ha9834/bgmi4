package com.tencent.abase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.abase.log.XLog;

/* loaded from: classes2.dex */
public class ConnectionChangeReceiver extends BroadcastReceiver {
    private static NetworkState LastState = NetworkState.NotReachable;
    private static final String TAG = "ConnectionChangeReceiver";

    public void runNetworkStateChange(int i) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            if (LastState != NetworkState.NotReachable) {
                XLog.i(TAG, "ApolloNetInfo : null or disConnected. Network State change to TYPE_None");
                LastState = NetworkState.NotReachable;
                TX.Instance.NetworkStateChangeNotify(NetworkState.NotReachable.ordinal());
                return;
            }
            return;
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
                if (LastState != NetworkState.ReachableViaWWAN) {
                    if (LastState != NetworkState.NotReachable) {
                        TX.Instance.NetworkStateChangeNotify(NetworkState.NotReachable.ordinal());
                    }
                    XLog.i(TAG, "Network State change to TYPE_MOBILE");
                    LastState = NetworkState.ReachableViaWWAN;
                    TX.Instance.NetworkStateChangeNotify(NetworkState.ReachableViaWWAN.ordinal());
                    return;
                }
                return;
            case 1:
                if (LastState != NetworkState.ReachableViaWiFi) {
                    if (LastState != NetworkState.NotReachable) {
                        TX.Instance.NetworkStateChangeNotify(NetworkState.NotReachable.ordinal());
                    }
                    XLog.i(TAG, "Network State change to TYPE_WIFI");
                    LastState = NetworkState.ReachableViaWiFi;
                    TX.Instance.NetworkStateChangeNotify(NetworkState.ReachableViaWiFi.ordinal());
                    return;
                }
                return;
            default:
                if (LastState != NetworkState.ReachableViaOthers) {
                    if (LastState != NetworkState.NotReachable) {
                        TX.Instance.NetworkStateChangeNotify(NetworkState.NotReachable.ordinal());
                    }
                    XLog.i(TAG, "Network Type : Other Network Type:" + activeNetworkInfo.getType());
                    LastState = NetworkState.ReachableViaOthers;
                    TX.Instance.NetworkStateChangeNotify(NetworkState.ReachableViaOthers.ordinal());
                    return;
                }
                return;
        }
    }
}
