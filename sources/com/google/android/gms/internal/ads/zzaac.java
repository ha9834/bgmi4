package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzaac extends zzfn implements zzaab {
    public zzaac() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zza();
                parcel2.writeNoException();
                return true;
            case 2:
                setAppVolume(parcel.readFloat());
                parcel2.writeNoException();
                return true;
            case 3:
                zzbu(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                setAppMuted(zzfo.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 5:
                zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzb(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                float zzpq = zzpq();
                parcel2.writeNoException();
                parcel2.writeFloat(zzpq);
                return true;
            case 8:
                boolean zzpr = zzpr();
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, zzpr);
                return true;
            case 9:
                String versionString = getVersionString();
                parcel2.writeNoException();
                parcel2.writeString(versionString);
                return true;
            case 10:
                zzbv(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zza(zzamq.zzy(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                zza(zzaiu.zzw(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                List<zzaio> zzps = zzps();
                parcel2.writeNoException();
                parcel2.writeTypedList(zzps);
                return true;
            default:
                return false;
        }
    }
}
