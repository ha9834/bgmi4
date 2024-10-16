package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzbjj extends zzfm implements zzbjh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.measurement.IMeasurementManager");
    }

    @Override // com.google.android.gms.internal.ads.zzbjh
    public final void zzc(zzbjf zzbjfVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzbjfVar);
        b(1, a2);
    }
}
