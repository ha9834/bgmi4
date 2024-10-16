package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzex;

/* loaded from: classes2.dex */
public abstract class zzq extends zzew implements zzp {
    public zzq() {
        attachInterface(this, "com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        zzap((Status) zzex.zza(parcel, Status.CREATOR));
        return true;
    }
}
