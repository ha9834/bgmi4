package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzez;
import com.google.android.gms.measurement.internal.zzfa;

/* loaded from: classes2.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzfa {

    /* renamed from: a, reason: collision with root package name */
    private zzez f4716a;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f4716a == null) {
            this.f4716a = new zzez(this);
        }
        this.f4716a.onReceive(context, intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzfa
    public final void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzfa
    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }
}
