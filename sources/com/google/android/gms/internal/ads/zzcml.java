package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbqy;

/* loaded from: classes2.dex */
public final class zzcml extends zzcmn<zzbph> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbjm f3321a;
    private final zzbxk b;
    private final zzbqy.zza c;
    private final zzbtv d;

    public zzcml(zzbjm zzbjmVar, zzbxk zzbxkVar, zzbqy.zza zzaVar, zzbtv zzbtvVar) {
        this.f3321a = zzbjmVar;
        this.b = zzbxkVar;
        this.c = zzaVar;
        this.d = zzbtvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcmn
    protected final zzbbh<zzbph> a(zzcxv zzcxvVar, Bundle bundle) {
        return this.f3321a.zzacl().zza(this.c.zza(zzcxvVar).zze(bundle).zzagh()).zza(this.d).zza(this.b).zzacy().zzada();
    }
}
