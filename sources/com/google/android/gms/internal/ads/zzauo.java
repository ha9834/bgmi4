package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.common.internal.Preconditions;

@zzard
/* loaded from: classes2.dex */
public final class zzauo implements MediationRewardedAdCallback {

    /* renamed from: a, reason: collision with root package name */
    private final zzamv f2807a;

    public zzauo(zzamv zzamvVar) {
        this.f2807a = zzamvVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void onAdOpened() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onAdOpened.");
        try {
            this.f2807a.onAdOpened();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void onAdClosed() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onAdClosed.");
        try {
            this.f2807a.onAdClosed();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onUserEarnedReward(RewardItem rewardItem) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onUserEarnedReward.");
        try {
            this.f2807a.zza(new zzaup(rewardItem));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void reportAdClicked() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called reportAdClicked.");
        try {
            this.f2807a.onAdClicked();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void reportAdImpression() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called reportAdImpression.");
        try {
            this.f2807a.onAdImpression();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onAdFailedToShow(String str) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onAdFailedToShow.");
        String valueOf = String.valueOf(str);
        zzbad.zzep(valueOf.length() != 0 ? "Mediation ad failed to show: ".concat(valueOf) : new String("Mediation ad failed to show: "));
        try {
            this.f2807a.zzcs(0);
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onVideoStart() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onVideoStart.");
        try {
            this.f2807a.zzsm();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onVideoComplete() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onVideoComplete.");
        try {
            this.f2807a.zzsn();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
