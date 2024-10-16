package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaeq extends zzfm implements zzaep {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaeq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final IBinder zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, iObjectWrapper2);
        zzfo.zza(a2, iObjectWrapper3);
        a2.writeInt(i);
        Parcel a3 = a(1, a2);
        IBinder readStrongBinder = a3.readStrongBinder();
        a3.recycle();
        return readStrongBinder;
    }
}
