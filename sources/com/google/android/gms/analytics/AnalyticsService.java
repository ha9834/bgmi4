package com.google.android.gms.analytics;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.gtm.zzcq;
import com.google.android.gms.internal.gtm.zzcu;

/* loaded from: classes.dex */
public final class AnalyticsService extends Service implements zzcu {

    /* renamed from: a, reason: collision with root package name */
    private zzcq<AnalyticsService> f1189a;

    private final zzcq<AnalyticsService> a() {
        if (this.f1189a == null) {
            this.f1189a = new zzcq<>(this);
        }
        return this.f1189a;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        a().onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        a().onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        return a().onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        a();
        return null;
    }

    @Override // com.google.android.gms.internal.gtm.zzcu
    public final boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    @Override // com.google.android.gms.internal.gtm.zzcu
    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }
}
