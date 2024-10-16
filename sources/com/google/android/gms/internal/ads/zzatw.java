package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface zzatw extends IInterface {
    void onRewardedAdClosed() throws RemoteException;

    void onRewardedAdFailedToShow(int i) throws RemoteException;

    void onRewardedAdOpened() throws RemoteException;

    void zza(zzatq zzatqVar) throws RemoteException;
}
