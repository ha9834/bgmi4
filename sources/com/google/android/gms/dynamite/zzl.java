package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* loaded from: classes.dex */
public final class zzl extends zza implements zzk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, iObjectWrapper);
        a2.writeString(str);
        a2.writeInt(i);
        zzc.zza(a2, iObjectWrapper2);
        Parcel a3 = a(2, a2);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a3.readStrongBinder());
        a3.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, iObjectWrapper);
        a2.writeString(str);
        a2.writeInt(i);
        zzc.zza(a2, iObjectWrapper2);
        Parcel a3 = a(3, a2);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a3.readStrongBinder());
        a3.recycle();
        return asInterface;
    }
}
