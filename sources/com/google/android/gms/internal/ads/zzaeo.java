package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaeo extends zzfm implements zzaem {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaeo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzc(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        zzfo.zza(a2, iObjectWrapper);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final IObjectWrapper zzcf(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        Parcel a3 = a(2, a2);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a3.readStrongBinder());
        a3.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(3, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void destroy() throws RemoteException {
        b(4, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzc(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        a2.writeInt(i);
        b(5, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(6, a2);
    }
}
