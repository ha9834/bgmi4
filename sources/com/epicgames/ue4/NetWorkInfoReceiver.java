package com.epicgames.ue4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;

/* loaded from: classes.dex */
public class NetWorkInfoReceiver extends BroadcastReceiver {
    public int NetWorkType = -2;
    public int NetworkSubType = -1;
    public String SubTypeStringName = "";
    public ConnectivityManager connectivity;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.connectivity == null) {
            this.connectivity = (ConnectivityManager) context.getSystemService(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION);
        }
        ConnectivityManager connectivityManager = this.connectivity;
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.NetWorkType = activeNetworkInfo.getType();
                this.NetworkSubType = activeNetworkInfo.getSubtype();
                this.SubTypeStringName = activeNetworkInfo.getSubtypeName();
            } else {
                this.NetWorkType = -1;
                this.NetworkSubType = -1;
                this.SubTypeStringName = "";
            }
        }
    }
}
