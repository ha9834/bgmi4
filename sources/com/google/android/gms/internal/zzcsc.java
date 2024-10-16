package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzcsc extends zzev implements zzcsa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcsa
    public final void zza(zzctj zzctjVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzctjVar);
        zzc(3, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcsa
    public final void zza(zzctp zzctpVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzctpVar);
        zzc(2, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcsa
    public final void zza(zzctr zzctrVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzctrVar);
        zzc(4, zzbc);
    }
}
