package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class aq implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f950a;
    final /* synthetic */ j b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(e eVar, i iVar, j jVar) {
        this.c = eVar;
        this.f950a = iVar;
        this.b = jVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        e.a(this.c, this.f950a, this.b);
        return null;
    }
}
