package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzzd extends zzfn implements zzzc {
    public zzzd() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zza((zzxz) zzfo.zza(parcel, zzxz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 3:
                boolean isLoading = isLoading();
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, isLoading);
                return true;
            case 4:
                String zzpj = zzpj();
                parcel2.writeNoException();
                parcel2.writeString(zzpj);
                return true;
            case 5:
                zza((zzxz) zzfo.zza(parcel, zzxz.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
