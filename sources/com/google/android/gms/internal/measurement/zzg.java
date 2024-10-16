package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzg extends zzb implements zzf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.zzf
    public final Bundle zza(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, bundle);
        Parcel a3 = a(1, a2);
        Bundle bundle2 = (Bundle) zzd.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle2;
    }
}
