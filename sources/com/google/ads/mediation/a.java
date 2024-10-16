package com.google.ads.mediation;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements RewardedVideoAdListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AbstractAdViewAdapter f1111a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f1111a = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdLoaded() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.f1111a.zzmi;
        mediationRewardedVideoAdListener.onAdLoaded(this.f1111a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdOpened() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.f1111a.zzmi;
        mediationRewardedVideoAdListener.onAdOpened(this.f1111a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoStarted() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.f1111a.zzmi;
        mediationRewardedVideoAdListener.onVideoStarted(this.f1111a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdClosed() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.f1111a.zzmi;
        mediationRewardedVideoAdListener.onAdClosed(this.f1111a);
        AbstractAdViewAdapter.zza(this.f1111a, (InterstitialAd) null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewarded(RewardItem rewardItem) {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.f1111a.zzmi;
        mediationRewardedVideoAdListener.onRewarded(this.f1111a, rewardItem);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdLeftApplication() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.f1111a.zzmi;
        mediationRewardedVideoAdListener.onAdLeftApplication(this.f1111a);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdFailedToLoad(int i) {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.f1111a.zzmi;
        mediationRewardedVideoAdListener.onAdFailedToLoad(this.f1111a, i);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoCompleted() {
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener = this.f1111a.zzmi;
        mediationRewardedVideoAdListener.onVideoCompleted(this.f1111a);
    }
}
