package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ba implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Future f961a;
    final /* synthetic */ Runnable b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(e eVar, Future future, Runnable runnable) {
        this.f961a = future;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f961a.isDone() || this.f961a.isCancelled()) {
            return;
        }
        this.f961a.cancel(true);
        zza.zzb("BillingClient", "Async task is taking too long, cancel it!");
        Runnable runnable = this.b;
        if (runnable != null) {
            runnable.run();
        }
    }
}
