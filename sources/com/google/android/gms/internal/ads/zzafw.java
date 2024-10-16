package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzafw extends zzfm implements zzafu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafu
    public final void zza(zzzk zzzkVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzzkVar);
        zzfo.zza(a2, iObjectWrapper);
        b(1, a2);
    }
}
