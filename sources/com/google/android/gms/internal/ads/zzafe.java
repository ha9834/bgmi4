package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes2.dex */
public interface zzafe extends IInterface {
    void destroy() throws RemoteException;

    List<String> getAvailableAssetNames() throws RemoteException;

    String getCustomTemplateId() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    void performClick(String str) throws RemoteException;

    void recordImpression() throws RemoteException;

    String zzcj(String str) throws RemoteException;

    zzaei zzck(String str) throws RemoteException;

    boolean zzp(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzrh() throws RemoteException;

    IObjectWrapper zzrm() throws RemoteException;
}
