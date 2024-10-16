package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzair extends zzfn implements zzaiq {
    public zzair() {
        super("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    public static zzaiq zzv(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
        if (queryLocalInterface instanceof zzaiq) {
            return (zzaiq) queryLocalInterface;
        }
        return new zzais(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                onInitializationSucceeded();
                break;
            case 3:
                onInitializationFailed(parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
