package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzabp f2186a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zzabp zzabpVar) {
        this.f2186a = zzabpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzyz zzyzVar;
        zzyz zzyzVar2;
        zzyzVar = this.f2186a.f2690a;
        if (zzyzVar != null) {
            try {
                zzyzVar2 = this.f2186a.f2690a;
                zzyzVar2.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbad.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
