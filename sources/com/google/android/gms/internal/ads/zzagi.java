package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzagi extends zzfm implements zzagg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getHeadline() throws RemoteException {
        Parcel a2 = a(2, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final List getImages() throws RemoteException {
        Parcel a2 = a(3, a());
        ArrayList zzb = zzfo.zzb(a2);
        a2.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getBody() throws RemoteException {
        Parcel a2 = a(4, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaei zzri() throws RemoteException {
        zzaei zzaekVar;
        Parcel a2 = a(5, a());
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzaekVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            if (queryLocalInterface instanceof zzaei) {
                zzaekVar = (zzaei) queryLocalInterface;
            } else {
                zzaekVar = new zzaek(readStrongBinder);
            }
        }
        a2.recycle();
        return zzaekVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getCallToAction() throws RemoteException {
        Parcel a2 = a(6, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getAdvertiser() throws RemoteException {
        Parcel a2 = a(7, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final double getStarRating() throws RemoteException {
        Parcel a2 = a(8, a());
        double readDouble = a2.readDouble();
        a2.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getStore() throws RemoteException {
        Parcel a2 = a(9, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getPrice() throws RemoteException {
        Parcel a2 = a(10, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaar getVideoController() throws RemoteException {
        Parcel a2 = a(11, a());
        zzaar zzh = zzaas.zzh(a2.readStrongBinder());
        a2.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel a2 = a(12, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void destroy() throws RemoteException {
        b(13, a());
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaea zzrj() throws RemoteException {
        zzaea zzaecVar;
        Parcel a2 = a(14, a());
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzaecVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            if (queryLocalInterface instanceof zzaea) {
                zzaecVar = (zzaea) queryLocalInterface;
            } else {
                zzaecVar = new zzaec(readStrongBinder);
            }
        }
        a2.recycle();
        return zzaecVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void performClick(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, bundle);
        b(15, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, bundle);
        Parcel a3 = a(16, a2);
        boolean zza = zzfo.zza(a3);
        a3.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, bundle);
        b(17, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final IObjectWrapper zzrh() throws RemoteException {
        Parcel a2 = a(18, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final IObjectWrapper zzrk() throws RemoteException {
        Parcel a2 = a(19, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final Bundle getExtras() throws RemoteException {
        Parcel a2 = a(20, a());
        Bundle bundle = (Bundle) zzfo.zza(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void zza(zzagd zzagdVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzagdVar);
        b(21, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void cancelUnconfirmedClick() throws RemoteException {
        b(22, a());
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final List getMuteThisAdReasons() throws RemoteException {
        Parcel a2 = a(23, a());
        ArrayList zzb = zzfo.zzb(a2);
        a2.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final boolean isCustomMuteThisAdEnabled() throws RemoteException {
        Parcel a2 = a(24, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void zza(zzaak zzaakVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaakVar);
        b(25, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void zza(zzaag zzaagVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzaagVar);
        b(26, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void zzro() throws RemoteException {
        b(27, a());
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void recordCustomClickGesture() throws RemoteException {
        b(28, a());
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaee zzrp() throws RemoteException {
        zzaee zzaegVar;
        Parcel a2 = a(29, a());
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzaegVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            if (queryLocalInterface instanceof zzaee) {
                zzaegVar = (zzaee) queryLocalInterface;
            } else {
                zzaegVar = new zzaeg(readStrongBinder);
            }
        }
        a2.recycle();
        return zzaegVar;
    }
}
