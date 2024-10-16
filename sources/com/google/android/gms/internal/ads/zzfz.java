package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzfz extends zzfm implements zzfx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzfx
    public final void zzb(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        a2.writeString(str);
        b(2, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzfx
    public final void zzdj() throws RemoteException {
        b(3, a());
    }

    @Override // com.google.android.gms.internal.ads.zzfx
    public final void zza(int[] iArr) throws RemoteException {
        Parcel a2 = a();
        a2.writeIntArray(null);
        b(4, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzfx
    public final void zzc(byte[] bArr) throws RemoteException {
        Parcel a2 = a();
        a2.writeByteArray(bArr);
        b(5, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzfx
    public final void zzl(int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        b(6, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzfx
    public final void zzm(int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        b(7, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzfx
    public final void zza(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        a2.writeString(str);
        a2.writeString(null);
        b(8, a2);
    }
}
