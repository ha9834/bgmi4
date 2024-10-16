package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public interface zzzk extends IInterface {
    void destroy() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getAdUnitId() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(zzaax zzaaxVar) throws RemoteException;

    void zza(zzacd zzacdVar) throws RemoteException;

    void zza(zzado zzadoVar) throws RemoteException;

    void zza(zzaqn zzaqnVar) throws RemoteException;

    void zza(zzaqt zzaqtVar, String str) throws RemoteException;

    void zza(zzatb zzatbVar) throws RemoteException;

    void zza(zzyd zzydVar) throws RemoteException;

    void zza(zzyw zzywVar) throws RemoteException;

    void zza(zzzp zzzpVar) throws RemoteException;

    void zza(zzzs zzzsVar) throws RemoteException;

    void zzb(zzyz zzyzVar) throws RemoteException;

    void zzb(zzzy zzzyVar) throws RemoteException;

    boolean zzb(zzxz zzxzVar) throws RemoteException;

    void zzbt(String str) throws RemoteException;

    String zzpj() throws RemoteException;

    IObjectWrapper zzpl() throws RemoteException;

    void zzpm() throws RemoteException;

    zzyd zzpn() throws RemoteException;

    zzzs zzpo() throws RemoteException;

    zzyz zzpp() throws RemoteException;
}
