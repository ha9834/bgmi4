package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ e f2164a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f2164a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzabl.a(this.f2164a.f2138a) != null) {
            try {
                zzabl.a(this.f2164a.f2138a).onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbad.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
