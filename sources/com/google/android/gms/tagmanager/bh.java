package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;

/* loaded from: classes2.dex */
class bh extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private static final String f5091a = "com.google.android.gms.tagmanager.bh";
    private final zzfm b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(zzfm zzfmVar) {
        this.b = zzfmVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (NetWorkChangeReceiver.NETWORK_CHANGE_ACTION.equals(action)) {
            Bundle extras = intent.getExtras();
            Boolean bool = Boolean.FALSE;
            if (extras != null) {
                bool = Boolean.valueOf(intent.getExtras().getBoolean("noConnectivity"));
            }
            this.b.zzf(!bool.booleanValue());
            return;
        }
        if (!"com.google.analytics.RADIO_POWERED".equals(action) || intent.hasExtra(f5091a)) {
            return;
        }
        this.b.zzjp();
    }

    public static void a(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(f5091a, true);
        context.sendBroadcast(intent);
    }
}
