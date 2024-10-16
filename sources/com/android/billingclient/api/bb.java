package com.android.billingclient.api;

import android.os.Bundle;
import com.android.vending.billing.util.IabHelper;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class bb implements Callable<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f962a;
    final /* synthetic */ Bundle b;
    final /* synthetic */ e c;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Bundle call() throws Exception {
        return e.b(this.c).zzj(8, e.a(this.c).getPackageName(), this.f962a, IabHelper.ITEM_TYPE_SUBS, this.b);
    }
}
