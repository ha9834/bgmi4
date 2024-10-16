package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzcwq implements zzcva<zzcwp> {

    /* renamed from: a, reason: collision with root package name */
    private zzamg f3479a;
    private ScheduledExecutorService b;
    private boolean c;
    private ApplicationInfo d;

    public zzcwq(zzamg zzamgVar, ScheduledExecutorService scheduledExecutorService, boolean z, ApplicationInfo applicationInfo) {
        this.f3479a = zzamgVar;
        this.b = scheduledExecutorService;
        this.c = z;
        this.d = applicationInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcwp> zzalm() {
        if (!this.c) {
            return zzbar.zzd(new Exception("Auto Collect Location is false."));
        }
        return zzbar.zza(zzbar.zza(this.f3479a.zza(this.d), ((Long) zzyt.zzpe().zzd(zzacu.zzcsq)).longValue(), TimeUnit.MILLISECONDS, this.b), zz.f2679a, zzaxg.zzdvp);
    }
}
