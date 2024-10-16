package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
/* loaded from: classes2.dex */
public final class zzatn implements MediationRewardedVideoAdListener {

    /* renamed from: a, reason: collision with root package name */
    private final zzatk f2802a;

    public zzatn(zzatk zzatkVar) {
        this.f2802a = zzatkVar;
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onInitializationSucceeded.");
        try {
            this.f2802a.zzae(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onInitializationFailed.");
        try {
            this.f2802a.zzd(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onAdLoaded.");
        try {
            this.f2802a.zzaf(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onAdOpened.");
        try {
            this.f2802a.zzag(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onVideoStarted.");
        try {
            this.f2802a.zzah(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onAdClosed.");
        try {
            this.f2802a.zzai(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onRewarded.");
        try {
            if (rewardItem != null) {
                this.f2802a.zza(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter), new zzato(rewardItem));
            } else {
                this.f2802a.zza(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter), new zzato("", 1));
            }
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onAdClicked.");
        try {
            this.f2802a.zzaj(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onAdFailedToLoad.");
        try {
            this.f2802a.zze(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onAdLeftApplication.");
        try {
            this.f2802a.zzak(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onVideoCompleted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onVideoCompleted.");
        try {
            this.f2802a.zzal(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void zzb(Bundle bundle) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbad.zzdp("Adapter called onAdMetadataChanged.");
        try {
            this.f2802a.zzb(bundle);
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
