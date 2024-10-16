package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbsm;

/* loaded from: classes2.dex */
public interface zzcka<AdT, AdapterT, ListenerT extends zzbsm> {
    void zza(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<AdapterT, ListenerT> zzcjyVar) throws RemoteException;

    AdT zzb(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<AdapterT, ListenerT> zzcjyVar) throws RemoteException, zzcmw;
}
