package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;

@zzard
/* loaded from: classes2.dex */
public final class zzatg extends zzatc {

    /* renamed from: a, reason: collision with root package name */
    private RewardedVideoAdListener f2800a;

    public zzatg(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f2800a = rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdLoaded() {
        RewardedVideoAdListener rewardedVideoAdListener = this.f2800a;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdOpened() {
        RewardedVideoAdListener rewardedVideoAdListener = this.f2800a;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoStarted() {
        RewardedVideoAdListener rewardedVideoAdListener = this.f2800a;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoStarted();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdClosed() {
        RewardedVideoAdListener rewardedVideoAdListener = this.f2800a;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void zza(zzasr zzasrVar) {
        RewardedVideoAdListener rewardedVideoAdListener = this.f2800a;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewarded(new zzate(zzasrVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdLeftApplication() {
        RewardedVideoAdListener rewardedVideoAdListener = this.f2800a;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdFailedToLoad(int i) {
        RewardedVideoAdListener rewardedVideoAdListener = this.f2800a;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoCompleted() {
        RewardedVideoAdListener rewardedVideoAdListener = this.f2800a;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoCompleted();
        }
    }

    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        return this.f2800a;
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f2800a = rewardedVideoAdListener;
    }
}
