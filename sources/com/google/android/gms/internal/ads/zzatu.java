package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public abstract class zzatu extends zzfn implements zzatt {
    public zzatu() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzatt zzak(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        if (queryLocalInterface instanceof zzatt) {
            return (zzatt) queryLocalInterface;
        }
        return new zzatv(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaub zzaubVar = null;
        zzaue zzaueVar = null;
        zzatw zzatwVar = null;
        switch (i) {
            case 1:
                zzxz zzxzVar = (zzxz) zzfo.zza(parcel, zzxz.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    if (queryLocalInterface instanceof zzaub) {
                        zzaubVar = (zzaub) queryLocalInterface;
                    } else {
                        zzaubVar = new zzaud(readStrongBinder);
                    }
                }
                zza(zzxzVar, zzaubVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    if (queryLocalInterface2 instanceof zzatw) {
                        zzatwVar = (zzatw) queryLocalInterface2;
                    } else {
                        zzatwVar = new zzaty(readStrongBinder2);
                    }
                }
                zza(zzatwVar);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean isLoaded = isLoaded();
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, isLoaded);
                return true;
            case 4:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 5:
                zzj(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                    if (queryLocalInterface3 instanceof zzaue) {
                        zzaueVar = (zzaue) queryLocalInterface3;
                    } else {
                        zzaueVar = new zzauf(readStrongBinder3);
                    }
                }
                zza(zzaueVar);
                parcel2.writeNoException();
                return true;
            case 7:
                zza((zzaum) zzfo.zza(parcel, zzaum.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                zza(zzaap.zzg(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle adMetadata = getAdMetadata();
                parcel2.writeNoException();
                zzfo.zzb(parcel2, adMetadata);
                return true;
            case 10:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzfo.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 11:
                zzatq zzqh = zzqh();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzqh);
                return true;
            default:
                return false;
        }
    }
}
