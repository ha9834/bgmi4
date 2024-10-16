package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class vn extends zzaon {

    /* renamed from: a, reason: collision with root package name */
    private zzcjy<zzaov, zzcla> f2568a;

    private vn(zzclq zzclqVar, zzcjy zzcjyVar) {
        this.f2568a = zzcjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaom
    public final void zzsw() throws RemoteException {
        this.f2568a.zzfzn.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzaom
    public final void zzdb(String str) throws RemoteException {
        this.f2568a.zzfzn.onAdFailedToLoad(0);
    }
}
