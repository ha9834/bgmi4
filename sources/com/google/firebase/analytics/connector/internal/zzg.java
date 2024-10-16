package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzg implements AppMeasurement.OnEventListener {
    private final /* synthetic */ zze zzacv;

    public zzg(zze zzeVar) {
        this.zzacv = zzeVar;
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.OnEventListener, com.google.android.gms.measurement.internal.zzgn
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener;
        if (str == null || str.equals("crash") || !zzd.zzdk(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j);
        bundle2.putBundle(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
        analyticsConnectorListener = this.zzacv.zzacj;
        analyticsConnectorListener.onMessageTriggered(3, bundle2);
    }
}
