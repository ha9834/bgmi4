package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

/* loaded from: classes.dex */
final class av implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Exception f955a;
    final /* synthetic */ ax b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ax axVar, Exception exc) {
        this.b = axVar;
        this.f955a = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String valueOf = String.valueOf(this.f955a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32);
        sb.append("Error acknowledge purchase; ex: ");
        sb.append(valueOf);
        zza.zzb("BillingClient", sb.toString());
        this.b.b.a(ad.q);
    }
}
