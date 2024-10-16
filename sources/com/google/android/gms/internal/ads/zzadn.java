package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzadn extends zzfm implements zzadl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final String zzqz() throws RemoteException {
        Parcel a2 = a(1, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final String getContent() throws RemoteException {
        Parcel a2 = a(2, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(3, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void recordClick() throws RemoteException {
        b(4, a());
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void recordImpression() throws RemoteException {
        b(5, a());
    }
}
