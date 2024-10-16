package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* loaded from: classes2.dex */
public final class zzzh extends zzfm implements zzzf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final zzzc zzpk() throws RemoteException {
        zzzc zzzeVar;
        Parcel a2 = a(1, a());
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzzeVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            if (queryLocalInterface instanceof zzzc) {
                zzzeVar = (zzzc) queryLocalInterface;
            } else {
                zzzeVar = new zzze(readStrongBinder);
            }
        }
        a2.recycle();
        return zzzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzyz zzyzVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzyzVar);
        b(2, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzafi zzafiVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzafiVar);
        b(3, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzafl zzaflVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaflVar);
        b(4, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(String str, zzafr zzafrVar, zzafo zzafoVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        zzfo.zza(a2, zzafrVar);
        zzfo.zza(a2, zzafoVar);
        b(5, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzady zzadyVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzadyVar);
        b(6, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzzy zzzyVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzzyVar);
        b(7, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzafu zzafuVar, zzyd zzydVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzafuVar);
        zzfo.zza(a2, zzydVar);
        b(8, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, publisherAdViewOptions);
        b(9, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzafx zzafxVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzafxVar);
        b(10, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzaiy zzaiyVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaiyVar);
        b(13, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void zza(zzaje zzajeVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzajeVar);
        b(14, a2);
    }
}
