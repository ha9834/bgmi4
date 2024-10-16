package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public interface zzadl extends IInterface {
    String getContent() throws RemoteException;

    void recordClick() throws RemoteException;

    void recordImpression() throws RemoteException;

    void zzo(IObjectWrapper iObjectWrapper) throws RemoteException;

    String zzqz() throws RemoteException;
}
