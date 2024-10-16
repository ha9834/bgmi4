package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzzl extends zzfn implements zzzk {
    public zzzl() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzzk zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface instanceof zzzk) {
            return (zzzk) queryLocalInterface;
        }
        return new zzzm(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzyz zzyzVar = null;
        zzzp zzzpVar = null;
        zzzy zzzyVar = null;
        zzyw zzywVar = null;
        zzzs zzzsVar = null;
        switch (i) {
            case 1:
                IObjectWrapper zzpl = zzpl();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzpl);
                return true;
            case 2:
                destroy();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean isReady = isReady();
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, isReady);
                return true;
            case 4:
                boolean zzb = zzb((zzxz) zzfo.zza(parcel, zzxz.CREATOR));
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, zzb);
                return true;
            case 5:
                pause();
                parcel2.writeNoException();
                return true;
            case 6:
                resume();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface instanceof zzyz) {
                        zzyzVar = (zzyz) queryLocalInterface;
                    } else {
                        zzyzVar = new zzzb(readStrongBinder);
                    }
                }
                zzb(zzyzVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    if (queryLocalInterface2 instanceof zzzs) {
                        zzzsVar = (zzzs) queryLocalInterface2;
                    } else {
                        zzzsVar = new zzzu(readStrongBinder2);
                    }
                }
                zza(zzzsVar);
                parcel2.writeNoException();
                return true;
            case 9:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 10:
                stopLoading();
                parcel2.writeNoException();
                return true;
            case 11:
                zzpm();
                parcel2.writeNoException();
                return true;
            case 12:
                zzyd zzpn = zzpn();
                parcel2.writeNoException();
                zzfo.zzb(parcel2, zzpn);
                return true;
            case 13:
                zza((zzyd) zzfo.zza(parcel, zzyd.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza(zzaqo.zzad(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zza(zzaqu.zzaf(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 19:
                zza(zzadp.zzi(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    if (queryLocalInterface3 instanceof zzyw) {
                        zzywVar = (zzyw) queryLocalInterface3;
                    } else {
                        zzywVar = new zzyy(readStrongBinder3);
                    }
                }
                zza(zzywVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface4 instanceof zzzy) {
                        zzzyVar = (zzzy) queryLocalInterface4;
                    } else {
                        zzzyVar = new zzaaa(readStrongBinder4);
                    }
                }
                zzb(zzzyVar);
                parcel2.writeNoException();
                return true;
            case 22:
                setManualImpressionsEnabled(zzfo.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 23:
                boolean isLoading = isLoading();
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, isLoading);
                return true;
            case 24:
                zza(zzatc.zzah(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 25:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 26:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.zza(parcel2, videoController);
                return true;
            case 29:
                zza((zzacd) zzfo.zza(parcel, zzacd.CREATOR));
                parcel2.writeNoException();
                return true;
            case 30:
                zza((zzaax) zzfo.zza(parcel, zzaax.CREATOR));
                parcel2.writeNoException();
                return true;
            case 31:
                String adUnitId = getAdUnitId();
                parcel2.writeNoException();
                parcel2.writeString(adUnitId);
                return true;
            case 32:
                zzzs zzpo = zzpo();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzpo);
                return true;
            case 33:
                zzyz zzpp = zzpp();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzpp);
                return true;
            case 34:
                setImmersiveMode(zzfo.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 35:
                String zzpj = zzpj();
                parcel2.writeNoException();
                parcel2.writeString(zzpj);
                return true;
            case 36:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    if (queryLocalInterface5 instanceof zzzp) {
                        zzzpVar = (zzzp) queryLocalInterface5;
                    } else {
                        zzzpVar = new zzzr(readStrongBinder5);
                    }
                }
                zza(zzzpVar);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle adMetadata = getAdMetadata();
                parcel2.writeNoException();
                zzfo.zzb(parcel2, adMetadata);
                return true;
            case 38:
                zzbt(parcel.readString());
                parcel2.writeNoException();
                return true;
        }
    }
}
