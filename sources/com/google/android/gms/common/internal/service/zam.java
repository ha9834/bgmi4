package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zam extends com.google.android.gms.internal.base.zaa implements zal {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    @Override // com.google.android.gms.common.internal.service.zal
    public final void zaa(zaj zajVar) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.base.zac.zaa(a2, zajVar);
        c(1, a2);
    }
}
