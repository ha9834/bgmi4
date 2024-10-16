package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
final class ux extends zzaok {

    /* renamed from: a, reason: collision with root package name */
    private zzcjy<zzaov, zzcla> f2553a;
    private final /* synthetic */ zzckm b;

    private ux(zzckm zzckmVar, zzcjy zzcjyVar) {
        this.b = zzckmVar;
        this.f2553a = zzcjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaoj
    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzckm.a(this.b, (View) ObjectWrapper.unwrap(iObjectWrapper));
        this.f2553a.zzfzn.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzaoj
    public final void zzdb(String str) throws RemoteException {
        this.f2553a.zzfzn.onAdFailedToLoad(0);
    }
}
