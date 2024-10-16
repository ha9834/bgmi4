package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzamr extends zzfm implements zzamp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzamp
    public final zzams zzcu(String str) throws RemoteException {
        zzams zzamuVar;
        Parcel a2 = a();
        a2.writeString(str);
        Parcel a3 = a(1, a2);
        IBinder readStrongBinder = a3.readStrongBinder();
        if (readStrongBinder == null) {
            zzamuVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (queryLocalInterface instanceof zzams) {
                zzamuVar = (zzams) queryLocalInterface;
            } else {
                zzamuVar = new zzamu(readStrongBinder);
            }
        }
        a3.recycle();
        return zzamuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamp
    public final boolean zzcv(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        Parcel a3 = a(2, a2);
        boolean zza = zzfo.zza(a3);
        a3.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzamp
    public final zzaov zzcy(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        Parcel a3 = a(3, a2);
        zzaov zzab = zzaow.zzab(a3.readStrongBinder());
        a3.recycle();
        return zzab;
    }
}
