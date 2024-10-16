package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzagc extends zzfm implements zzaga {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IShouldDelayBannerRenderingListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaga
    public final boolean zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        Parcel a3 = a(2, a2);
        boolean zza = zzfo.zza(a3);
        a3.recycle();
        return zza;
    }
}
