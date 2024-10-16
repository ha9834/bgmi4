package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaet extends zzfm implements zzaer {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaet(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void unregisterNativeAd() throws RemoteException {
        b(2, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(3, a2);
    }
}
