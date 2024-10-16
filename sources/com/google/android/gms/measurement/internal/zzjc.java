package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzi;

/* loaded from: classes2.dex */
public final class zzjc extends gq {
    private final AlarmManager b;
    private final a c;
    private Integer d;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzjc(zzjg zzjgVar) {
        super(zzjgVar);
        this.b = (AlarmManager) getContext().getSystemService("alarm");
        this.c = new gp(this, zzjgVar.f(), zzjgVar);
    }

    @Override // com.google.android.gms.measurement.internal.gq
    protected final boolean a() {
        this.b.cancel(f());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        d();
        return false;
    }

    @TargetApi(24)
    private final void d() {
        JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
        int e = e();
        zzab().zzgs().zza("Cancelling job. JobID", Integer.valueOf(e));
        jobScheduler.cancel(e);
    }

    public final void zzv(long j) {
        c();
        zzae();
        Context context = getContext();
        if (!zzez.zzl(context)) {
            zzab().zzgr().zzao("Receiver not registered/enabled");
        }
        if (!zzjs.a(context, false)) {
            zzab().zzgr().zzao("Service not registered/enabled");
        }
        cancel();
        long elapsedRealtime = zzx().elapsedRealtime() + j;
        if (j < Math.max(0L, zzak.zzhc.get(null).longValue()) && !this.c.b()) {
            zzab().zzgs().zzao("Scheduling upload with DelayedRunnable");
            this.c.a(j);
        }
        zzae();
        if (Build.VERSION.SDK_INT >= 24) {
            zzab().zzgs().zzao("Scheduling upload with JobScheduler");
            Context context2 = getContext();
            ComponentName componentName = new ComponentName(context2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int e = e();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            JobInfo build = new JobInfo.Builder(e, componentName).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build();
            zzab().zzgs().zza("Scheduling job. JobID", Integer.valueOf(e));
            zzi.zza(context2, build, "com.google.android.gms", "UploadAlarm");
            return;
        }
        zzab().zzgs().zzao("Scheduling upload with AlarmManager");
        this.b.setInexactRepeating(2, elapsedRealtime, Math.max(zzak.zzgx.get(null).longValue(), j), f());
    }

    private final int e() {
        if (this.d == null) {
            String valueOf = String.valueOf(getContext().getPackageName());
            this.d = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.d.intValue();
    }

    public final void cancel() {
        c();
        this.b.cancel(f());
        this.c.c();
        if (Build.VERSION.SDK_INT >= 24) {
            d();
        }
    }

    private final PendingIntent f() {
        Context context = getContext();
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }

    @Override // com.google.android.gms.measurement.internal.go
    public final /* bridge */ /* synthetic */ zzjo zzgw() {
        return super.zzgw();
    }

    @Override // com.google.android.gms.measurement.internal.go
    public final /* bridge */ /* synthetic */ hb zzgx() {
        return super.zzgx();
    }

    @Override // com.google.android.gms.measurement.internal.go
    public final /* bridge */ /* synthetic */ he zzgy() {
        return super.zzgy();
    }

    @Override // com.google.android.gms.measurement.internal.go
    public final /* bridge */ /* synthetic */ zzfd zzgz() {
        return super.zzgz();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ cz zzac() {
        return super.zzac();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
