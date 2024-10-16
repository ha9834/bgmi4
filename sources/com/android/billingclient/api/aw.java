package com.android.billingclient.api;

import com.android.billingclient.api.h;

/* loaded from: classes.dex */
final class aw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f956a;
    final /* synthetic */ String b;
    final /* synthetic */ ax c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(ax axVar, int i, String str) {
        this.c = axVar;
        this.f956a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar = this.c.b;
        h.a c = h.c();
        c.a(this.f956a);
        c.a(this.b);
        cVar.a(c.a());
    }
}
