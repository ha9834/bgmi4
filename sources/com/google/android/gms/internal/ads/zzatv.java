package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzatv extends zzfm implements zzatt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(zzxz zzxzVar, zzaub zzaubVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzxzVar);
        zzfo.zza(a2, zzaubVar);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(zzatw zzatwVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzatwVar);
        b(2, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final boolean isLoaded() throws RemoteException {
        Parcel a2 = a(3, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel a2 = a(4, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(5, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(zzaue zzaueVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaueVar);
        b(6, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(zzaum zzaumVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaumVar);
        b(7, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(zzaao zzaaoVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaaoVar);
        b(8, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final Bundle getAdMetadata() throws RemoteException {
        Parcel a2 = a(9, a());
        Bundle bundle = (Bundle) zzfo.zza(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.writeBoolean(a2, z);
        b(10, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final zzatq zzqh() throws RemoteException {
        zzatq zzatsVar;
        Parcel a2 = a(11, a());
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzatsVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            if (queryLocalInterface instanceof zzatq) {
                zzatsVar = (zzatq) queryLocalInterface;
            } else {
                zzatsVar = new zzats(readStrongBinder);
            }
        }
        a2.recycle();
        return zzatsVar;
    }
}
