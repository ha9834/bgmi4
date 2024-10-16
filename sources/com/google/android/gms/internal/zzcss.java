package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzcss extends zzev implements zzcsq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcss(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.IPayloadListener");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcsq
    public final void zza(zzctp zzctpVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzctpVar);
        zzc(2, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzcsq
    public final void zza(zzctr zzctrVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzctrVar);
        zzc(3, zzbc);
    }
}
