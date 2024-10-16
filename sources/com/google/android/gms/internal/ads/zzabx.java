package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzabx extends zzasx {

    /* renamed from: a, reason: collision with root package name */
    private zzatb f2692a;

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void destroy() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void pause() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void resume() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setAppPackageName(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setCustomData(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setUserId(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void show() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zza(zzasu zzasuVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zza(zzzp zzzpVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zza(zzath zzathVar) throws RemoteException {
        zzbad.zzen("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzazt.zzyr.post(new j(this));
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zza(zzatb zzatbVar) throws RemoteException {
        this.f2692a = zzatbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }
}
