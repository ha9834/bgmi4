package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzdbg extends zzfm implements zzdbf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdbg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final zzdbd zza(zzdbb zzdbbVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzdbbVar);
        Parcel a3 = a(1, a2);
        zzdbd zzdbdVar = (zzdbd) zzfo.zza(a3, zzdbd.CREATOR);
        a3.recycle();
        return zzdbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void zza(zzday zzdayVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzdayVar);
        b(2, a2);
    }
}
