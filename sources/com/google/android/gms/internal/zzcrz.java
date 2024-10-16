package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzcrz extends zzev implements zzcrx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcrz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcrx
    public final void zza(zzctd zzctdVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzctdVar);
        zzc(2, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcrx
    public final void zza(zzctv zzctvVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzctvVar);
        zzc(3, zzbc);
    }
}
