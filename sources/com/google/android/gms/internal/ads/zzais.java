package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzais extends zzfm implements zzaiq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzais(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final void onInitializationSucceeded() throws RemoteException {
        b(2, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final void onInitializationFailed(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(3, a2);
    }
}
