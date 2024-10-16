package com.google.android.gms.plus.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ICancelToken;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzg extends com.google.android.gms.internal.plus.zza implements zzf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.plus.internal.IPlusService");
    }

    @Override // com.google.android.gms.plus.internal.zzf
    public final String getAccountName() throws RemoteException {
        Parcel a2 = a(5, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.plus.internal.zzf
    public final ICancelToken zza(zzb zzbVar, int i, int i2, int i3, String str) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.plus.zzc.zza(a2, zzbVar);
        a2.writeInt(i);
        a2.writeInt(i2);
        a2.writeInt(-1);
        a2.writeString(str);
        Parcel a3 = a(16, a2);
        ICancelToken asInterface = ICancelToken.Stub.asInterface(a3.readStrongBinder());
        a3.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.plus.internal.zzf
    public final void zza() throws RemoteException {
        b(6, a());
    }

    @Override // com.google.android.gms.plus.internal.zzf
    public final void zza(zzb zzbVar) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.plus.zzc.zza(a2, zzbVar);
        b(19, a2);
    }

    @Override // com.google.android.gms.plus.internal.zzf
    public final void zza(zzb zzbVar, List<String> list) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.plus.zzc.zza(a2, zzbVar);
        a2.writeStringList(list);
        b(34, a2);
    }
}
