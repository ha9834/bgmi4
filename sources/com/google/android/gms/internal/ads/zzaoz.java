package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzaoz extends zzfn implements zzaoy {
    public zzaoz() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzdc(parcel.readString());
                break;
            case 2:
                onFailure(parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
