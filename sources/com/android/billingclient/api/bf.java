package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Exception f966a;
    final /* synthetic */ j b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(e eVar, Exception exc, j jVar, String str) {
        this.f966a = exc;
        this.b = jVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String valueOf = String.valueOf(this.f966a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
        sb.append("Error consuming purchase; ex: ");
        sb.append(valueOf);
        zza.zzb("BillingClient", sb.toString());
        this.b.onConsumeResponse(ad.q, this.c);
    }
}
