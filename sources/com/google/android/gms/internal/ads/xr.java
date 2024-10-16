package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class xr extends zzzq {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzzp f2619a;
    private final /* synthetic */ zzcqj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xr(zzcqj zzcqjVar, zzzp zzzpVar) {
        this.b = zzcqjVar;
        this.f2619a = zzzpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzp
    public final void onAdMetadataChanged() throws RemoteException {
        boolean z;
        zzzp zzzpVar;
        z = this.b.i;
        if (!z || (zzzpVar = this.f2619a) == null) {
            return;
        }
        zzzpVar.onAdMetadataChanged();
    }
}
