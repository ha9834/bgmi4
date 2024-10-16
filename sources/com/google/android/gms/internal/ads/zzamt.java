package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzamt extends zzfn implements zzams {
    public zzamt() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzamv zzamxVar;
        zzamv zzamxVar2;
        zzamv zzamxVar3;
        zzamv zzamxVar4;
        zzamv zzamvVar = null;
        switch (i) {
            case 1:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzyd zzydVar = (zzyd) zzfo.zza(parcel, zzyd.CREATOR);
                zzxz zzxzVar = (zzxz) zzfo.zza(parcel, zzxz.CREATOR);
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzamxVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface instanceof zzamv) {
                        zzamxVar = (zzamv) queryLocalInterface;
                    } else {
                        zzamxVar = new zzamx(readStrongBinder);
                    }
                }
                zza(asInterface, zzydVar, zzxzVar, readString, zzamxVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper zzse = zzse();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzse);
                return true;
            case 3:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzxz zzxzVar2 = (zzxz) zzfo.zza(parcel, zzxz.CREATOR);
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface2 instanceof zzamv) {
                        zzamvVar = (zzamv) queryLocalInterface2;
                    } else {
                        zzamvVar = new zzamx(readStrongBinder2);
                    }
                }
                zza(asInterface2, zzxzVar2, readString2, zzamvVar);
                parcel2.writeNoException();
                return true;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 5:
                destroy();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzyd zzydVar2 = (zzyd) zzfo.zza(parcel, zzyd.CREATOR);
                zzxz zzxzVar3 = (zzxz) zzfo.zza(parcel, zzxz.CREATOR);
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 == null) {
                    zzamxVar2 = null;
                } else {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface3 instanceof zzamv) {
                        zzamxVar2 = (zzamv) queryLocalInterface3;
                    } else {
                        zzamxVar2 = new zzamx(readStrongBinder3);
                    }
                }
                zza(asInterface3, zzydVar2, zzxzVar3, readString3, readString4, zzamxVar2);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzxz zzxzVar4 = (zzxz) zzfo.zza(parcel, zzxz.CREATOR);
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 == null) {
                    zzamxVar3 = null;
                } else {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface4 instanceof zzamv) {
                        zzamxVar3 = (zzamv) queryLocalInterface4;
                    } else {
                        zzamxVar3 = new zzamx(readStrongBinder4);
                    }
                }
                zza(asInterface4, zzxzVar4, readString5, readString6, zzamxVar3);
                parcel2.writeNoException();
                return true;
            case 8:
                pause();
                parcel2.writeNoException();
                return true;
            case 9:
                resume();
                parcel2.writeNoException();
                return true;
            case 10:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzxz) zzfo.zza(parcel, zzxz.CREATOR), parcel.readString(), zzatl.zzai(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zza((zzxz) zzfo.zza(parcel, zzxz.CREATOR), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                showVideo();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean isInitialized = isInitialized();
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, isInitialized);
                return true;
            case 14:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzxz zzxzVar5 = (zzxz) zzfo.zza(parcel, zzxz.CREATOR);
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 == null) {
                    zzamxVar4 = null;
                } else {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface5 instanceof zzamv) {
                        zzamxVar4 = (zzamv) queryLocalInterface5;
                    } else {
                        zzamxVar4 = new zzamx(readStrongBinder5);
                    }
                }
                zza(asInterface5, zzxzVar5, readString7, readString8, zzamxVar4, (zzady) zzfo.zza(parcel, zzady.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 15:
                zzana zzsf = zzsf();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzsf);
                return true;
            case 16:
                zzand zzsg = zzsg();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzsg);
                return true;
            case 17:
                Bundle zzsh = zzsh();
                parcel2.writeNoException();
                zzfo.zzb(parcel2, zzsh);
                return true;
            case 18:
                Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzfo.zzb(parcel2, interstitialAdapterInfo);
                return true;
            case 19:
                Bundle zzsi = zzsi();
                parcel2.writeNoException();
                zzfo.zzb(parcel2, zzsi);
                return true;
            case 20:
                zza((zzxz) zzfo.zza(parcel, zzxz.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 21:
                zzr(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zzsj = zzsj();
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, zzsj);
                return true;
            case 23:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzatl.zzai(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 24:
                zzafe zzsk = zzsk();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzsk);
                return true;
            case 25:
                setImmersiveMode(zzfo.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 26:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.zza(parcel2, videoController);
                return true;
            case 27:
                zzang zzsl = zzsl();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzsl);
                return true;
            case 28:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzxz zzxzVar6 = (zzxz) zzfo.zza(parcel, zzxz.CREATOR);
                String readString9 = parcel.readString();
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface6 instanceof zzamv) {
                        zzamvVar = (zzamv) queryLocalInterface6;
                    } else {
                        zzamvVar = new zzamx(readStrongBinder6);
                    }
                }
                zzb(asInterface6, zzxzVar6, readString9, zzamvVar);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                zzs(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 31:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzair.zzv(parcel.readStrongBinder()), parcel.createTypedArrayList(zzaiw.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
