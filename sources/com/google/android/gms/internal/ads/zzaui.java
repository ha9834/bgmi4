package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdCallback;

@zzard
/* loaded from: classes2.dex */
public final class zzaui extends zzatx {

    /* renamed from: a, reason: collision with root package name */
    private final RewardedAdCallback f2805a;

    public zzaui(RewardedAdCallback rewardedAdCallback) {
        this.f2805a = rewardedAdCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void onRewardedAdOpened() {
        RewardedAdCallback rewardedAdCallback = this.f2805a;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void onRewardedAdClosed() {
        RewardedAdCallback rewardedAdCallback = this.f2805a;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void zza(zzatq zzatqVar) {
        RewardedAdCallback rewardedAdCallback = this.f2805a;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onUserEarnedReward(new zzauh(zzatqVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void onRewardedAdFailedToShow(int i) {
        RewardedAdCallback rewardedAdCallback = this.f2805a;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(i);
        }
    }
}
