package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;

/* loaded from: classes.dex */
public final class zzl extends zza implements IGmsCallbacks {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        a2.writeStrongBinder(iBinder);
        com.google.android.gms.internal.common.zzc.zza(a2, bundle);
        b(1, a2);
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zza(int i, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        com.google.android.gms.internal.common.zzc.zza(a2, bundle);
        b(2, a2);
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zza(int i, IBinder iBinder, zzb zzbVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        a2.writeStrongBinder(iBinder);
        com.google.android.gms.internal.common.zzc.zza(a2, zzbVar);
        b(3, a2);
    }
}
