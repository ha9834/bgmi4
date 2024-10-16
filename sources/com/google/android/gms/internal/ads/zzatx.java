package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzatx extends zzfn implements zzatw {
    public zzatx() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzatq zzatsVar;
        switch (i) {
            case 1:
                onRewardedAdOpened();
                break;
            case 2:
                onRewardedAdClosed();
                break;
            case 3:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzatsVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
                    if (queryLocalInterface instanceof zzatq) {
                        zzatsVar = (zzatq) queryLocalInterface;
                    } else {
                        zzatsVar = new zzats(readStrongBinder);
                    }
                }
                zza(zzatsVar);
                break;
            case 4:
                onRewardedAdFailedToShow(parcel.readInt());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
