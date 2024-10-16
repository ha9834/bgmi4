package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public interface zzasw extends IInterface {
    void destroy() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoaded() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setAppPackageName(String str) throws RemoteException;

    void setCustomData(String str) throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void show() throws RemoteException;

    void zza(zzasu zzasuVar) throws RemoteException;

    void zza(zzatb zzatbVar) throws RemoteException;

    void zza(zzath zzathVar) throws RemoteException;

    void zza(zzzp zzzpVar) throws RemoteException;

    void zzk(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzl(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzm(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzn(IObjectWrapper iObjectWrapper) throws RemoteException;
}
