package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaa extends zza implements zzz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
    }

    @Override // com.google.android.gms.internal.auth.zzz
    public final void zza(zzx zzxVar, zzaf zzafVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzxVar);
        zzc.zza(a2, zzafVar);
        b(5, a2);
    }

    @Override // com.google.android.gms.internal.auth.zzz
    public final void zza(zzx zzxVar, zzad zzadVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzxVar);
        zzc.zza(a2, zzadVar);
        b(6, a2);
    }

    @Override // com.google.android.gms.internal.auth.zzz
    public final void zza(zzx zzxVar, zzv zzvVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzxVar);
        zzc.zza(a2, zzvVar);
        b(7, a2);
    }

    @Override // com.google.android.gms.internal.auth.zzz
    public final void zza(zzx zzxVar, zzah zzahVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzxVar);
        zzc.zza(a2, zzahVar);
        b(8, a2);
    }

    @Override // com.google.android.gms.internal.auth.zzz
    public final void zza(zzx zzxVar, zzab zzabVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzxVar);
        zzc.zza(a2, zzabVar);
        b(9, a2);
    }
}
