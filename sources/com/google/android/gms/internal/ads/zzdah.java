package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public interface zzdah extends IInterface {
    String getVersion() throws RemoteException;

    IObjectWrapper zza(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5) throws RemoteException;

    void zzaa(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzab(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzap(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzd(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;
}
