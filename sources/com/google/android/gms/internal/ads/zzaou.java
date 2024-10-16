package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaou extends zzfm implements zzaos {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaou(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaos
    public final void zzsw() throws RemoteException {
        b(2, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaos
    public final void zzdb(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(3, a2);
    }
}
