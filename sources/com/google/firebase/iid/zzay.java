package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;
import javax.annotation.Nullable;

@VisibleForTesting
/* loaded from: classes.dex */
final class zzay extends BroadcastReceiver {

    @Nullable
    private zzaz zzdp;

    public zzay(zzaz zzazVar) {
        this.zzdp = zzazVar;
    }

    public final void zzam() {
        if (FirebaseInstanceId.zzm()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.zzdp.getContext().registerReceiver(this, new IntentFilter(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzaz zzazVar = this.zzdp;
        if (zzazVar != null && zzazVar.zzao()) {
            if (FirebaseInstanceId.zzm()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.zza(this.zzdp, 0L);
            this.zzdp.getContext().unregisterReceiver(this);
            this.zzdp = null;
        }
    }
}
