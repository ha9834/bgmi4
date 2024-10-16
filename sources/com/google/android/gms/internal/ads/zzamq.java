package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzamq extends zzfn implements zzamp {
    public zzamq() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzamp zzy(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzamp) {
            return (zzamp) queryLocalInterface;
        }
        return new zzamr(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzams zzcu = zzcu(parcel.readString());
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzcu);
                return true;
            case 2:
                boolean zzcv = zzcv(parcel.readString());
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, zzcv);
                return true;
            case 3:
                zzaov zzcy = zzcy(parcel.readString());
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzcy);
                return true;
            default:
                return false;
        }
    }
}
