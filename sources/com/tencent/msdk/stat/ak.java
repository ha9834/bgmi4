package com.tencent.msdk.stat;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f6306a;
    final /* synthetic */ int b;
    final /* synthetic */ boolean c;
    final /* synthetic */ boolean d;
    final /* synthetic */ aj e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, List list, int i, boolean z, boolean z2) {
        this.e = ajVar;
        this.f6306a = list;
        this.b = i;
        this.c = z;
        this.d = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.e.a((List<as>) this.f6306a, this.b, this.c);
        if (this.d) {
            this.f6306a.clear();
        }
    }
}
