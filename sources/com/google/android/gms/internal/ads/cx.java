package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class cx implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzanu f2110a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(zzanu zzanuVar) {
        this.f2110a = zzanuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzamv zzamvVar;
        try {
            zzamvVar = this.f2110a.f2770a;
            zzamvVar.onAdClosed();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
