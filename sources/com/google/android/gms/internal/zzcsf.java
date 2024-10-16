package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzcsf extends zzev implements zzcsd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcsd
    public final void zza(zzcsz zzcszVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzcszVar);
        zzc(5, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcsd
    public final void zza(zzctb zzctbVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzctbVar);
        zzc(2, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcsd
    public final void zza(zzcth zzcthVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzcthVar);
        zzc(3, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcsd
    public final void zza(zzctj zzctjVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzctjVar);
        zzc(4, zzbc);
    }
}
