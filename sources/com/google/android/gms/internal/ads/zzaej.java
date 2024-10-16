package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzaej extends zzfn implements zzaei {
    public zzaej() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzaei zzk(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        if (queryLocalInterface instanceof zzaei) {
            return (zzaei) queryLocalInterface;
        }
        return new zzaek(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                IObjectWrapper zzrf = zzrf();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzrf);
                return true;
            case 2:
                Uri uri = getUri();
                parcel2.writeNoException();
                zzfo.zzb(parcel2, uri);
                return true;
            case 3:
                double scale = getScale();
                parcel2.writeNoException();
                parcel2.writeDouble(scale);
                return true;
            case 4:
                int width = getWidth();
                parcel2.writeNoException();
                parcel2.writeInt(width);
                return true;
            case 5:
                int height = getHeight();
                parcel2.writeNoException();
                parcel2.writeInt(height);
                return true;
            default:
                return false;
        }
    }
}
