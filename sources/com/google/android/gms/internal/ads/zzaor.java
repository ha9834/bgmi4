package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaor extends zzfm implements zzaop {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaor(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void zza(zzang zzangVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzangVar);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void zzdb(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(2, a2);
    }
}
