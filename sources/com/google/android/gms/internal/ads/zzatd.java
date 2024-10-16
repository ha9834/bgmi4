package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzatd extends zzfm implements zzatb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdLoaded() throws RemoteException {
        b(1, a());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdOpened() throws RemoteException {
        b(2, a());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoStarted() throws RemoteException {
        b(3, a());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdClosed() throws RemoteException {
        b(4, a());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void zza(zzasr zzasrVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzasrVar);
        b(5, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        b(6, a());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        b(7, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoCompleted() throws RemoteException {
        b(8, a());
    }
}
