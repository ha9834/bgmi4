package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* loaded from: classes.dex */
public final class zzo extends zza implements zzm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzm
    public final boolean zza(com.google.android.gms.common.zzk zzkVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.common.zzc.zza(a2, zzkVar);
        com.google.android.gms.internal.common.zzc.zza(a2, iObjectWrapper);
        Parcel a3 = a(5, a2);
        boolean zza = com.google.android.gms.internal.common.zzc.zza(a3);
        a3.recycle();
        return zza;
    }
}
