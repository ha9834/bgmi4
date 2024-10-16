package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzex;

/* loaded from: classes2.dex */
public final class zzz extends zzev implements zzx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.IStatusCallback");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzx
    public final void onPermissionChanged(boolean z) throws RemoteException {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, z);
        zzc(1, zzbc);
    }
}
