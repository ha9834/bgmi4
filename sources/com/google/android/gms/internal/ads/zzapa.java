package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzapa extends zzfm implements zzaoy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final void zzdc(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final void onFailure(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(2, a2);
    }
}
