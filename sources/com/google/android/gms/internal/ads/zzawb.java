package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzawb extends zzfn implements zzawa {
    public zzawb() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzavy zzavzVar;
        if (i != 1) {
            return false;
        }
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        zzawc zzawcVar = (zzawc) zzfo.zza(parcel, zzawc.CREATOR);
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzavzVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
            if (queryLocalInterface instanceof zzavy) {
                zzavzVar = (zzavy) queryLocalInterface;
            } else {
                zzavzVar = new zzavz(readStrongBinder);
            }
        }
        zza(asInterface, zzawcVar, zzavzVar);
        parcel2.writeNoException();
        return true;
    }
}
