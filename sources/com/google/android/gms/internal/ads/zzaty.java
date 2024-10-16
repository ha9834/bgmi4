package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaty extends zzfm implements zzatw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaty(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void onRewardedAdOpened() throws RemoteException {
        b(1, a());
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void onRewardedAdClosed() throws RemoteException {
        b(2, a());
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void zza(zzatq zzatqVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzatqVar);
        b(3, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void onRewardedAdFailedToShow(int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        b(4, a2);
    }
}
