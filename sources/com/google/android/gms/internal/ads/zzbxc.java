package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbxc implements zzbrl {

    /* renamed from: a, reason: collision with root package name */
    private final zzbrt f3097a;
    private final zzcxm b;

    public zzbxc(zzbrt zzbrtVar, zzcxm zzcxmVar) {
        this.f3097a = zzbrtVar;
        this.b = zzcxmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void zzb(zzasr zzasrVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdOpened() {
        if (this.b.zzgkp == 0 || this.b.zzgkp == 1) {
            this.f3097a.onAdImpression();
        }
    }
}
