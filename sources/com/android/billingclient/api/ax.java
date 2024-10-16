package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzd;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ax implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f957a;
    final /* synthetic */ c b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(e eVar, b bVar, c cVar) {
        this.c = eVar;
        this.f957a = bVar;
        this.b = cVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        zzd zzdVar;
        Context context;
        String str;
        try {
            zzdVar = this.c.g;
            context = this.c.f;
            String packageName = context.getPackageName();
            String a2 = this.f957a.a();
            b bVar = this.f957a;
            str = this.c.b;
            Bundle zzn = zzdVar.zzn(9, packageName, a2, zza.zzk(bVar, str));
            this.c.a(new aw(this, zza.zzd(zzn, "BillingClient"), zza.zze(zzn, "BillingClient")));
            return null;
        } catch (Exception e) {
            this.c.a(new av(this, e));
            return null;
        }
    }
}
