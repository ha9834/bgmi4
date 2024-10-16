package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f964a;
    final /* synthetic */ h b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(e eVar, j jVar, h hVar, String str) {
        this.f964a = jVar;
        this.b = hVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zza.zza("BillingClient", "Successfully consumed purchase.");
        this.f964a.onConsumeResponse(this.b, this.c);
    }
}
