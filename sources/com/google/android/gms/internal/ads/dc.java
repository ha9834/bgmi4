package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class dc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzanu f2115a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(zzanu zzanuVar) {
        this.f2115a = zzanuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzamv zzamvVar;
        try {
            zzamvVar = this.f2115a.f2770a;
            zzamvVar.onAdLoaded();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
