package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public interface zzaov extends IInterface {
    zzaar getVideoController() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzyd zzydVar, zzaoy zzaoyVar) throws RemoteException;

    void zza(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaoj zzaojVar, zzamv zzamvVar, zzyd zzydVar) throws RemoteException;

    void zza(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaom zzaomVar, zzamv zzamvVar) throws RemoteException;

    void zza(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaop zzaopVar, zzamv zzamvVar) throws RemoteException;

    void zza(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaos zzaosVar, zzamv zzamvVar) throws RemoteException;

    void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException;

    zzapj zzsx() throws RemoteException;

    zzapj zzsy() throws RemoteException;

    void zzx(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzy(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzz(IObjectWrapper iObjectWrapper) throws RemoteException;
}
