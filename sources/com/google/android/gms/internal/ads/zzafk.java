package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzafk extends zzfm implements zzafi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafi
    public final void zza(zzaew zzaewVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaewVar);
        b(1, a2);
    }
}
