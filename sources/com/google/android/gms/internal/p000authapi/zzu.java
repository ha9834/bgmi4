package com.google.android.gms.internal.p000authapi;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public interface zzu extends IInterface {
    void zzc(Status status) throws RemoteException;

    void zzc(Status status, Credential credential) throws RemoteException;

    void zzc(Status status, String str) throws RemoteException;
}
