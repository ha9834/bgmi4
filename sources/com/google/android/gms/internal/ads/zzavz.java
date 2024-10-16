package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzavz extends zzfm implements zzavy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzavy
    public final void zzk(String str, String str2) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzavy
    public final void onError(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(2, a2);
    }
}
