package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class zzcsr extends zzew implements zzcsq {
    public zzcsr() {
        attachInterface(this, "com.google.android.gms.nearby.internal.connection.IPayloadListener");
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
                zza((zzctr) zzex.zza(parcel, zzctr.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
