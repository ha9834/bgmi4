package com.google.android.gms.plus.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zze extends com.google.android.gms.internal.plus.zza implements zzd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.plus.internal.IPlusOneButtonCreator");
    }

    @Override // com.google.android.gms.plus.internal.zzd
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, int i, int i2, String str, int i3) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.plus.zzc.zza(a2, iObjectWrapper);
        a2.writeInt(i);
        a2.writeInt(i2);
        a2.writeString(str);
        a2.writeInt(i3);
        Parcel a3 = a(1, a2);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a3.readStrongBinder());
        a3.recycle();
        return asInterface;
    }
}
