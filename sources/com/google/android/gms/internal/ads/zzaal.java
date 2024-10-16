package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzaal extends zzfn implements zzaak {
    public zzaal() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public static zzaak zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        if (queryLocalInterface instanceof zzaak) {
            return (zzaak) queryLocalInterface;
        }
        return new zzaam(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String description = getDescription();
                parcel2.writeNoException();
                parcel2.writeString(description);
                return true;
            case 2:
                String zzpt = zzpt();
                parcel2.writeNoException();
                parcel2.writeString(zzpt);
                return true;
            default:
                return false;
        }
    }
}
