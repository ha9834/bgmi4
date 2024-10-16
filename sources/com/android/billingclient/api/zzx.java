package com.android.billingclient.api;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.h;
import com.google.android.gms.internal.play_billing.zza;

/* loaded from: classes.dex */
final class zzx extends ResultReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f991a;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        h.a c = h.c();
        c.a(i);
        c.a(zza.zze(bundle, "BillingClient"));
        this.f991a.a(c.a());
    }
}
