package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class zzbt extends com.google.android.gms.internal.games.zzb implements zzbs {
    public zzbt() {
        super("com.google.android.gms.games.internal.IGamesClient");
    }

    @Override // com.google.android.gms.internal.games.zzb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1001) {
            return false;
        }
        zzbw zzas = zzas();
        parcel2.writeNoException();
        com.google.android.gms.internal.games.zzc.zzb(parcel2, zzas);
        return true;
    }
}
