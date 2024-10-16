package com.tdatamaster.tdm.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public class TDMNetworkReceiver extends BroadcastReceiver {
    private NetworkType LastNet = NetworkType.NETWORK_UNKNOWN;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkType GetNetworkType = TDMSystem.getInstance().GetNetworkType(context);
        if (GetNetworkType != this.LastNet) {
            this.LastNet = GetNetworkType;
            TDMUtils.GetInstance().OnNetworkChanged(GetNetworkType.ordinal(), true);
        }
    }
}
