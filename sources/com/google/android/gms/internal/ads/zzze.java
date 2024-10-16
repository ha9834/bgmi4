package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzze extends zzfm implements zzzc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zza(zzxz zzxzVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzxzVar);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel a2 = a(2, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean isLoading() throws RemoteException {
        Parcel a2 = a(3, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final String zzpj() throws RemoteException {
        Parcel a2 = a(4, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zza(zzxz zzxzVar, int i) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzxzVar);
        a2.writeInt(i);
        b(5, a2);
    }
}
