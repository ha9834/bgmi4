package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class df implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzanu f2118a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(zzanu zzanuVar) {
        this.f2118a = zzanuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzamv zzamvVar;
        try {
            zzamvVar = this.f2118a.f2770a;
            zzamvVar.onAdLeftApplication();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
