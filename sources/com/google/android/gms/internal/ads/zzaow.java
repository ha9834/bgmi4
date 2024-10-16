package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public abstract class zzaow extends zzfn implements zzaov {
    public zzaow() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzaov zzab(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        if (queryLocalInterface instanceof zzaov) {
            return (zzaov) queryLocalInterface;
        }
        return new zzaox(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaoy zzapaVar;
        zzaoj zzaolVar;
        zzaom zzaooVar;
        zzaos zzaouVar;
        zzaop zzaorVar;
        switch (i) {
            case 1:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString = parcel.readString();
                Bundle bundle = (Bundle) zzfo.zza(parcel, Bundle.CREATOR);
                Bundle bundle2 = (Bundle) zzfo.zza(parcel, Bundle.CREATOR);
                zzyd zzydVar = (zzyd) zzfo.zza(parcel, zzyd.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzapaVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                    if (queryLocalInterface instanceof zzaoy) {
                        zzapaVar = (zzaoy) queryLocalInterface;
                    } else {
                        zzapaVar = new zzapa(readStrongBinder);
                    }
                }
                zza(asInterface, readString, bundle, bundle2, zzydVar, zzapaVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzapj zzsx = zzsx();
                parcel2.writeNoException();
                zzfo.zzb(parcel2, zzsx);
                return true;
            case 3:
                zzapj zzsy = zzsy();
                parcel2.writeNoException();
                zzfo.zzb(parcel2, zzsy);
                return true;
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
            case 12:
            default:
                return false;
            case 5:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.zza(parcel2, videoController);
                return true;
            case 10:
                zzx(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                zza(parcel.createStringArray(), (Bundle[]) parcel.createTypedArray(Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                zzxz zzxzVar = (zzxz) zzfo.zza(parcel, zzxz.CREATOR);
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 == null) {
                    zzaolVar = null;
                } else {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                    if (queryLocalInterface2 instanceof zzaoj) {
                        zzaolVar = (zzaoj) queryLocalInterface2;
                    } else {
                        zzaolVar = new zzaol(readStrongBinder2);
                    }
                }
                zza(readString2, readString3, zzxzVar, asInterface2, zzaolVar, zzamw.zzz(parcel.readStrongBinder()), (zzyd) zzfo.zza(parcel, zzyd.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                zzxz zzxzVar2 = (zzxz) zzfo.zza(parcel, zzxz.CREATOR);
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 == null) {
                    zzaooVar = null;
                } else {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                    if (queryLocalInterface3 instanceof zzaom) {
                        zzaooVar = (zzaom) queryLocalInterface3;
                    } else {
                        zzaooVar = new zzaoo(readStrongBinder3);
                    }
                }
                zza(readString4, readString5, zzxzVar2, asInterface3, zzaooVar, zzamw.zzz(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                boolean zzy = zzy(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, zzy);
                return true;
            case 16:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                zzxz zzxzVar3 = (zzxz) zzfo.zza(parcel, zzxz.CREATOR);
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 == null) {
                    zzaouVar = null;
                } else {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                    if (queryLocalInterface4 instanceof zzaos) {
                        zzaouVar = (zzaos) queryLocalInterface4;
                    } else {
                        zzaouVar = new zzaou(readStrongBinder4);
                    }
                }
                zza(readString6, readString7, zzxzVar3, asInterface4, zzaouVar, zzamw.zzz(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 17:
                boolean zzz = zzz(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, zzz);
                return true;
            case 18:
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                zzxz zzxzVar4 = (zzxz) zzfo.zza(parcel, zzxz.CREATOR);
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 == null) {
                    zzaorVar = null;
                } else {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                    if (queryLocalInterface5 instanceof zzaop) {
                        zzaorVar = (zzaop) queryLocalInterface5;
                    } else {
                        zzaorVar = new zzaor(readStrongBinder5);
                    }
                }
                zza(readString8, readString9, zzxzVar4, asInterface5, zzaorVar, zzamw.zzz(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
        }
    }
}
