package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzd;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class s implements Callable<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f983a;
    final /* synthetic */ String b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(e eVar, p pVar, String str) {
        this.c = eVar;
        this.f983a = pVar;
        this.b = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Bundle call() throws Exception {
        zzd zzdVar;
        Context context;
        zzdVar = this.c.g;
        context = this.c.f;
        return zzdVar.zzc(3, context.getPackageName(), this.f983a.b(), this.b, null);
    }
}
