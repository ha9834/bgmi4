package com.android.billingclient.api;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f987a;
    final /* synthetic */ z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(z zVar, h hVar) {
        this.b = zVar;
        this.f987a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        f fVar;
        f fVar2;
        obj = this.b.b;
        synchronized (obj) {
            fVar = this.b.d;
            if (fVar != null) {
                fVar2 = this.b.d;
                fVar2.onBillingSetupFinished(this.f987a);
            }
        }
    }
}
