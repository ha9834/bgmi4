package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzr extends zzb implements zzp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void zzb(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, bundle);
        b(1, a2);
    }
}
