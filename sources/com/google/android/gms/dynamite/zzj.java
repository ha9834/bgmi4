package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* loaded from: classes.dex */
public final class zzj extends zza implements zzi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, iObjectWrapper);
        a2.writeString(str);
        a2.writeInt(i);
        Parcel a3 = a(2, a2);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a3.readStrongBinder());
        a3.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final int zza(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, iObjectWrapper);
        a2.writeString(str);
        zzc.writeBoolean(a2, z);
        Parcel a3 = a(3, a2);
        int readInt = a3.readInt();
        a3.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, iObjectWrapper);
        a2.writeString(str);
        a2.writeInt(i);
        Parcel a3 = a(4, a2);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a3.readStrongBinder());
        a3.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final int zzb(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, iObjectWrapper);
        a2.writeString(str);
        zzc.writeBoolean(a2, z);
        Parcel a3 = a(5, a2);
        int readInt = a3.readInt();
        a3.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final int zzak() throws RemoteException {
        Parcel a2 = a(6, a());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }
}
