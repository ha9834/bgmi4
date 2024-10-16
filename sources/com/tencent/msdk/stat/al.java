package com.tencent.msdk.stat;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f6307a;
    final /* synthetic */ boolean b;
    final /* synthetic */ boolean c;
    final /* synthetic */ aj d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar, List list, boolean z, boolean z2) {
        this.d = ajVar;
        this.f6307a = list;
        this.b = z;
        this.c = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.a((List<as>) this.f6307a, this.b);
        if (this.c) {
            this.f6307a.clear();
        }
    }
}
