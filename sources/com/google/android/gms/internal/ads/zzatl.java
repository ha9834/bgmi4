package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzatl extends zzfn implements zzatk {
    public zzatl() {
        super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static zzatk zzai(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (queryLocalInterface instanceof zzatk) {
            return (zzatk) queryLocalInterface;
        }
        return new zzatm(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzae(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 2:
                zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                zzaf(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 4:
                zzag(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 5:
                zzah(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 6:
                zzai(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 7:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzato) zzfo.zza(parcel, zzato.CREATOR));
                break;
            case 8:
                zzaj(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 9:
                zze(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                zzak(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 11:
                zzal(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 12:
                zzb((Bundle) zzfo.zza(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
