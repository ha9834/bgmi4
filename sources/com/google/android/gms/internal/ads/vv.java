package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class vv extends zzaoq {

    /* renamed from: a, reason: collision with root package name */
    private zzcjy<zzaov, zzcla> f2574a;
    private final /* synthetic */ zzcmg b;

    private vv(zzcmg zzcmgVar, zzcjy zzcjyVar) {
        this.b = zzcmgVar;
        this.f2574a = zzcjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void zza(zzang zzangVar) throws RemoteException {
        zzcmg.a(this.b, zzangVar);
        this.f2574a.zzfzn.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void zzdb(String str) throws RemoteException {
        this.f2574a.zzfzn.onAdFailedToLoad(0);
    }
}
