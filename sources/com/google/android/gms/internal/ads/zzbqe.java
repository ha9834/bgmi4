package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes2.dex */
public final class zzbqe implements zzbrl, zzbrw, zzbsr, zzbtk, zzxr {

    /* renamed from: a, reason: collision with root package name */
    private final Clock f3006a;
    private final zzawj b;

    public zzbqe(Clock clock, zzawj zzawjVar) {
        this.f3006a = clock;
        this.b = zzawjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdOpened() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzb(zzarx zzarxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void zzb(zzasr zzasrVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final void onAdClicked() {
        this.b.zzuk();
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        this.b.zzah(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final void onAdImpression() {
        this.b.zzuj();
    }

    public final void zzf(zzxz zzxzVar) {
        this.b.zze(zzxzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zza(zzcxu zzcxuVar) {
        this.b.zzfb(this.f3006a.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdClosed() {
        this.b.zzul();
    }

    public final String zzum() {
        return this.b.zzum();
    }
}
