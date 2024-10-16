package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class zzaeb extends zzfn implements zzaea {
    public zzaeb() {
        super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzaea zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        if (queryLocalInterface instanceof zzaea) {
            return (zzaea) queryLocalInterface;
        }
        return new zzaec(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                String text = getText();
                parcel2.writeNoException();
                parcel2.writeString(text);
                return true;
            case 3:
                List<zzaei> zzra = zzra();
                parcel2.writeNoException();
                parcel2.writeList(zzra);
                return true;
            default:
                return false;
        }
    }
}
