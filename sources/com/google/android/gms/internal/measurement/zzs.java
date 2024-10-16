package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzs extends zzb implements zzq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzq
    public final void onEvent(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        zzd.zza(a2, bundle);
        a2.writeLong(j);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.measurement.zzq
    public final int id() throws RemoteException {
        Parcel a2 = a(2, a());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }
}
