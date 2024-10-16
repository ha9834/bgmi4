package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzasx extends zzfn implements zzasw {
    public zzasx() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static zzasw zzag(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        if (queryLocalInterface instanceof zzasw) {
            return (zzasw) queryLocalInterface;
        }
        return new zzasy(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 34) {
            zzatb zzatbVar = null;
            zzasu zzasuVar = null;
            switch (i) {
                case 1:
                    zza((zzath) zzfo.zza(parcel, zzath.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    show();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                        if (queryLocalInterface instanceof zzatb) {
                            zzatbVar = (zzatb) queryLocalInterface;
                        } else {
                            zzatbVar = new zzatd(readStrongBinder);
                        }
                    }
                    zza(zzatbVar);
                    parcel2.writeNoException();
                    return true;
                default:
                    switch (i) {
                        case 5:
                            boolean isLoaded = isLoaded();
                            parcel2.writeNoException();
                            zzfo.writeBoolean(parcel2, isLoaded);
                            return true;
                        case 6:
                            pause();
                            parcel2.writeNoException();
                            return true;
                        case 7:
                            resume();
                            parcel2.writeNoException();
                            return true;
                        case 8:
                            destroy();
                            parcel2.writeNoException();
                            return true;
                        case 9:
                            zzl(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 10:
                            zzm(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 11:
                            zzn(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 12:
                            String mediationAdapterClassName = getMediationAdapterClassName();
                            parcel2.writeNoException();
                            parcel2.writeString(mediationAdapterClassName);
                            return true;
                        case 13:
                            setUserId(parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 14:
                            zza(zzzq.zzc(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 15:
                            Bundle adMetadata = getAdMetadata();
                            parcel2.writeNoException();
                            zzfo.zzb(parcel2, adMetadata);
                            return true;
                        case 16:
                            IBinder readStrongBinder2 = parcel.readStrongBinder();
                            if (readStrongBinder2 != null) {
                                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                                if (queryLocalInterface2 instanceof zzasu) {
                                    zzasuVar = (zzasu) queryLocalInterface2;
                                } else {
                                    zzasuVar = new zzasv(readStrongBinder2);
                                }
                            }
                            zza(zzasuVar);
                            parcel2.writeNoException();
                            return true;
                        case 17:
                            setAppPackageName(parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 18:
                            zzk(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 19:
                            setCustomData(parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        default:
                            return false;
                    }
            }
        }
        setImmersiveMode(zzfo.zza(parcel));
        parcel2.writeNoException();
        return true;
    }
}
