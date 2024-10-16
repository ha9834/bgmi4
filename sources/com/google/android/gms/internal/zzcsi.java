package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzcsi extends zzev implements zzcsg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcsg
    public final void zza(zzctf zzctfVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzctfVar);
        zzc(2, zzbc);
    }
}
