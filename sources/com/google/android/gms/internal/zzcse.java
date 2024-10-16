package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class zzcse extends zzew implements zzcsd {
    public zzcse() {
        attachInterface(this, "com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 2:
                zza((zzctb) zzex.zza(parcel, zzctb.CREATOR));
                return true;
            case 3:
                zza((zzcth) zzex.zza(parcel, zzcth.CREATOR));
                return true;
            case 4:
                zza((zzctj) zzex.zza(parcel, zzctj.CREATOR));
                return true;
            case 5:
                zza((zzcsz) zzex.zza(parcel, zzcsz.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
