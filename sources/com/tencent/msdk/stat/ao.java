package com.tencent.msdk.stat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f6310a;
    final /* synthetic */ aj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(aj ajVar, h hVar) {
        this.b = ajVar;
        this.f6310a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f6310a);
    }
}
