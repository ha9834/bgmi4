package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzadq extends zzfm implements zzado {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final void zza(zzadl zzadlVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzadlVar);
        b(1, a2);
    }
}
