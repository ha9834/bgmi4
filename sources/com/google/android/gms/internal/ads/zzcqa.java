package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcqa implements zzbrl, zzbrs {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private zzatw f3373a;

    @GuardedBy("this")
    private zzaue b;

    public final synchronized void zzb(zzatw zzatwVar) {
        this.f3373a = zzatwVar;
    }

    public final synchronized void zzb(zzaue zzaueVar) {
        this.b = zzaueVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdOpened() {
        if (this.f3373a != null) {
            try {
                this.f3373a.onRewardedAdOpened();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdClosed() {
        if (this.f3373a != null) {
            try {
                this.f3373a.onRewardedAdClosed();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void zzb(zzasr zzasrVar, String str, String str2) {
        if (this.f3373a != null) {
            try {
                this.f3373a.zza(new zzaup(zzasrVar.getType(), zzasrVar.getAmount()));
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
        if (this.b != null) {
            try {
                this.b.zza(new zzaup(zzasrVar.getType(), zzasrVar.getAmount()), str, str2);
            } catch (RemoteException e2) {
                zzbad.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrs
    public final synchronized void zzcs(int i) {
        if (this.f3373a != null) {
            try {
                this.f3373a.onRewardedAdFailedToShow(i);
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final synchronized void onRewardedVideoCompleted() {
    }
}
