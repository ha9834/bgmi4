package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class be implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f965a;
    final /* synthetic */ j b;
    final /* synthetic */ h c;
    final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(e eVar, int i, j jVar, h hVar, String str) {
        this.f965a = i;
        this.b = jVar;
        this.c = hVar;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f965a;
        StringBuilder sb = new StringBuilder(63);
        sb.append("Error consuming purchase with token. Response code: ");
        sb.append(i);
        zza.zzb("BillingClient", sb.toString());
        this.b.onConsumeResponse(this.c, this.d);
    }
}
