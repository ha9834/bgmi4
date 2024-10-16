package com.google.android.gms.internal.gtm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.PersistableBundle;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzbv extends zzan {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4400a;
    private boolean b;
    private final AlarmManager c;
    private Integer d;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbv(zzap zzapVar) {
        super(zzapVar);
        this.c = (AlarmManager) e().getSystemService("alarm");
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
        try {
            cancel();
            if (zzbq.zzeq() > 0) {
                Context e = e();
                ActivityInfo receiverInfo = e.getPackageManager().getReceiverInfo(new ComponentName(e, "com.google.android.gms.analytics.AnalyticsReceiver"), 0);
                if (receiverInfo == null || !receiverInfo.enabled) {
                    return;
                }
                zzq("Receiver registered for local dispatch.");
                this.f4400a = true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final boolean zzfc() {
        return this.f4400a;
    }

    public final boolean zzez() {
        return this.b;
    }

    public final void zzfd() {
        q();
        Preconditions.checkState(this.f4400a, "Receiver not registered");
        long zzeq = zzbq.zzeq();
        if (zzeq > 0) {
            cancel();
            long elapsedRealtime = d().elapsedRealtime() + zzeq;
            this.b = true;
            zzby.zzaaq.get().booleanValue();
            if (Build.VERSION.SDK_INT >= 24) {
                zzq("Scheduling upload with JobScheduler");
                Context e = e();
                ComponentName componentName = new ComponentName(e, "com.google.android.gms.analytics.AnalyticsJobService");
                int c = c();
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putString("action", "com.google.android.gms.analytics.ANALYTICS_DISPATCH");
                JobInfo build = new JobInfo.Builder(c, componentName).setMinimumLatency(zzeq).setOverrideDeadline(zzeq << 1).setExtras(persistableBundle).build();
                zza("Scheduling job. JobID", Integer.valueOf(c));
                zzdb.zza(e, build, "com.google.android.gms", "DispatchAlarm");
                return;
            }
            zzq("Scheduling upload with AlarmManager");
            this.c.setInexactRepeating(2, elapsedRealtime, zzeq, b());
        }
    }

    private final PendingIntent b() {
        Context e = e();
        return PendingIntent.getBroadcast(e, 0, new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH").setComponent(new ComponentName(e, "com.google.android.gms.analytics.AnalyticsReceiver")), 0);
    }

    public final void cancel() {
        this.b = false;
        this.c.cancel(b());
        if (Build.VERSION.SDK_INT >= 24) {
            JobScheduler jobScheduler = (JobScheduler) e().getSystemService("jobscheduler");
            int c = c();
            zza("Cancelling job. JobID", Integer.valueOf(c));
            jobScheduler.cancel(c);
        }
    }

    private final int c() {
        if (this.d == null) {
            String valueOf = String.valueOf(e().getPackageName());
            this.d = Integer.valueOf((valueOf.length() != 0 ? "analytics".concat(valueOf) : new String("analytics")).hashCode());
        }
        return this.d.intValue();
    }
}
