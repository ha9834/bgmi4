package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class zzcsm extends zzew implements zzcsl {
    public zzcsm() {
        attachInterface(this, "com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 2:
                zza((zzctl) zzex.zza(parcel, zzctl.CREATOR));
                return true;
            case 3:
                zza((zzctn) zzex.zza(parcel, zzctn.CREATOR));
                return true;
            case 4:
                zza((zzctx) zzex.zza(parcel, zzctx.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
