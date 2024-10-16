package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.util.PlatformVersion;

/* loaded from: classes.dex */
public abstract class zab {

    /* renamed from: a, reason: collision with root package name */
    private final int f1389a;

    public zab(int i) {
        this.f1389a = i;
    }

    public abstract void zaa(Status status);

    public abstract void zaa(GoogleApiManager.zaa<?> zaaVar) throws DeadObjectException;

    public abstract void zaa(zaab zaabVar, boolean z);

    public abstract void zaa(RuntimeException runtimeException);

    /* JADX INFO: Access modifiers changed from: private */
    public static Status b(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (PlatformVersion.isAtLeastIceCreamSandwichMR1() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }
}
