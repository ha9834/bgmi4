package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzast extends zzfm implements zzasr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzast(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.zzasr
    public final String getType() throws RemoteException {
        Parcel a2 = a(1, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzasr
    public final int getAmount() throws RemoteException {
        Parcel a2 = a(2, a());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }
}
