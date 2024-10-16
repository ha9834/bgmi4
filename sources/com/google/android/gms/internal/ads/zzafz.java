package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzafz extends zzfm implements zzafx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    public final void zza(zzagg zzaggVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaggVar);
        b(1, a2);
    }
}
