package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@zzard
/* loaded from: classes2.dex */
public final class zzanu<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {

    /* renamed from: a, reason: collision with root package name */
    private final zzamv f2770a;

    public zzanu(zzamv zzamvVar) {
        this.f2770a = zzamvVar;
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbad.zzdp("Adapter called onClick.");
        zzyt.zzpa();
        if (!zzazt.zzwy()) {
            zzbad.zze("#008 Must be called on the main UI thread.", null);
            zzazt.zzyr.post(new cu(this));
        } else {
            try {
                this.f2770a.onAdClicked();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbad.zzdp("Adapter called onDismissScreen.");
        zzyt.zzpa();
        if (!zzazt.zzwy()) {
            zzbad.zzep("#008 Must be called on the main UI thread.");
            zzazt.zzyr.post(new cx(this));
        } else {
            try {
                this.f2770a.onAdClosed();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzbad.zzdp(sb.toString());
        zzyt.zzpa();
        if (!zzazt.zzwy()) {
            zzbad.zze("#008 Must be called on the main UI thread.", null);
            zzazt.zzyr.post(new cy(this, errorCode));
        } else {
            try {
                this.f2770a.onAdFailedToLoad(zzaog.zza(errorCode));
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbad.zzdp("Adapter called onLeaveApplication.");
        zzyt.zzpa();
        if (!zzazt.zzwy()) {
            zzbad.zze("#008 Must be called on the main UI thread.", null);
            zzazt.zzyr.post(new da(this));
        } else {
            try {
                this.f2770a.onAdLeftApplication();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbad.zzdp("Adapter called onPresentScreen.");
        zzyt.zzpa();
        if (!zzazt.zzwy()) {
            zzbad.zze("#008 Must be called on the main UI thread.", null);
            zzazt.zzyr.post(new db(this));
        } else {
            try {
                this.f2770a.onAdOpened();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbad.zzdp("Adapter called onReceivedAd.");
        zzyt.zzpa();
        if (!zzazt.zzwy()) {
            zzbad.zze("#008 Must be called on the main UI thread.", null);
            zzazt.zzyr.post(new dc(this));
        } else {
            try {
                this.f2770a.onAdLoaded();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbad.zzdp("Adapter called onDismissScreen.");
        zzyt.zzpa();
        if (!zzazt.zzwy()) {
            zzbad.zze("#008 Must be called on the main UI thread.", null);
            zzazt.zzyr.post(new dd(this));
        } else {
            try {
                this.f2770a.onAdClosed();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(".");
        zzbad.zzdp(sb.toString());
        zzyt.zzpa();
        if (!zzazt.zzwy()) {
            zzbad.zze("#008 Must be called on the main UI thread.", null);
            zzazt.zzyr.post(new de(this, errorCode));
        } else {
            try {
                this.f2770a.onAdFailedToLoad(zzaog.zza(errorCode));
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbad.zzdp("Adapter called onLeaveApplication.");
        zzyt.zzpa();
        if (!zzazt.zzwy()) {
            zzbad.zze("#008 Must be called on the main UI thread.", null);
            zzazt.zzyr.post(new df(this));
        } else {
            try {
                this.f2770a.onAdLeftApplication();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbad.zzdp("Adapter called onPresentScreen.");
        zzyt.zzpa();
        if (!zzazt.zzwy()) {
            zzbad.zze("#008 Must be called on the main UI thread.", null);
            zzazt.zzyr.post(new cv(this));
        } else {
            try {
                this.f2770a.onAdOpened();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbad.zzdp("Adapter called onReceivedAd.");
        zzyt.zzpa();
        if (!zzazt.zzwy()) {
            zzbad.zze("#008 Must be called on the main UI thread.", null);
            zzazt.zzyr.post(new cw(this));
        } else {
            try {
                this.f2770a.onAdLoaded();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
