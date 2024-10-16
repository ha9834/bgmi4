package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzaon extends zzfn implements zzaom {
    public zzaon() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                zzsw();
                break;
            case 3:
                zzdb(parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
