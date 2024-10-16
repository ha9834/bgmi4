package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzcsy extends zzev implements zzcsw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcsw
    public final void zza(zzctt zzcttVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzcttVar);
        zzc(2, zzbc);
    }
}
