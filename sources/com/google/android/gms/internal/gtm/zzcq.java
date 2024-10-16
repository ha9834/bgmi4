package com.google.android.gms.internal.gtm;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzcu;
import com.google.android.gms.stats.WakeLock;

/* loaded from: classes2.dex */
public final class zzcq<T extends Context & zzcu> {
    private static Boolean c;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f4411a;
    private final T b;

    public zzcq(T t) {
        Preconditions.checkNotNull(t);
        this.b = t;
        this.f4411a = new zzdj();
    }

    public static boolean zze(Context context) {
        Preconditions.checkNotNull(context);
        Boolean bool = c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zzc = zzcz.zzc(context, "com.google.android.gms.analytics.AnalyticsService");
        c = Boolean.valueOf(zzc);
        return zzc;
    }

    public final void onCreate() {
        zzap.zzc(this.b).zzco().zzq("Local AnalyticsService is starting up");
    }

    public final void onDestroy() {
        zzap.zzc(this.b).zzco().zzq("Local AnalyticsService is shutting down");
    }

    public final int onStartCommand(Intent intent, int i, final int i2) {
        try {
            synchronized (zzcp.f4410a) {
                WakeLock wakeLock = zzcp.b;
                if (wakeLock != null && wakeLock.isHeld()) {
                    wakeLock.release();
                }
            }
        } catch (SecurityException unused) {
        }
        final zzci zzco = zzap.zzc(this.b).zzco();
        if (intent == null) {
            zzco.zzt("AnalyticsService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzco.zza("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            a(new Runnable(this, i2, zzco) { // from class: com.google.android.gms.internal.gtm.af

                /* renamed from: a, reason: collision with root package name */
                private final zzcq f4295a;
                private final int b;
                private final zzci c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f4295a = this;
                    this.b = i2;
                    this.c = zzco;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f4295a.a(this.b, this.c);
                }
            });
        }
        return 2;
    }

    private final void a(Runnable runnable) {
        zzap.zzc(this.b).zzcs().zza(new ah(this, runnable));
    }

    @TargetApi(24)
    public final boolean onStartJob(final JobParameters jobParameters) {
        final zzci zzco = zzap.zzc(this.b).zzco();
        String string = jobParameters.getExtras().getString("action");
        zzco.zza("Local AnalyticsJobService called. action", string);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            return true;
        }
        a(new Runnable(this, zzco, jobParameters) { // from class: com.google.android.gms.internal.gtm.ag

            /* renamed from: a, reason: collision with root package name */
            private final zzcq f4296a;
            private final zzci b;
            private final JobParameters c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4296a = this;
                this.b = zzco;
                this.c = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f4296a.a(this.b, this.c);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzci zzciVar, JobParameters jobParameters) {
        zzciVar.zzq("AnalyticsJobService processed last dispatch request");
        this.b.zza(jobParameters, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, zzci zzciVar) {
        if (this.b.callServiceStopSelfResult(i)) {
            zzciVar.zzq("Local AnalyticsService processed last dispatch request");
        }
    }
}
