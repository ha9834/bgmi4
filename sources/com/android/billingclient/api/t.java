package com.android.billingclient.api;

import com.android.billingclient.api.l;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class t implements Callable<l.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f984a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(e eVar, String str) {
        this.b = eVar;
        this.f984a = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ l.a call() throws Exception {
        return e.a(this.b, this.f984a);
    }
}
