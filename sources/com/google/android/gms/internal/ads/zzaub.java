package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface zzaub extends IInterface {
    void onRewardedAdFailedToLoad(int i) throws RemoteException;

    void onRewardedAdLoaded() throws RemoteException;
}
