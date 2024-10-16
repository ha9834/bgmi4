package com.android.billingclient.api;

/* loaded from: classes.dex */
final class ar implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f951a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(e eVar, j jVar, i iVar) {
        this.f951a = jVar;
        this.b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f951a.onConsumeResponse(ad.r, this.b.a());
    }
}
