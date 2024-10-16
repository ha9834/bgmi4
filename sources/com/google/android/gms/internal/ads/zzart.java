package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzart extends zzfm implements zzarr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzart(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzarr
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, parcelFileDescriptor);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzarr
    public final void zza(zzaym zzaymVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaymVar);
        b(2, a2);
    }
}
