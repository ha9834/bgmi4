package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzcwu implements zzcva<zzcwt> {

    /* renamed from: a, reason: collision with root package name */
    private zzaqm f3482a;
    private ScheduledExecutorService b;
    private Context c;

    public zzcwu(zzaqm zzaqmVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.f3482a = zzaqmVar;
        this.b = scheduledExecutorService;
        this.c = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcwt> zzalm() {
        return zzbar.zza(zzbar.zza(this.f3482a.zzn(this.c), ((Long) zzyt.zzpe().zzd(zzacu.zzctg)).longValue(), TimeUnit.MILLISECONDS, this.b), aaa.f1752a, zzaxg.zzdvp);
    }
}
