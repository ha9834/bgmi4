package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaug;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class RewardedAd {

    /* renamed from: a, reason: collision with root package name */
    private final zzaug f1179a;

    public RewardedAd(Context context, String str) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(str, "adUnitID cannot be null");
        this.f1179a = new zzaug(context, str);
    }

    public final void loadAd(AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.f1179a.zza(adRequest.zzde(), rewardedAdLoadCallback);
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.f1179a.zza(publisherAdRequest.zzde(), rewardedAdLoadCallback);
    }

    public final String getMediationAdapterClassName() {
        return this.f1179a.getMediationAdapterClassName();
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f1179a.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.f1179a.setOnAdMetadataChangedListener(onAdMetadataChangedListener);
    }

    public final Bundle getAdMetadata() {
        return this.f1179a.getAdMetadata();
    }

    public final boolean isLoaded() {
        return this.f1179a.isLoaded();
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        this.f1179a.show(activity, rewardedAdCallback);
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        this.f1179a.show(activity, rewardedAdCallback, z);
    }

    @Nullable
    public final RewardItem getRewardItem() {
        return this.f1179a.getRewardItem();
    }
}
