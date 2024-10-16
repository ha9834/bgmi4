package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzbme implements zzbrl, zzbrw, zzbsr, zzxr {

    /* renamed from: a, reason: collision with root package name */
    private final zzcxu f2930a;
    private final zzcxm b;
    private final zzdae c;

    @GuardedBy("this")
    private boolean d;

    @GuardedBy("this")
    private boolean e;

    public zzbme(zzcxu zzcxuVar, zzcxm zzcxmVar, zzdae zzdaeVar) {
        this.f2930a = zzcxuVar;
        this.b = zzcxmVar;
        this.c = zzdaeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdOpened() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final synchronized void onAdLoaded() {
        if (this.d) {
            ArrayList arrayList = new ArrayList(this.b.zzdff);
            arrayList.addAll(this.b.zzgka);
            this.c.zza(this.f2930a, this.b, true, (List<String>) arrayList);
        } else {
            this.c.zza(this.f2930a, this.b, this.b.zzgkc);
            this.c.zza(this.f2930a, this.b, this.b.zzgka);
        }
        this.d = true;
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final void onAdClicked() {
        zzdae zzdaeVar = this.c;
        zzcxu zzcxuVar = this.f2930a;
        zzcxm zzcxmVar = this.b;
        zzdaeVar.zza(zzcxuVar, zzcxmVar, zzcxmVar.zzdfe);
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final synchronized void onAdImpression() {
        if (!this.e) {
            this.c.zza(this.f2930a, this.b, this.b.zzdff);
            this.e = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void zzb(zzasr zzasrVar, String str, String str2) {
        zzdae zzdaeVar = this.c;
        zzcxu zzcxuVar = this.f2930a;
        zzcxm zzcxmVar = this.b;
        zzdaeVar.zza(zzcxuVar, zzcxmVar, zzcxmVar.zzdnz, zzasrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoStarted() {
        zzdae zzdaeVar = this.c;
        zzcxu zzcxuVar = this.f2930a;
        zzcxm zzcxmVar = this.b;
        zzdaeVar.zza(zzcxuVar, zzcxmVar, zzcxmVar.zzdny);
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoCompleted() {
        zzdae zzdaeVar = this.c;
        zzcxu zzcxuVar = this.f2930a;
        zzcxm zzcxmVar = this.b;
        zzdaeVar.zza(zzcxuVar, zzcxmVar, zzcxmVar.zzgkb);
    }
}
