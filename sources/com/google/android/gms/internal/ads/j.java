package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzabx f2255a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(zzabx zzabxVar) {
        this.f2255a = zzabxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzatb zzatbVar;
        zzatb zzatbVar2;
        zzatbVar = this.f2255a.f2692a;
        if (zzatbVar != null) {
            try {
                zzatbVar2 = this.f2255a.f2692a;
                zzatbVar2.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbad.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
