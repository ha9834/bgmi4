package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzzo extends zzfm implements zzzn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzzn
    public final IBinder zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, zzamp zzampVar, int i, int i2) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzydVar);
        a2.writeString(str);
        zzfo.zza(a2, zzampVar);
        a2.writeInt(i);
        a2.writeInt(i2);
        Parcel a3 = a(2, a2);
        IBinder readStrongBinder = a3.readStrongBinder();
        a3.recycle();
        return readStrongBinder;
    }
}
