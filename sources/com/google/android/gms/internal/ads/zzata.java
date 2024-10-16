package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzata extends zzfm implements zzasz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzata(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzasz
    public final IBinder zzb(IObjectWrapper iObjectWrapper, zzamp zzampVar, int i) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzampVar);
        a2.writeInt(i);
        Parcel a3 = a(1, a2);
        IBinder readStrongBinder = a3.readStrongBinder();
        a3.recycle();
        return readStrongBinder;
    }
}
