package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;

/* loaded from: classes2.dex */
public final class zzac extends zzev implements zzaa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzaa
    public final void onExpired() throws RemoteException {
        zzc(1, zzbc());
    }
}
