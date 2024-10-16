package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;

/* loaded from: classes2.dex */
public final class zzw extends zzev implements zzu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.IPublishCallback");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzu
    public final void onExpired() throws RemoteException {
        zzc(1, zzbc());
    }
}
