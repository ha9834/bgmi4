package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzex;

/* loaded from: classes2.dex */
public final class zzt extends zzev implements zzs {
    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(SubscribeRequest subscribeRequest) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, subscribeRequest);
        zzc(3, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzbz zzbzVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzbzVar);
        zzc(1, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzcb zzcbVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzcbVar);
        zzc(8, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzce zzceVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzceVar);
        zzc(2, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzcg zzcgVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzcgVar);
        zzc(4, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzh zzhVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzhVar);
        zzc(7, zzbc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.nearby.messages.internal.zzs
    public final void zza(zzj zzjVar) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, zzjVar);
        zzc(9, zzbc);
    }
}
