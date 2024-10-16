package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaua extends zzfm implements zzatz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaua(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzatz
    public final IBinder zzd(IObjectWrapper iObjectWrapper, String str, zzamp zzampVar, int i) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        a2.writeString(str);
        zzfo.zza(a2, zzampVar);
        a2.writeInt(i);
        Parcel a3 = a(1, a2);
        IBinder readStrongBinder = a3.readStrongBinder();
        a3.recycle();
        return readStrongBinder;
    }
}
