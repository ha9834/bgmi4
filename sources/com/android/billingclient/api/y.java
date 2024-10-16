package com.android.billingclient.api;

/* loaded from: classes.dex */
final class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f989a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(z zVar) {
        this.f989a = zVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f989a.f990a.f970a = 0;
        this.f989a.f990a.g = null;
        this.f989a.a(ad.r);
    }
}
