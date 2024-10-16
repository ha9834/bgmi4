package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class db implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzanu f2114a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(zzanu zzanuVar) {
        this.f2114a = zzanuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzamv zzamvVar;
        try {
            zzamvVar = this.f2114a.f2770a;
            zzamvVar.onAdOpened();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
