package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbqy;

/* loaded from: classes2.dex */
public final class zzcmq extends zzcmn<zzbvx> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbjm f3325a;
    private final zzbqy.zza b;
    private final zzcow c;
    private final zzbtv d;

    public zzcmq(zzbjm zzbjmVar, zzbqy.zza zzaVar, zzcow zzcowVar, zzbtv zzbtvVar) {
        this.f3325a = zzbjmVar;
        this.b = zzaVar;
        this.c = zzcowVar;
        this.d = zzbtvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcmn
    protected final zzbbh<zzbvx> a(zzcxv zzcxvVar, Bundle bundle) {
        return this.f3325a.zzack().zzc(this.b.zza(zzcxvVar).zze(bundle).zzagh()).zzc(this.d).zzb(this.c).zzaed().zzadu();
    }
}
