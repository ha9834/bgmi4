package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzg extends zza implements zze {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final String getId() throws RemoteException {
        Parcel a2 = a(1, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final boolean zzb(boolean z) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, true);
        Parcel a3 = a(2, a2);
        boolean zza = zzc.zza(a3);
        a3.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final boolean zzc() throws RemoteException {
        Parcel a2 = a(6, a());
        boolean zza = zzc.zza(a2);
        a2.recycle();
        return zza;
    }
}
