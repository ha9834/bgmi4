package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzit;
import com.google.android.gms.measurement.internal.zzix;

@TargetApi(24)
/* loaded from: classes2.dex */
public final class AppMeasurementJobService extends JobService implements zzix {

    /* renamed from: a, reason: collision with root package name */
    private zzit<AppMeasurementJobService> f4715a;

    private final zzit<AppMeasurementJobService> a() {
        if (this.f4715a == null) {
            this.f4715a = new zzit<>(this);
        }
        return this.f4715a;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzix
    public final void zza(Intent intent) {
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

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return a().onStartJob(jobParameters);
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
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzix
    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
