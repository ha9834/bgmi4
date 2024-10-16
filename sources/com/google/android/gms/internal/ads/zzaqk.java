package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaqk extends zzfm implements zzaqj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzaqj
    public final IBinder zzad(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        Parcel a3 = a(1, a2);
        IBinder readStrongBinder = a3.readStrongBinder();
        a3.recycle();
        return readStrongBinder;
    }
}
