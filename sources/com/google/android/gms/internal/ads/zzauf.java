package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzauf extends zzfm implements zzaue {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzauf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaue
    public final void zza(zzatq zzatqVar, String str, String str2) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzatqVar);
        a2.writeString(str);
        a2.writeString(str2);
        b(2, a2);
    }
}
