package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcqc implements zzbrl, zzbro, zzbsr {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private zzatb f3375a;

    @GuardedBy("this")
    private zzasu b;

    public final synchronized void zzb(zzatb zzatbVar) {
        this.f3375a = zzatbVar;
    }

    public final synchronized void zzb(zzasu zzasuVar) {
        this.b = zzasuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdClosed() {
        if (this.f3375a != null) {
            try {
                this.f3375a.onRewardedVideoAdClosed();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdClosed.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final synchronized void onAdFailedToLoad(int i) {
        if (this.f3375a != null) {
            try {
                this.f3375a.onRewardedVideoAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdFailedToLoad.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdLeftApplication() {
        if (this.f3375a != null) {
            try {
                this.f3375a.onRewardedVideoAdLeftApplication();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdLeftApplication.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final synchronized void onAdLoaded() {
        if (this.f3375a != null) {
            try {
                this.f3375a.onRewardedVideoAdLoaded();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdLoaded.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdOpened() {
        if (this.f3375a != null) {
            try {
                this.f3375a.onRewardedVideoAdOpened();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onAdOpened.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onRewardedVideoStarted() {
        if (this.f3375a != null) {
            try {
                this.f3375a.onRewardedVideoStarted();
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onRewardedVideoStarted.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void zzb(zzasr zzasrVar, String str, String str2) {
        if (this.f3375a != null) {
            try {
                this.f3375a.zza(zzasrVar);
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception at onRewarded.", e);
            }
        }
        if (this.b != null) {
            try {
                this.b.zza(zzasrVar, str, str2);
            } catch (RemoteException e2) {
                zzbad.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onRewardedVideoCompleted() {
        if (this.f3375a != null) {
            try {
                this.f3375a.onRewardedVideoCompleted();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
