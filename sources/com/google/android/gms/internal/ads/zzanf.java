package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzanf extends zzfm implements zzand {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String getHeadline() throws RemoteException {
        Parcel a2 = a(2, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final List getImages() throws RemoteException {
        Parcel a2 = a(3, a());
        ArrayList zzb = zzfo.zzb(a2);
        a2.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String getBody() throws RemoteException {
        Parcel a2 = a(4, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaei zzrl() throws RemoteException {
        Parcel a2 = a(5, a());
        zzaei zzk = zzaej.zzk(a2.readStrongBinder());
        a2.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String getCallToAction() throws RemoteException {
        Parcel a2 = a(6, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String getAdvertiser() throws RemoteException {
        Parcel a2 = a(7, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void recordImpression() throws RemoteException {
        b(8, a());
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(9, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zzu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(10, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final boolean getOverrideImpressionRecording() throws RemoteException {
        Parcel a2 = a(11, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final boolean getOverrideClickHandling() throws RemoteException {
        Parcel a2 = a(12, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final Bundle getExtras() throws RemoteException {
        Parcel a2 = a(13, a());
        Bundle bundle = (Bundle) zzfo.zza(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zzv(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(14, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper zzso() throws RemoteException {
        Parcel a2 = a(15, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaar getVideoController() throws RemoteException {
        Parcel a2 = a(16, a());
        zzaar zzh = zzaas.zzh(a2.readStrongBinder());
        a2.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaea zzrj() throws RemoteException {
        Parcel a2 = a(19, a());
        zzaea zzj = zzaeb.zzj(a2.readStrongBinder());
        a2.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper zzsp() throws RemoteException {
        Parcel a2 = a(20, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper zzrk() throws RemoteException {
        Parcel a2 = a(21, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, iObjectWrapper2);
        zzfo.zza(a2, iObjectWrapper3);
        b(22, a2);
    }
}
