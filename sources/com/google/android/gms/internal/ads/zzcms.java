package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbqy;

/* loaded from: classes2.dex */
public final class zzcms extends zzcmn<zzcdb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbjm f3327a;
    private final zzbqy.zza b;
    private final zzbtv c;

    public zzcms(zzbjm zzbjmVar, zzbqy.zza zzaVar, zzbtv zzbtvVar) {
        this.f3327a = zzbjmVar;
        this.b = zzaVar;
        this.c = zzbtvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcmn
    protected final zzbbh<zzcdb> a(zzcxv zzcxvVar, Bundle bundle) {
        return this.f3327a.zzacm().zzd(this.b.zza(zzcxvVar).zze(bundle).zzagh()).zzd(this.c).zzaeh().zzadu();
    }
}
