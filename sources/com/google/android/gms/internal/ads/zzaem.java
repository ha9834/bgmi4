package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public interface zzaem extends IInterface {
    void destroy() throws RemoteException;

    void zzc(IObjectWrapper iObjectWrapper, int i) throws RemoteException;

    void zzc(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzcf(String str) throws RemoteException;

    void zze(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper) throws RemoteException;
}
