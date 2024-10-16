package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzajb extends zzfn implements zzaja {
    public zzajb() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzajc zzajdVar;
        switch (i) {
            case 3:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.zza(parcel2, videoController);
                return true;
            case 4:
                destroy();
                parcel2.writeNoException();
                return true;
            case 5:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzajdVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                    if (queryLocalInterface instanceof zzajc) {
                        zzajdVar = (zzajc) queryLocalInterface;
                    } else {
                        zzajdVar = new zzajd(readStrongBinder);
                    }
                }
                zza(asInterface, zzajdVar);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
