package com.google.android.gms.auth;

import android.os.IBinder;
import android.os.RemoteException;
import java.io.IOException;

/* loaded from: classes.dex */
interface f<T> {
    T a(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException;
}
