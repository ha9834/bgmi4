package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzarn extends zzfn implements zzarm {
    public zzarn() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzarp zzarpVar = null;
        zzarr zzarrVar = null;
        zzarr zzarrVar2 = null;
        switch (i) {
            case 1:
                zzari zza = zza((zzarg) zzfo.zza(parcel, zzarg.CREATOR));
                parcel2.writeNoException();
                zzfo.zzb(parcel2, zza);
                return true;
            case 2:
                zzarg zzargVar = (zzarg) zzfo.zza(parcel, zzarg.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (queryLocalInterface instanceof zzarp) {
                        zzarpVar = (zzarp) queryLocalInterface;
                    } else {
                        zzarpVar = new zzarq(readStrongBinder);
                    }
                }
                zza(zzargVar, zzarpVar);
                parcel2.writeNoException();
                return true;
            case 3:
            default:
                return false;
            case 4:
                zzarx zzarxVar = (zzarx) zzfo.zza(parcel, zzarx.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface2 instanceof zzarr) {
                        zzarrVar2 = (zzarr) queryLocalInterface2;
                    } else {
                        zzarrVar2 = new zzart(readStrongBinder2);
                    }
                }
                zza(zzarxVar, zzarrVar2);
                parcel2.writeNoException();
                return true;
            case 5:
                zzarx zzarxVar2 = (zzarx) zzfo.zza(parcel, zzarx.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface3 instanceof zzarr) {
                        zzarrVar = (zzarr) queryLocalInterface3;
                    } else {
                        zzarrVar = new zzart(readStrongBinder3);
                    }
                }
                zzb(zzarxVar2, zzarrVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
