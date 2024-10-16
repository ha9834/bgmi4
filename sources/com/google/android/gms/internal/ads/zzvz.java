package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzvz extends zzfm implements zzvy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final zzvs zza(zzvv zzvvVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzvvVar);
        Parcel a3 = a(1, a2);
        zzvs zzvsVar = (zzvs) zzfo.zza(a3, zzvs.CREATOR);
        a3.recycle();
        return zzvsVar;
    }
}
