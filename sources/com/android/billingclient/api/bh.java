package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import com.android.vending.billing.util.IabHelper;
import com.google.android.gms.internal.play_billing.zzd;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class bh implements Callable<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f968a;
    final /* synthetic */ p b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(e eVar, g gVar, p pVar) {
        this.c = eVar;
        this.f968a = gVar;
        this.b = pVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Bundle call() throws Exception {
        zzd zzdVar;
        Context context;
        zzdVar = this.c.g;
        context = this.c.f;
        return zzdVar.zzf(5, context.getPackageName(), Arrays.asList(this.f968a.a()), this.b.b(), IabHelper.ITEM_TYPE_SUBS, null);
    }
}
