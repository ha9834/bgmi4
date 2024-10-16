package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

@zzard
/* loaded from: classes2.dex */
public final class zzaul extends zzauc {

    /* renamed from: a, reason: collision with root package name */
    private final RewardedAdLoadCallback f2806a;

    public zzaul(RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.f2806a = rewardedAdLoadCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzaub
    public final void onRewardedAdLoaded() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.f2806a;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaub
    public final void onRewardedAdFailedToLoad(int i) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.f2806a;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdFailedToLoad(i);
        }
    }
}
