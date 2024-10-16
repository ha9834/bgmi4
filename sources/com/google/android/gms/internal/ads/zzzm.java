package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzzm extends zzfm implements zzzk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final IObjectWrapper zzpl() throws RemoteException {
        Parcel a2 = a(1, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void destroy() throws RemoteException {
        b(2, a());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean isReady() throws RemoteException {
        Parcel a2 = a(3, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean zzb(zzxz zzxzVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzxzVar);
        Parcel a3 = a(4, a2);
        boolean zza = zzfo.zza(a3);
        a3.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void pause() throws RemoteException {
        b(5, a());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void resume() throws RemoteException {
        b(6, a());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzb(zzyz zzyzVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzyzVar);
        b(7, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzzs zzzsVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzzsVar);
        b(8, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void showInterstitial() throws RemoteException {
        b(9, a());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void stopLoading() throws RemoteException {
        b(10, a());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzpm() throws RemoteException {
        b(11, a());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyd zzpn() throws RemoteException {
        Parcel a2 = a(12, a());
        zzyd zzydVar = (zzyd) zzfo.zza(a2, zzyd.CREATOR);
        a2.recycle();
        return zzydVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzyd zzydVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzydVar);
        b(13, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzaqn zzaqnVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaqnVar);
        b(14, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzaqt zzaqtVar, String str) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaqtVar);
        a2.writeString(str);
        b(15, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel a2 = a(18, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzado zzadoVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzadoVar);
        b(19, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzyw zzywVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzywVar);
        b(20, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzb(zzzy zzzyVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzzyVar);
        b(21, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        Parcel a2 = a();
        zzfo.writeBoolean(a2, z);
        b(22, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean isLoading() throws RemoteException {
        Parcel a2 = a(23, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzatb zzatbVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzatbVar);
        b(24, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setUserId(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(25, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzaar getVideoController() throws RemoteException {
        zzaar zzaatVar;
        Parcel a2 = a(26, a());
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzaatVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            if (queryLocalInterface instanceof zzaar) {
                zzaatVar = (zzaar) queryLocalInterface;
            } else {
                zzaatVar = new zzaat(readStrongBinder);
            }
        }
        a2.recycle();
        return zzaatVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzacd zzacdVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzacdVar);
        b(29, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzaax zzaaxVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaaxVar);
        b(30, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String getAdUnitId() throws RemoteException {
        Parcel a2 = a(31, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzzs zzpo() throws RemoteException {
        zzzs zzzuVar;
        Parcel a2 = a(32, a());
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzzuVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            if (queryLocalInterface instanceof zzzs) {
                zzzuVar = (zzzs) queryLocalInterface;
            } else {
                zzzuVar = new zzzu(readStrongBinder);
            }
        }
        a2.recycle();
        return zzzuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyz zzpp() throws RemoteException {
        zzyz zzzbVar;
        Parcel a2 = a(33, a());
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzzbVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            if (queryLocalInterface instanceof zzyz) {
                zzzbVar = (zzyz) queryLocalInterface;
            } else {
                zzzbVar = new zzzb(readStrongBinder);
            }
        }
        a2.recycle();
        return zzzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel a2 = a();
        zzfo.writeBoolean(a2, z);
        b(34, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String zzpj() throws RemoteException {
        Parcel a2 = a(35, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zza(zzzp zzzpVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzzpVar);
        b(36, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final Bundle getAdMetadata() throws RemoteException {
        Parcel a2 = a(37, a());
        Bundle bundle = (Bundle) zzfo.zza(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzbt(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(38, a2);
    }
}
