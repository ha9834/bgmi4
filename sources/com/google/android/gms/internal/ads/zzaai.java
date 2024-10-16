package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaai extends zzfm implements zzaag {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaai(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaag
    public final void onAdMuted() throws RemoteException {
        b(1, a());
    }
}
