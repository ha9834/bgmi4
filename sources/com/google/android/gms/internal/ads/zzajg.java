package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzajg extends zzfm implements zzaje {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zza(zzaja zzajaVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzajaVar);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzcr(int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        b(2, a2);
    }
}
