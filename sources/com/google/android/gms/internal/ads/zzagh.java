package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzagh extends zzfn implements zzagg {
    public zzagh() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzagd zzagfVar;
        switch (i) {
            case 2:
                String headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 3:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                return true;
            case 4:
                String body = getBody();
                parcel2.writeNoException();
                parcel2.writeString(body);
                return true;
            case 5:
                zzaei zzri = zzri();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzri);
                return true;
            case 6:
                String callToAction = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(callToAction);
                return true;
            case 7:
                String advertiser = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(advertiser);
                return true;
            case 8:
                double starRating = getStarRating();
                parcel2.writeNoException();
                parcel2.writeDouble(starRating);
                return true;
            case 9:
                String store = getStore();
                parcel2.writeNoException();
                parcel2.writeString(store);
                return true;
            case 10:
                String price = getPrice();
                parcel2.writeNoException();
                parcel2.writeString(price);
                return true;
            case 11:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.zza(parcel2, videoController);
                return true;
            case 12:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 13:
                destroy();
                parcel2.writeNoException();
                return true;
            case 14:
                zzaea zzrj = zzrj();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzrj);
                return true;
            case 15:
                performClick((Bundle) zzfo.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 16:
                boolean recordImpression = recordImpression((Bundle) zzfo.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, recordImpression);
                return true;
            case 17:
                reportTouchEvent((Bundle) zzfo.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 18:
                IObjectWrapper zzrh = zzrh();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzrh);
                return true;
            case 19:
                IObjectWrapper zzrk = zzrk();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzrk);
                return true;
            case 20:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.zzb(parcel2, extras);
                return true;
            case 21:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzagfVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                    if (queryLocalInterface instanceof zzagd) {
                        zzagfVar = (zzagd) queryLocalInterface;
                    } else {
                        zzagfVar = new zzagf(readStrongBinder);
                    }
                }
                zza(zzagfVar);
                parcel2.writeNoException();
                return true;
            case 22:
                cancelUnconfirmedClick();
                parcel2.writeNoException();
                return true;
            case 23:
                List muteThisAdReasons = getMuteThisAdReasons();
                parcel2.writeNoException();
                parcel2.writeList(muteThisAdReasons);
                return true;
            case 24:
                boolean isCustomMuteThisAdEnabled = isCustomMuteThisAdEnabled();
                parcel2.writeNoException();
                zzfo.writeBoolean(parcel2, isCustomMuteThisAdEnabled);
                return true;
            case 25:
                zza(zzaal.zzf(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 26:
                zza(zzaah.zze(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 27:
                zzro();
                parcel2.writeNoException();
                return true;
            case 28:
                recordCustomClickGesture();
                parcel2.writeNoException();
                return true;
            case 29:
                zzaee zzrp = zzrp();
                parcel2.writeNoException();
                zzfo.zza(parcel2, zzrp);
                return true;
            default:
                return false;
        }
    }
}
