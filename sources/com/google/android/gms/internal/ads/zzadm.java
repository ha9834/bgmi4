package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public abstract class zzadm extends zzfn implements zzadl {
    public zzadm() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String zzqz = zzqz();
                parcel2.writeNoException();
                parcel2.writeString(zzqz);
                return true;
            case 2:
                String content = getContent();
                parcel2.writeNoException();
                parcel2.writeString(content);
                return true;
            case 3:
                zzo(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                recordClick();
                parcel2.writeNoException();
                return true;
            case 5:
                recordImpression();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
