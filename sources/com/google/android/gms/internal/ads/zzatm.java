package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzatm extends zzfm implements zzatk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzae(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzd(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        a2.writeInt(i);
        b(2, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzaf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(3, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzag(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(4, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzah(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(5, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzai(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(6, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zza(IObjectWrapper iObjectWrapper, zzato zzatoVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzatoVar);
        b(7, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzaj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(8, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        a2.writeInt(i);
        b(9, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzak(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(10, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzal(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(11, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzb(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, bundle);
        b(12, a2);
    }
}
