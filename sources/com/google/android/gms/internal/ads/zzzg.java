package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* loaded from: classes2.dex */
public abstract class zzzg extends zzfn implements zzzf {
    public zzzg() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzyz zzyzVar = null;
        zzzy zzzyVar = null;
        switch (i) {
            case 1:
                zzzc zzpk = zzpk();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzpk);
                return true;
            case 2:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface instanceof zzyz) {
                        zzyzVar = (zzyz) queryLocalInterface;
                    } else {
                        zzyzVar = new zzzb(readStrongBinder);
                    }
                }
                zza(zzyzVar);
                parcel2.writeNoException();
                return true;
            case 3:
                zza(zzafj.zzo(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                zza(zzafm.zzp(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                zza(parcel.readString(), zzafs.zzr(parcel.readStrongBinder()), zzafp.zzq(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                zza((zzady) zzfo.zza(parcel, zzady.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface2 instanceof zzzy) {
                        zzzyVar = (zzzy) queryLocalInterface2;
                    } else {
                        zzzyVar = new zzaaa(readStrongBinder2);
                    }
                }
                zza(zzzyVar);
                parcel2.writeNoException();
                return true;
            case 8:
                zza(zzafv.zzs(parcel.readStrongBinder()), (zzyd) zzfo.zza(parcel, zzyd.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                zza((PublisherAdViewOptions) zzfo.zza(parcel, PublisherAdViewOptions.CREATOR));
                parcel2.writeNoException();
                return true;
            case 10:
                zza(zzafy.zzt(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zza((zzaiy) zzfo.zza(parcel, zzaiy.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza(zzajf.zzx(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
        }
    }
}
