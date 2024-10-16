package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzasy extends zzfm implements zzasw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zza(zzath zzathVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzathVar);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void show() throws RemoteException {
        b(2, a());
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zza(zzatb zzatbVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzatbVar);
        b(3, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final boolean isLoaded() throws RemoteException {
        Parcel a2 = a(5, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void pause() throws RemoteException {
        b(6, a());
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void resume() throws RemoteException {
        b(7, a());
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void destroy() throws RemoteException {
        b(8, a());
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(9, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(10, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(11, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel a2 = a(12, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setUserId(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(13, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zza(zzzp zzzpVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzzpVar);
        b(14, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final Bundle getAdMetadata() throws RemoteException {
        Parcel a2 = a(15, a());
        Bundle bundle = (Bundle) zzfo.zza(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zza(zzasu zzasuVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzasuVar);
        b(16, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setAppPackageName(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(17, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(18, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setCustomData(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(19, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel a2 = a();
        zzfo.writeBoolean(a2, z);
        b(34, a2);
    }
}
