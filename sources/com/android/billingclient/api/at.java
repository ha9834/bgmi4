package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class at implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f953a;
    final /* synthetic */ n b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(e eVar, String str, n nVar) {
        this.c = eVar;
        this.f953a = str;
        this.b = nVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        this.c.a(new as(this, e.b(this.c, this.f953a)));
        return null;
    }
}
