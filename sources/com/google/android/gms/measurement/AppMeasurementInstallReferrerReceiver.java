package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzez;
import com.google.android.gms.measurement.internal.zzfa;

/* loaded from: classes2.dex */
public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements zzfa {

    /* renamed from: a, reason: collision with root package name */
    private zzez f4714a;

    @Override // com.google.android.gms.measurement.internal.zzfa
    public final void doStartService(Context context, Intent intent) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f4714a == null) {
            this.f4714a = new zzez(this);
        }
        this.f4714a.onReceive(context, intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzfa
    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }
}
