package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzix;

/* loaded from: classes2.dex */
public final class zzit<T extends Context & zzix> {

    /* renamed from: a, reason: collision with root package name */
    private final T f4950a;

    public zzit(T t) {
        Preconditions.checkNotNull(t);
        this.f4950a = t;
    }

    public final void onCreate() {
        zzfj zza = zzfj.zza(this.f4950a, null);
        zzef zzab = zza.zzab();
        zza.zzae();
        zzab.zzgs().zzao("Local AppMeasurementService is starting up");
    }

    public final void onDestroy() {
        zzfj zza = zzfj.zza(this.f4950a, null);
        zzef zzab = zza.zzab();
        zza.zzae();
        zzab.zzgs().zzao("Local AppMeasurementService is shutting down");
    }

    public final int onStartCommand(final Intent intent, int i, final int i2) {
        zzfj zza = zzfj.zza(this.f4950a, null);
        final zzef zzab = zza.zzab();
        if (intent == null) {
            zzab.zzgn().zzao("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zza.zzae();
        zzab.zzgs().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            a(new Runnable(this, i2, zzab, intent) { // from class: com.google.android.gms.measurement.internal.gf

                /* renamed from: a, reason: collision with root package name */
                private final zzit f4880a;
                private final int b;
                private final zzef c;
                private final Intent d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f4880a = this;
                    this.b = i2;
                    this.c = zzab;
                    this.d = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f4880a.a(this.b, this.c, this.d);
                }
            });
        }
        return 2;
    }

    private final void a(Runnable runnable) {
        zzjg zzm = zzjg.zzm(this.f4950a);
        zzm.zzaa().zza(new gg(this, zzm, runnable));
    }

    public final IBinder onBind(Intent intent) {
        if (intent == null) {
            a().zzgk().zzao("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzfk(zzjg.zzm(this.f4950a));
        }
        a().zzgn().zza("onBind received unknown action", action);
        return null;
    }

    public final boolean onUnbind(Intent intent) {
        if (intent == null) {
            a().zzgk().zzao("onUnbind called with null intent");
            return true;
        }
        a().zzgs().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    @TargetApi(24)
    public final boolean onStartJob(final JobParameters jobParameters) {
        zzfj zza = zzfj.zza(this.f4950a, null);
        final zzef zzab = zza.zzab();
        String string = jobParameters.getExtras().getString("action");
        zza.zzae();
        zzab.zzgs().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        a(new Runnable(this, zzab, jobParameters) { // from class: com.google.android.gms.measurement.internal.gh

            /* renamed from: a, reason: collision with root package name */
            private final zzit f4882a;
            private final zzef b;
            private final JobParameters c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4882a = this;
                this.b = zzab;
                this.c = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f4882a.a(this.b, this.c);
            }
        });
        return true;
    }

    public final void onRebind(Intent intent) {
        if (intent == null) {
            a().zzgk().zzao("onRebind called with null intent");
        } else {
            a().zzgs().zza("onRebind called. action", intent.getAction());
        }
    }

    private final zzef a() {
        return zzfj.zza(this.f4950a, null).zzab();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzef zzefVar, JobParameters jobParameters) {
        zzefVar.zzgs().zzao("AppMeasurementJobService processed last upload request.");
        this.f4950a.zza(jobParameters, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, zzef zzefVar, Intent intent) {
        if (this.f4950a.zza(i)) {
            zzefVar.zzgs().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            a().zzgs().zzao("Completed wakeful intent.");
            this.f4950a.zza(intent);
        }
    }
}
