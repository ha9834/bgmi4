package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzcsn extends zzev implements zzcsl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcsl
    public final void zza(zzctl zzctlVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzctlVar);
        zzc(2, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcsl
    public final void zza(zzctn zzctnVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzctnVar);
        zzc(3, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcsl
    public final void zza(zzctx zzctxVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzctxVar);
        zzc(4, zzbc);
    }
}
