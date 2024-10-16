package com.android.billingclient.api;

/* loaded from: classes.dex */
final class ap implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ r f949a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(e eVar, r rVar) {
        this.f949a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f949a.onSkuDetailsResponse(ad.r, null);
    }
}
