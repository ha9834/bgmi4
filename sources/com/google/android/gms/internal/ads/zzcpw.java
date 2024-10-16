package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcpw implements zzbrl, zzbro, zzbrw, zzbsr, zzxr {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private zzyz f3369a;

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void zzb(zzasr zzasrVar, String str, String str2) {
    }

    public final synchronized void zzc(zzyz zzyzVar) {
        this.f3369a = zzyzVar;
    }

    public final synchronized zzyz zzald() {
        return this.f3369a;
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdClosed() {
        if (this.f3369a != null) {
            try {
                this.f3369a.onAdClosed();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdClosed.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final synchronized void onAdFailedToLoad(int i) {
        if (this.f3369a != null) {
            try {
                this.f3369a.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdFailedToLoad.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdLeftApplication() {
        if (this.f3369a != null) {
            try {
                this.f3369a.onAdLeftApplication();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdLeftApplication.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final synchronized void onAdLoaded() {
        if (this.f3369a != null) {
            try {
                this.f3369a.onAdLoaded();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdLoaded.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdOpened() {
        if (this.f3369a != null) {
            try {
                this.f3369a.onAdOpened();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdOpened.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final synchronized void onAdClicked() {
        if (this.f3369a != null) {
            try {
                this.f3369a.onAdClicked();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final synchronized void onAdImpression() {
        if (this.f3369a != null) {
            try {
                this.f3369a.onAdImpression();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdImpression.", e);
            }
        }
    }
}
