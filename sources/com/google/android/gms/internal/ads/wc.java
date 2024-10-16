package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class wc extends zzaot {

    /* renamed from: a, reason: collision with root package name */
    private zzcjy<zzaov, zzcla> f2579a;

    private wc(zzcnd zzcndVar, zzcjy zzcjyVar) {
        this.f2579a = zzcjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaos
    public final void zzsw() throws RemoteException {
        this.f2579a.zzfzn.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzaos
    public final void zzdb(String str) throws RemoteException {
        this.f2579a.zzfzn.onAdFailedToLoad(0);
    }
}
