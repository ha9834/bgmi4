package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public interface zzatt extends IInterface {
    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoaded() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException;

    void zza(zzaao zzaaoVar) throws RemoteException;

    void zza(zzatw zzatwVar) throws RemoteException;

    void zza(zzaue zzaueVar) throws RemoteException;

    void zza(zzaum zzaumVar) throws RemoteException;

    void zza(zzxz zzxzVar, zzaub zzaubVar) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzatq zzqh() throws RemoteException;
}
