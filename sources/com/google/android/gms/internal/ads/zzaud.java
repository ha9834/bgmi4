package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaud extends zzfm implements zzaub {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaud(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaub
    public final void onRewardedAdLoaded() throws RemoteException {
        b(1, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaub
    public final void onRewardedAdFailedToLoad(int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        b(2, a2);
    }
}
