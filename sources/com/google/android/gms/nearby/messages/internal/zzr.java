package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzex;

/* loaded from: classes2.dex */
public final class zzr extends zzev implements zzp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzp
    public final void zzap(Status status) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, status);
        zzc(1, zzbc);
    }
}
