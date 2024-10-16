package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface zzamv extends IInterface {
    void onAdClicked() throws RemoteException;

    void onAdClosed() throws RemoteException;

    void onAdFailedToLoad(int i) throws RemoteException;

    void onAdImpression() throws RemoteException;

    void onAdLeftApplication() throws RemoteException;

    void onAdLoaded() throws RemoteException;

    void onAdOpened() throws RemoteException;

    void onAppEvent(String str, String str2) throws RemoteException;

    void onVideoEnd() throws RemoteException;

    void onVideoPause() throws RemoteException;

    void onVideoPlay() throws RemoteException;

    void zza(zzafe zzafeVar, String str) throws RemoteException;

    void zza(zzamy zzamyVar) throws RemoteException;

    void zza(zzatq zzatqVar) throws RemoteException;

    void zzb(Bundle bundle) throws RemoteException;

    void zzb(zzato zzatoVar) throws RemoteException;

    void zzcs(int i) throws RemoteException;

    void zzcz(String str) throws RemoteException;

    void zzsm() throws RemoteException;

    void zzsn() throws RemoteException;
}
