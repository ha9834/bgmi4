package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcla extends zzamw implements zzbsm {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private zzamv f3304a;

    @GuardedBy("this")
    private zzbsn b;

    public final synchronized void zza(zzamv zzamvVar) {
        this.f3304a = zzamvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final synchronized void zza(zzbsn zzbsnVar) {
        this.b = zzbsnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAdClicked() throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAdClosed() throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.onAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAdFailedToLoad(int i) throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.onAdFailedToLoad(i);
        }
        if (this.b != null) {
            this.b.onAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAdLeftApplication() throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.onAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAdOpened() throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.onAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAdLoaded() throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.onAdLoaded();
        }
        if (this.b != null) {
            this.b.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void zza(zzamy zzamyVar) throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.zza(zzamyVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAdImpression() throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onAppEvent(String str, String str2) throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.onAppEvent(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void zza(zzafe zzafeVar, String str) throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.zza(zzafeVar, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onVideoEnd() throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.onVideoEnd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void zzcz(String str) throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.zzcz(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void zzsm() throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.zzsm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onVideoPlay() throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.onVideoPlay();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void zzb(zzato zzatoVar) throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.zzb(zzatoVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void onVideoPause() throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.onVideoPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.zzb(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void zzsn() throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.zzsn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void zzcs(int i) throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.zzcs(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final synchronized void zza(zzatq zzatqVar) throws RemoteException {
        if (this.f3304a != null) {
            this.f3304a.zza(zzatqVar);
        }
    }
}
