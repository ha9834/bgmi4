package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzzu extends zzfm implements zzzs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    @Override // com.google.android.gms.internal.ads.zzzs
    public final void onAppEvent(String str, String str2) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        b(1, a2);
    }
}
