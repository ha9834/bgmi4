package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaol extends zzfm implements zzaoj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaol(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaoj
    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaoj
    public final void zzdb(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(2, a2);
    }
}
