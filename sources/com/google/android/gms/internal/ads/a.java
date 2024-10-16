package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a extends zzyv {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzabb f1750a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zzabb zzabbVar) {
        this.f1750a = zzabbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyv, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        VideoController videoController;
        videoController = this.f1750a.d;
        videoController.zza(this.f1750a.zzdh());
        super.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzyv, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(int i) {
        VideoController videoController;
        videoController = this.f1750a.d;
        videoController.zza(this.f1750a.zzdh());
        super.onAdFailedToLoad(i);
    }
}
