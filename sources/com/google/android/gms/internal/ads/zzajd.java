package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzajd extends zzfm implements zzajc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzajc
    public final void zzrt() throws RemoteException {
        b(1, a());
    }

    @Override // com.google.android.gms.internal.ads.zzajc
    public final void zzcq(int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        b(2, a2);
    }
}
