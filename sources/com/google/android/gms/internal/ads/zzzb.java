package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzzb extends zzfm implements zzyz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdClosed() throws RemoteException {
        b(1, a());
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdFailedToLoad(int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        b(2, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdLeftApplication() throws RemoteException {
        b(3, a());
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdLoaded() throws RemoteException {
        b(4, a());
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdOpened() throws RemoteException {
        b(5, a());
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdClicked() throws RemoteException {
        b(6, a());
    }

    @Override // com.google.android.gms.internal.ads.zzyz
    public final void onAdImpression() throws RemoteException {
        b(7, a());
    }
}
