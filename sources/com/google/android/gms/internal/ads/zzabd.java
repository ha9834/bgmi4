package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
/* loaded from: classes2.dex */
public final class zzabd {

    /* renamed from: a, reason: collision with root package name */
    private final zzamo f2686a;
    private final Context b;
    private final zzyc c;
    private AdListener d;
    private zzxr e;
    private zzzk f;
    private String g;
    private AdMetadataListener h;
    private AppEventListener i;
    private OnCustomRenderedAdLoadedListener j;
    private Correlator k;
    private RewardedVideoAdListener l;
    private boolean m;
    private boolean n;

    public zzabd(Context context) {
        this(context, zzyc.zzche, null);
    }

    public zzabd(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzyc.zzche, publisherInterstitialAd);
    }

    @VisibleForTesting
    private zzabd(Context context, zzyc zzycVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.f2686a = new zzamo();
        this.b = context;
        this.c = zzycVar;
    }

    public final AdListener getAdListener() {
        return this.d;
    }

    public final String getAdUnitId() {
        return this.g;
    }

    public final AppEventListener getAppEventListener() {
        return this.i;
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.j;
    }

    public final boolean isLoaded() {
        try {
            if (this.f == null) {
                return false;
            }
            return this.f.isReady();
        } catch (RemoteException e) {
            zzbad.zze("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.f == null) {
                return false;
            }
            return this.f.isLoading();
        } catch (RemoteException e) {
            zzbad.zze("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    public final void zza(zzaaz zzaazVar) {
        try {
            if (this.f == null) {
                if (this.g == null) {
                    a("loadAd");
                }
                zzyd zzou = this.m ? zzyd.zzou() : new zzyd();
                zzyh zzpb = zzyt.zzpb();
                Context context = this.b;
                this.f = new aqh(zzpb, context, zzou, this.g, this.f2686a).a(context, false);
                if (this.d != null) {
                    this.f.zzb(new zzxv(this.d));
                }
                if (this.e != null) {
                    this.f.zza(new zzxs(this.e));
                }
                if (this.h != null) {
                    this.f.zza(new zzxy(this.h));
                }
                if (this.i != null) {
                    this.f.zza(new zzyf(this.i));
                }
                if (this.j != null) {
                    this.f.zza(new zzadr(this.j));
                }
                if (this.k != null) {
                    this.f.zzb(this.k.zzdf());
                }
                if (this.l != null) {
                    this.f.zza(new zzatg(this.l));
                }
                this.f.setImmersiveMode(this.n);
            }
            if (this.f.zzb(zzyc.zza(this.b, zzaazVar))) {
                this.f2686a.zzf(zzaazVar.zzqa());
            }
        } catch (RemoteException e) {
            zzbad.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.d = adListener;
            if (this.f != null) {
                this.f.zzb(adListener != null ? new zzxv(adListener) : null);
            }
        } catch (RemoteException e) {
            zzbad.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void zza(zzxr zzxrVar) {
        try {
            this.e = zzxrVar;
            if (this.f != null) {
                this.f.zza(zzxrVar != null ? new zzxs(zzxrVar) : null);
            }
        } catch (RemoteException e) {
            zzbad.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.g != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.g = str;
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        try {
            this.h = adMetadataListener;
            if (this.f != null) {
                this.f.zza(adMetadataListener != null ? new zzxy(adMetadataListener) : null);
            }
        } catch (RemoteException e) {
            zzbad.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final Bundle getAdMetadata() {
        try {
            if (this.f != null) {
                return this.f.getAdMetadata();
            }
        } catch (RemoteException e) {
            zzbad.zze("#008 Must be called on the main UI thread.", e);
        }
        return new Bundle();
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.i = appEventListener;
            if (this.f != null) {
                this.f.zza(appEventListener != null ? new zzyf(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzbad.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.j = onCustomRenderedAdLoadedListener;
            if (this.f != null) {
                this.f.zza(onCustomRenderedAdLoadedListener != null ? new zzadr(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzbad.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setCorrelator(Correlator correlator) {
        this.k = correlator;
        try {
            if (this.f != null) {
                this.f.zzb(this.k == null ? null : this.k.zzdf());
            }
        } catch (RemoteException e) {
            zzbad.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.l = rewardedVideoAdListener;
            if (this.f != null) {
                this.f.zza(rewardedVideoAdListener != null ? new zzatg(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzbad.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void zzc(boolean z) {
        this.m = true;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.f != null) {
                return this.f.zzpj();
            }
            return null;
        } catch (RemoteException e) {
            zzbad.zze("#008 Must be called on the main UI thread.", e);
            return null;
        }
    }

    public final void show() {
        try {
            a("show");
            this.f.showInterstitial();
        } catch (RemoteException e) {
            zzbad.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.n = z;
            if (this.f != null) {
                this.f.setImmersiveMode(z);
            }
        } catch (RemoteException e) {
            zzbad.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    private final void a(String str) {
        if (this.f != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
        sb.append("The ad unit ID must be set on InterstitialAd before ");
        sb.append(str);
        sb.append(" is called.");
        throw new IllegalStateException(sb.toString());
    }
}
