package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaoo extends zzfm implements zzaom {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaoo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaom
    public final void zzsw() throws RemoteException {
        b(2, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaom
    public final void zzdb(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(3, a2);
    }
}
