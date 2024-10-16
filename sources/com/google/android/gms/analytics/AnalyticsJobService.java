package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.gtm.zzcq;
import com.google.android.gms.internal.gtm.zzcu;

@TargetApi(24)
/* loaded from: classes.dex */
public final class AnalyticsJobService extends JobService implements zzcu {

    /* renamed from: a, reason: collision with root package name */
    private zzcq<AnalyticsJobService> f1187a;

    private final zzcq<AnalyticsJobService> a() {
        if (this.f1187a == null) {
            this.f1187a = new zzcq<>(this);
        }
        return this.f1187a;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
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

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return a().onStartJob(jobParameters);
    }

    @Override // com.google.android.gms.internal.gtm.zzcu
    public final boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    @Override // com.google.android.gms.internal.gtm.zzcu
    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
