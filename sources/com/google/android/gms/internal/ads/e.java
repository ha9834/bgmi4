package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e extends zzzd {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzabl f2138a;

    private e(zzabl zzablVar) {
        this.f2138a = zzablVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final String zzpj() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zza(zzxz zzxzVar) throws RemoteException {
        zza(zzxzVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zza(zzxz zzxzVar, int i) throws RemoteException {
        zzbad.zzen("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzazt.zzyr.post(new f(this));
    }
}
