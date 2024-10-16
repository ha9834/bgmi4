package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzaif extends zzfn implements zzaie {
    public zzaif() {
        super("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((ParcelFileDescriptor) zzfo.zza(parcel, ParcelFileDescriptor.CREATOR));
        return true;
    }
}
