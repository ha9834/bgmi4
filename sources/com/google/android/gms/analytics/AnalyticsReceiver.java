package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.gtm.zzcp;

/* loaded from: classes.dex */
public final class AnalyticsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private zzcp f1188a;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f1188a == null) {
            this.f1188a = new zzcp();
        }
        zzcp.onReceive(context, intent);
    }
}
