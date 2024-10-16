package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzafy extends zzfn implements zzafx {
    public zzafy() {
        super("com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public static zzafx zzt(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
        if (queryLocalInterface instanceof zzafx) {
            return (zzafx) queryLocalInterface;
        }
        return new zzafz(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzagg zzagiVar;
        if (i != 1) {
            return false;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzagiVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
            if (queryLocalInterface instanceof zzagg) {
                zzagiVar = (zzagg) queryLocalInterface;
            } else {
                zzagiVar = new zzagi(readStrongBinder);
            }
        }
        zza(zzagiVar);
        parcel2.writeNoException();
        return true;
    }
}
