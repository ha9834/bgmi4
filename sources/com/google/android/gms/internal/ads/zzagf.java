package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzagf extends zzfm implements zzagd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzagd
    public final void onUnconfirmedClickReceived(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzagd
    public final void onUnconfirmedClickCancelled() throws RemoteException {
        b(2, a());
    }
}
