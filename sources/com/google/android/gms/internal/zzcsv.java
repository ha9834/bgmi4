package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzcsv extends zzev implements zzcst {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IResultListener");
    }

    @Override // com.google.android.gms.internal.zzcst
    public final void zzer(int i) throws RemoteException {
        Parcel zzbc = zzbc();
        zzbc.writeInt(i);
        zzc(2, zzbc);
    }
}
