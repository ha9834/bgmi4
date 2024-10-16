package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcqb implements zzbro, zzbsr {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private zzaub f3374a;

    public final synchronized void zza(zzaub zzaubVar) {
        this.f3374a = zzaubVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final synchronized void onAdLoaded() {
        if (this.f3374a != null) {
            try {
                this.f3374a.onRewardedAdLoaded();
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final synchronized void onAdFailedToLoad(int i) {
        if (this.f3374a != null) {
            try {
                this.f3374a.onRewardedAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
