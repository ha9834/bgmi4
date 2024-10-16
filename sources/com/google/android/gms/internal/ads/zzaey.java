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
public final class zzaey extends zzfm implements zzaew {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaey(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final IObjectWrapper zzrh() throws RemoteException {
        Parcel a2 = a(2, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getHeadline() throws RemoteException {
        Parcel a2 = a(3, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final List getImages() throws RemoteException {
        Parcel a2 = a(4, a());
        ArrayList zzb = zzfo.zzb(a2);
        a2.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getBody() throws RemoteException {
        Parcel a2 = a(5, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzaei zzri() throws RemoteException {
        zzaei zzaekVar;
        Parcel a2 = a(6, a());
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

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getCallToAction() throws RemoteException {
        Parcel a2 = a(7, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final double getStarRating() throws RemoteException {
        Parcel a2 = a(8, a());
        double readDouble = a2.readDouble();
        a2.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getStore() throws RemoteException {
        Parcel a2 = a(9, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getPrice() throws RemoteException {
        Parcel a2 = a(10, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final Bundle getExtras() throws RemoteException {
        Parcel a2 = a(11, a());
        Bundle bundle = (Bundle) zzfo.zza(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void destroy() throws RemoteException {
        b(12, a());
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzaar getVideoController() throws RemoteException {
        Parcel a2 = a(13, a());
        zzaar zzh = zzaas.zzh(a2.readStrongBinder());
        a2.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void performClick(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, bundle);
        b(14, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, bundle);
        Parcel a3 = a(15, a2);
        boolean zza = zzfo.zza(a3);
        a3.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, bundle);
        b(16, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzaea zzrj() throws RemoteException {
        zzaea zzaecVar;
        Parcel a2 = a(17, a());
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

    @Override // com.google.android.gms.internal.ads.zzaew
    public final IObjectWrapper zzrk() throws RemoteException {
        Parcel a2 = a(18, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel a2 = a(19, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }
}
