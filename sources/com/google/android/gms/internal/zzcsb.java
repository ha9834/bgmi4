package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class zzcsb extends zzew implements zzcsa {
    public zzcsb() {
        attachInterface(this, "com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 2:
                zza((zzctp) zzex.zza(parcel, zzctp.CREATOR));
                return true;
            case 3:
                zza((zzctj) zzex.zza(parcel, zzctj.CREATOR));
                return true;
            case 4:
                zza((zzctr) zzex.zza(parcel, zzctr.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
