package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes.dex */
public interface zzagg extends IInterface {
    void cancelUnconfirmedClick() throws RemoteException;

    void destroy() throws RemoteException;

    String getAdvertiser() throws RemoteException;

    String getBody() throws RemoteException;

    String getCallToAction() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getHeadline() throws RemoteException;

    List getImages() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    List getMuteThisAdReasons() throws RemoteException;

    String getPrice() throws RemoteException;

    double getStarRating() throws RemoteException;

    String getStore() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    boolean isCustomMuteThisAdEnabled() throws RemoteException;

    void performClick(Bundle bundle) throws RemoteException;

    void recordCustomClickGesture() throws RemoteException;

    boolean recordImpression(Bundle bundle) throws RemoteException;

    void reportTouchEvent(Bundle bundle) throws RemoteException;

    void zza(zzaag zzaagVar) throws RemoteException;

    void zza(zzaak zzaakVar) throws RemoteException;

    void zza(zzagd zzagdVar) throws RemoteException;

    IObjectWrapper zzrh() throws RemoteException;

    zzaei zzri() throws RemoteException;

    zzaea zzrj() throws RemoteException;

    IObjectWrapper zzrk() throws RemoteException;

    void zzro() throws RemoteException;

    zzaee zzrp() throws RemoteException;
}
