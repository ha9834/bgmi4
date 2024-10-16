package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
/* loaded from: classes2.dex */
public final class zzatj implements RewardedVideoAd {

    /* renamed from: a, reason: collision with root package name */
    private final zzasw f2801a;
    private final Context b;
    private final Object c = new Object();
    private final zzatg d = new zzatg(null);
    private String e;
    private String f;

    public zzatj(Context context, zzasw zzaswVar) {
        this.f2801a = zzaswVar == null ? new zzabx() : zzaswVar;
        this.b = context.getApplicationContext();
    }

    private final void a(String str, zzaaz zzaazVar) {
        synchronized (this.c) {
            if (this.f2801a == null) {
                return;
            }
            try {
                this.f2801a.zza(new zzath(zzyc.zza(this.b, zzaazVar), str));
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, AdRequest adRequest) {
        a(str, adRequest.zzde());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        a(str, publisherAdRequest.zzde());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void show() {
        synchronized (this.c) {
            if (this.f2801a == null) {
                return;
            }
            try {
                this.f2801a.show();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.c) {
            this.d.setRewardedVideoAdListener(rewardedVideoAdListener);
            if (this.f2801a != null) {
                try {
                    this.f2801a.zza(this.d);
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.c) {
            if (this.f2801a != null) {
                try {
                    this.f2801a.zza(new zzxy(adMetadataListener));
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final Bundle getAdMetadata() {
        synchronized (this.c) {
            if (this.f2801a != null) {
                try {
                    return this.f2801a.getAdMetadata();
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
            return new Bundle();
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setUserId(String str) {
        synchronized (this.c) {
            this.e = str;
            if (this.f2801a != null) {
                try {
                    this.f2801a.setUserId(str);
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final boolean isLoaded() {
        synchronized (this.c) {
            if (this.f2801a == null) {
                return false;
            }
            try {
                return this.f2801a.isLoaded();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause() {
        pause(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause(Context context) {
        synchronized (this.c) {
            if (this.f2801a == null) {
                return;
            }
            try {
                this.f2801a.zzl(ObjectWrapper.wrap(context));
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume() {
        resume(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume(Context context) {
        synchronized (this.c) {
            if (this.f2801a == null) {
                return;
            }
            try {
                this.f2801a.zzm(ObjectWrapper.wrap(context));
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy() {
        destroy(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy(Context context) {
        synchronized (this.c) {
            this.d.setRewardedVideoAdListener(null);
            if (this.f2801a == null) {
                return;
            }
            try {
                this.f2801a.zzn(ObjectWrapper.wrap(context));
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.c) {
            rewardedVideoAdListener = this.d.getRewardedVideoAdListener();
        }
        return rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getUserId() {
        String str;
        synchronized (this.c) {
            str = this.e;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getMediationAdapterClassName() {
        try {
            if (this.f2801a != null) {
                return this.f2801a.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setImmersiveMode(boolean z) {
        synchronized (this.c) {
            if (this.f2801a != null) {
                try {
                    this.f2801a.setImmersiveMode(z);
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setCustomData(String str) {
        synchronized (this.c) {
            if (this.f2801a != null) {
                try {
                    this.f2801a.setCustomData(str);
                    this.f = str;
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getCustomData() {
        String str;
        synchronized (this.c) {
            str = this.f;
        }
        return str;
    }
}
