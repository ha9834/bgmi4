package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes2.dex */
public final class zzbqr implements zzbtk {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3015a;
    private final zzcxv b;
    private final zzbai c;
    private final zzaxb d;
    private final zzcgb e;

    public zzbqr(Context context, zzcxv zzcxvVar, zzbai zzbaiVar, zzaxb zzaxbVar, zzcgb zzcgbVar) {
        this.f3015a = context;
        this.b = zzcxvVar;
        this.c = zzbaiVar;
        this.d = zzaxbVar;
        this.e = zzcgbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zza(zzcxu zzcxuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzb(zzarx zzarxVar) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcsv)).booleanValue()) {
            zzk.zzlo().zza(this.f3015a, this.c, this.b.zzglb, this.d.zzvr());
        }
        this.e.d();
    }
}
