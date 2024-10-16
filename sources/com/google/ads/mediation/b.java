package com.google.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;

/* loaded from: classes.dex */
final class b extends AdMetadataListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AbstractAdViewAdapter f1112a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f1112a = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        InterstitialAd interstitialAd;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        InterstitialAd interstitialAd2;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener2;
        interstitialAd = this.f1112a.zzmh;
        if (interstitialAd != null) {
            mediationRewardedVideoAdListener = this.f1112a.zzmi;
            if (mediationRewardedVideoAdListener != null) {
                interstitialAd2 = this.f1112a.zzmh;
                Bundle adMetadata = interstitialAd2.getAdMetadata();
                mediationRewardedVideoAdListener2 = this.f1112a.zzmi;
                mediationRewardedVideoAdListener2.zzb(adMetadata);
            }
        }
    }
}
