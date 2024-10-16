package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzabd;
import com.google.android.gms.internal.ads.zzxr;

/* loaded from: classes.dex */
public final class InterstitialAd {

    /* renamed from: a, reason: collision with root package name */
    private final zzabd f1125a;

    public InterstitialAd(Context context) {
        this.f1125a = new zzabd(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.f1125a.getAdListener();
    }

    public final String getAdUnitId() {
        return this.f1125a.getAdUnitId();
    }

    public final boolean isLoaded() {
        return this.f1125a.isLoaded();
    }

    public final boolean isLoading() {
        return this.f1125a.isLoading();
    }

    public final void loadAd(AdRequest adRequest) {
        this.f1125a.zza(adRequest.zzde());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setAdListener(AdListener adListener) {
        this.f1125a.setAdListener(adListener);
        if (adListener != 0 && (adListener instanceof zzxr)) {
            this.f1125a.zza((zzxr) adListener);
        } else if (adListener == 0) {
            this.f1125a.zza((zzxr) null);
        }
    }

    public final void setAdUnitId(String str) {
        this.f1125a.setAdUnitId(str);
    }

    public final String getMediationAdapterClassName() {
        return this.f1125a.getMediationAdapterClassName();
    }

    public final void show() {
        this.f1125a.show();
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f1125a.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        this.f1125a.setAdMetadataListener(adMetadataListener);
    }

    public final Bundle getAdMetadata() {
        return this.f1125a.getAdMetadata();
    }

    public final void zzc(boolean z) {
        this.f1125a.zzc(true);
    }

    public final void setImmersiveMode(boolean z) {
        this.f1125a.setImmersiveMode(z);
    }
}
