package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzit;
import com.google.android.gms.measurement.internal.zzix;

/* loaded from: classes2.dex */
public final class AppMeasurementService extends Service implements zzix {

    /* renamed from: a, reason: collision with root package name */
    private zzit<AppMeasurementService> f4717a;

    private final zzit<AppMeasurementService> a() {
        if (this.f4717a == null) {
            this.f4717a = new zzit<>(this);
        }
        return this.f4717a;
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
        return a().onBind(intent);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return a().onUnbind(intent);
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        a().onRebind(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzix
    public final boolean zza(int i) {
        return stopSelfResult(i);
    }

    @Override // com.google.android.gms.measurement.internal.zzix
    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzix
    public final void zza(Intent intent) {
        AppMeasurementReceiver.completeWakefulIntent(intent);
    }
}
