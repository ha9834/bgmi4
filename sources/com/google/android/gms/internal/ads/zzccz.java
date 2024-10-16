package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* loaded from: classes.dex */
public final class zzccz implements zzahy {

    /* renamed from: a, reason: collision with root package name */
    private final zzbse f3188a;

    @Nullable
    private final zzato b;
    private final String c;
    private final String d;

    public zzccz(zzbse zzbseVar, zzcxm zzcxmVar) {
        this.f3188a = zzbseVar;
        this.b = zzcxmVar.zzdnx;
        this.c = zzcxmVar.zzdeu;
        this.d = zzcxmVar.zzdev;
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    public final void zzrq() {
        this.f3188a.onRewardedVideoStarted();
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    @ParametersAreNonnullByDefault
    public final void zza(zzato zzatoVar) {
        int i;
        String str = "";
        zzato zzatoVar2 = this.b;
        if (zzatoVar2 != null) {
            zzatoVar = zzatoVar2;
        }
        if (zzatoVar != null) {
            str = zzatoVar.type;
            i = zzatoVar.zzdqm;
        } else {
            i = 1;
        }
        this.f3188a.zzb(new zzasp(str, i), this.c, this.d);
    }

    @Override // com.google.android.gms.internal.ads.zzahy
    public final void zzrr() {
        this.f3188a.onRewardedVideoCompleted();
    }
}
