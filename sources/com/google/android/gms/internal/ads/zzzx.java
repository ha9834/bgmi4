package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzzx extends zzfm implements zzzv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, zzamp zzampVar, int i) throws RemoteException {
        zzzk zzzmVar;
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzydVar);
        a2.writeString(str);
        zzfo.zza(a2, zzampVar);
        a2.writeInt(i);
        Parcel a3 = a(1, a2);
        IBinder readStrongBinder = a3.readStrongBinder();
        if (readStrongBinder == null) {
            zzzmVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzzk) {
                zzzmVar = (zzzk) queryLocalInterface;
            } else {
                zzzmVar = new zzzm(readStrongBinder);
            }
        }
        a3.recycle();
        return zzzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zzb(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, zzamp zzampVar, int i) throws RemoteException {
        zzzk zzzmVar;
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzydVar);
        a2.writeString(str);
        zzfo.zza(a2, zzampVar);
        a2.writeInt(i);
        Parcel a3 = a(2, a2);
        IBinder readStrongBinder = a3.readStrongBinder();
        if (readStrongBinder == null) {
            zzzmVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzzk) {
                zzzmVar = (zzzk) queryLocalInterface;
            } else {
                zzzmVar = new zzzm(readStrongBinder);
            }
        }
        a3.recycle();
        return zzzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzf zza(IObjectWrapper iObjectWrapper, String str, zzamp zzampVar, int i) throws RemoteException {
        zzzf zzzhVar;
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        a2.writeString(str);
        zzfo.zza(a2, zzampVar);
        a2.writeInt(i);
        Parcel a3 = a(3, a2);
        IBinder readStrongBinder = a3.readStrongBinder();
        if (readStrongBinder == null) {
            zzzhVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzzf) {
                zzzhVar = (zzzf) queryLocalInterface;
            } else {
                zzzhVar = new zzzh(readStrongBinder);
            }
        }
        a3.recycle();
        return zzzhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaab zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaab zzaadVar;
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        Parcel a3 = a(4, a2);
        IBinder readStrongBinder = a3.readStrongBinder();
        if (readStrongBinder == null) {
            zzaadVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzaab) {
                zzaadVar = (zzaab) queryLocalInterface;
            } else {
                zzaadVar = new zzaad(readStrongBinder);
            }
        }
        a3.recycle();
        return zzaadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaem zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, iObjectWrapper2);
        Parcel a3 = a(5, a2);
        zzaem zzl = zzaen.zzl(a3.readStrongBinder());
        a3.recycle();
        return zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzasw zza(IObjectWrapper iObjectWrapper, zzamp zzampVar, int i) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzampVar);
        a2.writeInt(i);
        Parcel a3 = a(6, a2);
        zzasw zzag = zzasx.zzag(a3.readStrongBinder());
        a3.recycle();
        return zzag;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaqq zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        Parcel a3 = a(7, a2);
        zzaqq zzae = zzaqr.zzae(a3.readStrongBinder());
        a3.recycle();
        return zzae;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaqg zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        Parcel a3 = a(8, a2);
        zzaqg zzac = zzaqh.zzac(a3.readStrongBinder());
        a3.recycle();
        return zzac;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaab zza(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzaab zzaadVar;
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        a2.writeInt(i);
        Parcel a3 = a(9, a2);
        IBinder readStrongBinder = a3.readStrongBinder();
        if (readStrongBinder == null) {
            zzaadVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzaab) {
                zzaadVar = (zzaab) queryLocalInterface;
            } else {
                zzaadVar = new zzaad(readStrongBinder);
            }
        }
        a3.recycle();
        return zzaadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, int i) throws RemoteException {
        zzzk zzzmVar;
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzydVar);
        a2.writeString(str);
        a2.writeInt(i);
        Parcel a3 = a(10, a2);
        IBinder readStrongBinder = a3.readStrongBinder();
        if (readStrongBinder == null) {
            zzzmVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzzk) {
                zzzmVar = (zzzk) queryLocalInterface;
            } else {
                zzzmVar = new zzzm(readStrongBinder);
            }
        }
        a3.recycle();
        return zzzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaer zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, iObjectWrapper2);
        zzfo.zza(a2, iObjectWrapper3);
        Parcel a3 = a(11, a2);
        zzaer zzm = zzaes.zzm(a3.readStrongBinder());
        a3.recycle();
        return zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzatt zzb(IObjectWrapper iObjectWrapper, String str, zzamp zzampVar, int i) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        a2.writeString(str);
        zzfo.zza(a2, zzampVar);
        a2.writeInt(i);
        Parcel a3 = a(12, a2);
        zzatt zzak = zzatu.zzak(a3.readStrongBinder());
        a3.recycle();
        return zzak;
    }
}
