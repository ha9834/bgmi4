package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzabv extends zzatu {
    @Override // com.google.android.gms.internal.ads.zzatt
    public final String getMediationAdapterClassName() throws RemoteException {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(IObjectWrapper iObjectWrapper, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(zzaao zzaaoVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(zzatw zzatwVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(zzaue zzaueVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(zzaum zzaumVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    @Nullable
    public final zzatq zzqh() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(zzxz zzxzVar, final zzaub zzaubVar) throws RemoteException {
        zzbad.zzen("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzazt.zzyr.post(new Runnable(zzaubVar) { // from class: com.google.android.gms.internal.ads.i

            /* renamed from: a, reason: collision with root package name */
            private final zzaub f2232a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2232a = zzaubVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzaub zzaubVar2 = this.f2232a;
                if (zzaubVar2 != null) {
                    try {
                        zzaubVar2.onRewardedAdFailedToLoad(1);
                    } catch (RemoteException e) {
                        zzbad.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }
}
