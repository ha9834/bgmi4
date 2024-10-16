package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaro extends zzfm implements zzarm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaro(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final zzari zza(zzarg zzargVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzargVar);
        Parcel a3 = a(1, a2);
        zzari zzariVar = (zzari) zzfo.zza(a3, zzari.CREATOR);
        a3.recycle();
        return zzariVar;
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void zza(zzarg zzargVar, zzarp zzarpVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzargVar);
        zzfo.zza(a2, zzarpVar);
        b(2, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void zza(zzarx zzarxVar, zzarr zzarrVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzarxVar);
        zzfo.zza(a2, zzarrVar);
        b(4, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void zzb(zzarx zzarxVar, zzarr zzarrVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzarxVar);
        zzfo.zza(a2, zzarrVar);
        b(5, a2);
    }
}
