package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzass extends zzfn implements zzasr {
    public zzass() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String type = getType();
                parcel2.writeNoException();
                parcel2.writeString(type);
                return true;
            case 2:
                int amount = getAmount();
                parcel2.writeNoException();
                parcel2.writeInt(amount);
                return true;
            default:
                return false;
        }
    }
}
