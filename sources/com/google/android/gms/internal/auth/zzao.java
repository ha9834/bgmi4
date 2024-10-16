package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

/* loaded from: classes2.dex */
public final class zzao extends zza implements zzan {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzao(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.internal.IAuthService");
    }

    @Override // com.google.android.gms.internal.auth.zzan
    public final void zza(zzal zzalVar, ProxyRequest proxyRequest) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzalVar);
        zzc.zza(a2, proxyRequest);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.auth.zzan
    public final void zza(zzal zzalVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzalVar);
        b(3, a2);
    }
}
