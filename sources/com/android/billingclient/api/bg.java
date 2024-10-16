package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzd;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class bg implements Callable<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f967a;
    final /* synthetic */ p b;
    final /* synthetic */ String c;
    final /* synthetic */ g d;
    final /* synthetic */ Bundle e;
    final /* synthetic */ e f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(e eVar, int i, p pVar, String str, g gVar, Bundle bundle) {
        this.f = eVar;
        this.f967a = i;
        this.b = pVar;
        this.c = str;
        this.d = gVar;
        this.e = bundle;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Bundle call() throws Exception {
        zzd zzdVar;
        Context context;
        zzdVar = this.f.g;
        int i = this.f967a;
        context = this.f.f;
        return zzdVar.zzg(i, context.getPackageName(), this.b.b(), this.c, null, this.e);
    }
}
