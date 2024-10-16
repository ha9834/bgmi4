package com.android.billingclient.api;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f986a;
    final /* synthetic */ List b;
    final /* synthetic */ r c;
    final /* synthetic */ e d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(e eVar, String str, List list, String str2, r rVar) {
        this.d = eVar;
        this.f986a = str;
        this.b = list;
        this.c = rVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        this.d.a(new u(this, this.d.a(this.f986a, this.b, (String) null)));
        return null;
    }
}
