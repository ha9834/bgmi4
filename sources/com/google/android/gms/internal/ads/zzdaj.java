package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzdaj extends zzfm implements zzdah {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.omid.IOmid");
    }

    @Override // com.google.android.gms.internal.ads.zzdah
    public final boolean zzap(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        Parcel a3 = a(2, a2);
        boolean zza = zzfo.zza(a3);
        a3.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzdah
    public final void zzaa(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(4, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzdah
    public final void zzd(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, iObjectWrapper2);
        b(5, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzdah
    public final String getVersion() throws RemoteException {
        Parcel a2 = a(6, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzdah
    public final void zzab(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(7, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzdah
    public final IObjectWrapper zza(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        zzfo.zza(a2, iObjectWrapper);
        a2.writeString(str2);
        a2.writeString(str3);
        a2.writeString(str4);
        a2.writeString(str5);
        Parcel a3 = a(9, a2);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a3.readStrongBinder());
        a3.recycle();
        return asInterface;
    }
}
