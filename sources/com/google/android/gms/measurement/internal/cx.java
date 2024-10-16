package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class cx extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private static final String f4795a = "com.google.android.gms.measurement.internal.cx";
    private final zzjg b;
    private boolean c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(zzjg zzjgVar) {
        Preconditions.checkNotNull(zzjgVar);
        this.b = zzjgVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.b.b();
        String action = intent.getAction();
        this.b.zzab().zzgs().zza("NetworkBroadcastReceiver received action", action);
        if (NetWorkChangeReceiver.NETWORK_CHANGE_ACTION.equals(action)) {
            boolean zzgv = this.b.zzjf().zzgv();
            if (this.d != zzgv) {
                this.d = zzgv;
                this.b.zzaa().zza(new da(this, zzgv));
                return;
            }
            return;
        }
        this.b.zzab().zzgn().zza("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void a() {
        this.b.b();
        this.b.zzaa().zzo();
        if (this.c) {
            return;
        }
        this.b.getContext().registerReceiver(this, new IntentFilter(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION));
        this.d = this.b.zzjf().zzgv();
        this.b.zzab().zzgs().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.d));
        this.c = true;
    }

    public final void b() {
        this.b.b();
        this.b.zzaa().zzo();
        this.b.zzaa().zzo();
        if (this.c) {
            this.b.zzab().zzgs().zzao("Unregistering connectivity change receiver");
            this.c = false;
            this.d = false;
            try {
                this.b.getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.b.zzab().zzgk().zza("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
