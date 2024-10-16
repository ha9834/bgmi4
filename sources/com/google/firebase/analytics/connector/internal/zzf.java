package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzf implements AppMeasurement.OnEventListener {
    private final /* synthetic */ zzc zzacs;

    public zzf(zzc zzcVar) {
        this.zzacs = zzcVar;
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.OnEventListener, com.google.android.gms.measurement.internal.zzgn
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener;
        if (this.zzacs.zzaci.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", zzd.zzdn(str2));
            analyticsConnectorListener = this.zzacs.zzacj;
            analyticsConnectorListener.onMessageTriggered(2, bundle2);
        }
    }
}
