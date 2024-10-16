package com.tencent.msdk.stat;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f6332a;
    final /* synthetic */ j b;
    final /* synthetic */ k c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, List list, j jVar) {
        this.c = kVar;
        this.f6332a = list;
        this.b = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.f6332a, this.b);
    }
}
