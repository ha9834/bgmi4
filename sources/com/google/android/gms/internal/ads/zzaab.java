package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes.dex */
public interface zzaab extends IInterface {
    String getVersionString() throws RemoteException;

    void setAppMuted(boolean z) throws RemoteException;

    void setAppVolume(float f) throws RemoteException;

    void zza() throws RemoteException;

    void zza(zzait zzaitVar) throws RemoteException;

    void zza(zzamp zzampVar) throws RemoteException;

    void zzb(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzbu(String str) throws RemoteException;

    void zzbv(String str) throws RemoteException;

    void zzc(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    float zzpq() throws RemoteException;

    boolean zzpr() throws RemoteException;

    List<zzaio> zzps() throws RemoteException;
}
