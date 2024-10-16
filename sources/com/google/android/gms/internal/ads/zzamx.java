package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzamx extends zzfm implements zzamv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdClicked() throws RemoteException {
        b(1, a());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdClosed() throws RemoteException {
        b(2, a());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdFailedToLoad(int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        b(3, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdLeftApplication() throws RemoteException {
        b(4, a());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdOpened() throws RemoteException {
        b(5, a());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdLoaded() throws RemoteException {
        b(6, a());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(zzamy zzamyVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzamyVar);
        b(7, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdImpression() throws RemoteException {
        b(8, a());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAppEvent(String str, String str2) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        b(9, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(zzafe zzafeVar, String str) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzafeVar);
        a2.writeString(str);
        b(10, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onVideoEnd() throws RemoteException {
        b(11, a());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzcz(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(12, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzsm() throws RemoteException {
        b(13, a());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzb(zzato zzatoVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzatoVar);
        b(14, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onVideoPause() throws RemoteException {
        b(15, a());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(zzatq zzatqVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzatqVar);
        b(16, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzcs(int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        b(17, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzsn() throws RemoteException {
        b(18, a());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzb(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, bundle);
        b(19, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onVideoPlay() throws RemoteException {
        b(20, a());
    }
}
