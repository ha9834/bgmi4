package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzex;

/* loaded from: classes2.dex */
public abstract class zzy extends zzew implements zzx {
    public zzy() {
        attachInterface(this, "com.google.android.gms.nearby.messages.internal.IStatusCallback");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        onPermissionChanged(zzex.zza(parcel));
        return true;
    }
}
