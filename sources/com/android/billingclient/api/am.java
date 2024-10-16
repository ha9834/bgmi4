package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.play_billing.zza;

/* loaded from: classes.dex */
public final class am extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ an f947a;
    private final o b;
    private boolean c;

    public /* synthetic */ am(an anVar, o oVar, al alVar) {
        this.f947a = anVar;
        this.b = oVar;
    }

    public final void a(Context context) {
        am amVar;
        if (this.c) {
            amVar = this.f947a.b;
            context.unregisterReceiver(amVar);
            this.c = false;
            return;
        }
        zza.zzb("BillingBroadcastManager", "Receiver is not registered.");
    }

    public final void a(Context context, IntentFilter intentFilter) {
        am amVar;
        if (this.c) {
            return;
        }
        amVar = this.f947a.b;
        context.registerReceiver(amVar, intentFilter);
        this.c = true;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.b.onPurchasesUpdated(zza.zzc(intent, "BillingBroadcastManager"), zza.zzf(intent.getExtras()));
    }
}
