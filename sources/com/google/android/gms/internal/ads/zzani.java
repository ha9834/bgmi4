package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzani extends zzfm implements zzang {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzani(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String getHeadline() throws RemoteException {
        Parcel a2 = a(2, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final List getImages() throws RemoteException {
        Parcel a2 = a(3, a());
        ArrayList zzb = zzfo.zzb(a2);
        a2.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String getBody() throws RemoteException {
        Parcel a2 = a(4, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzaei zzri() throws RemoteException {
        Parcel a2 = a(5, a());
        zzaei zzk = zzaej.zzk(a2.readStrongBinder());
        a2.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String getCallToAction() throws RemoteException {
        Parcel a2 = a(6, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String getAdvertiser() throws RemoteException {
        Parcel a2 = a(7, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final double getStarRating() throws RemoteException {
        Parcel a2 = a(8, a());
        double readDouble = a2.readDouble();
        a2.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String getStore() throws RemoteException {
        Parcel a2 = a(9, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final String getPrice() throws RemoteException {
        Parcel a2 = a(10, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzaar getVideoController() throws RemoteException {
        Parcel a2 = a(11, a());
        zzaar zzh = zzaas.zzh(a2.readStrongBinder());
        a2.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzaea zzrj() throws RemoteException {
        Parcel a2 = a(12, a());
        zzaea zzj = zzaeb.zzj(a2.readStrongBinder());
        a2.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final IObjectWrapper zzso() throws RemoteException {
        Parcel a2 = a(13, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final IObjectWrapper zzsp() throws RemoteException {
        Parcel a2 = a(14, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final IObjectWrapper zzrk() throws RemoteException {
        Parcel a2 = a(15, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final Bundle getExtras() throws RemoteException {
        Parcel a2 = a(16, a());
        Bundle bundle = (Bundle) zzfo.zza(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final boolean getOverrideImpressionRecording() throws RemoteException {
        Parcel a2 = a(17, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final boolean getOverrideClickHandling() throws RemoteException {
        Parcel a2 = a(18, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void recordImpression() throws RemoteException {
        b(19, a());
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(20, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, iObjectWrapper2);
        zzfo.zza(a2, iObjectWrapper3);
        b(21, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzv(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(22, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final float zzsq() throws RemoteException {
        Parcel a2 = a(23, a());
        float readFloat = a2.readFloat();
        a2.recycle();
        return readFloat;
    }
}
