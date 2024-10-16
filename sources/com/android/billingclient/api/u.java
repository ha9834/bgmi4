package com.android.billingclient.api;

import com.android.billingclient.api.h;

/* loaded from: classes.dex */
final class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ag f985a;
    final /* synthetic */ v b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(v vVar, ag agVar) {
        this.b = vVar;
        this.f985a = agVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r rVar = this.b.c;
        h.a c = h.c();
        c.a(this.f985a.b());
        c.a(this.f985a.c());
        rVar.onSkuDetailsResponse(c.a(), this.f985a.a());
    }
}
