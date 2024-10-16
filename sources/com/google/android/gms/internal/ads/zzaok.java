package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzaok extends zzfn implements zzaoj {
    public zzaok() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzw(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 2:
                zzdb(parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
