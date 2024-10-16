package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzew extends zza implements zzeu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzew(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.drive.internal.IEventReleaseCallback");
    }

    @Override // com.google.android.gms.internal.drive.zzeu
    public final void zza(boolean z) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, z);
        c(1, a2);
    }
}
