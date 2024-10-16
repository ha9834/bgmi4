package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public final class zzae extends zzan {

    /* renamed from: a, reason: collision with root package name */
    private final n f4384a;

    public zzae(zzap zzapVar, zzar zzarVar) {
        super(zzapVar);
        Preconditions.checkNotNull(zzarVar);
        this.f4384a = new n(zzapVar, zzarVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
        this.f4384a.zzag();
    }

    public final void start() {
        this.f4384a.b();
    }

    public final void setLocalDispatchPeriod(int i) {
        q();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(i));
        h().zza(new a(this, i));
    }

    public final long zza(zzas zzasVar) {
        q();
        Preconditions.checkNotNull(zzasVar);
        com.google.android.gms.analytics.zzk.zzav();
        long a2 = this.f4384a.a(zzasVar, true);
        if (a2 == 0) {
            this.f4384a.a(zzasVar);
        }
        return a2;
    }

    public final void zza(zzcd zzcdVar) {
        Preconditions.checkNotNull(zzcdVar);
        q();
        zzb("Hit delivery requested", zzcdVar);
        h().zza(new d(this, zzcdVar));
    }

    public final void zzch() {
        q();
        h().zza(new e(this));
    }

    public final void zza(zzbw zzbwVar) {
        q();
        h().zza(new f(this, zzbwVar));
    }

    public final void zzci() {
        q();
        Context e = e();
        if (zzcp.zza(e) && zzcq.zze(e)) {
            Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent.setComponent(new ComponentName(e, "com.google.android.gms.analytics.AnalyticsService"));
            e.startService(intent);
            return;
        }
        zza((zzbw) null);
    }

    public final boolean zzcj() {
        q();
        try {
            h().zza(new g(this)).get(4L, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            zzd("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            zze("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            zzd("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }

    public final void zzck() {
        q();
        com.google.android.gms.analytics.zzk.zzav();
        n nVar = this.f4384a;
        com.google.android.gms.analytics.zzk.zzav();
        nVar.q();
        nVar.zzq("Service disconnected");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        com.google.android.gms.analytics.zzk.zzav();
        this.f4384a.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        com.google.android.gms.analytics.zzk.zzav();
        this.f4384a.r();
    }

    public final void zza(String str, Runnable runnable) {
        Preconditions.checkNotEmpty(str, "campaign param can't be empty");
        h().zza(new c(this, str, runnable));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ n a(zzae zzaeVar) {
        return zzaeVar.f4384a;
    }
}
