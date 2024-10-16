package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzafs extends zzfn implements zzafr {
    public zzafs() {
        super("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public static zzafr zzr(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
        if (queryLocalInterface instanceof zzafr) {
            return (zzafr) queryLocalInterface;
        }
        return new zzaft(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzafe zzafgVar;
        if (i != 1) {
            return false;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzafgVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
            if (queryLocalInterface instanceof zzafe) {
                zzafgVar = (zzafe) queryLocalInterface;
            } else {
                zzafgVar = new zzafg(readStrongBinder);
            }
        }
        zzb(zzafgVar);
        parcel2.writeNoException();
        return true;
    }
}
